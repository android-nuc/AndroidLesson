package com.juhezi.lesson2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by qiao1 on 2017/1/7.
 */
public class HelloActivity extends AppCompatActivity {
    private static String TAG = "HelloActivity";

    private TextView mTvShow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        setContentView(R.layout.activity_hello);
        mTvShow = (TextView) findViewById(R.id.tv_show);
        if (getIntent() != null) {
            String str = getIntent().getStringExtra("Username");
            mTvShow.setText(str);
        }
    }
}
