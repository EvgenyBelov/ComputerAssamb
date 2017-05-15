package com.easyway2in.mysqldbdemo.VCArd;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.easyway2in.mysqldbdemo.Cooling.Cooling;
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

public class VideoCard extends AppCompatActivity {

    String json_string;
    JSONObject mJSONObject;
    JSONArray mJSONArray;
    ContactAdapterVCard mContactAdapterVCard;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_card_layout);



        mListView = (ListView) findViewById(R.id.listview);
        mContactAdapterVCard = new ContactAdapterVCard(this,R.layout.row_layout_proc);
        mListView.setAdapter(mContactAdapterVCard);
        json_string =getIntent().getExtras().getString("vCard");
        try {
            mJSONObject = new JSONObject(json_string);
            mJSONArray = mJSONObject.getJSONArray("server_response");
            int count = 0;
            String name, pci, pci_ver, memory, type, shina, power, url, url_img;
            while (count<mJSONArray.length()) {
                JSONObject JO = mJSONArray.getJSONObject(count);
                name = JO.getString("v_name");
                pci = JO.getString("v_pci");
                pci_ver = JO.getString("v_pci_ver");
                memory = JO.getString("v_memory");
                type = JO.getString("v_type");
                shina = JO.getString("v_shina");
                power = JO.getString("v_power");
                url = JO.getString("v_url");
                url_img = JO.getString("v_url_img");
                String nameprc = getIntent().getStringExtra("NAMEPRC_3");
                String namemath = getIntent().getStringExtra("NAMEMATH_2");
                String nameram = getIntent().getStringExtra("NAMERAM");
                String powerPRC = getIntent().getStringExtra("POWERPRC_3");
                String powerMath = getIntent().getStringExtra("POWERMATH_2");
                String powerRam = getIntent().getStringExtra("POWERRAM");
                String socPRC = getIntent().getStringExtra("SOCPRC_3");
                String sataMath = getIntent().getStringExtra("SATAMATH_2");

                String factor = getIntent().getStringExtra("FACTOR_2");

                String pci_one = getIntent().getStringExtra("PCIONE");
                String pci_two = getIntent().getStringExtra("PCITWO");


               if (pci_one.contains(pci)&&pci_two.contains(pci_ver)) {
                        ContactVCard contactVCard = new ContactVCard(name, pci, pci_ver, memory, type, shina, power, url, url_img,
                                                                        nameprc, namemath, nameram, powerPRC, socPRC, sataMath,
                                                                    powerMath, powerRam, factor);
                        mContactAdapterVCard.add(contactVCard);
                   }

                count++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
