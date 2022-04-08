package com.example.connectivitymanager_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkChangeReceiver extends BroadcastReceiver {

    boolean isWiFi;
    boolean WiMax;

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectionManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isAvailable()) {
            if(isWiFi = networkInfo.getType() == ConnectivityManager.TYPE_WIFI){
                Log.d("MainActivity","WIFI网络已连接");
            }
            else if(WiMax = networkInfo.getType() ==ConnectivityManager.TYPE_WIMAX) {
                Log.d("MainActivity","移动网络已连接");
            }
        }

        if(networkInfo== null){

            Log.d("MainActivity","网络连接已断开");
        }

    }
}
