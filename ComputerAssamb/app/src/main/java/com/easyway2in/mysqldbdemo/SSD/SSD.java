package com.easyway2in.mysqldbdemo.SSD;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.easyway2in.mysqldbdemo.pSupply.PowerSupply;
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

public class SSD extends AppCompatActivity {

    String json_string;
    JSONObject mJSONObject;
    JSONArray mJSONArray;
    ContactAdapterSSD mContactAdapterSSD;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssd);


        mListView = (ListView) findViewById(R.id.listview);
        mContactAdapterSSD = new ContactAdapterSSD(this,R.layout.row_layout_proc);
        mListView.setAdapter(mContactAdapterSSD);
        json_string =getIntent().getExtras().getString("ssd");
        try {
            mJSONObject = new JSONObject(json_string);
            mJSONArray = mJSONObject.getJSONArray("server_response");
            int count = 0;
            String name, interfc, power, time, speed, url, url_img, memory;
            while (count<mJSONArray.length()) {
                JSONObject JO = mJSONArray.getJSONObject(count);
                name = JO.getString("s_name");
                interfc = JO.getString("s_interface");
                time = JO.getString("s_time");
                memory = JO.getString("s_memory");
                speed = JO.getString("s_speed");
                power = JO.getString("s_power");
                url = JO.getString("s_url");
                url_img = JO.getString("s_url_img");

                String namePrc = getIntent().getStringExtra("NAMEPRC_6");
                String nameMath = getIntent().getStringExtra("NAMEMATH_5");
                String nameRam = getIntent().getStringExtra("NAMERAM_4");
                String nameVCard = getIntent().getStringExtra("NAMEvCARD_3");
                String nameHDD = getIntent().getStringExtra("NAMEHDD");
                String nameCool = getIntent().getStringExtra("NAMECOOL_2");

                String sataMath = getIntent().getStringExtra("SATAMATH_4");

                String powerPrc = getIntent().getStringExtra("POWERPRC_6");
                String powerMath = getIntent().getStringExtra("POWERMAT_5");
                String powerRam = getIntent().getStringExtra("POWERAM_4");
                String powerVCard = getIntent().getStringExtra("POWERVCARD_3");
                String powerCool = getIntent().getStringExtra("POWERCOOL_2");
                String powerHDD = getIntent().getStringExtra("POWERHDD");


                String factor = getIntent().getStringExtra("FACTOR_5");

                if (sataMath.contains(interfc)) {
                    ContactSSD contactSSD = new ContactSSD(name, interfc, time, memory, speed, power, url, url_img,
                                                            namePrc, nameMath, nameRam, nameVCard, nameHDD, nameCool,
                                                            powerPrc, powerMath, powerRam, powerVCard, powerCool, powerHDD,
                                                            factor);
                    mContactAdapterSSD.add(contactSSD);
                }
                count++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
