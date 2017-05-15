package com.easyway2in.mysqldbdemo.Cooling;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.easyway2in.mysqldbdemo.HDD.HDD;
import com.easyway2in.mysqldbdemo.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Cooling extends AppCompatActivity {

    String json_string;
    JSONObject mJSONObject;
    JSONArray mJSONArray;
    ContactAdapterCool mContactAdapterCool;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ram__layout);


        mListView = (ListView) findViewById(R.id.listview);
        mContactAdapterCool = new ContactAdapterCool(this,R.layout.row_layout_proc);
        mListView.setAdapter(mContactAdapterCool);
        json_string =getIntent().getExtras().getString("cool");
        try {
            mJSONObject = new JSONObject(json_string);
            mJSONArray = mJSONObject.getJSONArray("server_response");
            int count = 0;
            String name, socket, power, noise, speed, url, url_img;
            while (count<mJSONArray.length()) {
                JSONObject JO = mJSONArray.getJSONObject(count);
                name = JO.getString("c_name");
                socket = JO.getString("c_cocket");
                power = JO.getString("c_power");
                noise = JO.getString("c_noise");
                speed = JO.getString("c_speed");
                url = JO.getString("c_url");
                url_img = JO.getString("c_url_img");

                String nameprc = getIntent().getStringExtra("NAMEPRC_4");
                String namemath = getIntent().getStringExtra("NAMEMATH_3");
                String nameram = getIntent().getStringExtra("NAMERAM_2");
                String namevcard = getIntent().getStringExtra("NAMEvCARD");

                String sataMath = getIntent().getStringExtra("SATAMATH_3");

                String powerPrc = getIntent().getStringExtra("POWERPRC_4");
                String powerMath = getIntent().getStringExtra("POWERMAT_3");
                String powerRam = getIntent().getStringExtra("POWERAM_2");
                String powerVCard = getIntent().getStringExtra("POWERVCARD");
                String socprc = getIntent().getStringExtra("SOCPRC_4");

                String factor = getIntent().getStringExtra("FACTOR_3");


                final String CDATA_BEGIN = "LGA";
                String sss = socprc.substring(CDATA_BEGIN.length(),socprc.length()/1);


                int powerCool = Integer.parseInt(power);
               int powerprc = Integer.parseInt(powerPrc);

// nameprc+"\n"+namemath+"\n"+nameram+"\n"+namevcard+"\n"+powerprc+"\n"+socprc,Toast
    //            Toast.makeText(this,sss,Toast.LENGTH_LONG).show();

               if (socket.contains(sss)&&powerprc<=powerCool)
                {
                    ContactCool contactCool = new ContactCool(name, socket, power, noise, speed, url, url_img,
                                                                nameprc, namemath, nameram, namevcard, sataMath,
                                                                powerPrc, powerMath, powerRam, powerVCard, factor);
                    mContactAdapterCool.add(contactCool);
                }


                count++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




}
