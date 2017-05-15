package com.easyway2in.mysqldbdemo.RecConfig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.easyway2in.mysqldbdemo.R;

public class RecConfig extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_config);
    }

    public void BTN_one (View view) {
        Intent intent = new Intent(this, Office.class);
        startActivity(intent);

    }

    public void BTN_two (View view) {
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);

    }

    public void BTN_thr (View view) {
        Intent intent = new Intent(this, Media.class);
        startActivity(intent);

    }
}
