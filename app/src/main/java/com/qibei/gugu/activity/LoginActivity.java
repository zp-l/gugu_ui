package com.qibei.gugu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.qibei.gugu.MainActivity;
import com.qibei.gugu.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends Activity {

    @Bind(R.id.iv_al_back)          //  返回
    ImageView ivAlBack;
    @Bind(R.id.tv_la_register)      //  注册
    TextView tvLaRegister;
    @Bind(R.id.et_al_name)          //  用户名
    EditText etAlName;
    @Bind(R.id.et_al_password)      //  密码
    EditText etAlPassword;
    @Bind(R.id.bt_al_login)         //  登录
    Button btAlLogin;
    @Bind(R.id.tv_al_forget)        //  忘记密码
    TextView tvAlForget;

    /*-------------------第三方登录-----------------------------*/
    @Bind(R.id.tv_wechat)
    ImageView tvWechat;         //  微信
    @Bind(R.id.iv_sina)
    ImageView ivSina;
    @Bind(R.id.iv_qq)
    ImageView ivQq;
    @Bind(R.id.iv_facebook)
    ImageView ivFacebook;
    @Bind(R.id.iv_twitter)
    ImageView ivTwitter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
        registerListeners();
    }

    private void initView() {

    }

    private void registerListeners() {

    }

    @OnClick({R.id.iv_al_back, R.id.tv_la_register, R.id.et_al_name, R.id.et_al_password, R.id.bt_al_login, R.id.tv_al_forget})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_al_back:           //   返回
                finish();
                break;
            case R.id.tv_la_register:       //   注册
                Intent intent_register = new Intent(LoginActivity.this,RegisterActivity.class);
                //用Bundle携带数据
                Bundle bundle=new Bundle();
                bundle.putString("flag", "register");
                intent_register.putExtras(bundle);
                startActivity(intent_register);
                break;
            case R.id.et_al_name:           //   账号
                break;
            case R.id.et_al_password:       //   密码
                break;
            case R.id.bt_al_login:          //   登录
                Intent intent_main = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent_main);
                break;
            case R.id.tv_al_forget:         //   忘记密码
                Intent intent_forget = new Intent(LoginActivity.this,RegisterActivity.class);
                //用Bundle携带数据
                Bundle bundle1=new Bundle();
                bundle1.putString("flag", "forget");
                intent_forget.putExtras(bundle1);
                startActivity(intent_forget);
                break;
        }
    }
}