package com.qibei.gugu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.qibei.gugu.R;
import com.qibei.gugu.ui.CommonTopView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutActivity extends Activity {

    @Bind(R.id.ctv_about)
    CommonTopView ctvAbout;
    @Bind(R.id.tv_clause)
    TextView tvClause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        initView();
        registerListeners();
    }

    private void initView() {

    }

    //  注册监听事件
    private void registerListeners() {
        //返回监听
        ctvAbout.setonClick(new CommonTopView.ICoallBack() {
            @Override
            public void onClickBack() {
                finish();
            }

            @Override
            public void onClickSeting() {
            }
        });
    }
    @OnClick(R.id.tv_clause)
    public void onClick() {
        Intent intent = new Intent(AboutActivity.this,ServiceProvisionActivity.class);
        startActivity(intent);
    }
}
