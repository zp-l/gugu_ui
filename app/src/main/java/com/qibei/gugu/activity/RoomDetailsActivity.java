package com.qibei.gugu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qibei.gugu.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

//   房间详情
public class RoomDetailsActivity extends Activity {


    @Bind(R.id.tv_rda_buy)
    TextView tvRdaBuy;
    @Bind(R.id.iv_rda_back)
    ImageView ivRdaBack;
    @Bind(R.id.iv_rda_comment)
    ImageView ivRdaComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_details);
        ButterKnife.bind(this);
        // 初始化控件
        initView();
        //初始化数据
        initData();
        // 绑定券页面
        bindPageData();
        // 注册监听
        registerListener();
    }


    private void initView() {

    }

    /**
     * 初始化数据
     */
    private void initData() {

    }

    /**
     * 绑定页面数据
     */
    private void bindPageData() {

    }

    /**
     * 注册事件监听
     */
    private void registerListener() {

    }

    @OnClick({R.id.iv_rda_back, R.id.tv_rda_buy, R.id.iv_rda_comment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_rda_back:
                finish();
                break;
            case R.id.tv_rda_buy:
                //   启动  订单详情
                Intent intent_product = new Intent(this, PersonalInformationActivity.class);
                startActivity(intent_product);
                break;
            case R.id.iv_rda_comment:  // 点击评论
                Intent intent_blank = new Intent(this, BlankActivity.class);
                //用Bundle携带数据
                Bundle bundle1 = new Bundle();
                bundle1.putString("classString", "com.qibei.gugu.fragment.CommentFragment");
                intent_blank.putExtras(bundle1);
                startActivity(intent_blank);
        }
    }
}

