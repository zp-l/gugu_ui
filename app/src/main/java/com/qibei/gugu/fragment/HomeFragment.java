package com.qibei.gugu.fragment;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ScrollView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.qibei.gugu.R;
import com.qibei.gugu.activity.FindDoctorActivity;
import com.qibei.gugu.activity.FindEncyclopediasActivity;
import com.qibei.gugu.activity.FindHospitalActivity;
import com.qibei.gugu.activity.HospitalDetailActivity;
import com.qibei.gugu.adapter.HorizontalListViewAdapter;
import com.qibei.gugu.ui.loadinglayout.HeaderLayout;
import com.qibei.gugu.ui.HorizontalListView;
import com.qibei.gugu.ui.NavigationHeadView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends Fragment implements GestureDetector.OnGestureListener {
    @Bind(R.id.scrollview)
    PullToRefreshScrollView scrollview;
    ScrollView mScrollView;

    private View view = null;
    private HorizontalListViewAdapter hlva;
    private HorizontalListView hlv;
    Intent intent_doctor = null;
    Intent intent_hospital = null;
    Intent intent_encyclopedias = null;

    @Bind(R.id.nhv_hot_doctor)      //  热门医生导航条
            NavigationHeadView nhvHotDoctor;
    @Bind(R.id.nhv_hot_hospital)    //  热门医院导航条
            NavigationHeadView nhvHotHospital;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        initdate();

        registerListeners();
        return view;

    }

    //  注册监听事件
    private void registerListeners() {
        nhvHotDoctor.setonClick(new NavigationHeadView.ICoallBack() {
            @Override
            public void onClickBack() {         //  热门医生被点击
                startActivity(intent_doctor);
            }
        });
        nhvHotHospital.setonClick(new NavigationHeadView.ICoallBack() {
            @Override
            public void onClickBack() {          //  热门医院被点击
                Intent intent_doctor = new Intent(getActivity(), FindDoctorActivity.class);
                startActivity(intent_hospital);
            }
        });
    }

    private void initdate() {

        intent_doctor = new Intent(getActivity(), FindDoctorActivity.class);
        intent_hospital = new Intent(getActivity(), FindHospitalActivity.class);
        intent_encyclopedias = new Intent(getActivity(), FindEncyclopediasActivity.class);

        hlv = (HorizontalListView) view.findViewById(R.id.horizontallistview1);
        hlva = new HorizontalListViewAdapter(getActivity(), R.layout.show_hospital_layout);
        hlva.notifyDataSetChanged();
        hlv.setAdapter(hlva);
        hlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Intent intent = new Intent(getActivity(), HospitalDetailActivity.class);
                startActivity(intent);
            }
        });


        //   刷新控件初始化
        scrollview.setHeaderLayout(new HeaderLayout(getContext()));
        scrollview.setFooterLayout(new HeaderLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_END));

        scrollview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ScrollView>() {

            @Override
            public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
                new GetDataTask().execute();
            }
        });
        mScrollView = scrollview.getRefreshableView();

    }

    private class GetDataTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            // Simulates a background job.
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(String[] result) {
            // Do some stuff here

            // Call onRefreshComplete when the list has been refreshed.
            scrollview.onRefreshComplete();

            super.onPostExecute(result);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.ll_doctor, R.id.ll_build, R.id.ll_baike})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_doctor:    //  找医生
                startActivity(intent_doctor);
                break;
            case R.id.ll_build:     //  找机构
                startActivity(intent_hospital);
                break;
            case R.id.ll_baike:     //  查百科
                startActivity(intent_encyclopedias);
                break;
            default:
                break;
        }
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
