package com.example.workout1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class StopWatchFragment extends Fragment {
    private int seconds=0;
    private boolean running;
    private boolean wasRunning;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState !=null){
            seconds=savedInstanceState.getInt("seconds");
            running=savedInstanceState.getBoolean("running");
            wasRunning=savedInstanceState.getBoolean("wasRunning");
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_stop_watch, container, false);
        btnClick(view);
        runTimer(view);
        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        if(wasRunning){
            running=true;
        }
    }
    @Override
    public void onStop() {
        super.onStop();
        wasRunning=running;
        running=false;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running",running);
        savedInstanceState.putBoolean("wasRunning",wasRunning);
    }
    private void btnClick(View view1){
        Button start=view1.findViewById(R.id.start);
        Button stop=view1.findViewById(R.id.stp);
        Button reset=view1.findViewById(R.id.reset);

        start.setOnClickListener(view -> running=true);

        stop.setOnClickListener(view -> running=false);

        reset.setOnClickListener(view -> {
            running=false;
            seconds=0;
        });

    }
    private void runTimer(View view){
        TextView txt=view.findViewById(R.id.text);
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