package com.example.broadcastbestpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //findViewById的返回值是View类型，所以需要对应的类型转换
        accountEdit = (EditText) findViewById(R.id.account);
        passwordEdit = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               //使用EditView类的getText()方法以及继承Object的toString()方法将获取的字符串传递给一个String对象
               String account = accountEdit.getText().toString();
               String password = passwordEdit.getText().toString();
               //如果账号是admin，密码是123456,那么登陆成功
               //对于String类型，判断字符串是否相同使用equals方法
               if(account.equals("admin") && password.equals("123456")){
                   Intent intent =  new Intent(LoginActivity.this, MainActivity.class);
                   startActivity(intent);
                   finish();
               }
               else{
                   //在Android内部类中使用this表示内部类本身，要表示外部类则使用类名.this
                   Toast.makeText(LoginActivity.this , "account or password is invalid", Toast.LENGTH_SHORT).show();
               }

           }
        });

    }
}
