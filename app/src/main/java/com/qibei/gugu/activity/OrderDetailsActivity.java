package com.qibei.gugu.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qibei.gugu.R;
import com.qibei.gugu.adapter.MyCouponFragmentAdapter;
import com.qibei.gugu.fragment.OrderDetailsFragment;
import com.qibei.gugu.fragment.OrderStateFragment;
import com.qibei.gugu.ui.CommonTopView;
import com.qibei.gugu.util.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OrderDetailsActivity extends FragmentActivity implements View.OnClickListener {

    @Bind(R.id.ctv_order_details)
    CommonTopView ctvOrderDetails;
    private ViewPager vp_order_details;
    // ViewPager适配器
    private MyCouponFragmentAdapter adapter = null;
    private int tabWidth;
    private DisplayMetrics dm = new DisplayMetrics();
    private ImageView img_tabLine;
    //订单状态
    private TextView tv_order_details;
    // 订单详情
    private TextView tv_order_state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
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
        vp_order_details = (ViewPager) findViewById(R.id.vp_order_details);
        img_tabLine = (ImageView) findViewById(R.id.img_tabLine);
        tv_order_state = (TextView) findViewById(R.id.tv_order_state);
        tv_order_details = (TextView) findViewById(R.id.tv_order_details);
        tv_order_state.setTextColor(getResources().getColor(R.color.textcolor_mine_red));

    }

    /**
     * 初始化数据
     */
    private void initData() {
        getWindowManager().getDefaultDisplay().getMetrics(dm);
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
        OrderStateFragment orderStateFragment = new OrderStateFragment();
        list.add(orderStateFragment);
        OrderDetailsFragment orderDetailsFragment = new OrderDetailsFragment();
        list.add(orderDetailsFragment);
        adapter = new MyCouponFragmentAdapter(getSupportFragmentManager(), list);
        vp_order_details.setAdapter(adapter);
    }

    /**
     * 注册事件监听
     */
    private void registerListener() {
        tv_order_state.setOnClickListener(this);
        tv_order_details.setOnClickListener(this);
        vp_order_details.setOnPageChangeListener(new PageListener());

        ctvOrderDetails.setonClick(new CommonTopView.ICoallBack() {

            @Override
            public void onClickBack() {
                finish();
            }

            @Override
            public void onClickSeting() {
                UIUtils.Toast("点击了设置", false);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_order_state: {
                resetTab();
                tv_order_state.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                vp_order_details.setCurrentItem(0);
            }
            break;
            case R.id.tv_order_details: {
                resetTab();
                tv_order_details.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                vp_order_details.setCurrentItem(1);
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
                    tv_order_state.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                    vp_order_details.setCurrentItem(0);
                }
                break;
                case 1: {
                    resetTab();
                    tv_order_details.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                    vp_order_details.setCurrentItem(1);
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
        tv_order_state.setTextColor(getResources().getColor(R.color.details));
        tv_order_details.setTextColor(getResources().getColor(R.color.details));
    }
}

