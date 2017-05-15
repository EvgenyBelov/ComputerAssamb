package com.easyway2in.mysqldbdemo.HDD;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.easyway2in.mysqldbdemo.R;
import com.easyway2in.mysqldbdemo.SSD.SSD;

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

public class HDD extends AppCompatActivity {

    String json_string;
    JSONObject mJSONObject;
    JSONArray mJSONArray;
    ContactAdapterHDD mContactAdapterHDD;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hdd);


        mListView = (ListView) findViewById(R.id.listview);
        mContactAdapterHDD = new ContactAdapterHDD(this,R.layout.row_layout_proc);
        mListView.setAdapter(mContactAdapterHDD);
        json_string =getIntent().getExtras().getString("hdd");
        try {
            mJSONObject = new JSONObject(json_string);
            mJSONArray = mJSONObject.getJSONArray("server_response");
            int count = 0;
            String name, sata, power, speed_disk, speed, url, url_img, memory;
            while (count<mJSONArray.length()) {
                JSONObject JO = mJSONArray.getJSONObject(count);
                name = JO.getString("h_name");
                sata = JO.getString("h_sata");
                speed = JO.getString("h_speed");
                memory = JO.getString("h_memory");
                speed_disk = JO.getString("h_speed_dick");
                power = JO.getString("h_power");
                url = JO.getString("h_url");
                url_img = JO.getString("h_url_img");

                String nameProc = getIntent().getStringExtra("NAMEPRC_5");
                String nameMath = getIntent().getStringExtra("NAMEMATH_4");
                String nameRam = getIntent().getStringExtra("NAMERAM_3");
                String nameVCard = getIntent().getStringExtra("NAMEvCARD_2");
                String nameCool = getIntent().getStringExtra("NAMECOOL");
                String SATAMath = getIntent().getStringExtra("SATAMATH_4");

                String powerPrc = getIntent().getStringExtra("POWERPRC_5");
                String powerMath = getIntent().getStringExtra("POWERMAT_4");
                String powerRam = getIntent().getStringExtra("POWERAM_3");
                String powerVCard = getIntent().getStringExtra("POWERVCARD_2");
                String powerCool = getIntent().getStringExtra("POWERCOOL");

                String factor = getIntent().getStringExtra("FACTOR_4");

                if (SATAMath.contains(sata)) {
                    ContactHDD contactHDD = new ContactHDD(name, sata, speed, memory, speed_disk, power, url, url_img,
                                                            nameProc, nameMath, nameRam, nameVCard, nameCool, SATAMath,
                                                            powerPrc, powerMath, powerRam, powerVCard, powerCool, factor);
                    mContactAdapterHDD.add(contactHDD);
                }
                count++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
