package com.easyway2in.mysqldbdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        TextView prc, moth, ram, vcard, cool, hdd, ssd, psuplly, casee;
        prc = (TextView) findViewById(R.id.tx_nameprc);
        moth = (TextView) findViewById(R.id.tx_nameMath);
        ram = (TextView) findViewById(R.id.tx_nameRam);
        vcard = (TextView) findViewById(R.id.tx_nameVCard);
        cool = (TextView) findViewById(R.id.tx_nameCool);
        hdd = (TextView) findViewById(R.id.tx_nameHDD);
        ssd = (TextView) findViewById(R.id.tx_nameSSD);
        psuplly = (TextView) findViewById(R.id.tx_namePSup);
        casee = (TextView) findViewById(R.id.tx_nameCase);

        String tprc, tmoth, tram, tvcard, tcool, thdd, tssd, tpsuplly, tcasee;
        tprc = getIntent().getStringExtra("NAMEPRC_9");
        tmoth = getIntent().getStringExtra("NAMEMATH_8");
        tram = getIntent().getStringExtra("NAMERAM_7");
        tvcard = getIntent().getStringExtra("NAMEvCARD_6");
        thdd = getIntent().getStringExtra("NAMEHDD_4");
        tcool = getIntent().getStringExtra("NAMECOOL_5");
        tssd = getIntent().getStringExtra("NAMESSD_3");
        tpsuplly = getIntent().getStringExtra("NAMEPSUP_2");
        tcasee = getIntent().getStringExtra("NAMECASE");

        //Toast.makeText(this,tprc,Toast.LENGTH_LONG).show();

        prc.setText(tprc);
        moth.setText(tmoth);
        ram.setText(tram);
        vcard.setText(tvcard);
        cool.setText(tcool);
        hdd.setText(thdd);
        ssd.setText(tssd);
        psuplly.setText(tpsuplly);
        casee.setText(tcasee);
    }
}
