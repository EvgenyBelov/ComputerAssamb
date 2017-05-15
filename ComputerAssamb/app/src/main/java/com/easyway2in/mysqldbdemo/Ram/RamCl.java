package com.easyway2in.mysqldbdemo.Ram;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.easyway2in.mysqldbdemo.R;
import com.easyway2in.mysqldbdemo.VCArd.VideoCard;

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

public class RamCl extends AppCompatActivity {

    String json_string;
    JSONObject mJSONObject;
    JSONArray mJSONArray;
    ContactAdapterRam mContactAdapterRAm;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ram__layout);


        mListView = (ListView) findViewById(R.id.listview);
        mContactAdapterRAm = new ContactAdapterRam(this,R.layout.row_layout_proc);
        mListView.setAdapter(mContactAdapterRAm);
        json_string =getIntent().getExtras().getString("ram");
        try {
            mJSONObject = new JSONObject(json_string);
            mJSONArray = mJSONObject.getJSONArray("server_response");
            int count = 0;
            String name, memory, memory_max, freq, power, url, url_img;
            while (count<mJSONArray.length()) {
                JSONObject JO = mJSONArray.getJSONObject(count);
                name = JO.getString("r_name");
                memory = JO.getString("r_memory");
                memory_max = JO.getString("r_memory_max");
                freq = JO.getString("r_freq");
                power = JO.getString("r_power");
                url = JO.getString("r_url");
                url_img = JO.getString("r_url_img");
                String nameprc = getIntent().getStringExtra("NAMEPRC_2");
                String namemath = getIntent().getStringExtra("NAMEMATH");
                String pci_1 = getIntent().getStringExtra("PCI_1");
                String pci_2 = getIntent().getStringExtra("PCI_2");
                String powerPRC = getIntent().getStringExtra("POWERPRC_2");
                String powerMath = getIntent().getStringExtra("POWERMATH");
                String socPRC = getIntent().getStringExtra("SOCPRC_2");
                String sataMAth = getIntent().getStringExtra("SATAMATH");
                String factor = getIntent().getStringExtra("FACTOR");

                String mem = getIntent().getStringExtra("mem");
                String max_mem = getIntent().getStringExtra("max_mem");
                int kol = Integer.parseInt(memory_max);
                int max_kol = Integer.parseInt(max_mem);

                if (memory.equals(mem)&&kol<=max_kol) {
                    ContactRam contactRam = new ContactRam(name, memory, memory_max, freq, power, url, url_img,
                                                            nameprc, namemath, pci_1, pci_2, powerPRC, powerMath,socPRC,
                                                            sataMAth, factor);
                    mContactAdapterRAm.add(contactRam);
                }
                count++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
