package com.juhezi.who;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView mImgGet;
    private RecyclerView mRvList;
    private Button mBtnRestart;

    private WhoAdapter whoAdapter;

    private static final String TAG = "MainActivity";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

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
                Random random = new Random();
                int flag = 0;   //重复次数
                while (true) {
                    //产生0-100的随机数
                    int index = random.nextInt(100);
                    //判断是否已经存在
                    boolean isRepeat = false;   //标识是否存在
                    for (int i = 0; i < whoAdapter.data.size(); i++) {
                        if (Integer.parseInt(whoAdapter.data.get(i)) == index) {
                            isRepeat = true;
                            break;
                        }
                    }
                    if (isRepeat) { //重复
                        flag++;
                    } else {
                        //向列表的数据中添加
                        whoAdapter.data.add(index + "");
                        whoAdapter.notifyItemInserted(
                                whoAdapter.data.size() - 1);
                        break;
                    }
                    if (flag >= 16) {
                        Log.i(TAG, "onClick: Hello");
                        Toast.makeText(MainActivity.this,
                                "休息会", Toast.LENGTH_SHORT)
                                .show();
                        break;
                    }
                }
                //通知RecyclerView数据发生改变，让它显示新的数据
//                whoAdapter.notifyDataSetChanged();
                //使RecyclerView滚动到最后一位，
                // -1使因为位置是从0开始的
                mRvList.scrollToPosition(
                        whoAdapter.data.size() - 1);
                //为按钮添加旋转动画
                ObjectAnimator rotateAnim =
                        ObjectAnimator.ofFloat(mImgGet,
                                "rotation", 0f, 180f);
                ObjectAnimator scaleY =
                        ObjectAnimator.ofFloat(mImgGet,
                                "scaleY", 1f, 1.5f);
                ObjectAnimator scaleX =
                        ObjectAnimator.ofFloat(mImgGet,
                                "scaleX", 1f, 1.5f);
                AnimatorSet set = new AnimatorSet();
                set.setDuration(500);
                set.playTogether(rotateAnim, scaleX, scaleY);
//                set.play(rotateAnim).after(scaleX).after(scaleY);
                set.start();
            }
        });
        mBtnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whoAdapter.data.clear();    //清空数据
                //通知RecyclerView进行更新
                whoAdapter.notifyDataSetChanged();
            }
        });
        //alt + ctrl + 空格
        //Adapter Data(ArryList<String>) -> RecyclerView
        //创建一个线性布局管理器对象
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this,
                        LinearLayoutManager.VERTICAL, false);
        mRvList.setLayoutManager(layoutManager);
        whoAdapter = new WhoAdapter();
        mRvList.setAdapter(whoAdapter);
    }

}
