package com.qibei.gugu.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;

import com.qibei.gugu.R;
import com.qibei.gugu.util.UIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

//   宝宝档案
public class BabyFileActivity extends Activity {

    @Bind(R.id.iv_bfa_back)
    ImageView ivBfaBack;
    @Bind(R.id.iv_bfa_add_file)
    ImageView ivBfaAddFile;
    @Bind(R.id.lv_bfa)         //       listview
            ListView lvBfa;
    @Bind(R.id.sv_bfa)
    ScrollView svBfa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_file);
        ButterKnife.bind(this);
        // 初始化控件
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView() {

        lvBfa.setAdapter(new BabyFileAdapter(this));
        svBfa.smoothScrollTo(0, 0);
    }

    @OnClick({R.id.iv_bfa_back, R.id.iv_bfa_add_file})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_bfa_back:
                finish();
                break;
            case R.id.iv_bfa_add_file:
                UIUtils.Toast("添加档案", false);
                break;
        }
    }

    //   我的 中   的   功能列表的适配器
    public class BabyFileAdapter extends BaseAdapter {

        private LayoutInflater inflater;
        private Context mContext;
        private GridView gridView;
        private int[] itemImages = new int[]{R.drawable.baby2, R.drawable.baby2, R.drawable.baby2, R.drawable.baby2};

        public BabyFileAdapter(Context context) {

            this.mContext = context;
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return 4;
        }

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
            convertView = inflater.inflate(R.layout.item_baby_file, null);
            gridView = (GridView) convertView.findViewById(R.id.gv_bfa);
            // 设置数据匹配器
            gridView.setAdapter(getAdapter());
            return convertView;
        }

        private ListAdapter getAdapter() {
            // 该list用来存放每一个item对应的文字和图片
            List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
            for (int i = 0; i < itemImages.length; i++) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("itemImage", itemImages[i]);
                list.add(map);
            }
            // 该构造函数，这里说明一下
            // 第一个参数为new SimpleAdapter(Context, 上面的list,每一个项对应的itemView,itemView里显示的所有信息（要和list里的map里的名称一样） ,
            // itemView里控件id);
            SimpleAdapter simpleAdapter = new SimpleAdapter(BabyFileActivity.this, list, R.layout.item_image, new String[]{"itemImage"},
                    new int[]{R.id.imageView});
            return simpleAdapter;
        }

    }
}

