package com.qibei.gugu.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.qibei.gugu.R;
import com.qibei.gugu.activity.BabyFileActivity;
import com.qibei.gugu.activity.MyBankCardActivity;
import com.qibei.gugu.activity.MyCollectionActivity;
import com.qibei.gugu.activity.MyOrderActivity;
import com.qibei.gugu.activity.SetingActivity;
import com.qibei.gugu.activity.UserInfoActivity;
import com.qibei.gugu.activity.VoucherActivity;
import com.qibei.gugu.adapter.HLVMyfunctionAdapter;
import com.qibei.gugu.model.Myfunction;
import com.qibei.gugu.ui.CommonTopView;
import com.qibei.gugu.ui.HorizontalListView;
import com.qibei.gugu.ui.NavigationHeadView;
import com.qibei.gugu.util.BitmapUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyFragment extends Fragment implements GestureDetector.OnGestureListener {

    private List<Myfunction> mDatas;

    @Bind(R.id.scrollview_my_set)
    ScrollView scrollviewMySet;
    private View view = null;
    private HLVMyfunctionAdapter hlva;

    @Bind(R.id.ctv_user_center)
    CommonTopView ctvUserCenter;        //   顶部
    @Bind(R.id.rl_user)
    RelativeLayout rlUser;              //   用户信息布局
    @Bind(R.id.hlv_user)
    HorizontalListView hlvUser;         //   功能列表
    @Bind(R.id.nhv_schedule_manage)
    NavigationHeadView nhvScheduleManage;   //  日程管理导航栏

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user_center, container, false);
        ButterKnife.bind(this, view);
        initdate();
        registerListeners();
        return view;
    }

    @OnClick({R.id.rl_user})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_user:    //  进入个人信息
//                UIUtils.Toast("进入个人信息", false);
                Intent intent = new Intent(getActivity(), UserInfoActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    //  注册监听事件
    private void registerListeners() {

        //  顶部监听
        ctvUserCenter.setonClick(new CommonTopView.ICoallBack() {

            @Override
            public void onClickBack() {
            }

            @Override
            public void onClickSeting() {
                Intent intent = new Intent(getActivity(), SetingActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initdate() {

        //  初始化导航栏
        nhvScheduleManage.showLlMore(false);

        {
            mDatas = new ArrayList<Myfunction>();
            Myfunction data1 = new Myfunction("我的订单", BitmapUtil.ReadBitmapById(getContext(),R.drawable.btn_user1));
            Myfunction data2 = new Myfunction("代金卷", BitmapUtil.ReadBitmapById(getContext(),R.drawable.btn_user2));
            Myfunction data3 = new Myfunction("宝贝档案", BitmapUtil.ReadBitmapById(getContext(),R.drawable.btn_user4));
            Myfunction data4 = new Myfunction("病历单", BitmapUtil.ReadBitmapById(getContext(),R.drawable.btn_user3));
            Myfunction data5 = new Myfunction("我的银行卡", BitmapUtil.ReadBitmapById(getContext(),R.drawable.bankcard));
            Myfunction data6 = new Myfunction("我的收藏", BitmapUtil.ReadBitmapById(getContext(),R.drawable.btn_user5));
            mDatas.add(data1);mDatas.add(data2);mDatas.add(data3);mDatas.add(data4);mDatas.add(data5);mDatas.add(data6);

        }
            //   初始化功能列表
        hlvUser = (HorizontalListView) view.findViewById(R.id.hlv_user);
        hlva = new HLVMyfunctionAdapter(getActivity(), mDatas);
        hlva.notifyDataSetChanged();
        hlvUser.setAdapter(hlva);
        hlvUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                dealClick(position);
            }
        });

    }

    public void dealClick(int position){
        switch (position){
            case 0:     // 我的订单
                Intent intent_my_order = new Intent(getActivity(),MyOrderActivity.class);
                startActivity(intent_my_order);
                break;
            case 1:     //  代金券
                Intent intent_voucher = new Intent(getActivity(),VoucherActivity.class);
                startActivity(intent_voucher);
                break;
            case 2:     //  宝宝档案
                Intent intent_baby_file = new Intent(getActivity(),BabyFileActivity.class);
                startActivity(intent_baby_file);
                break;
            case 3:     //  病历单
                break;
            case 4:     //  我的银行卡
                Intent intent_my_bank_card = new Intent(getActivity(),MyBankCardActivity.class);
                startActivity(intent_my_bank_card);
                break;
            case 5:     //  我的收藏
                Intent intent_my_collection = new Intent(getActivity(),MyCollectionActivity.class);
                startActivity(intent_my_collection);
                break;
            default:
                break;
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        // TODO Auto-generated method stub
        return false;
    }


}
