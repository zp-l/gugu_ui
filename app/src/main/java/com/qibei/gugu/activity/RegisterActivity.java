package com.qibei.gugu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qibei.gugu.R;
import com.qibei.gugu.ui.CommonTopView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends Activity {

    @Bind(R.id.tv_send_rerification)
    TextView tvSendRerification;
    @Bind(R.id.im_showpad)
    ImageView imShowpad;
    @Bind(R.id.agreement)       //  协议
            TextView agreement;
    @Bind(R.id.tv_ra_prompt)    //  错误提示
            TextView tvRaPrompt;
    @Bind(R.id.ctv_register)    //  头
            CommonTopView ctvRegister;
    @Bind(R.id.bu_register)     //  注册按钮
    Button buRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        //新页面接收数据
        Bundle bundle = this.getIntent().getExtras();
        //接收name值
        String flag = bundle.getString("flag");
        if (flag.equals("register")) {        //  注册

        } else if (flag.equals("forget")) {    //  修改密码
            ctvRegister.setTvTitle("修改密码");
            buRegister.setText("找回密码");
            tvRaPrompt.setVisibility(View.INVISIBLE);
            agreement.setVisibility(View.INVISIBLE);
        }

        initView();
        registerListeners();

    }

    private void initView() {

    }

    private void registerListeners() {
        //返回监听
        ctvRegister.setonClick(new CommonTopView.ICoallBack() {
            @Override
            public void onClickBack() {
                finish();
            }

            @Override
            public void onClickSeting() {
            }
        });
    }

    @OnClick({R.id.tv_send_rerification, R.id.im_showpad, R.id.bu_register, R.id.agreement})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_send_rerification:
                Toast.makeText(this, "发送验证信息", Toast.LENGTH_LONG).show();
                break;
            case R.id.im_showpad:
                Toast.makeText(this, "显示密码", Toast.LENGTH_LONG).show();
                break;
            case R.id.bu_register:
                Toast.makeText(this, " 注册", Toast.LENGTH_LONG).show();
                break;
            case R.id.agreement:
                Intent intent_main = new Intent(RegisterActivity.this,ServiceProvisionActivity.class);
                startActivity(intent_main);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);//解除
    }

}
