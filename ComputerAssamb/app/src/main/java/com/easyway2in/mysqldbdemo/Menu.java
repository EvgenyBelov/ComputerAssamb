package com.easyway2in.mysqldbdemo;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.easyway2in.mysqldbdemo.Prc.PrcActivity;
import com.easyway2in.mysqldbdemo.RecConfig.RecConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Menu extends AppCompatActivity {

    String json_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);


        Intent intent = getIntent();
        String one = intent.getStringExtra("one");
        if(one.equals("2")) {
            Button btmenu5 = (Button) findViewById(R.id.btmenu5);
            btmenu5.setVisibility(View.GONE);
        }

        new MyTask().execute();


    }
    //Реккомендуемы конфигурации


    public void RecConf(View view) {
    Intent intent = new Intent(this, RecConfig.class);
        startActivity(intent);
    }

    //Гибкое создание конфигураций
    public void GMENU (View view) {
        if(json_string==null){
            Toast.makeText(getApplicationContext(),"First GET JSON",Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this,PrcActivity.class);
            intent.putExtra("JD",json_string);
            startActivity(intent);

        }
    }


    //Кнопка выхода
    public void Exit (View view) {
        startActivity(new Intent(this, MainActivity.class));
    }


    class MyTask extends AsyncTask<Void,Void,String> {

        String json_url;
        String JSON_STRING;

        @Override
        protected void onPreExecute() {
            json_url = "http://overtopman.myjino.ru/scripts/proc/json_get_data_proc.php";
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
