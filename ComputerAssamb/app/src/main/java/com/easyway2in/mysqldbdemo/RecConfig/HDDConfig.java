package com.easyway2in.mysqldbdemo.RecConfig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.easyway2in.mysqldbdemo.R;
import com.easyway2in.mysqldbdemo.SSD.SSD;

public class HDDConfig extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hddconfig);
    }

    public void BTN_one (View view) {
        Intent intent = new Intent(this, SSDConfig.class);
        startActivity(intent);

    }

    public void BTN_two (View view) {
        Intent intent = new Intent(this, SSDConfig.class);
        startActivity(intent);

    }

}
