package com.qibei.gugu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.qibei.gugu.R;
import com.qibei.gugu.ui.CommonTopView;

import butterknife.Bind;
import butterknife.ButterKnife;

//   百科详情
public class EncyclopediasDetailActivity extends Activity {


    @Bind(R.id.ctv_encyclopedias_detail)
    CommonTopView ctvEncyclopediasDetail;
    @Bind(R.id.tv_eda_title)        //  标题
    TextView tvEdaTitle;
    @Bind(R.id.tv_eda_time)         //  时间
    TextView tvEdaTime;
    @Bind(R.id.tv_eda_from)         //  来源
    TextView tvEdaFrom;
    @Bind(R.id.iv_eda_logo)         //  图片
    ImageView ivEdaLogo;
    @Bind(R.id.iv_eda_describe)     //  描述
    TextView ivEdaDescribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encyclopedias_details);
        ButterKnife.bind(this);

        initView();

        registerListeners();
    }

    private void initView() {

    }

    private void registerListeners() {
        //返回监听
        ctvEncyclopediasDetail.setonClick(new CommonTopView.ICoallBack() {
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
