package com.qibei.gugu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.qibei.gugu.MainActivity;
import com.qibei.gugu.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

//  支付返回
public class PayReturnActivity extends Activity {

    @Bind(R.id.tv_return_text)
    TextView tvReturnText;
    @Bind(R.id.tv_see_order)
    TextView tvSeeOrder;
    @Bind(R.id.tv_return_main)
    TextView tvReturnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_return);
        ButterKnife.bind(this);
        initView();

        registerListeners();
    }

    private void initView() {

    }


    //  注册监听事件
    private void registerListeners() {

    }


    @OnClick({R.id.tv_see_order, R.id.tv_return_main})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_see_order:
                Intent intent_order = new Intent(this, MyOrderActivity.class);
                startActivity(intent_order);
                break;
            case R.id.tv_return_main:
                Intent intent_main = new Intent(this, MainActivity.class);
                startActivity(intent_main);
                break;
        }
    }
}
