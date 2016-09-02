package com.qibei.gugu.fragment;


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
import com.qibei.gugu.util.UIUtils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CommentFragment extends Fragment {
    @Bind(R.id.lv_ef_evaluate)
    ListView lvEfEvaluate;
    private View view = null;
    EvaluateAdapter listAdapter = null;
    private ArrayList<String> mDatas = null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_comment, container, false);
        ButterKnife.bind(this, view);
        initView();
        registerListeners();
        return view;
    }

    public void initView() {
        {
            mDatas = new ArrayList<String>();
            String data1 = new String("data1");
            String data2 = new String("data2");
            String data3 = new String("data2");
            String data4 = new String("data2");
            String data5 = new String("data2");

            mDatas.add(data1);
            mDatas.add(data2);mDatas.add(data3);mDatas.add(data4);mDatas.add(data5);
        }

        listAdapter = new EvaluateAdapter(getContext(), mDatas);
        lvEfEvaluate.setAdapter(listAdapter);
        lvEfEvaluate.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                UIUtils.Toast("点击了评论", false);
            }
        });

    }

    private void registerListeners() {

    }

    //   我的 中   的   功能列表的适配器
    public class EvaluateAdapter extends BaseAdapter {

        private LayoutInflater inflater;
        private Context mContext;
        ArrayList<String> list = null;

        public EvaluateAdapter(Context context, ArrayList<String> list) {
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
            convertView = inflater.inflate(R.layout.item_evaluate, null);
            return convertView;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
