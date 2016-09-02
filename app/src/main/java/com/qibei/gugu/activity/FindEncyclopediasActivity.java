package com.qibei.gugu.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.qibei.gugu.R;
import com.qibei.gugu.ui.CommonTopView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

//   查百科
public class FindEncyclopediasActivity extends Activity {

    @Bind(R.id.ctv_find_encyclopedias)
    CommonTopView ctvFindEncyclopedias;
    @Bind(R.id.lv_encyclopedias)
    ListView lvEncyclopedias;
    private ArrayList<String> mDatas = null;
    private Activity activity = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_encyclopedias);
        ButterKnife.bind(this);

        initView();

        registerListeners();

    }

    private void initView() {

        activity = this;

        {
            mDatas = new ArrayList<String>();
            String data1 = new String("1");
            String data2 = new String("1");
            String data3 = new String("1");
            String data4 = new String("1");
            String data5 = new String("1");
            mDatas.add(data1);
            mDatas.add(data2);
            mDatas.add(data3);
            mDatas.add(data4);
            mDatas.add(data5);
        }

        lvEncyclopedias.setAdapter(new MyBankCardAdapter(this, mDatas));
        lvEncyclopedias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Intent intent = new Intent(FindEncyclopediasActivity.this,EncyclopediasDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    private void registerListeners() {
        //返回监听
        ctvFindEncyclopedias.setonClick(new CommonTopView.ICoallBack() {
            @Override
            public void onClickBack() {
                finish();
            }

            @Override
            public void onClickSeting() {

            }
        });
    }

    //   我的 中   的   功能列表的适配器
    public class MyBankCardAdapter extends BaseAdapter {

        private LayoutInflater inflater;
        private Context mContext;
        ArrayList<String> list = null;

        public MyBankCardAdapter(Context context, ArrayList<String> list) {
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
            convertView = inflater.inflate(R.layout.item_encyclopedias, null);
            return convertView;
        }
    }
}
