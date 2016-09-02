package com.qibei.gugu.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.qibei.gugu.R;
import com.qibei.gugu.activity.ProductDetailsActivity;
import com.qibei.gugu.activity.RoomDetailsActivity;
import com.qibei.gugu.adapter.CommonAdapter;
import com.qibei.gugu.adapter.ViewHolder;
import com.qibei.gugu.model.DoctorProductItem;
import com.qibei.gugu.util.BitmapUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RoomTypeFragment extends Fragment {

    @Bind(R.id.lv_pf_product)   //   产品列表
    ListView lvPfProduct;
    private ArrayList<DoctorProductItem> mDatas = null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        ButterKnife.bind(this, view);
        // 初始化控件
        initView();
        // 注册监听
        registerListener();
        return view;
    }

    /**
     * 初始化控件
     */
    private void initView() {

        {
            mDatas = new ArrayList<DoctorProductItem>();
            DoctorProductItem data1 = new DoctorProductItem("经济型房间", "5999元", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",  BitmapUtil.ReadBitmapById(getActivity(), R.drawable.hospital3));
            DoctorProductItem data2 = new DoctorProductItem("经济型房间", "5999元", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",  BitmapUtil.ReadBitmapById(getActivity(), R.drawable.hospital3));
            DoctorProductItem data3 = new DoctorProductItem("经济型房间", "5999元", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",  BitmapUtil.ReadBitmapById(getActivity(), R.drawable.hospital3));
            DoctorProductItem data4 = new DoctorProductItem("经济型房间", "5999元", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",  BitmapUtil.ReadBitmapById(getActivity(), R.drawable.hospital3));
            DoctorProductItem data5 = new DoctorProductItem("经济型房间", "5999元", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",  BitmapUtil.ReadBitmapById(getActivity(), R.drawable.hospital3));

            mDatas.add(data1);
            mDatas.add(data2);
            mDatas.add(data3);
            mDatas.add(data4);
            mDatas.add(data5);
        }

        lvPfProduct.setAdapter(new DoctorProductAdapter(getActivity(), mDatas));
        lvPfProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                //   启动  房间详情
                Intent intent_product = new Intent(getActivity(), RoomDetailsActivity.class);
                startActivity(intent_product);
            }
        });
    }

    /**
     * 注册监听
     */
    private void registerListener() {

    }

    //   我的 中   的   功能列表的适配器
    public class DoctorProductAdapter extends CommonAdapter<DoctorProductItem> {

        public DoctorProductAdapter(Context context, List<DoctorProductItem> datas) {
            super(context, datas, R.layout.item_doctor_product);
        }

        @Override
        public void convert(ViewHolder holder, DoctorProductItem bean) {

            holder.setText(R.id.tv_dpf_hospital, bean.getTv_dpf_hospital());
            holder.setText(R.id.tv_dpf_money, bean.getTv_dpf_money());
            holder.setText(R.id.tv_dpf_describe, bean.getTv_dpf_describe());
            holder.setImageBitmap(R.id.iv_dpf_product_logo, bean.getIv_dpf_product_logo());

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
