package com.easyway2in.mysqldbdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.MalformedJsonException;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;


public class Register extends Activity {
    EditText ET_NAME,ET_USER_NAME,ET_USER_PASS, et_pass;
    String name,user_name,user_pass, pass_p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        ET_NAME = (EditText)findViewById(R.id.name);
        ET_USER_NAME= (EditText)findViewById(R.id.new_user_name);
        ET_USER_PASS = (EditText)findViewById(R.id.new_user_pass);
        et_pass = (EditText) findViewById(R.id.new_user_pass_2);


    }
 public void userReg(View view)
 {

     name = ET_NAME.getText().toString();
     user_name = ET_USER_NAME.getText().toString();
     user_pass = ET_USER_PASS.getText().toString();
     pass_p = et_pass.getText().toString();



if(user_pass.equals(pass_p)){
    MyTask myTask = new MyTask();
    myTask.execute(name,user_name,user_pass);
    finish();

     } else {

         Toast toast = Toast.makeText(getApplicationContext(),
                 "Пароли не совпадают, введите еще раз", Toast.LENGTH_SHORT);
         toast.show();
     }
 }

 class MyTask extends AsyncTask<String,Void,String> {

     String add_info_url;

     @Override
     protected void onPreExecute() {

        add_info_url = "http://overtopman_assembler@overtopman.myjino.ru/scripts/info/add_info.php";
     }

     @Override
     protected String doInBackground(String... args) {
         String user, user_name, user_pass;
         user = args[0];
         user_name = args[1];
         user_pass = args[2];
         try {
             URL url = new URL(add_info_url);
             HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
             httpURLConnection.setRequestMethod("POST");
             httpURLConnection.setDoOutput(true);

             //httpURLConnection.setDoInput(true);
             OutputStream OS = httpURLConnection.getOutputStream();
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
             String data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8") + "&" +
                     URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&" +
                     URLEncoder.encode("user_pass", "UTF-8") + "=" + URLEncoder.encode(user_pass, "UTF-8");
             bufferedWriter.write(data);
             bufferedWriter.flush();
             bufferedWriter.close();
             OS.close();
             InputStream IS = httpURLConnection.getInputStream();
             IS.close();
             //httpURLConnection.connect();
             httpURLConnection.disconnect();
             return "Регистрация прошла успешно...";


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
         Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
     }
 }


}
