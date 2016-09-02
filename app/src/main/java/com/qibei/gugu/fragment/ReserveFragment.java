package com.qibei.gugu.fragment;


import android.content.Context;
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
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.qibei.gugu.R;
import com.qibei.gugu.activity.TubeBabyActivity;
import com.qibei.gugu.adapter.HorizontalListViewAdapter;
import com.qibei.gugu.ui.HorizontalListView;
import com.qibei.gugu.ui.NavigationHeadView;
import com.qibei.gugu.util.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ReserveFragment extends Fragment implements GestureDetector.OnGestureListener {


    @Bind(R.id.nhv_yuezi)
    NavigationHeadView nhvYuezi;    //  月子中心导航条
    @Bind(R.id.hlv_yuezi)
    HorizontalListView hlvYuezi;
    @Bind(R.id.nhv_abroad)
    NavigationHeadView nhvAbroad;   //  境外导航条
    @Bind(R.id.hlv_abroad)
    HorizontalListView hlvAbroad;
    @Bind(R.id.nhv_territory)
    NavigationHeadView nhvTerritory;    //  境内导航条
    @Bind(R.id.hlv_territory)
    HorizontalListView hlvTerritory;
    private View view = null;
    private HorizontalListViewAdapter hlva_territory;   //  境内适配器
    private HorizontalListViewAdapter hlva_abroad;   //  境外适配器
    private HorizontalListViewAdapter hlva_yuezi;   //  境外适配器

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_reserve, container, false);
        ButterKnife.bind(this, view);
        initdate();
        registerListeners();
        return view;
    }

    //  注册监听事件
    private void registerListeners() {
        nhvYuezi.setonClick(new NavigationHeadView.ICoallBack() {
            @Override
            public void onClickBack() {          //     月子中心被点击
                UIUtils.Toast(" 月子中心更多", false);
            }
        });
        nhvTerritory.setonClick(new NavigationHeadView.ICoallBack() {
            @Override
            public void onClickBack() {         //  境内服务被点击
                UIUtils.Toast("境内服务更多", false);
            }
        });
        nhvAbroad.setonClick(new NavigationHeadView.ICoallBack() {
            @Override
            public void onClickBack() {          //     境外服务被点击
                UIUtils.Toast(" 境外服务更多", false);
            }
        });
    }

    private void initdate() {

        hlva_yuezi = new HorizontalListViewAdapter(getActivity(), R.layout.item_reserve_service);
        hlva_yuezi.notifyDataSetChanged();
        hlvYuezi.setAdapter(hlva_yuezi);
        hlvYuezi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {  //  月子中心
                Intent intent_register = new Intent(getActivity(),TubeBabyActivity.class);
                //用Bundle携带数据
                Bundle bundle=new Bundle();
                bundle.putString("flag", "yuezi");
                intent_register.putExtras(bundle);
                startActivity(intent_register);
            }
        });

        hlva_abroad = new HorizontalListViewAdapter(getActivity(), R.layout.item_reserve_service);
        hlva_abroad.notifyDataSetChanged();
        hlvAbroad.setAdapter(hlva_abroad);
        hlvAbroad.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {      //  境外
                Intent intent_register = new Intent(getActivity(),TubeBabyActivity.class);
                //用Bundle携带数据
                Bundle bundle=new Bundle();
                bundle.putString("flag", "abroad");
                intent_register.putExtras(bundle);
                startActivity(intent_register);
            }
        });

        hlva_territory = new HorizontalListViewAdapter(getActivity(), R.layout.item_reserve_service);
        hlva_territory.notifyDataSetChanged();
        hlvTerritory.setAdapter(hlva_territory);
        hlvTerritory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {      //  境内
                Intent intent_register = new Intent(getActivity(),TubeBabyActivity.class);
                //用Bundle携带数据
                Bundle bundle=new Bundle();
                bundle.putString("flag", "territory");
                intent_register.putExtras(bundle);
                startActivity(intent_register);
            }
        });

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
