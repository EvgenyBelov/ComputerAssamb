package com.easyway2in.mysqldbdemo.Matherboard;


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
import com.easyway2in.mysqldbdemo.Ram.RamCl;
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
 * Created by Evgeny on 11.05.2017.
 */

public class ContactAdapterMath extends ArrayAdapter {
    List list = new ArrayList();
    String json_string;


    public ContactAdapterMath(Context context, int resource) {
        super(context, resource);
    }


    public void add(ContactMath object) {
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
            contactHolder.tx_user = (TextView) row.findViewById(R.id.tx_global);
            contactHolder.tx_socket = (TextView) row.findViewById(R.id.tx_socket);
            contactHolder.tx_memory = (TextView) row.findViewById(R.id.tx_core);
            contactHolder.tx_freq = (TextView) row.findViewById(R.id.tx_freq);
            contactHolder.tx_cache = (TextView) row.findViewById(R.id.tx_cache);
            contactHolder.imjURL = (ImageView) row.findViewById(R.id.imjURL);
            contactHolder.tx_url = (TextView) row.findViewById(R.id.tx_url);
            contactHolder.btnADD = (Button) row.findViewById(R.id.btnADD);
            contactHolder.btnURL = (Button) row.findViewById(R.id.btnURL);

            row.setTag(contactHolder);
        } else {
            contactHolder = (ContactHolder) row.getTag();
        }
        final ContactMath contactMath = (ContactMath) this.getItem(position);

        contactHolder.tx_user.setText(contactMath.getName() + " (" + contactMath.getSocket() + "/" + contactMath.getFactor()+")");
        contactHolder.tx_socket.setText("Тип под. памяти: " + contactMath.getMemory());
        contactHolder.tx_memory.setText("Мак. под. память: "+contactMath.getMemory_max()+" Гб");
        contactHolder.tx_freq.setText("Поддержка PCI-E " + contactMath.getPci_two()+" / "+contactMath.getPci_one());
        contactHolder.tx_cache.setText("SATA: " + contactMath.getSata());
        contactHolder.tx_url.setText(contactMath.getUrl());



        Picasso.with(getContext())
             .load(contactMath.getUrl_img())
                .placeholder(R.drawable.vectorimg)
              .into(contactHolder.imjURL);
        contactHolder.btnURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri address = Uri.parse(contactMath.getUrl());
                Intent openlink = new Intent(Intent.ACTION_VIEW, address);
                getContext().startActivity(openlink);
            }
        });
        contactHolder.btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String socket = contactMath.getSocket();
                if(json_string==null){
                    Toast.makeText(getContext(),"First GET JSON",Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getContext(),RamCl.class);
                    intent.putExtra("ram",json_string);
                    intent.putExtra("mem", contactMath.getMemory());
                    intent.putExtra("max_mem", contactMath.getMemory_max());
                    intent.putExtra("NAMEPRC_2", contactMath.getNameprc());
                    intent.putExtra("NAMEMATH", contactMath.getName());
                    intent.putExtra("PCI_1", contactMath.getPci_one());
                    intent.putExtra("PCI_2", contactMath.getPci_two());
                    intent.putExtra("POWERPRC_2", contactMath.getPowerPRC());
                    intent.putExtra("POWERMATH", contactMath.getPower());
                    intent.putExtra("SOCPRC_2", contactMath.getSoc());
                    intent.putExtra("SATAMATH", contactMath.getSata());

                    intent.putExtra("FACTOR", contactMath.getFactor());
                    getContext().startActivity(intent);


                }

            }
        });



        return row;
    }

    static  class ContactHolder {
        TextView tx_user, tx_socket, tx_memory, tx_freq, tx_cache, tx_url;
        ImageView imjURL;
        Button btnADD, btnURL;
    }

    class MyTask extends AsyncTask<Void,Void,String> {

        String json_url;
        String JSON_STRING;

        @Override
        protected void onPreExecute() {
            json_url = "http://overtopman.myjino.ru/scripts/ram/json_get_data_ram.php";
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
