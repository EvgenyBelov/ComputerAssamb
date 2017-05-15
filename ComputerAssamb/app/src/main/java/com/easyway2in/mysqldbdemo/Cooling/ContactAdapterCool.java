package com.easyway2in.mysqldbdemo.Cooling;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.easyway2in.mysqldbdemo.HDD.HDD;
import com.easyway2in.mysqldbdemo.R;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeny on 12.05.2017.
 */

public class ContactAdapterCool extends ArrayAdapter {

    List list = new ArrayList();
    String json_string;

    public ContactAdapterCool(Context context, int resource) {
        super(context, resource);
    }


    public void add(ContactCool object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        new MyTask().execute();
        View row;
        row = convertView;
        ContactHolder contactHolder;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater)
                    this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout_proc,parent,false);
            contactHolder = new ContactHolder();
            contactHolder.tx_name = (TextView) row.findViewById(R.id.tx_global);
            contactHolder.tx_socket = (TextView) row.findViewById(R.id.tx_socket);
            contactHolder.tx_noise = (TextView) row.findViewById(R.id.tx_core);
            contactHolder.tx_speed = (TextView) row.findViewById(R.id.tx_freq);
            contactHolder.tx_power = (TextView) row.findViewById(R.id.tx_cache);
            contactHolder.imjURL = (ImageView) row.findViewById(R.id.imjURL);
            contactHolder.tx_url = (TextView) row.findViewById(R.id.tx_url);
            contactHolder.btnADD = (Button) row.findViewById(R.id.btnADD);
            contactHolder.btnURL = (Button) row.findViewById(R.id.btnURL);

            row.setTag(contactHolder);
        } else {
            contactHolder = (ContactHolder) row.getTag();
        }
        final ContactCool contactCool = (ContactCool) this.getItem(position);
        contactHolder.tx_name.setText(contactCool.getName());
        contactHolder.tx_socket.setText("Socket: " + contactCool.getSocket()+"...");
        contactHolder.tx_noise.setText("Макс. уровень шума: " + contactCool.getNoise()+" дБ");
        contactHolder.tx_speed.setText("Cкорость вращения: " + contactCool.getSpeed()+" об/мин");
        contactHolder.tx_power.setText("Рассеиваемая мощность: " + contactCool.getPower()+" Вт");
        contactHolder.tx_url.setText(contactCool.getUrl());


        Picasso.with(getContext())
                .load(contactCool.getUrl_img())
                .placeholder(R.drawable.vectorimg)
                .into(contactHolder.imjURL);

        contactHolder.btnURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri address = Uri.parse(contactCool.getUrl());
                Intent openlink = new Intent(Intent.ACTION_VIEW, address);
                getContext().startActivity(openlink);
            }
        });
        contactHolder.btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(json_string==null){
                    Toast.makeText(getContext(),"First GET JSON",Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getContext(),HDD.class);
                    intent.putExtra("hdd",json_string);
                    intent.putExtra("NAMEPRC_5", contactCool.getNameprc());
                    intent.putExtra("NAMEMATH_4", contactCool.getNamemath());
                    intent.putExtra("NAMERAM_3", contactCool.getNameram());
                    intent.putExtra("NAMEvCARD_2", contactCool.getNamevcard());
                    intent.putExtra("NAMECOOL", contactCool.getName());

                    intent.putExtra("SATAMATH_4", contactCool.getSataMath());

                    intent.putExtra("POWERPRC_5", contactCool.getPowerPrc());
                    intent.putExtra("POWERMAT_4", contactCool.getPowerMath());
                    intent.putExtra("POWERAM_3", contactCool.getPowerRam());
                    intent.putExtra("POWERVCARD_2", contactCool.getPowerVCard());
                    intent.putExtra("POWERCOOL", contactCool.getPower());
                    intent.putExtra("SATAMATH_4", contactCool.getSataMath());


                    intent.putExtra("FACTOR_4", contactCool.getFactor());
                    getContext().startActivity(intent);


                }

            }
        });

        //  Intent it = new Intent(this.getContext(), PrcActivity.class);
        //  it.putExtra("ADD",contactMath.getUrl());




        return row;
    }

    static  class ContactHolder {
        TextView tx_name, tx_socket, tx_power, tx_noise, tx_speed, tx_url;
        ImageView imjURL;
        Button btnURL, btnADD;
    }

    class MyTask extends AsyncTask<Void,Void,String> {

        String json_url;
        String JSON_STRING;

        @Override
        protected void onPreExecute() {
            json_url = "http://overtopman.myjino.ru/scripts/hdd/json_get_data_hdd.php";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try{
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_STRING = bufferedReader.readLine())!=null) {
                    stringBuilder.append(JSON_STRING+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            json_string = result;
        }
    }
}
