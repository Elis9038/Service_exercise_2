package com.example.opilane.service2;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

public class TheService extends Service {

    Context thisContext;
    private boolean running = false;

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service created", Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (running) Toast.makeText(this, "Service already runing", Toast.LENGTH_LONG).show();
        else {
            final int currentId = startId;
            running = true;
            new CountDownTimer(30000, 1000) {

                public void onTick(long millisUntilFinished) {
                    if (!running) cancel();
                    else sendMessage(currentId);
                }

                public void onFinish() {
                    Toast.makeText(thisContext, "Finished", Toast.LENGTH_LONG).show();
                }

            }.start();
        }
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        running = false;
        Toast.makeText(this, "Service destroyed", Toast.LENGTH_LONG).show();
    }

    private void sendMessage(int id){
        final int currentId = id;
        Handler handler = new Handler(TheService.this.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "Service " + currentId + " is working", Toast.LENGTH_LONG).show();
            }
        });
    }
}