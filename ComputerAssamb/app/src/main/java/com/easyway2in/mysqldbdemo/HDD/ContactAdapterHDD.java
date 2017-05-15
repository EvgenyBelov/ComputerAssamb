package com.easyway2in.mysqldbdemo.HDD;

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

import com.easyway2in.mysqldbdemo.R;
import com.easyway2in.mysqldbdemo.SSD.SSD;
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

public class ContactAdapterHDD extends ArrayAdapter {
    List list = new ArrayList();
    String json_string;


    public ContactAdapterHDD(Context context, int resource) {
        super(context, resource);
    }


    public void add(ContactHDD object) {
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
            contactHolder.tx_memory = (TextView) row.findViewById(R.id.tx_socket);
            contactHolder.tx_sata = (TextView) row.findViewById(R.id.tx_core);
            contactHolder.tx_speed = (TextView) row.findViewById(R.id.tx_freq);
            contactHolder.tx_speed_disk = (TextView) row.findViewById(R.id.tx_cache);
            contactHolder.imjURL = (ImageView) row.findViewById(R.id.imjURL);
            contactHolder.tx_url = (TextView) row.findViewById(R.id.tx_url);
            contactHolder.btnADD = (Button) row.findViewById(R.id.btnADD);
            contactHolder.btnURL = (Button) row.findViewById(R.id.btnURL);

            row.setTag(contactHolder);
        } else {
            contactHolder = (ContactHolder) row.getTag();
        }
        final ContactHDD contactHDD = (ContactHDD) this.getItem(position);
        contactHolder.tx_name.setText(contactHDD.getName());
        contactHolder.tx_memory.setText("Объем: " + contactHDD.getMemory() + "Gb");
        contactHolder.tx_sata.setText("Интерфейс: " + contactHDD.getSata());
        contactHolder.tx_speed.setText("Скорость зап./чт.: " + contactHDD.getSpeed()+" Мб/с");
        contactHolder.tx_speed_disk.setText("Скорость вращения: " + contactHDD.getSpeed_disk() +" rpm");
        contactHolder.tx_url.setText(contactHDD.getUrl());


        Picasso.with(getContext())
                .load(contactHDD.getUrl_img())
                .placeholder(R.drawable.vectorimg)
                .into(contactHolder.imjURL);

        contactHolder.btnURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri address = Uri.parse(contactHDD.getUrl());
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
                    Intent intent = new Intent(getContext(),SSD.class);
                    intent.putExtra("ssd",json_string);
                    intent.putExtra("NAMEPRC_6", contactHDD.getNameProc());
                    intent.putExtra("NAMEMATH_5", contactHDD.getNameMath());
                    intent.putExtra("NAMERAM_4", contactHDD.getNameRam());
                    intent.putExtra("NAMEvCARD_3", contactHDD.getNameVCard());
                    intent.putExtra("NAMEHDD", contactHDD.getName());
                    intent.putExtra("NAMECOOL_2", contactHDD.getNameCool());

                    intent.putExtra("SATAMATH_4", contactHDD.getSATAMath());

                    intent.putExtra("POWERPRC_6", contactHDD.getPowerPrc());
                    intent.putExtra("POWERMAT_5", contactHDD.getPowerMath());
                    intent.putExtra("POWERAM_4", contactHDD.getPowerRam());
                    intent.putExtra("POWERVCARD_3", contactHDD.getPowerVCard());
                    intent.putExtra("POWERCOOL_2", contactHDD.getPowerCool());
                    intent.putExtra("POWERHDD", contactHDD.getPower());


                    intent.putExtra("FACTOR_5", contactHDD.getFactor());
                    getContext().startActivity(intent);


                }

            }
        });




        return row;
    }

    static  class ContactHolder {
        TextView tx_name, tx_sata, tx_power, tx_speed, tx_memory, tx_speed_disk, tx_url;
        ImageView imjURL;
        Button btnURL, btnADD;
    }

    class MyTask extends AsyncTask<Void,Void,String> {

        String json_url;
        String JSON_STRING;

        @Override
        protected void onPreExecute() {
            json_url = "http://overtopman.myjino.ru/scripts/ssd/json_get_data_ssd.php";
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
