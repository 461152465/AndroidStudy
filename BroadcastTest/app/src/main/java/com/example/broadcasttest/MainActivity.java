package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private NetworkChangeReceiver networkChangeReceiver;
    private IntentFilter intentFilter; //一般不在MainActivity中使用IntentFilter类

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //广播需要监听到的信息在InterFilter类中使用addAction方法添加
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        //使用registerReceiver方法进行注册
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);
    }

    //BroadcastReceiver类在原先的活动中并没有，所以不存在重写方法的问题
    class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent){
            //ConnectivityManager和NetworkInfo两个类组合使用
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if(networkInfo != null && networkInfo.isAvailable()){
                Toast.makeText(context, "network is available",Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(context, "network is not available",Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }
}
