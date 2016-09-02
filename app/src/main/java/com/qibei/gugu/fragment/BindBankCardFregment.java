package com.qibei.gugu.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.qibei.gugu.R;
import com.qibei.gugu.util.UIUtils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 绑定银行卡
 */
public class BindBankCardFregment extends Fragment {

    @Bind(R.id.et_bbcf_user_name)       //  用户名
            EditText etBbcfUserName;
    @Bind(R.id.et_bbcf_id)              //  身份证
            EditText etBbcfId;
    @Bind(R.id.et_bbcf_phone_number)    //  手机号
            EditText etBbcfPhoneNumber;
    @Bind(R.id.et_bbcf_code)            //  验证码
            EditText etBbcfCode;
    @Bind(R.id.tv_bbcf_send_code)       //  发送验证码
            TextView tvBbcfSendCode;
    @Bind(R.id.tv_bbcf_agreement)       //  协议
            TextView tvBbcfAgreement;
    @Bind(R.id.bt_bbcf_add)             //  添加
            Button btBbcfAdd;
    private View view = null;
    private ArrayList<String> mDatas;
    MyBankCardFregment.MyListener mylistener;

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        mylistener = (MyBankCardFregment.MyListener) activity;
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bind_bank_card, container, false);
        ButterKnife.bind(this, view);
        initView();
        registerListeners();
        return view;
    }

    @OnClick({R.id.tv_bbcf_send_code, R.id.tv_bbcf_agreement, R.id.bt_bbcf_add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_bbcf_send_code:
                UIUtils.Toast("发送验证码",false);
                break;
            case R.id.tv_bbcf_agreement:
                mylistener.showMessage(4);
                break;
            case R.id.bt_bbcf_add:
                getActivity().finish();
                break;
        }
    }


    public void initView() {

    }

    private void registerListeners() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
