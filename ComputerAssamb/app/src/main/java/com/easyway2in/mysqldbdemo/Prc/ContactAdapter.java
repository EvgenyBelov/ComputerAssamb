package com.easyway2in.mysqldbdemo.Prc;

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
 * Created by Evgeny on 07.05.2017.
 */

public class ContactAdapter extends ArrayAdapter {

    List list = new ArrayList();
    String json_string;



    public ContactAdapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(Contacts object) {
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

    public List getItems(){
        return list ;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        new MyTask().execute();

        View row;
        row = convertView;
        ContactHolder contactHolder;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater)
                    this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout_proc,parent,false);
            contactHolder = new ContactHolder();
            contactHolder.tx_user = (TextView) row.findViewById(R.id.tx_global);
            contactHolder.tx_user_name = (TextView) row.findViewById(R.id.tx_socket);
            contactHolder.tx_user_pass = (TextView) row.findViewById(R.id.tx_core);
            contactHolder.tx_freq = (TextView) row.findViewById(R.id.tx_freq);
            contactHolder.tx_cache = (TextView) row.findViewById(R.id.tx_cache);
            contactHolder.imjURL = (ImageView) row.findViewById(R.id.imjURL);
            contactHolder.tx_url = (TextView) row.findViewById(R.id.tx_url);
           contactHolder.btnURL = (Button) row.findViewById(R.id.btnURL);
            contactHolder.btnADD = (Button) row.findViewById(R.id.btnADD);

            row.setTag(contactHolder);
        } else {
            contactHolder = (ContactHolder) row.getTag();
        }
        final Contacts contacts = (Contacts) this.getItem(position);
        contactHolder.tx_user.setText(contacts.getName());
        contactHolder.tx_user_name.setText("Socket: " + contacts.getSocket());
        contactHolder.tx_user_pass.setText("Кол-во ядер: " + contacts.getCore());
        contactHolder.tx_freq.setText("Частота проц-ра: "+contacts.getFreq()+" МГц");
        contactHolder.tx_cache.setText("Кэш (L1/L2/L3): "+contacts.getCache()+"/"+contacts.getCache_two()+"/"+contacts.getCache_thr()+" Кб");
        contactHolder.tx_url.setText(contacts.getUrl());



        contactHolder.btnURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri address = Uri.parse(contacts.getUrl());
                Intent openlink = new Intent(Intent.ACTION_VIEW, address);
               getContext().startActivity(openlink);
            }
        });
        contactHolder.btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String socket = contacts.getSocket();
                if(json_string==null){
                    Toast.makeText(getContext(),"First GET JSON",Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getContext(),Matherboard.class);
                    intent.putExtra("Math",json_string);
                    intent.putExtra("NAMEPRC", contacts.getName());
                    intent.putExtra("soc",socket);
                    intent.putExtra("powerPRC", contacts.getPower());
                    getContext().startActivity(intent);



                }

            }
        });


        Picasso.with(getContext())
                .load(contacts.getUrl_img())
                .into(contactHolder.imjURL);


        return row;
    }

    static  class ContactHolder {
        TextView tx_user, tx_user_name, tx_user_pass, tx_freq, tx_cache, tx_url;
        ImageView imjURL;
        Button btnURL, btnADD;
    }

    class MyTask extends AsyncTask<Void,Void,String> {

        String json_url;
        String JSON_STRING;

        @Override
        protected void onPreExecute() {
            json_url = "http://overtopman.myjino.ru/scripts/moth/json_get_data_moth.php";
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
