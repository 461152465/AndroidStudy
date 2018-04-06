package com.example.broadcastbestpractice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 461152465 on 2018/4/7.
 * 用于管理所有活动的类
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    //isFinishing()方法判断一个活动是处在活跃状态还是处在回收状态
    public static void finishAll(){
        for(Activity activity : activities){
            if(activity.isFinishing())
                activity.finish();
        }
        //清空列表中的所有元素
        activities.clear();
    }

}
