package com.juhezi.who;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mImgGet;
    private RecyclerView mRvList;
    private Button mBtnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImgGet = (ImageView) findViewById(R.id.img_get);
        mRvList = (RecyclerView) findViewById(R.id.rv_list);
        mBtnRestart = (Button) findViewById(R.id.btn_restart);
        mImgGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mBtnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //alt + ctrl + 空格
        //Adapter Data(ArryList<String>) -> RecyclerView
    }
}
