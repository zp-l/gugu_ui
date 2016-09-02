package com.qibei.gugu.activity;

import android.app.Activity;
import android.os.Bundle;

import com.qibei.gugu.R;
import com.qibei.gugu.ui.CommonTopView;

import butterknife.Bind;
import butterknife.ButterKnife;


public class UserInfoActivity extends Activity {

    @Bind(R.id.ctv_user_info)
    CommonTopView ctvUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ButterKnife.bind(this);
        initView();
        registerListeners();
    }
    private void initView() {

    }

    //  注册监听事件
    private void registerListeners() {
        //返回监听
        ctvUserInfo.setonClick(new CommonTopView.ICoallBack() {
            @Override
            public void onClickBack() {
                finish();
            }
            @Override
            public void onClickSeting() {
            }
        });
    }

}
