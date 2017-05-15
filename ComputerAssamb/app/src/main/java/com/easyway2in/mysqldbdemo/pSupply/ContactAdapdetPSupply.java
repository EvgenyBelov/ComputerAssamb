package com.easyway2in.mysqldbdemo.pSupply;

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

import com.easyway2in.mysqldbdemo.Casee.Case;
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
 * Created by Evgeny on 13.05.2017.
 */

public class ContactAdapdetPSupply extends ArrayAdapter {
    String json_string;
    List list = new ArrayList();


    public ContactAdapdetPSupply(Context context, int resource) {
        super(context, resource);
    }


    public void add(ContactPSupply object) {
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
            contactHolder.tx_power = (TextView) row.findViewById(R.id.tx_socket);
            contactHolder.tx_cert = (TextView) row.findViewById(R.id.tx_core);
            contactHolder.tx_stand = (TextView) row.findViewById(R.id.tx_freq);
            contactHolder.tx_factor= (TextView) row.findViewById(R.id.tx_cache);
            contactHolder.imjURL = (ImageView) row.findViewById(R.id.imjURL);
            contactHolder.tx_url = (TextView) row.findViewById(R.id.tx_url);
            contactHolder.btnADD = (Button) row.findViewById(R.id.btnADD);
            contactHolder.btnURL = (Button) row.findViewById(R.id.btnURL);

            row.setTag(contactHolder);
        } else {
            contactHolder = (ContactHolder) row.getTag();
        }
        final ContactPSupply contactPSupply = (ContactPSupply) this.getItem(position);
        contactHolder.tx_name.setText(contactPSupply.getName());
        contactHolder.tx_power.setText("Мощность: " + contactPSupply.getPower()+" Вт");
        contactHolder.tx_cert.setText("Сертификат: 80 PLUS - " + contactPSupply.getCert());
        contactHolder.tx_stand.setText("Стандарт: " + contactPSupply.getStand());
        contactHolder.tx_factor.setText("Форм-фактор: " + contactPSupply.getFactor());
        contactHolder.tx_url.setText(contactPSupply.getUrl());


        Picasso.with(getContext())
                .load(contactPSupply.getUrl_img())
                .placeholder(R.drawable.vectorimg)
                .into(contactHolder.imjURL);

        contactHolder.btnURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri address = Uri.parse(contactPSupply.getUrl());
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
                    Intent intent = new Intent(getContext(),Case.class);
                    intent.putExtra("case",json_string);

                    intent.putExtra("NAMEPRC_8", contactPSupply.getNamePrc());
                    intent.putExtra("NAMEMATH_7", contactPSupply.getNameMath());
                    intent.putExtra("NAMERAM_6", contactPSupply.getNameRam());
                    intent.putExtra("NAMEvCARD_5", contactPSupply.getNameVCard());
                    intent.putExtra("NAMEHDD_3", contactPSupply.getNameHDD());
                    intent.putExtra("NAMECOOL_4", contactPSupply.getNameCool());
                    intent.putExtra("NAMESSD_2", contactPSupply.getNameSSD());
                    intent.putExtra("NAMEPSUP", contactPSupply.getName());


                    intent.putExtra("FACTOR_7", contactPSupply.getfMath());

                    getContext().startActivity(intent);


                }

            }
        });




        return row;
    }

    static  class ContactHolder {
        TextView tx_name, tx_factor, tx_power, tx_cert, tx_stand, tx_time, tx_url;
        ImageView imjURL;
        Button btnURL, btnADD;
    }
    class MyTask extends AsyncTask<Void,Void,String> {

        String json_url;
        String JSON_STRING;

        @Override
        protected void onPreExecute() {
            json_url = "http://overtopman.myjino.ru/scripts/case/json_get_data_case.php";
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
