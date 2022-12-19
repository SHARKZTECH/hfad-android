package com.example.stopwatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button start;
    Button stop;
    Button reset;

    private int seconds=0;
    private boolean running;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState !=null){
            seconds=savedInstanceState.getInt("seconds");
            running=savedInstanceState.getBoolean("running");
            wasRunning=savedInstanceState.getBoolean("wasRunning");
        }

        start=findViewById(R.id.start);
        stop=findViewById(R.id.stp);
        reset=findViewById(R.id.reset);

        start.setOnClickListener(view -> running=true);

        stop.setOnClickListener(view -> running=false);

        reset.setOnClickListener(view -> {
            running=false;
            seconds=0;
        });


        runTimer();
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running",running);
        savedInstanceState.putBoolean("wasRunning",wasRunning);
    }
    @Override
    protected void onStart() {
        super.onStart();
        if(wasRunning){
            running=true;
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        wasRunning=running;
        running=false;
    }

    private void runTimer(){
        txt=findViewById(R.id.text);
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hrs=seconds/3600;
                int mts=(seconds%3600)/60;
                int sec=seconds%60;

                String time=String.format(Locale.getDefault(),"%d:%02d:%02d",hrs,mts,sec);
                txt.setText(time);
                if(running){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
}