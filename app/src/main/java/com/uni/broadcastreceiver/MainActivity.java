package com.uni.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            myReceiver = new MyReceiver();
            registerReceiver(myReceiver,
                    new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        unregisterReceiver(myReceiver);
        super.onPause();
    }
}