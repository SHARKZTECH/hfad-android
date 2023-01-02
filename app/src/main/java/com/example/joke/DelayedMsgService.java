package com.example.joke;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import androidx.core.app.NotificationCompat;


public class DelayedMsgService extends IntentService {
    public static final String EXTRA_MESSAGE="message";
    public static final int NOTIFICATION_ID = 5453;


    public DelayedMsgService() {
        super("DelayedMsgService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this){
            try{
                wait(10000);
            }catch (InterruptedException e){
               e.printStackTrace();
            }
        }
        String text=intent.getStringExtra(EXTRA_MESSAGE);
        showText(text);
    }

    private void showText(String text){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .setContentTitle(getString(R.string.question))
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(new long[] {Long.valueOf(0), Long.valueOf(1000)})
                .setAutoCancel(true);

        Intent intent=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(NOTIFICATION_ID,builder.build());

    }

}