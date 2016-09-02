package com.qibei.gugu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.qibei.gugu.R;
import com.qibei.gugu.ui.CommonTopView;
import com.qibei.gugu.ui.SetOrderInfoView;
import com.qibei.gugu.util.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetingActivity extends Activity {

    SetingActivity activity;
    @Bind(R.id.ctv_setting)
    CommonTopView ctvSetting;           //  公共头
    @Bind(R.id.soiv_security)
    SetOrderInfoView soivSecurity;      //  账号与安全
    @Bind(R.id.soiv_update)
    SetOrderInfoView soivUpdate;        //  版本更新
    @Bind(R.id.tv_push)                 //  消息推送
            TextView tvPush;
    @Bind(R.id.mTogBtn)                 //  滑动框
            ToggleButton mTogBtn;
    @Bind(R.id.soiv_clear_cache)        //  清除缓存
            SetOrderInfoView soivClearCache;
    @Bind(R.id.soiv_about)              //  关于呱呱
            SetOrderInfoView soivAbout;
    @Bind(R.id.tv_exit_login)           //  退出登录
            TextView tvExitLogin;
    @Bind(R.id.soiv_advise)             //  反馈建议
    SetOrderInfoView soivAdvise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seting);
        ButterKnife.bind(this);
        initView();

        registerListeners();
    }


    private void initView() {
        activity = this;
    }

    @OnClick({R.id.ctv_setting, R.id.tv_exit_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_exit_login:      // 退出登录
                Intent intent_login = new Intent(this, LoginActivity.class);
                startActivity(intent_login);
                break;
            default:
                break;
        }
    }

    //  注册监听事件
    private void registerListeners() {
        //返回监听
        ctvSetting.setonClick(new CommonTopView.ICoallBack() {
            @Override
            public void onClickBack() {
                finish();
            }

            @Override
            public void onClickSeting() {
            }
        });
        //  账号与安全
        soivSecurity.setonClick(new SetOrderInfoView.ICoallBack() {
            @Override
            public void onClickBack() {
                Intent intent = new Intent(activity, AccountSecurityActivity.class);
                startActivity(intent);
            }
        });
        //  版本更新
        soivUpdate.setonClick(new SetOrderInfoView.ICoallBack() {
            @Override
            public void onClickBack() {
                UIUtils.Toast("版本更新", false);
            }
        });

        //  清除缓存
        soivClearCache.setonClick(new SetOrderInfoView.ICoallBack() {
            @Override
            public void onClickBack() {
                UIUtils.Toast("清除缓存", false);
            }
        });

        //  关于呱呱
        soivAbout.setonClick(new SetOrderInfoView.ICoallBack() {
            @Override
            public void onClickBack() {
                Intent intent = new Intent(activity, AboutActivity.class);
                startActivity(intent);
            }
        });
        //  反馈意见
        soivAdvise.setonClick(new SetOrderInfoView.ICoallBack() {
            @Override
            public void onClickBack() {
                Intent intent = new Intent(activity, AdviseActivity.class);
                startActivity(intent);
            }
        });


        //   滑动监听
        mTogBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                if (isChecked) {
                    UIUtils.Toast("打开推送", true);
                } else {
                    UIUtils.Toast("关闭推送", true);
                }
            }
        });
    }

}
