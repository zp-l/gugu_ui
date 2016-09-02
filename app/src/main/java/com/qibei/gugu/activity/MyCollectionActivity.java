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
import com.qibei.gugu.fragment.DoctorListFragment;
import com.qibei.gugu.fragment.HospitalListFragment;
import com.qibei.gugu.fragment.Mm_Release_Fragment;
import com.qibei.gugu.fragment.Mm_Share_Fragment;

import java.util.ArrayList;
import java.util.List;

public class MyCollectionActivity extends FragmentActivity implements View.OnClickListener{

    private ViewPager vp_collection;
    // ViewPager适配器
    private MyCouponFragmentAdapter adapter = null;
    private int tabWidth;
    private DisplayMetrics dm = new DisplayMetrics();
    private ImageView img_tabLine;
    //医院
    private TextView tv_hospital;
    //医生
    private TextView tv_doctor;
    //妈妈分享
    private TextView tv_mmfx;
    //名医发布
    private TextView tv_myfb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
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
            vp_collection = (ViewPager) findViewById(R.id.vp_collection);
            img_tabLine = (ImageView) findViewById(R.id.img_tabLine);

            tv_doctor = (TextView) findViewById(R.id.tv_doctor);
            tv_hospital = (TextView) findViewById(R.id.tv_hospital);
            tv_mmfx = (TextView) findViewById(R.id.tv_mmfx);
            tv_myfb = (TextView) findViewById(R.id.tv_myfb);

            tv_doctor.setTextColor(getResources().getColor(R.color.textcolor_mine_red));

        }
        /**
         * 初始化数据
         */
        private void initData() {
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            tabWidth = dm.widthPixels / 4;
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
            List<Fragment> list  = new ArrayList<Fragment>();
            //  医院
            HospitalListFragment hospitalListFragment = new HospitalListFragment();
            list.add(hospitalListFragment);
            //  医生
            DoctorListFragment doctorListFragment = new DoctorListFragment();
            list.add(doctorListFragment);
            //  妈妈分享
            Mm_Share_Fragment mm_share_fragment = new Mm_Share_Fragment();
            list.add(mm_share_fragment);
            //  名医发布
            Mm_Release_Fragment mm_release_fragment = new Mm_Release_Fragment();
            list.add(mm_release_fragment);
            adapter = new MyCouponFragmentAdapter(getSupportFragmentManager(),list);
            vp_collection.setAdapter(adapter);
        }
        /**
         * 注册事件监听
         */
        private void registerListener() {
            tv_doctor.setOnClickListener(this);
            tv_hospital.setOnClickListener(this);
            tv_mmfx.setOnClickListener(this);
            tv_myfb.setOnClickListener(this);
            vp_collection.setOnPageChangeListener(new PageListener());
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_doctor: {      //  医生
                    resetTab();
                    tv_doctor.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                    vp_collection.setCurrentItem(0);
                }
                break;
                case R.id.tv_hospital: {    //  医院
                    resetTab();
                    tv_hospital.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                    vp_collection.setCurrentItem(1);
                }
                break;
                case R.id.tv_mmfx: {        //  妈妈分享
                    resetTab();
                    tv_mmfx.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                    vp_collection.setCurrentItem(2);
                }
                break;
                case R.id.tv_myfb: {        //  名医发布
                    resetTab();
                    tv_mmfx.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                    vp_collection.setCurrentItem(3);
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
                    case 2:
                        matrix.setTranslate(2*tabWidth, 0);
                        break;
                    case 3:
                        matrix.setTranslate(3*tabWidth, 0);
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
                        tv_doctor.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                        vp_collection.setCurrentItem(0);
                    }
                    break;
                    case 1: {
                        resetTab();
                        tv_hospital.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                        vp_collection.setCurrentItem(1);
                    }
                    break;
                    case 2: {
                        resetTab();
                        tv_mmfx.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                        vp_collection.setCurrentItem(2);
                    }
                    break;
                    case 3: {
                        resetTab();
                        tv_myfb.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                        vp_collection.setCurrentItem(3);
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
            tv_doctor.setTextColor(getResources().getColor(R.color.details));
            tv_hospital.setTextColor(getResources().getColor(R.color.details));
            tv_mmfx.setTextColor(getResources().getColor(R.color.details));
            tv_myfb.setTextColor(getResources().getColor(R.color.details));
        }
    }

