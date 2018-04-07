package com.example.broadcastbestpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 461152465 on 2018/4/7.
 * 作为所有类的父类
 */

public class BaseActivity extends AppCompatActivity {

    private ForceOfflineReceiver receiver; //在onResume()方法中需要用到

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    //OnResume()的时候活动在栈顶，OnPause()的时候活动不在栈顶
    @Override
    public void onResume(){
        super.onResume();
        //监听发出的广播
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcastbestpractice.FORCE_OFFLINE");
        receiver = new ForceOfflineReceiver();
        registerReceiver(receiver, intentFilter);

    }

    @Override
    public void onPause(){
        super.onPause();
        //如果onPause()则需要取消Receiver的监听，并且设置值为null
        if(receiver != null){
            unregisterReceiver(receiver);
            receiver = null;
        }
    }


    class ForceOfflineReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(final Context context, Intent intent){
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Warning");
            builder.setMessage("You are forced to be offline. Please try to login again");
            builder.setCancelable(false); //AlertDialog是不能通过后退键取消的
            //DialogInterface.OnClickListener是一个接口，其中的onClick是一个抽象方法， 所以构造匿名内部类的时候使用@Override重写方法
            builder.setPositiveButton("OK",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //销毁所有活动
                    ActivityCollector.finishAll();
                    //重新启动LoginActivity活动
                    Intent intent = new Intent(context, LoginActivity.class);
                    context.startActivity(intent);
                }
            });
            builder.show();
        }

    }
}
