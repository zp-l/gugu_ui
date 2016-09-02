package com.qibei.gugu.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.qibei.gugu.R;
import com.qibei.gugu.adapter.CommonAdapter;
import com.qibei.gugu.adapter.ViewHolder;
import com.qibei.gugu.model.HospitalMassageItem;
import com.qibei.gugu.ui.CommonTopView;
import com.qibei.gugu.util.BitmapUtil;
import com.qibei.gugu.util.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FindHospitalActivity extends Activity {

    @Bind(R.id.ctv_find_hospital)
    CommonTopView ctvFindHospital;
    @Bind(R.id.lv_hospital)
    ListView lvHospital;
    private ArrayList<HospitalMassageItem> mDatas = null;
    private Activity activity = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_hospital);
        ButterKnife.bind(this);

        initView();

        registerListeners();

    }

    private void initView() {

        activity = this;

        {
            mDatas = new ArrayList<HospitalMassageItem>();
            HospitalMassageItem data1 = new HospitalMassageItem("上海第六人民医院", "中国-上海", "主攻于骨科、外科",  BitmapUtil.ReadBitmapById(this, R.drawable.hospital2));
            HospitalMassageItem data2 = new HospitalMassageItem("上海第六人民医院", "中国-上海", "主攻于骨科、外科",  BitmapUtil.ReadBitmapById(this, R.drawable.hospital2));
            HospitalMassageItem data3 = new HospitalMassageItem("上海第六人民医院", "中国-上海", "主攻于骨科、外科",  BitmapUtil.ReadBitmapById(this, R.drawable.hospital2));
            HospitalMassageItem data4 = new HospitalMassageItem("上海第六人民医院", "中国-上海", "主攻于骨科、外科",  BitmapUtil.ReadBitmapById(this, R.drawable.hospital2));
            HospitalMassageItem data5 = new HospitalMassageItem("上海第六人民医院", "中国-上海", "主攻于骨科、外科",  BitmapUtil.ReadBitmapById(this, R.drawable.hospital2));

            mDatas.add(data1);
            mDatas.add(data2);
            mDatas.add(data3);
            mDatas.add(data4);
            mDatas.add(data5);
        }

        lvHospital.setAdapter(new FindHospitalAdapter(this, mDatas));
        lvHospital.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Intent intent = new Intent(activity, HospitalDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    private void registerListeners() {
        //返回监听
        ctvFindHospital.setonClick(new CommonTopView.ICoallBack() {
            @Override
            public void onClickBack() {
                finish();
            }

            @Override
            public void onClickSeting() {
                UIUtils.Toast("搜索医院", false);
            }
        });
    }

    //   我的 中   的   功能列表的适配器
    public class FindHospitalAdapter extends CommonAdapter<HospitalMassageItem> {

        public FindHospitalAdapter(Context context, List<HospitalMassageItem> datas) {
            super(context, datas, R.layout.item_hospital_massage);
        }

        @Override
        public void convert(ViewHolder holder, HospitalMassageItem bean) {

            holder.setText(R.id.tv_fha_hospital_name, bean.getIv_hospital_name());
            holder.setText(R.id.tv_fha_hospital_address, bean.getTv_hospital_address());
            holder.setText(R.id.tv_fha_hospital_expertise, bean.getTv_hospital_expertise());
            holder.setImageBitmap(R.id.iv_fha_hospital_logo, bean.getIv_hospital_logo());

        }
    }
}
