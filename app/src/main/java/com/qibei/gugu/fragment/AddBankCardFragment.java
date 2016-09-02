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
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.qibei.gugu.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 添加银行卡
 */
public class AddBankCardFragment extends Fragment {

    MyBankCardFregment.MyListener mylistener;

    @Bind(R.id.ll_select_bank_card)
    LinearLayout llSelectBankCard;
    @Bind(R.id.iv_abcf_select)      //   选择卡类型
            ImageView ivAbcfSelect;
    @Bind(R.id.et_abcf_card_num)    //   编辑框
    EditText etAbcfCardNum;
    @Bind(R.id.bt_abcf_next)        //  下一步
    Button btAbcfNext;

    private View view = null;

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        mylistener = (MyBankCardFregment.MyListener) activity;
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_bank_card, container, false);
        ButterKnife.bind(this, view);
        initView();
        registerListeners();
        return view;
    }


    @OnClick({R.id.iv_abcf_select, R.id.bt_abcf_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_abcf_select:
                mylistener.showMessage(2);      //  选择银行卡类型
                break;
            case R.id.bt_abcf_next:
                mylistener.showMessage(3);      //  填写银行信息
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
