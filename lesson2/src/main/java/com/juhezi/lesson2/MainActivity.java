package com.juhezi.lesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivitys";

    private EditText mEtUsername;
    private EditText mEtPasswd;
    private Button mBtnSignIn;

    private final static String USERNAME = "Juhezi";
    private final static String PASSWORD = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEtUsername = (EditText) findViewById(R.id.et_username);
        mEtPasswd = (EditText) findViewById(R.id.et_passwd);
        mBtnSignIn = (Button) findViewById(R.id.btn_sign_in);
        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mEtUsername.getText() + "";
                String passwd = mEtPasswd.getText() + "";
                username = username.trim();    //字符串前后的空格去掉
                passwd = passwd.trim();
                if (username.equals(USERNAME) &&
                        passwd.equals(PASSWORD)) {
                    //可以登录
                    Intent intent = new Intent(MainActivity.this,
                            HelloActivity.class);
                    startActivity(intent);
                } else {
                    //不可以登录
                    Toast.makeText(MainActivity.this,
                            "用户名或者密码不正确", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }

}
