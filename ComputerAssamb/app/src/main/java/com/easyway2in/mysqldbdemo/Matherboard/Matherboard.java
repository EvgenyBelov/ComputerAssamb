package com.easyway2in.mysqldbdemo.Matherboard;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.easyway2in.mysqldbdemo.R;
import com.easyway2in.mysqldbdemo.Ram.RamCl;

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

public class Matherboard extends AppCompatActivity {

    String json_string;
    JSONObject mJSONObject;
    JSONArray mJSONArray;
    ContactAdapterMath mContactAdapterMath;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matherboard);


        mListView = (ListView) findViewById(R.id.listview);
        mContactAdapterMath = new ContactAdapterMath(this,R.layout.row_layout_proc);
        mListView.setAdapter(mContactAdapterMath);
        json_string =getIntent().getExtras().getString("Math");
        try {
            mJSONObject = new JSONObject(json_string);
            mJSONArray = mJSONObject.getJSONArray("server_response");
            int count = 0;
            String name, socket, memory, memory_max, pci_one, pci_two,
                    vga, factor, sata, power, url, url_img;
            while (count<mJSONArray.length()) {
                JSONObject JO = mJSONArray.getJSONObject(count);
                name = JO.getString("m_name");
                socket = JO.getString("m_socket");
                memory = JO.getString("m_memory");
                memory_max = JO.getString("m_memory_max");
                pci_one = JO.getString("m_pci_one");
                pci_two = JO.getString("m_pci_two");
                vga = JO.getString("m_vga");
                factor = JO.getString("m_factor");
                sata = JO.getString("m_sata");
                power = JO.getString("m_power");
                url = JO.getString("m_url");
                url_img = JO.getString("m_url_img");
                String nameprc = getIntent().getStringExtra("NAMEPRC");
                String powerPRC = getIntent().getStringExtra("powerPRC");

                String soc = getIntent().getStringExtra("soc");

                if (socket.equals(soc)) {
                    ContactMath contactMath = new ContactMath(name, socket, memory, memory_max, pci_one, pci_two,
                            vga, factor, sata, power, url, url_img, soc, nameprc, powerPRC);
                    mContactAdapterMath.add(contactMath);

                }
                count++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
