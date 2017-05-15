package com.easyway2in.mysqldbdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;


public class MainActivity extends Activity{
    EditText ET_NAME,ET_PASS;
    String login_name,login_pass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     ET_NAME = (EditText)findViewById(R.id.user_name);
        ET_PASS = (EditText)findViewById(R.id.user_pass);

    }
//Кнопка регистрации
public void userReg(View view)
{
    startActivity(new Intent(this,Register.class));
}



public void userLogin(View view)
    {
        login_name = ET_NAME.getText().toString();
        login_pass = ET_PASS.getText().toString();
        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,login_name,login_pass);
        try {
            String res = backgroundTask.get();
            if(res.equals("Login Success ")){
                Intent intent = new Intent(this,Menu.class);
                intent.putExtra("one", "1");
                startActivity(intent);


            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void userUnReg (View view) {
        Intent intent = new Intent(this,Menu.class);
        intent.putExtra("one","2");
        startActivity(intent);

    }


}
