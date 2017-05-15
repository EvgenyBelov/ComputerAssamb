package com.easyway2in.mysqldbdemo.Casee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.easyway2in.mysqldbdemo.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Case extends AppCompatActivity {

    String json_string;
    JSONObject mJSONObject;
    JSONArray mJSONArray;
    ContactAdapterCase mContactAdapdetCase;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case);

        mListView = (ListView) findViewById(R.id.listview);
        mContactAdapdetCase = new ContactAdapterCase(this,R.layout.row_layout_proc);
        mListView.setAdapter(mContactAdapdetCase);
        json_string =getIntent().getExtras().getString("case");
        try {
            mJSONObject = new JSONObject(json_string);
            mJSONArray = mJSONObject.getJSONArray("server_response");
            int count = 0;
            String name, factor, front, size, url, url_img, mass, factor_2, factor_3, factor_4;
            while (count<mJSONArray.length()) {
                JSONObject JO = mJSONArray.getJSONObject(count);
                name = JO.getString("cs_name");
                factor = JO.getString("cs_factor");
                factor_2 = JO.getString("cs_factor_2");
                factor_3 = JO.getString("cs_factor_3");
                factor_4 = JO.getString("cs_factor_4");
                front = JO.getString("cs_front");
                size = JO.getString("cs_size");
                mass = JO.getString("cs_mass");
                url = JO.getString("cs_url");
                url_img = JO.getString("cs_url_img");

                String namePrc = getIntent().getStringExtra("NAMEPRC_8");
                String nameMath = getIntent().getStringExtra("NAMEMATH_7");
                String nameRam = getIntent().getStringExtra("NAMERAM_6");
                String nameVCard = getIntent().getStringExtra("NAMEvCARD_5");
                String nameHDD = getIntent().getStringExtra("NAMEHDD_3");
                String nameCool = getIntent().getStringExtra("NAMECOOL_4");
                String nameSSD = getIntent().getStringExtra("NAMESSD_2");
                String namePsup = getIntent().getStringExtra("NAMEPSUP");
                String fMAth = getIntent().getStringExtra("FACTOR_7");


                if (factor.equals(fMAth)) {
                    ContactCase contactCase = new ContactCase(name, factor, front, size, mass, url, url_img, factor_2, factor_3, factor_4,
                                                                namePrc, nameMath, nameRam, nameVCard, nameHDD, nameCool, nameSSD, namePsup);
                    mContactAdapdetCase.add(contactCase);
                } else if (factor_2.equals(fMAth)) {
                    ContactCase contactCase = new ContactCase(name, factor, front, size, mass, url, url_img,factor_2, factor_3, factor_4,
                            namePrc, nameMath, nameRam, nameVCard, nameHDD, nameCool, nameSSD, namePsup);
                    mContactAdapdetCase.add(contactCase);
                } else if (factor_3.equals(fMAth)) {
                    ContactCase contactCase = new ContactCase(name, factor, front, size, mass, url, url_img,factor_2, factor_3, factor_4,
                            namePrc, nameMath, nameRam, nameVCard, nameHDD, nameCool, nameSSD, namePsup);
                    mContactAdapdetCase.add(contactCase);
                } else if (factor_4.equals(fMAth)) {
                    ContactCase contactCase = new ContactCase(name, factor, front, size, mass, url, url_img,factor_2, factor_3, factor_4,
                            namePrc, nameMath, nameRam, nameVCard, nameHDD, nameCool, nameSSD, namePsup);
                    mContactAdapdetCase.add(contactCase);
                }


                count++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
