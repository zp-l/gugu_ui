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
import com.qibei.gugu.fragment.Doctor_DetailsFragment;
import com.qibei.gugu.fragment.CommentFragment;
import com.qibei.gugu.fragment.ProductFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

//   医生详情
public class DoctorDetailsActivity extends FragmentActivity implements View.OnClickListener {


    @Bind(R.id.iv_dda_back)         //  返回
            ImageView ivDdaBack;
    @Bind(R.id.tv_doctor_details)
    TextView tvDoctorDetails;       //  个人简介
    @Bind(R.id.tv_product)
    TextView tvProduct;             //  所属产品
    @Bind(R.id.tv_evaluate)         //  评价
    TextView tvEvaluate;
    @Bind(R.id.img_tabLine)
    ImageView imgTabLine;
    @Bind(R.id.vp_doctor_details)   //  页面容器
            ViewPager vpDoctorDetails;


    // ViewPager适配器
    private MyCouponFragmentAdapter adapter = null;
    private int tabWidth;
    private DisplayMetrics dm = new DisplayMetrics();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
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

        tvDoctorDetails.setTextColor(getResources().getColor(R.color.textcolor_mine_red));

    }

    /**
     * 初始化数据
     */
    private void initData() {
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        tabWidth = dm.widthPixels / 3;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tab_line);
        // /Bitmap b = Bitmap.createBitmap(bitmap, 0, 0, tabWidth, 8);
        // 设置tab的宽度和高度
        Bitmap bitmap2 = Bitmap.createScaledBitmap(bitmap, tabWidth, 8, true);
        imgTabLine.setImageBitmap(bitmap2);
    }

    /**
     * 绑定页面数据
     */
    private void bindPageData() {
        List<Fragment> list = new ArrayList<Fragment>();
        //   医生个人简介页
        Doctor_DetailsFragment doctor_detailsfragment = new Doctor_DetailsFragment();
        list.add(doctor_detailsfragment);
        //   医生所属产品
        ProductFragment productfragment = new ProductFragment();
        list.add(productfragment);
        //   评价
        CommentFragment evaluateFragment = new CommentFragment();
        list.add(evaluateFragment);
        adapter = new MyCouponFragmentAdapter(getSupportFragmentManager(), list);
        vpDoctorDetails.setAdapter(adapter);
    }

    /**
     * 注册事件监听
     */
    private void registerListener() {
        tvDoctorDetails.setOnClickListener(this);
        tvProduct.setOnClickListener(this);
        tvEvaluate.setOnClickListener(this);
        vpDoctorDetails.setOnPageChangeListener(new PageListener());
    }

    @OnClick({R.id.tv_doctor_details, R.id.tv_product, R.id.iv_dda_back, R.id.tv_evaluate})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_doctor_details: {
                resetTab();
                tvDoctorDetails.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                vpDoctorDetails.setCurrentItem(0);
            }
            break;
            case R.id.tv_product: {
                resetTab();
                tvProduct.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                vpDoctorDetails.setCurrentItem(1);
            }
            break;
            case R.id.tv_evaluate: {
                resetTab();
                tvEvaluate.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                vpDoctorDetails.setCurrentItem(2);
            }
            break;
            case R.id.iv_dda_back:         //  返回
                finish();
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
                case 2:
                    matrix.setTranslate(2*tabWidth, 0);
                    break;
            }
            // 在滑动的过程中，计算出激活条应该要滑动的距离
            float t = (tabWidth) * arg1;
            // 使用post追加数值
            matrix.postTranslate(t, 0);
            imgTabLine.setImageMatrix(matrix);
        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0: {
                    resetTab();
                    tvDoctorDetails.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                    vpDoctorDetails.setCurrentItem(0);
                }
                break;
                case 1: {
                    resetTab();
                    tvProduct.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                    vpDoctorDetails.setCurrentItem(1);
                }
                break;
                case 2: {
                    resetTab();
                    tvEvaluate.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                    vpDoctorDetails.setCurrentItem(2);
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
        tvDoctorDetails.setTextColor(getResources().getColor(R.color.details));
        tvProduct.setTextColor(getResources().getColor(R.color.details));
        tvEvaluate.setTextColor(getResources().getColor(R.color.details));
    }
}

