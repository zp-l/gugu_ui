package com.qibei.gugu.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.qibei.gugu.R;
import com.qibei.gugu.fragment.CommentFragment;
import com.qibei.gugu.ui.CommonTopView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BlankActivity extends FragmentActivity {

    @Bind(R.id.ctv_ba_top)
    CommonTopView ctvBaTop;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);
        ButterKnife.bind(this);
        Bundle bundle = this.getIntent().getExtras();
        //接收name值
        String classString = bundle.getString("classString");
        if (classString!= null)
        {
            try {
                Class<?> clazz = Class.forName(classString);
                fragment = (Fragment)clazz.newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if(fragment!=null){
            initView();
        }
        registerListeners();
    }

    private void initView() {

        ctvBaTop.setTvTitle("评论");
            //步骤一：添加一个FragmentTransaction的实例
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //步骤二：用add()方法加上Fragment的对象rightFragment
        transaction.replace(R.id.ll_layout,fragment);
        //步骤三：调用commit()方法使得FragmentTransaction实例的改变生效
        transaction.commit();
    }

    //  注册监听事件
    private void registerListeners() {
        //返回监听
        ctvBaTop.setonClick(new CommonTopView.ICoallBack() {
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
