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
import android.widget.ListView;

import com.qibei.gugu.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 选择银行卡
 */
public class SelectBankCardFregment extends Fragment {

    SelectBankCardAdapter listAdapter = null;
    @Bind(R.id.lv_select_bank_card)
    ListView lvSelectBankCard;
    private View view = null;
    private ArrayList<String> mDatas ;
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
        view = inflater.inflate(R.layout.fragment_select_bank_card, container, false);
        ButterKnife.bind(this, view);
        initView();
        registerListeners();
        return view;
    }


    public void initView() {

        {
            mDatas = new ArrayList<String>();
            String data1 = new String ("1");
            String data2 = new String ("1");
            mDatas.add(data1);
            mDatas.add(data2);
        }

        listAdapter = new SelectBankCardAdapter(getContext(), mDatas);
        lvSelectBankCard.setAdapter(listAdapter);
        lvSelectBankCard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                mylistener.showMessage(1);
            }
        });

    }

    private void registerListeners() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    //   我的 中   的   功能列表的适配器
    public class SelectBankCardAdapter extends BaseAdapter {

        private LayoutInflater inflater;
        private Context mContext;
        ArrayList list = null;

        public SelectBankCardAdapter(Context context, ArrayList<String> list) {
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
            convertView = inflater.inflate(R.layout.item_select_bank_card, null);
            return convertView;
        }
    }

}
