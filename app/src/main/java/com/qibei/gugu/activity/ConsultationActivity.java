package com.qibei.gugu.activity;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qibei.gugu.R;
import com.qibei.gugu.adapter.MyCouponFragmentAdapter;
import com.qibei.gugu.fragment.Assistant_Online_Fragment;
import com.qibei.gugu.fragment.Doctor_Online_Fragment;
import com.qibei.gugu.ui.CommonTopView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ConsultationActivity extends FragmentActivity implements View.OnClickListener {

    @Bind(R.id.ctv_consultation)
    CommonTopView ctvConsultation;
    private ViewPager vp_consultation;
    // ViewPager适配器
    private MyCouponFragmentAdapter adapter = null;
    private int tabWidth;
    private DisplayMetrics dm = new DisplayMetrics();
    private ImageView img_tabLine;
    private TextView tv_assistant_online;
    // 医生在线
    private TextView tv_doctor_online;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation);
        ButterKnife.bind(this);

        // 初始化控件
        initView();
        //初始化数据
        initData();
        // 绑定券页面
        bindPageData();
        // 注册监听
        registerListener();

    }

    /**
     * 初始化控件
     */
    private void initView() {
        vp_consultation = (ViewPager) findViewById(R.id.vp_consultation);
        img_tabLine = (ImageView) findViewById(R.id.img_tabLine);
        tv_doctor_online = (TextView) findViewById(R.id.tv_doctor_online);
        tv_assistant_online = (TextView) findViewById(R.id.tv_assistant_online);
        tv_doctor_online.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
    }

    /**
     * 初始化数据
     */
    private void initData() {
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        tabWidth = dm.widthPixels / 2;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tab_line);
        // /Bitmap b = Bitmap.createBitmap(bitmap, 0, 0, tabWidth, 8);
        // 设置tab的宽度和高度
        Bitmap bitmap2 = Bitmap.createScaledBitmap(bitmap, tabWidth, 8, true);
        img_tabLine.setImageBitmap(bitmap2);
    }

    /**
     * 绑定页面数据
     */
    private void bindPageData() {
        List<Fragment> list = new ArrayList<Fragment>();
        Doctor_Online_Fragment doctor_Online_Fragment = new Doctor_Online_Fragment();
        list.add(doctor_Online_Fragment);
        Assistant_Online_Fragment assistant_Online_Fragment = new Assistant_Online_Fragment();
        list.add(assistant_Online_Fragment);
        adapter = new MyCouponFragmentAdapter(this.getSupportFragmentManager(), list);
        vp_consultation.setAdapter(adapter);
    }

    /**
     * 注册事件监听
     */
    private void registerListener() {
        tv_doctor_online.setOnClickListener(this);
        tv_assistant_online.setOnClickListener(this);
        vp_consultation.setOnPageChangeListener(new PageListener());

        ctvConsultation.setonClick(new CommonTopView.ICoallBack() {

            @Override
            public void onClickBack() {
                finish();
            }

            @Override
            public void onClickSeting() {
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 未消费
            case R.id.tv_doctor_online: {
                resetTab();
                Log.i("test", "在线医生");
                tv_doctor_online.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                vp_consultation.setCurrentItem(0);
            }
            break;
            // 已消费
            case R.id.tv_assistant_online: {
                resetTab();
                Log.i("test", "在线助理");
                tv_assistant_online.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                vp_consultation.setCurrentItem(1);
            }
            break;
            default:
                break;
        }

    }

    /**
     * viewPager滑动监听
     */
    public class PageListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // new一个矩阵
            Matrix matrix = new Matrix();
            // 设置激活条的最终位置
            switch (arg0) {
                case 0:
                    // 使用set直接设置到那个位置
                    matrix.setTranslate(0, 0);
                    break;
                case 1:
                    matrix.setTranslate(tabWidth, 0);
                    break;
            }
            // 在滑动的过程中，计算出激活条应该要滑动的距离
            float t = (tabWidth) * arg1;
            // 使用post追加数值
            matrix.postTranslate(t, 0);
            img_tabLine.setImageMatrix(matrix);
        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0: {
                    resetTab();
                    tv_doctor_online.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                    vp_consultation.setCurrentItem(0);
                }
                break;
                case 1: {
                    resetTab();
                    tv_assistant_online.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                    vp_consultation.setCurrentItem(1);
                }
                break;
                default:
                    break;
            }
        }
    }

    /**
     * 文字全部重置为默认状态
     */
    private void resetTab() {
        tv_doctor_online.setTextColor(getResources().getColor(R.color.details));
        tv_assistant_online.setTextColor(getResources().getColor(R.color.details));
    }

    @Override
    public void finish() {
        // TODO Auto-generated method stub
        super.finish();
        this.overridePendingTransition(R.anim.activity_close,0);
    }

}

