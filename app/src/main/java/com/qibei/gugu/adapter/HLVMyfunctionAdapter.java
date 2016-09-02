package com.qibei.gugu.adapter;

import android.content.Context;

import com.qibei.gugu.R;
import com.qibei.gugu.model.Myfunction;

import java.util.List;

//   我的 中   的   功能列表的适配器
public class HLVMyfunctionAdapter extends CommonAdapter<Myfunction> {

    public HLVMyfunctionAdapter(Context context, List<Myfunction> datas) {
        super(context, datas, R.layout.item_my_function);
    }

    @Override
    public void convert(ViewHolder holder, Myfunction bean) {

        holder.setImageBitmap(R.id.iv_function, bean.getSrc());
        holder.setText(R.id.tv_function, bean.getText());

    }
}