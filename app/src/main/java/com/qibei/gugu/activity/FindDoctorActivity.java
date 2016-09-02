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
import com.qibei.gugu.model.DoctorMassageItem;
import com.qibei.gugu.ui.CommonTopView;
import com.qibei.gugu.util.BitmapUtil;
import com.qibei.gugu.util.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FindDoctorActivity extends Activity {

    private  ArrayList<DoctorMassageItem> mDatas = null;
    private  Activity activity = null;
    @Bind(R.id.ctv_find_doctor)
    CommonTopView ctvFindDoctor;
    @Bind(R.id.lv_doctor)
    ListView lvDoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        ButterKnife.bind(this);

        initView();

        registerListeners();

    }

    private void initView() {

        activity = this;

        {
            mDatas = new ArrayList<DoctorMassageItem>();
            DoctorMassageItem data1 = new DoctorMassageItem("赵启平", "(主任医生 教授)", "上海第六人民医院","10年", "健康就是财富,身体是革命的本钱", BitmapUtil.ReadBitmapById(this,R.drawable.my_logo));
            DoctorMassageItem data2 = new DoctorMassageItem("赵启平", "(主任医生 教授)", "上海第六人民医院","10年", "健康就是财富,身体是革命的本钱", BitmapUtil.ReadBitmapById(this,R.drawable.my_logo));
            DoctorMassageItem data3 = new DoctorMassageItem("赵启平", "(主任医生 教授)", "上海第六人民医院","10年", "健康就是财富,身体是革命的本钱", BitmapUtil.ReadBitmapById(this,R.drawable.my_logo));
            DoctorMassageItem data4 = new DoctorMassageItem("赵启平", "(主任医生 教授)", "上海第六人民医院","10年", "健康就是财富,身体是革命的本钱", BitmapUtil.ReadBitmapById(this,R.drawable.my_logo));
            DoctorMassageItem data5 = new DoctorMassageItem("赵启平", "(主任医生 教授)", "上海第六人民医院","10年", "健康就是财富,身体是革命的本钱", BitmapUtil.ReadBitmapById(this,R.drawable.my_logo));
            mDatas.add(data1);mDatas.add(data2);mDatas.add(data3);mDatas.add(data4);mDatas.add(data5);
        }

        lvDoctor.setAdapter(new FindDoctorAdapter(this,mDatas));
        lvDoctor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Intent intent = new Intent(activity, DoctorDetailsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void registerListeners() {
        //返回监听
        ctvFindDoctor.setonClick(new CommonTopView.ICoallBack() {
            @Override
            public void onClickBack() {
                finish();
            }

            @Override
            public void onClickSeting() {
                UIUtils.Toast("搜索医生",false);
            }
        });
    }

    //   我的 中   的   功能列表的适配器
    public class FindDoctorAdapter extends CommonAdapter<DoctorMassageItem> {

        public FindDoctorAdapter(Context context, List<DoctorMassageItem> datas) {
            super(context, datas, R.layout.item_doctor_massage_2);
        }

        @Override
        public void convert(ViewHolder holder, DoctorMassageItem bean) {

            holder.setImageBitmap(R.id.iv_fda_doctor_logo, bean.getTv_doctor_logo());
            holder.setText(R.id.tv_fda_doctor_name, bean.getTv_doctor_name());
            holder.setText(R.id.tv_fda_doctor_title, bean.getTv_doctor_title());
            holder.setText(R.id.tv_fda_doctor_hospital, bean.getTv_doctor_hospital());
            holder.setText(R.id.tv_fda_doctor_time, bean.getTv_doctor_time());
            holder.setText(R.id.tv_fda_doctor_autograph,bean.getTv_doctor_autograph());
        }
    }
}
