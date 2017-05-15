package com.easyway2in.mysqldbdemo.Ram;

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

import com.easyway2in.mysqldbdemo.Matherboard.Matherboard;
import com.easyway2in.mysqldbdemo.R;
import com.easyway2in.mysqldbdemo.VCArd.VideoCard;
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

public class ContactAdapterRam extends ArrayAdapter {

    List list = new ArrayList();
    String json_string;


    public ContactAdapterRam(Context context, int resource) {
        super(context, resource);
    }


    public void add(ContactRam object) {
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
            contactHolder.tx_memory_max = (TextView) row.findViewById(R.id.tx_core);
            contactHolder.tx_freq = (TextView) row.findViewById(R.id.tx_freq);
            contactHolder.tx__power = (TextView) row.findViewById(R.id.tx_cache);
            contactHolder.imjURL = (ImageView) row.findViewById(R.id.imjURL);
            contactHolder.tx_url = (TextView) row.findViewById(R.id.tx_url);
            contactHolder.btnADD = (Button) row.findViewById(R.id.btnADD);
            contactHolder.btnURL = (Button) row.findViewById(R.id.btnURL);

            row.setTag(contactHolder);
        } else {
            contactHolder = (ContactHolder) row.getTag();
        }
        final ContactRam contactRam = (ContactRam) this.getItem(position);
        contactHolder.tx_name.setText(contactRam.getName());
        contactHolder.tx_memory.setText("Тип памяти: " + contactRam.getMemory());
        contactHolder.tx_memory_max.setText("Объем памяти " + contactRam.getMemory_max()+" Гб");
        contactHolder.tx_freq.setText("Частота: " + contactRam.getFreq() + " МГц");
        contactHolder.tx__power.setText("Напряжение питания: " + contactRam.getPower()+" В");
        contactHolder.tx_url.setText(contactRam.getUrl());


        Picasso.with(getContext())
                .load(contactRam.getUrl_img())
                .placeholder(R.drawable.vectorimg)
                .into(contactHolder.imjURL);

        contactHolder.btnURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri address = Uri.parse(contactRam.getUrl());
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
                    Intent intent = new Intent(getContext(),VideoCard.class);
                    intent.putExtra("vCard",json_string);
                    intent.putExtra("NAMEPRC_3", contactRam.getNameprc());
                    intent.putExtra("NAMEMATH_2", contactRam.getNamemath());
                    intent.putExtra("NAMERAM", contactRam.getName());
                    intent.putExtra("PCIONE", contactRam.getPci_1());
                    intent.putExtra("PCITWO", contactRam.getPci_2());
                    intent.putExtra("POWERPRC_3", contactRam.getPowerPRC());
                    intent.putExtra("POWERMATH_2", contactRam.getPowerMath());
                    intent.putExtra("POWERRAM", contactRam.getPower());
                    intent.putExtra("SOCPRC_3", contactRam.getSocPRC());
                    intent.putExtra("SATAMATH_2", contactRam.getSataMath());

                    intent.putExtra("FACTOR_2", contactRam.getFactor());
                    getContext().startActivity(intent);


                }

            }
        });

        //  Intent it = new Intent(this.getContext(), PrcActivity.class);
        //  it.putExtra("ADD",contactMath.getUrl());




        return row;
    }

    static  class ContactHolder {
        TextView tx_name, tx_memory, tx_memory_max, tx_freq, tx__power, tx_url;
        ImageView imjURL;
        Button btnURL, btnADD;
    }

    class MyTask extends AsyncTask<Void,Void,String> {

        String json_url;
        String JSON_STRING;

        @Override
        protected void onPreExecute() {
            json_url = "http://overtopman.myjino.ru/scripts/vCard/json_get_data_vCard.php";
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
