package com.qibei.gugu.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qibei.gugu.R;
import com.qibei.gugu.fragment.AddBankCardFragment;
import com.qibei.gugu.fragment.BindBankCardFregment;
import com.qibei.gugu.fragment.MyBankCardFregment;
import com.qibei.gugu.fragment.PayAgreementFregment;
import com.qibei.gugu.fragment.SelectBankCardFregment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的银行卡
 */
public class MyBankCardActivity extends FragmentActivity implements MyBankCardFregment.MyListener {

    private int oldSelect = 0;
    @Bind(R.id.iv_mbca_back)    //  返回
    ImageView ivMbcaBack;
    @Bind(R.id.tv_mbca_title)   //  标题
    TextView tvMbcaTitle;
    private MyBankCardFregment myBankCardFregment = null;                       // 我的银行卡    0
    private AddBankCardFragment addBankCardFragment = null;                     // 添加银行卡    1
    private SelectBankCardFregment selectBankCardFregment = null;               // 选择银行卡    2
    private BindBankCardFregment bindBankCardFregment = null;                   //  绑定银行卡   3
    private PayAgreementFregment payAgreementFregment = null;                   //  支付协议     4

    private FragmentTransaction ft;

    public void showMessage(int x) {
        setSelect(x);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bank_card);
        ButterKnife.bind(this);
        initView();
        setSelect(0);
    }

    public void initView() {


    }

    @OnClick({R.id.iv_mbca_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_mbca_back:         //   返回监听
            {
                if (oldSelect == 0) finish();
                else if(oldSelect == 3) setSelect(1);     //   如果是绑定银行卡 直接跳回添加银行卡
                else{
                    setSelect(oldSelect - 1);
                }
            }
            break;
        }
    }

    private void setSelect(int i) {
        FragmentManager fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        reSetTab();
        hideFragment();
        switch (i) {
            case 0:
                if (myBankCardFregment == null) {
                    myBankCardFregment = new MyBankCardFregment();
                    ft.add(R.id.fl_my_bank, myBankCardFregment);
                }
                tvMbcaTitle.setText("我的银行卡");
                ft.show(myBankCardFregment);
                break;
            case 1:
                if (addBankCardFragment == null) {
                    addBankCardFragment = new AddBankCardFragment();
                    ft.add(R.id.fl_my_bank, addBankCardFragment);
                }
                tvMbcaTitle.setText("添加银行卡");
                ft.show(addBankCardFragment);
                break;
            case 2:
                if (selectBankCardFregment == null) {
                    selectBankCardFregment = new SelectBankCardFregment();
                    ft.add(R.id.fl_my_bank, selectBankCardFregment);
                }
                tvMbcaTitle.setText("选择银行卡");
                ft.show(selectBankCardFregment);
                break;
            case 3:
                if (bindBankCardFregment == null) {
                    bindBankCardFregment = new BindBankCardFregment();
                    ft.add(R.id.fl_my_bank, bindBankCardFregment);
                }
                tvMbcaTitle.setText("绑定银行卡");
                ft.show(bindBankCardFregment);
                break;
            case 4:
                if (payAgreementFregment == null) {
                    payAgreementFregment = new PayAgreementFregment();
                    ft.add(R.id.fl_my_bank, payAgreementFregment);
                }
                tvMbcaTitle.setText("支付协议");
                ft.show(payAgreementFregment);
                break;
            default:
                break;
        }
        oldSelect = i;
        ft.commit();
    }

    private void reSetTab() {

    }

    private void hideFragment() {

        if (myBankCardFregment != null) {
            ft.hide(myBankCardFregment);
        }
        if (addBankCardFragment != null) {
            ft.hide(addBankCardFragment);
        }
        if (selectBankCardFregment != null) {
            ft.hide(selectBankCardFregment);
        }
        if (bindBankCardFregment != null) {
            ft.hide(bindBankCardFregment);
        }
        if (payAgreementFregment != null) {
            ft.hide(payAgreementFregment);
        }

    }


}
