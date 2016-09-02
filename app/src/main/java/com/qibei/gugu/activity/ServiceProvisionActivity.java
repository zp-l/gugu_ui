package com.qibei.gugu.activity;

import android.app.Activity;
import android.os.Bundle;

import com.qibei.gugu.R;
import com.qibei.gugu.ui.CommonTopView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ServiceProvisionActivity extends Activity {

    @Bind(R.id.ctv_spa_provision)
    CommonTopView ctvSpaProvision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provision);
        ButterKnife.bind(this);
        initView();
        registerListeners();
    }

    private void initView() {

    }

    //  注册监听事件
    private void registerListeners() {
        //返回监听
        ctvSpaProvision.setonClick(new CommonTopView.ICoallBack() {
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
