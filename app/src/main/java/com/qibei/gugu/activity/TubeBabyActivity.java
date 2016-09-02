package com.qibei.gugu.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.qibei.gugu.R;
import com.qibei.gugu.adapter.CommonAdapter;
import com.qibei.gugu.adapter.ViewHolder;
import com.qibei.gugu.model.BankCarkItem;
import com.qibei.gugu.model.HospitalMassageItem;
import com.qibei.gugu.model.PreOrderProjectItem;
import com.qibei.gugu.ui.CommonTopView;
import com.qibei.gugu.util.BitmapUtil;
import com.qibei.gugu.util.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TubeBabyActivity extends Activity {

    @Bind(R.id.ctv_tube_baby)
    CommonTopView ctvTubeBaby;
    @Bind(R.id.lv_tube_baby)
    ListView lvTubeBaby;
    private String flag;

    private ArrayList<PreOrderProjectItem> mDatas = null;
    PerOrderProjectAdapter listAdapter = null;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tube_baby);
        ButterKnife.bind(this);
        initView();

        registerListeners();

    }

    private void initView() {
        activity = this;

        //新页面接收数据
        Bundle bundle = this.getIntent().getExtras();
        //接收name值
        flag = bundle.getString("flag");
        if (flag.equals("yuezi")) {
            {
                mDatas = new ArrayList<PreOrderProjectItem>();
                PreOrderProjectItem data1 = new PreOrderProjectItem("美酷宝宝", "美国-洛杉矶", "美酷宝宝月子中心",  BitmapUtil.ReadBitmapById(this, R.drawable.hospital2));
                PreOrderProjectItem data2 = new PreOrderProjectItem("美酷宝宝", "美国-洛杉矶", "美酷宝宝月子中心",  BitmapUtil.ReadBitmapById(this, R.drawable.hospital2));
                PreOrderProjectItem data3 = new PreOrderProjectItem("美酷宝宝", "美国-洛杉矶", "美酷宝宝月子中心",  BitmapUtil.ReadBitmapById(this, R.drawable.hospital2));
                PreOrderProjectItem data4 = new PreOrderProjectItem("美酷宝宝", "美国-洛杉矶", "美酷宝宝月子中心",  BitmapUtil.ReadBitmapById(this, R.drawable.hospital2));
                PreOrderProjectItem data5 = new PreOrderProjectItem("美酷宝宝", "美国-洛杉矶", "美酷宝宝月子中心",  BitmapUtil.ReadBitmapById(this, R.drawable.hospital2));
                mDatas.add(data1);
                mDatas.add(data2);
                mDatas.add(data3);
                mDatas.add(data4);
                mDatas.add(data5);
                ctvTubeBaby.setTvTitle("月子中心");
            }
        } else if (flag.equals("abroad")) {
            mDatas = new ArrayList<PreOrderProjectItem>();
            PreOrderProjectItem data1 = new PreOrderProjectItem("生命试管婴儿中心", "一次微刺激", "4950",  BitmapUtil.ReadBitmapById(this, R.drawable.hospital3));
            PreOrderProjectItem data2 = new PreOrderProjectItem("生命试管婴儿中心", "一次微刺激", "4950",  BitmapUtil.ReadBitmapById(this, R.drawable.hospital3));
            PreOrderProjectItem data3 = new PreOrderProjectItem("生命试管婴儿中心", "一次微刺激", "4950",  BitmapUtil.ReadBitmapById(this, R.drawable.hospital3));
            PreOrderProjectItem data4 = new PreOrderProjectItem("生命试管婴儿中心", "一次微刺激", "4950",  BitmapUtil.ReadBitmapById(this, R.drawable.hospital3));
            PreOrderProjectItem data5 = new PreOrderProjectItem("生命试管婴儿中心", "一次微刺激", "4950",  BitmapUtil.ReadBitmapById(this, R.drawable.hospital3));
            mDatas.add(data1);
            mDatas.add(data2);
            mDatas.add(data3);
            mDatas.add(data4);
            mDatas.add(data5);
            ctvTubeBaby.setTvTitle("海外试管项目");
        } else if (flag.equals("territory")) {
            mDatas = new ArrayList<PreOrderProjectItem>();
            PreOrderProjectItem data1 = new PreOrderProjectItem("生命试管婴儿中心", "一次微刺激", "6500",  BitmapUtil.ReadBitmapById(this, R.drawable.hospital3));
            PreOrderProjectItem data2 = new PreOrderProjectItem("生命试管婴儿中心", "一次微刺激", "6500",  BitmapUtil.ReadBitmapById(this, R.drawable.hospital3));
            PreOrderProjectItem data3 = new PreOrderProjectItem("生命试管婴儿中心", "一次微刺激", "6500",  BitmapUtil.ReadBitmapById(this, R.drawable.hospital3));
            PreOrderProjectItem data4 = new PreOrderProjectItem("生命试管婴儿中心", "一次微刺激", "6500",  BitmapUtil.ReadBitmapById(this, R.drawable.hospital3));
            PreOrderProjectItem data5 = new PreOrderProjectItem("生命试管婴儿中心", "一次微刺激", "6500",  BitmapUtil.ReadBitmapById(this, R.drawable.hospital3));
            mDatas.add(data1);
            mDatas.add(data2);
            mDatas.add(data3);
            mDatas.add(data4);
            mDatas.add(data5);
            ctvTubeBaby.setTvTitle("境内试管项目");

        }

        listAdapter = new PerOrderProjectAdapter(this, mDatas);
        lvTubeBaby.setAdapter(listAdapter);
        lvTubeBaby.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                if(flag.equals("abroad") || flag.equals("territory")){
                    Intent intent = new Intent(TubeBabyActivity.this , ProductDetailsActivity.class);
                    startActivity(intent);
               }else{
                    Intent intent = new Intent(TubeBabyActivity.this , MaternityHotelsActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    private void registerListeners() {
        //返回监听
        ctvTubeBaby.setonClick(new CommonTopView.ICoallBack() {
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
    public class PerOrderProjectAdapter extends CommonAdapter<PreOrderProjectItem> {

        public PerOrderProjectAdapter(Context context, List<PreOrderProjectItem> datas) {
            super(context, datas, R.layout.item_pre_order_project);
        }

        @Override
        public void convert(ViewHolder holder, PreOrderProjectItem bean) {

            holder.setText(R.id.tv_pre_order_1, bean.getTv_pre_order_1());
            holder.setText(R.id.tv_pre_order_2, bean.getTv_pre_order_2());
            holder.setText(R.id.tv_pre_order_3, bean.getTv_pre_order_3());
            holder.setImageBitmap(R.id.iv_pre_order_logo, bean.getTv_pre_order_logo());

            if(flag.equals("abroad") || flag.equals("territory")){
                Log.i("test","test");
                holder.setColor(R.id.tv_pre_order_3,activity.getResources().getColor(R.color.default_green));
            }
        }
    }

}
