package com.qibei.gugu.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.qibei.gugu.R;
import com.qibei.gugu.adapter.CommonAdapter;
import com.qibei.gugu.adapter.ViewHolder;
import com.qibei.gugu.model.VoucherItem;
import com.qibei.gugu.ui.CommonTopView;
import com.qibei.gugu.util.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class VoucherActivity extends Activity {

    private  ArrayList<VoucherItem> mDatas = null;
    @Bind(R.id.ctv_voucher)
    CommonTopView ctvVoucher;
    @Bind(R.id.lv_voucher)
    ListView lvVoucher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher);
        ButterKnife.bind(this);
        initView();
        registerListeners();

    }

    private void initView() {

        {
            mDatas = new ArrayList<VoucherItem>();
            VoucherItem data1 = new VoucherItem("代金卷", "生命试管婴儿中心", "有效期至2017-08-05", 150);
            VoucherItem data2 = new VoucherItem("代金卷", "生命试管婴儿中心", "有效期至2017-08-05", 250);
            VoucherItem data3 = new VoucherItem("代金卷", "生命试管婴儿中心", "有效期至2017-08-05", 350);
            VoucherItem data4 = new VoucherItem("代金卷", "生命试管婴儿中心", "有效期至2017-08-05", 650);
            VoucherItem data5 = new VoucherItem("代金卷", "生命试管婴儿中心", "有效期至2017-08-05", 750);
            mDatas.add(data1);mDatas.add(data2);mDatas.add(data3);mDatas.add(data4);mDatas.add(data5);
        }

        lvVoucher.setAdapter(new VoucherAdapter(this,mDatas));
        lvVoucher.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                UIUtils.Toast("点击了代金卷",false);
            }
        });
    }

    private void registerListeners() {
        //返回监听
        ctvVoucher.setonClick(new CommonTopView.ICoallBack() {
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
    public class VoucherAdapter extends CommonAdapter<VoucherItem> {

        public VoucherAdapter(Context context, List<VoucherItem> datas) {
            super(context, datas, R.layout.item_voucher);
        }

        @Override
        public void convert(ViewHolder holder, VoucherItem bean) {
            holder.setText(R.id.tv_voucher_name, bean.getTv_voucher_name());
            holder.setText(R.id.tv_voucher_hospital, bean.getTv_voucher_hospital());
            holder.setText(R.id.tv_voucher_time, bean.getTv_voucher_time());
            holder.setText(R.id.tv_voucher_money, bean.getTv_voucher_money()+"");
        }
    }

}
