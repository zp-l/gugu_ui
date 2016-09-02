package com.qibei.gugu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.qibei.gugu.R;
import com.qibei.gugu.model.BankCarkItem;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * 添加银行卡
 */
public class AddBankCardActivity extends Activity {

    private ArrayList<BankCarkItem> mDatas = null;
    private View view = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_add_bank_card);
        ButterKnife.bind(this);
        initView();
        registerListeners();

    }

    public void initView() {


    }

    private void registerListeners() {

    }

}
