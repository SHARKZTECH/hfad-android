package com.example.joke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=findViewById(R.id.btn);
        btn.setOnClickListener(view -> {
            Intent intent=new Intent(this,DelayedMsgService.class);
            intent.putExtra(DelayedMsgService.EXTRA_MESSAGE,getResources().getString(R.string.response));
            startService(intent);
        });
    }
}