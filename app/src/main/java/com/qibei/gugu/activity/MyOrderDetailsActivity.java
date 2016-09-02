package com.qibei.gugu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.qibei.gugu.MainActivity;
import com.qibei.gugu.R;
import com.qibei.gugu.ui.CommonTopView;
import com.qibei.gugu.util.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyOrderDetailsActivity extends Activity {

    @Bind(R.id.ctv_moda_order_deails)
    CommonTopView ctvModaOrderDeails;
    @Bind(R.id.tv_moda_modify_info)
    TextView tvModaModifyInfo;
    @Bind(R.id.bt_moda_buying)
    Button btModaBuying;
    private ToggleButton mTogBtn1;
    private ToggleButton mTogBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order_details);
        ButterKnife.bind(this);
        initView();
        registerListeners();
    }

    //  注册监听事件
    private void registerListeners() {
        //返回监听
        ctvModaOrderDeails.setonClick(new CommonTopView.ICoallBack() {
            @Override
            public void onClickBack() {
                finish();
            }

            @Override
            public void onClickSeting() {
            }
        });
    }

    private void initView() {
        mTogBtn1 = (ToggleButton) findViewById(R.id.mTogBtn1); // 获取到控件
        mTogBtn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                if (isChecked) {
                    UIUtils.Toast("选中", true);
                } else {
                    UIUtils.Toast("未选中", true);
                }
            }
        });

        mTogBtn2 = (ToggleButton) findViewById(R.id.mTogBtn2); // 获取到控件
        mTogBtn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                if (isChecked) {
                    UIUtils.Toast("选中", true);
                } else {
                    UIUtils.Toast("未选中", true);
                }
            }
        });


    }

    @OnClick({R.id.tv_moda_modify_info, R.id.bt_moda_buying})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_moda_modify_info:
                Intent intent_person_info = new Intent(MyOrderDetailsActivity.this, PersonalInformationActivity.class);
                startActivity(intent_person_info);
                break;
            case R.id.bt_moda_buying:
                Intent intent_main = new Intent(MyOrderDetailsActivity.this, MainActivity.class);
                startActivity(intent_main);
                break;
        }
    }
}
