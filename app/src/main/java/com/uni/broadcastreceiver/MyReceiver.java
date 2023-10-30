package com.uni.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (checkNetwork(context)) {
            Toast.makeText(context, "اتصال برقرار است", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "اتصال برقرار نیست", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkNetwork(Context mContext) {
        try {
            ConnectivityManager conManager =
                    (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = conManager.getActiveNetworkInfo();
            return (nInfo != null && nInfo.isConnected());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

}
