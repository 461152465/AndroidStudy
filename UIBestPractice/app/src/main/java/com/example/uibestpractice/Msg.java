package com.example.uibestpractice;

/**
 * Created by 461152465 on 2018/3/31.
 */

public class Msg {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;
    private String content;
    private int type;

    public Msg(String content, int type){
        this.content = content;
        this.type = type;
    }

    public String getContent(){
        return this.content;
    }

    public int getType(){
        return this.type;
    }
}
