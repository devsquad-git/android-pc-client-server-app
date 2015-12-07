package com.devsquad.dmg.clientapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.connectButton);
        final EditText tb = (EditText) findViewById(R.id.textBox);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ipAddress = tb.getText().toString();
                NetworkThread nt = new NetworkThread(ipAddress);
                new Thread(nt).start();

            }
        });

    }
}
