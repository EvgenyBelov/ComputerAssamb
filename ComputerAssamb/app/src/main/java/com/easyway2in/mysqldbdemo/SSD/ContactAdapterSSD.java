package com.easyway2in.mysqldbdemo.SSD;

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
import com.easyway2in.mysqldbdemo.pSupply.PowerSupply;
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

public class ContactAdapterSSD extends ArrayAdapter {
    String json_string;
    List list = new ArrayList();


    public ContactAdapterSSD(Context context, int resource) {
        super(context, resource);
    }


    public void add(ContactSSD object) {
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
        final ContactHolder contactHolder;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater)
                    this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout_proc,parent,false);
            contactHolder = new ContactHolder();
            contactHolder.tx_name = (TextView) row.findViewById(R.id.tx_global);
            contactHolder.tx_memory = (TextView) row.findViewById(R.id.tx_socket);
            contactHolder.tx_time = (TextView) row.findViewById(R.id.tx_core);
            contactHolder.tx_speed = (TextView) row.findViewById(R.id.tx_freq);
            contactHolder.tx_interfc= (TextView) row.findViewById(R.id.tx_cache);
            contactHolder.imjURL = (ImageView) row.findViewById(R.id.imjURL);
            contactHolder.tx_url = (TextView) row.findViewById(R.id.tx_url);
            contactHolder.btnADD = (Button) row.findViewById(R.id.btnADD);
            contactHolder.btnURL = (Button) row.findViewById(R.id.btnURL);

            row.setTag(contactHolder);
        } else {
            contactHolder = (ContactHolder) row.getTag();
        }
        final ContactSSD contactSSD = (ContactSSD) this.getItem(position);
        contactHolder.tx_name.setText(contactSSD.getName());
        contactHolder.tx_memory.setText("Объем: " + contactSSD.getMemory()+" Гб");
        contactHolder.tx_time.setText("Время работы: " + contactSSD.getTime()+" ч");
        contactHolder.tx_speed.setText("Скорость зап./чт.: " + contactSSD.getSpeed()+" Мб/с");
        contactHolder.tx_interfc.setText("SATA: " + contactSSD.getInterfc());
        contactHolder.tx_url.setText(contactSSD.getUrl());


        Picasso.with(getContext())
                .load(contactSSD.getUrl_img())
                .placeholder(R.drawable.vectorimg)
                .into(contactHolder.imjURL);

        contactHolder.btnURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri address = Uri.parse(contactSSD.getUrl());
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
                    Intent intent = new Intent(getContext(),PowerSupply.class);
                    intent.putExtra("psupply",json_string);

                    intent.putExtra("NAMEPRC_7", contactSSD.getNamePrc());
                    intent.putExtra("NAMEMATH_6", contactSSD.getNameMath());
                    intent.putExtra("NAMERAM_5", contactSSD.getNameRam());
                    intent.putExtra("NAMEvCARD_4", contactSSD.getNameVCard());
                    intent.putExtra("NAMEHDD_2", contactSSD.getNameHDD());
                    intent.putExtra("NAMECOOL_3", contactSSD.getNameCool());
                    intent.putExtra("NAMESSD", contactSSD.getName());

                    intent.putExtra("POWERPRC_7", contactSSD.getPowerPrc());
                    intent.putExtra("POWERMAT_6", contactSSD.getPowerMath());
                    intent.putExtra("POWERAM_5", contactSSD.getPowerRam());
                    intent.putExtra("POWERVCARD_4", contactSSD.getPowerVCard());
                    intent.putExtra("POWERCOOL_3", contactSSD.getPowerCool());
                    intent.putExtra("POWERHDD_2", contactSSD.getPowerHDD());
                    intent.putExtra("POWERSSD", contactSSD.getPower());

                    intent.putExtra("FACTOR_6", contactSSD.getFactor());

                    getContext().startActivity(intent);


                }

            }
        });




        return row;
    }

    static  class ContactHolder {
        TextView tx_name, tx_interfc, tx_power, tx_speed, tx_memory, tx_time, tx_url;
        ImageView imjURL;
        Button btnURL, btnADD;
    }

    class MyTask extends AsyncTask<Void,Void,String> {

        String json_url;
        String JSON_STRING;

        @Override
        protected void onPreExecute() {
            json_url = "http://overtopman.myjino.ru/scripts/powerSupplay/json_get_data_pSupply.php";
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
