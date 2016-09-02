package com.qibei.gugu.fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qibei.gugu.R;
import com.qibei.gugu.adapter.MyCouponFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class MmbdFragment extends Fragment implements View.OnClickListener{

    private View view;
    private ViewPager mViewPager;
    // ViewPager适配器
    private MyCouponFragmentAdapter adapter = null;
    private int tabWidth;
    private DisplayMetrics dm = new DisplayMetrics();
    private ImageView img_tabLine;
    // 妈妈分享
    private TextView tv_fx_mmfx;
    // 名医发布
    private TextView tv_fx_myfb;
    private FragmentActivity fragmentActivity = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mmbd, container, false);
        fragmentActivity = getActivity();
        // 初始化控件
        initView();
        //初始化数据
        initData();
        // 绑定券页面
        bindPageData();
        // 注册监听
        registerListener();

        return view;
    }

        /**
         * 初始化控件
         */
        private void initView() {
            mViewPager = (ViewPager) view.findViewById(R.id.vp_mmbd);
            img_tabLine = (ImageView) view.findViewById(R.id.img_tabLine);
            tv_fx_myfb = (TextView) view.findViewById(R.id.tv_fx_myfb);
            tv_fx_mmfx = (TextView) view.findViewById(R.id.tv_fx_mmfx);
            tv_fx_myfb.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
        }
        /**
         * 初始化数据
         */
        private void initData() {
            fragmentActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
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
            List<Fragment> list  = new ArrayList<Fragment>();
            //名医发布
            Mm_Release_Fragment mm_release_fragment = new Mm_Release_Fragment();
            list.add(mm_release_fragment);
            //妈妈分享
            Mm_Share_Fragment mm_share_fragment = new Mm_Share_Fragment();
            list.add(mm_share_fragment);
            adapter = new MyCouponFragmentAdapter(fragmentActivity.getSupportFragmentManager(),list);
            mViewPager.setAdapter(adapter);
        }
        /**
         * 注册事件监听
         */
        private void registerListener() {
            tv_fx_myfb.setOnClickListener(this);
            tv_fx_mmfx.setOnClickListener(this);
            mViewPager.setOnPageChangeListener(new PageListener());
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_fx_myfb: {
                    resetTab();
                    Log.i("test","名医发布");
                    tv_fx_myfb.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                    mViewPager.setCurrentItem(0);
                }
                break;
                case R.id.tv_fx_mmfx: {
                    resetTab();
                    Log.i("test","妈妈分享");
                    tv_fx_mmfx.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                    mViewPager.setCurrentItem(1);
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
                        tv_fx_myfb.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                        mViewPager.setCurrentItem(0);
                    }
                    break;
                    case 1: {
                        resetTab();
                        tv_fx_mmfx.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                        mViewPager.setCurrentItem(1);
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
            tv_fx_myfb.setTextColor(getResources().getColor(R.color.details));
            tv_fx_mmfx.setTextColor(getResources().getColor(R.color.details));
        }
    }

