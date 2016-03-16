package com.christopherdmark.simplethreadtimer;

import android.os.Bundle;
import android.os.Message;

import android.support.v7.app.AppCompatActivity;

import android.util.Log;


import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private Handler myHandler;
    boolean gameOn;
    long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startTime = System.currentTimeMillis();

        myHandler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (gameOn) {
                    long seconds = ((System.currentTimeMillis()- startTime)) / 1000;

                    Log.i("info", "seconds = " + seconds);
                }

                myHandler.sendEmptyMessageDelayed(0,1000);
            }

        };

        gameOn = true;
        myHandler.sendEmptyMessage(0);



    }


}
