package com.qibei.gugu.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.qibei.gugu.R;
import com.qibei.gugu.model.BankCarkItem;
import com.qibei.gugu.util.BitmapUtil;
import com.qibei.gugu.util.UIUtils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的银行卡
 */
public class MyBankCardFregment extends Fragment {

    @Bind(R.id.lv_my_bank_card)
    ListView lvMyBankCard;
    @Bind(R.id.iv_mbcf_next)        //   添加银行卡
    ImageView ivMbcfNext;
    @Bind(R.id.ll_add_bank_card)   //    添加银行卡布局
    LinearLayout llAddBankCard;
    private ArrayList<BankCarkItem> mDatas = null;
    MyBankCardAdapter listAdapter = null;
    private View view = null;
    MyListener mylistener;
    public interface MyListener {
        public void showMessage(int x);
    }

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        mylistener = (MyListener) activity;
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_bank_card, container, false);
        ButterKnife.bind(this, view);
        initView();
        registerListeners();
        return view;
    }

    @OnClick({R.id.iv_mbcf_next, R.id.ll_add_bank_card})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_mbcf_next:         //  添加银行卡
                mylistener.showMessage(1);
                break;
            case R.id.ll_add_bank_card:      //  添加银行卡布局
                break;
        }
    }


    public void initView() {

        {
            mDatas = new ArrayList<BankCarkItem>();
            BankCarkItem data1 = new BankCarkItem("建设银行", "储蓄卡", "1111 2222 3333 4444", BitmapUtil.ReadBitmapById(getContext(), R.drawable.my_logo));
            BankCarkItem data2 = new BankCarkItem("建设银行", "储蓄卡", "1111 2222 3333 4444", BitmapUtil.ReadBitmapById(getContext(), R.drawable.my_logo));

            mDatas.add(data1);
            mDatas.add(data2);
        }

        listAdapter = new MyBankCardAdapter(getContext(), mDatas);
        lvMyBankCard.setAdapter(listAdapter);
        lvMyBankCard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                UIUtils.Toast("点击了银行卡", false);
            }
        });

        setListViewHeightBasedOnChildren(lvMyBankCard);
        listAdapter.notifyDataSetChanged();
    }

    private void registerListeners() {

    }

    //在查阅的各种文档和资料后，发现在ScrollView中嵌套ListView空间，
    // 无法正确的计算ListView的大小，故可以通过代码，根据当前的ListView的列表项计算列表的尺寸。实现代码如下：
    public void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter

        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    //   我的 中   的   功能列表的适配器
    public class MyBankCardAdapter extends BaseAdapter {

        private LayoutInflater inflater;
        private Context mContext;
        ArrayList<BankCarkItem> list = null;

        public MyBankCardAdapter(Context context, ArrayList<BankCarkItem> list) {
            this.list = list;
            this.mContext = context;
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = inflater.inflate(R.layout.item_bank_card, null);
            return convertView;
        }
    }

}
