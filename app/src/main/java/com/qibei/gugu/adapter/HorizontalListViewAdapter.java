package com.qibei.gugu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.qibei.gugu.util.UIUtils;


public class HorizontalListViewAdapter extends BaseAdapter {

    ImageView ivAddressLogo;
    private int id;

    public HorizontalListViewAdapter(Context con,int id) {
        mInflater = LayoutInflater.from(con);
        this.id = id;
    }

    @Override
    public int getCount() {
        return 5;
    }

    private LayoutInflater mInflater;

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(id, null);
//        ivAddressLogo = (ImageView)convertView.findViewById(R.id.iv_address_logo);
//        ivAddressLogo.setOnClickListener( new MyListener(position));
        return convertView;
    }
    private class MyListener implements View.OnClickListener {
        int mPosition;
        public MyListener(int inPosition){
            mPosition= inPosition;
        }
        @Override
        public void onClick(View v) {
            UIUtils.Toast(mPosition+"",false);
        }

    }
}