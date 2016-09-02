package com.qibei.gugu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.qibei.gugu.R;
import com.qibei.gugu.ui.CommonTopView;
import com.qibei.gugu.util.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

//  支付
public class PayActivity extends Activity {


    @Bind(R.id.iv_bank_logo)        //  银行logo
            ImageView ivBankLogo;
    @Bind(R.id.tv_bank_name)        //  银行名字
            TextView tvBankName;
    @Bind(R.id.tv_bankcard_type)    //  银行类型
            TextView tvBankcardType;
    @Bind(R.id.tv_bankcard_num)     //  银行号
            TextView tvBankcardNum;
    @Bind(R.id.et_pa_phone_number)  //  手机号
            EditText etPaPhoneNumber;
    @Bind(R.id.et_pa_code)          //  验证码
            EditText etPaCode;
    @Bind(R.id.tv_pa_send_code)     //  发送验证码
            TextView tvPaSendCode;
    @Bind(R.id.bt_pa_confirm_pay)   //  确认支付
            Button btPaConfirmPay;
    @Bind(R.id.ctv_pay)
    CommonTopView ctvPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        ButterKnife.bind(this);
        initView();

        registerListeners();
    }

    @OnClick({R.id.tv_pa_send_code, R.id.bt_pa_confirm_pay})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_pa_send_code:
                UIUtils.Toast("发送验证码",false);
                break;
            case R.id.bt_pa_confirm_pay:

                break;
        }
    }

    private void initView() {

    }


    //  注册监听事件
    private void registerListeners() {
        //返回监听
        ctvPay.setonClick(new CommonTopView.ICoallBack() {
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
