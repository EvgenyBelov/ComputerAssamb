package com.easyway2in.mysqldbdemo.pSupply;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.FloatRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.easyway2in.mysqldbdemo.Casee.Case;
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

public class PowerSupply extends AppCompatActivity {

    String json_string;
    JSONObject mJSONObject;
    JSONArray mJSONArray;
    ContactAdapdetPSupply mContactAdapdetPSupply;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_supply);


        mListView = (ListView) findViewById(R.id.listview);
        mContactAdapdetPSupply = new ContactAdapdetPSupply(this,R.layout.row_layout_proc);
        mListView.setAdapter(mContactAdapdetPSupply);
        json_string =getIntent().getExtras().getString("psupply");
        try {
            mJSONObject = new JSONObject(json_string);
            mJSONArray = mJSONObject.getJSONArray("server_response");
            int count = 0;
            String name, factor, power, cert, stand, url, url_img, memory;
            while (count<mJSONArray.length()) {
                JSONObject JO = mJSONArray.getJSONObject(count);
                name = JO.getString("ps_name");
                power = JO.getString("ps_power");
                factor = JO.getString("ps_factor");
                cert = JO.getString("ps_cert");
                stand = JO.getString("ps_stand");
                url = JO.getString("ps_url");
                url_img = JO.getString("ps_url_img");

                String powerPrc = getIntent().getStringExtra("POWERPRC_7");
                String powerMath = getIntent().getStringExtra("POWERMAT_6");
                String powerRam = getIntent().getStringExtra("POWERAM_5");
                String powerVCard = getIntent().getStringExtra("POWERVCARD_4");
                String powerCool = getIntent().getStringExtra("POWERCOOL_3");
                String powerHDD = getIntent().getStringExtra("POWERHDD_2");
                String powerSSD = getIntent().getStringExtra("POWERSSD");

                String namePrc = getIntent().getStringExtra("NAMEPRC_7");
                String nameMath = getIntent().getStringExtra("NAMEMATH_6");
                String nameRam = getIntent().getStringExtra("NAMERAM_5");
                String nameVCard = getIntent().getStringExtra("NAMEvCARD_4");
                String nameCool = getIntent().getStringExtra("NAMECOOL_3");
                String nameHDD = getIntent().getStringExtra("NAMEHDD_2");
                String nameSSD = getIntent().getStringExtra("NAMESSD");

                String fMath = getIntent().getStringExtra("FACTOR_6");

                Float pPrc = Float.parseFloat(powerPrc);
                Float pMath = Float.parseFloat(powerMath);
                Float pRAm = Float.parseFloat(powerRam);
                Float pVCard = Float.parseFloat(powerVCard);
                Float pCool = Float.parseFloat(powerCool);
                Float pHDD = Float.parseFloat(powerHDD);
                Float pSSD = Float.parseFloat(powerSSD);
                Float power_p = Float.parseFloat(power);
                Float sum = pPrc + pMath + pRAm + pVCard + pCool + pHDD + pSSD;
                String ppp = String.valueOf(sum);
                //Toast.makeText(getApplicationContext(),factor+fMath,Toast.LENGTH_LONG).show();

                if (fMath.equals("microATX")||fMath.equals("flexATX")) {
                    if (sum<power_p&&factor.equals("SFX")) {
                        ContactPSupply contactPSupply = new ContactPSupply(name, power, factor, cert, stand, url, url_img,
                                                                            namePrc, nameMath, nameRam, nameVCard, nameCool, nameHDD, nameSSD,
                                                                            fMath);
                        mContactAdapdetPSupply.add(contactPSupply);
                    }
                } else {
                    if (sum < power_p && factor.equals(fMath)) {
                        ContactPSupply contactPSupply = new ContactPSupply(name, power, factor, cert, stand, url, url_img,
                                                                            namePrc, nameMath, nameRam, nameVCard, nameCool, nameHDD, nameSSD,
                                                                            fMath);
                        mContactAdapdetPSupply.add(contactPSupply);
                    }
                }
                count++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}
