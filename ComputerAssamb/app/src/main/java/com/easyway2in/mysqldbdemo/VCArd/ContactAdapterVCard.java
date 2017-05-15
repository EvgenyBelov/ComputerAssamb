package com.easyway2in.mysqldbdemo.VCArd;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.easyway2in.mysqldbdemo.Cooling.Cooling;
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

public class ContactAdapterVCard extends ArrayAdapter {
    List list = new ArrayList();
    String json_string;

    public ContactAdapterVCard(Context context, int resource) {
        super(context, resource);
    }


    public void add(ContactVCard object) {
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
            contactHolder.tx_pci = (TextView) row.findViewById(R.id.tx_socket);
            contactHolder.tx_memory = (TextView) row.findViewById(R.id.tx_core);
            contactHolder.tx_type = (TextView) row.findViewById(R.id.tx_freq);
            contactHolder.tx_shina = (TextView) row.findViewById(R.id.tx_cache);
            contactHolder.imjURL = (ImageView) row.findViewById(R.id.imjURL);
            contactHolder.tx_url = (TextView) row.findViewById(R.id.tx_url);
            contactHolder.btnADD = (Button) row.findViewById(R.id.btnADD);
            contactHolder.btnURL = (Button) row.findViewById(R.id.btnURL);

            row.setTag(contactHolder);
        } else {
            contactHolder = (ContactHolder) row.getTag();
        }
        final ContactVCard contactVCard = (ContactVCard) this.getItem(position);
        contactHolder.tx_name.setText(contactVCard.getName());
        contactHolder.tx_pci.setText("PCI-E: " + contactVCard.getPci() + " / " + contactVCard.getPci_ver());
        contactHolder.tx_memory.setText("Объем видеопамяти " + contactVCard.getMemory()+ " Мб");
        contactHolder.tx_type.setText("Тип Видеопамяти: " + contactVCard.getType());
        contactHolder.tx_shina.setText("Разрядность шины: " + contactVCard.getShina() + " бит");
        contactHolder.tx_url.setText(contactVCard.getUrl());


        Picasso.with(getContext())
                .load(contactVCard.getUrl_img())
                .placeholder(R.drawable.vectorimg)
                .into(contactHolder.imjURL);

        contactHolder.btnURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri address = Uri.parse(contactVCard.getUrl());
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
                    Intent intent = new Intent(getContext(),Cooling.class);
                    intent.putExtra("cool",json_string);
                    intent.putExtra("NAMEPRC_4", contactVCard.getNameprc());
                    intent.putExtra("NAMEMATH_3", contactVCard.getNamemath());
                    intent.putExtra("NAMERAM_2", contactVCard.getNameram());
                    intent.putExtra("NAMEvCARD", contactVCard.getName());
                    intent.putExtra("POWERPRC_4", contactVCard.getPowerPRC());
                    intent.putExtra("POWERMAT_3", contactVCard.getPowerMath());
                    intent.putExtra("POWERAM_2", contactVCard.getPowerRam());
                    intent.putExtra("POWERVCARD", contactVCard.getPower());
                    intent.putExtra("SOCPRC_4", contactVCard.getSocPRC());
                    intent.putExtra("SATAMATH_3", contactVCard.getSataMath());


                    intent.putExtra("FACTOR_3", contactVCard.getFactor());
                    getContext().startActivity(intent);


                }

            }
        });



        return row;
    }

    static  class ContactHolder {
        TextView tx_name, tx_pci, tx_memory, tx_type, tx__power, tx_shina, tx_url;
        ImageView imjURL;
        Button btnURL, btnADD;
    }

    class MyTask extends AsyncTask<Void,Void,String> {

        String json_url;
        String JSON_STRING;

        @Override
        protected void onPreExecute() {
            json_url = "http://overtopman.myjino.ru/scripts/cooling/json_get_data_cooling.php";
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
    }}
