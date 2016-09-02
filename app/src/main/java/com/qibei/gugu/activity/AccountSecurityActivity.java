package com.qibei.gugu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.qibei.gugu.R;
import com.qibei.gugu.ui.CommonTopView;
import com.qibei.gugu.ui.SetOrderInfoView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AccountSecurityActivity extends Activity {

    @Bind(R.id.ctv_account_security)
    CommonTopView ctvAccountSecurity;
    @Bind(R.id.soiv_asa_num)
    SetOrderInfoView soivAsaNum;
    @Bind(R.id.soiv_modify_password)
    SetOrderInfoView soivModifyPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_security);
        ButterKnife.bind(this);
        registerListeners();
        initView();
    }

    private void initView() {

    }

    //  注册监听事件
    private void registerListeners() {
        //返回监听
        ctvAccountSecurity.setonClick(new CommonTopView.ICoallBack() {
            @Override
            public void onClickBack() {
                finish();
            }

            @Override
            public void onClickSeting() {
            }
        });

        //  修改密码
        soivModifyPassword.setonClick(new SetOrderInfoView.ICoallBack() {
            @Override
            public void onClickBack() {
                Log.i("test","进入");
                Intent intent_forget = new Intent(AccountSecurityActivity.this,RegisterActivity.class);
                //用Bundle携带数据
                Bundle bundle1=new Bundle();
                bundle1.putString("flag", "forget");
                intent_forget.putExtras(bundle1);
                startActivity(intent_forget);
                Log.i("test","出去");
            }
        });

    }

}
