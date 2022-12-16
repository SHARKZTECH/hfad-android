package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveMsgActivity extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_msg);

        txt=findViewById(R.id.txt);
        Intent i=getIntent();


        String msg=i.getStringExtra("msg");
        txt.setText(msg);
    }
}