package com.easyway2in.mysqldbdemo.RecConfig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.easyway2in.mysqldbdemo.HDD.HDD;
import com.easyway2in.mysqldbdemo.R;

public class Media extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
    }

    public void BTN_one (View view) {
        Intent intent = new Intent(this, HDDConfig.class);
        startActivity(intent);

    }

    public void BTN_two (View view) {
        Intent intent = new Intent(this, HDDConfig.class);
        startActivity(intent);

    }


}
