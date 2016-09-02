package com.qibei.gugu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.qibei.gugu.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

//   订单填写
public class OrderModifyActivity extends Activity {

    @Bind(R.id.tv_oma_next)
    TextView tvOmaNext;
    private ToggleButton mTogBtn1;
    private ToggleButton mTogBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_modify);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

    }

    @OnClick({ R.id.tv_oma_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_oma_next:  //  下一步
                //   启动  订单详情
                Intent intent_order_details = new Intent(OrderModifyActivity.this, PersonalInformationActivity.class);
                startActivity(intent_order_details);
                break;
            default:
                break;
        }
    }
}
