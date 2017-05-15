package com.easyway2in.mysqldbdemo.Casee;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.easyway2in.mysqldbdemo.R;
import com.easyway2in.mysqldbdemo.Ram.RamCl;
import com.easyway2in.mysqldbdemo.Settings;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeny on 13.05.2017.
 */

public class ContactAdapterCase extends ArrayAdapter {
    List list = new ArrayList();
    String json_string;

    public ContactAdapterCase(Context context, int resource) {
        super(context, resource);
    }


    public void add(ContactCase object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        row = convertView;
        ContactHolder contactHolder;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater)
                    this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout_proc,parent,false);
            contactHolder = new ContactHolder();
            contactHolder.tx_name = (TextView) row.findViewById(R.id.tx_global);
            contactHolder.tx_front = (TextView) row.findViewById(R.id.tx_socket);
            contactHolder.tx_size = (TextView) row.findViewById(R.id.tx_core);
            contactHolder.tx_mass = (TextView) row.findViewById(R.id.tx_freq);
            contactHolder.tx_factor= (TextView) row.findViewById(R.id.tx_cache);
            contactHolder.imjURL = (ImageView) row.findViewById(R.id.imjURL);
            contactHolder.tx_url = (TextView) row.findViewById(R.id.tx_url);
            contactHolder.btnADD = (Button) row.findViewById(R.id.btnADD);
            contactHolder.btnURL = (Button) row.findViewById(R.id.btnURL);

            row.setTag(contactHolder);
        } else {
            contactHolder = (ContactHolder) row.getTag();
        }
        final ContactCase contactCase = (ContactCase) this.getItem(position);
        contactHolder.tx_name.setText(contactCase.getName());
        contactHolder.tx_factor.setText("Форм-фактор: " + contactCase.getFactor());
        contactHolder.tx_front.setText("Лиц. панель: " + contactCase.getFront());
        contactHolder.tx_size.setText("Габ. (ШхВхГ): " + contactCase.getSize()+" мм");
        contactHolder.tx_mass.setText("Масса: " + contactCase.getMass()+" Кг");
        contactHolder.tx_url.setText(contactCase.getUrl());


        Picasso.with(getContext())
                .load(contactCase.getUrl_img())
                .placeholder(R.drawable.vectorimg)
                .into(contactHolder.imjURL);

        contactHolder.btnURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri address = Uri.parse(contactCase.getUrl());
                Intent openlink = new Intent(Intent.ACTION_VIEW, address);
                getContext().startActivity(openlink);
            }
        });

        contactHolder.btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),Settings.class);
                intent.putExtra("NAMEPRC_9", contactCase.getNamePrc());
                intent.putExtra("NAMEMATH_8", contactCase.getNameMath());
                intent.putExtra("NAMERAM_7", contactCase.getNameRam());
                intent.putExtra("NAMEvCARD_6", contactCase.getNameVCard());
                intent.putExtra("NAMEHDD_4", contactCase.getNameHDD());
                intent.putExtra("NAMECOOL_5", contactCase.getNameCool());
                intent.putExtra("NAMESSD_3", contactCase.getNameSSD());
                intent.putExtra("NAMEPSUP_2", contactCase.getNamePsup());
                intent.putExtra("NAMECASE", contactCase.getName());

                getContext().startActivity(intent);
            }
        });




        return row;
    }

    static  class ContactHolder {
        TextView tx_name, tx_factor, tx_front, tx_size, tx_mass, tx_time, tx_url;
        ImageView imjURL;
        Button btnADD, btnURL;

    }
}
