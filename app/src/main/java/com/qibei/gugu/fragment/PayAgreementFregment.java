package com.qibei.gugu.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qibei.gugu.R;

import butterknife.ButterKnife;

/**
 * 支付协议
 */
public class PayAgreementFregment extends Fragment {


    private View view = null;
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
        view = inflater.inflate(R.layout.fragment_pey_agreement, container, false);
        ButterKnife.bind(this, view);
        initView();
        registerListeners();
        return view;
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
