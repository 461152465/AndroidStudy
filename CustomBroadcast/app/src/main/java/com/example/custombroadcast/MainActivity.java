package com.example.custombroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        Button button = (Button) findViewById(R.id.button_send_broadcast);
        button.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){
               Intent intent = new Intent("com.example.custombroadcast.LOCAL_BROADCAST");
               localBroadcastManager.sendBroadcast(intent);
           }
        });

        //注册本地广播监听器
        intentFilter = new IntentFilter();
        localReceiver = new LocalReceiver();
        intentFilter.addAction("com.example.custombroadcast.LOCAL_BROADCAST");
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver); //注销活动
    }

    class LocalReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent){
            Toast.makeText(context, "received a local msg",Toast.LENGTH_SHORT).show();
        }
    }
}

