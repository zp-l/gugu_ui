package com.qibei.gugu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;

import com.qibei.gugu.activity.ConsultationActivity;
import com.qibei.gugu.fragment.HomeFragment;
import com.qibei.gugu.fragment.MmbdFragment;
import com.qibei.gugu.fragment.MyFragment;
import com.qibei.gugu.fragment.ReserveFragment;

import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private int old_select = 0;
    private HomeFragment homeFragment = null;                   //  主页
    private MmbdFragment mmbdFragment = null;                   //  妈妈宝典
    private ConsultationActivity consultationActivity = null;   //  咨询
    private ReserveFragment reserveFragment = null;             //  预定
    private MyFragment myFragment = null;                       //  我的
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LinearLayout ll_mainhome = (LinearLayout) findViewById(R.id.ll_mainhome);
        LinearLayout ll_mm = (LinearLayout) findViewById(R.id.ll_mm);
        LinearLayout ll_zixun = (LinearLayout) findViewById(R.id.ll_zixun);
        LinearLayout ll_order = (LinearLayout) findViewById(R.id.ll_order);
        LinearLayout ll_my = (LinearLayout) findViewById(R.id.ll_my);
        ll_mainhome.setOnClickListener(this);
        ll_mm.setOnClickListener(this);
        ll_zixun.setOnClickListener(this);
        ll_order.setOnClickListener(this);
        ll_my.setOnClickListener(this);
        //  默认进入首页
        setSelect(0);

//        Intent intent = new Intent(this, PullToRefreshListActivity.class);
//        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_mainhome:
                setSelect(0);
                break;
            case R.id.ll_mm:
                setSelect(1);
                break;
            case R.id.ll_zixun:
                setSelect(2);
                break;
            case R.id.ll_order:
                setSelect(3);
                break;
            case R.id.ll_my:
                setSelect(4);
                break;
        }
    }


    private void setSelect(int i) {
        if(i!=2){
            FragmentManager fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            reSetTab();
            hideFragment();
        }
        switch (i) {
            case 0:
                //首页
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    ft.add(R.id.content, homeFragment);
                }
                ft.show(homeFragment);
                break;
            case 1:
                //妈妈宝贝
                if (mmbdFragment == null) {
                    mmbdFragment = new MmbdFragment();
                    ft.add(R.id.content, mmbdFragment);
                }
                ft.show(mmbdFragment);
                break;
            case 2:
                //咨询
                Intent intent = new Intent(this, ConsultationActivity.class);
                startActivity(intent);
                this.overridePendingTransition(R.anim.activity_open,0);
                break;
            case 3:
                //预定
                if (reserveFragment == null) {
                    reserveFragment = new ReserveFragment();
                    ft.add(R.id.content, reserveFragment);
                }
                ft.show(reserveFragment);
                break;
            case 4:
                //我的
                if (myFragment == null) {
                    myFragment = new MyFragment();
                    ft.add(R.id.content, myFragment);
                }
                ft.show(myFragment);
                break;
            default:
                break;
        }
        if(i!=2) {
            ft.commit();
        }
    }

    private void reSetTab() {

    }

    private void hideFragment() {

        if (homeFragment != null) {     //  主页
            ft.hide(homeFragment);
        }
        if (mmbdFragment != null) {     //  妈妈宝贝
            ft.hide(mmbdFragment);
        }

        if (reserveFragment != null) {  //  预约
            ft.hide(reserveFragment);
        }
        if (myFragment != null) {       //  我的
            ft.hide(myFragment);
        }

    }

}