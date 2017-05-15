package com.easyway2in.mysqldbdemo.Prc;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.easyway2in.mysqldbdemo.Matherboard.Matherboard;
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
import java.util.List;

public class PrcActivity extends AppCompatActivity {

    String json_string;
    JSONObject mJSONObject;
    JSONArray mJSONArray;
    ContactAdapter mContactAdapter;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prc_layout);




        mListView = (ListView) findViewById(R.id.listview);
        mContactAdapter = new ContactAdapter(this,R.layout.row_layout_proc);
        mListView.setAdapter(mContactAdapter);
        json_string =getIntent().getExtras().getString("JD");
        try {
            mJSONObject = new JSONObject(json_string);
            mJSONArray = mJSONObject.getJSONArray("server_response");
            int count = 0;
            String name, socket, core, freq, cache, cache_two, cache_thr, url, url_img, power;
            while (count<mJSONArray.length()) {
                JSONObject JO = mJSONArray.getJSONObject(count);
                name = JO.getString("p_name");
                socket = JO.getString("p_socket");
                core = JO.getString("p_core");
                freq = JO.getString("p_freq");
                cache = JO.getString("p_cache");
                cache_two = JO.getString("p_cahe_two");
                cache_thr = JO.getString("p_cache_thr");
                power = JO.getString("p_power");
                url = JO.getString("p_url");
                url_img = JO.getString("p_url_img");

                Contacts contacts = new Contacts(name, socket, core, freq, cache, cache_two, cache_thr,power, url, url_img);
                mContactAdapter.add(contacts);
                count++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

  /*public  void BtnURL (View view) {

        TextView ttx = (TextView) findViewById(R.id.tx_url);
        ttx.getText().toString();
        String url = ttx.getText().toString();
        Toast toast = Toast.makeText(getApplicationContext(),
                "Переходим на Ynadex.Market...", Toast.LENGTH_SHORT);
        toast.show();

        Uri address = Uri.parse(url);
        Intent openlink = new Intent(Intent.ACTION_VIEW, address);
        startActivity(openlink);


    }*/

   /* public  void BtnADD (View view) {

        if(json_string==null){
            Toast.makeText(getApplicationContext(),"First GET JSON",Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this,Matherboard.class);
            intent.putExtra("Math",json_string);
            startActivity(intent);

        }


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
    }*/
}
