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
import com.qibei.gugu.fragment.CommentFragment;
import com.qibei.gugu.fragment.Doctor_DetailsFragment;
import com.qibei.gugu.fragment.MHIntroductionFragment;
import com.qibei.gugu.fragment.ProductFragment;
import com.qibei.gugu.fragment.RoomTypeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

//   月子中心
public class MaternityHotelsActivity extends FragmentActivity implements View.OnClickListener {


    @Bind(R.id.tv_introduction)         //  简介
    TextView tvIntroduction;
    @Bind(R.id.tv_room_type)            //  房间类型
    TextView tvRoomType;
    @Bind(R.id.img_tabLine)
    ImageView imgTabLine;
    @Bind(R.id.vp_maternity_hotel)      // 月子中心容器
    ViewPager vpMaternityHotel;
    @Bind(R.id.iv_mha_back)         //  返回
    ImageView ivMhaBack;
    // ViewPager适配器
    private MyCouponFragmentAdapter adapter = null;
    private int tabWidth;
    private DisplayMetrics dm = new DisplayMetrics();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maternity_hotels);
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
        tvIntroduction.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
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
        imgTabLine.setImageBitmap(bitmap2);
    }

    /**
     * 绑定页面数据
     */
    private void bindPageData() {
        List<Fragment> list = new ArrayList<Fragment>();
        //   简介
        MHIntroductionFragment mhIntroductionFragment = new MHIntroductionFragment();
        list.add(mhIntroductionFragment);
        //   医生所属产品
        RoomTypeFragment roomTypeFragment = new RoomTypeFragment();
        list.add(roomTypeFragment);
        adapter = new MyCouponFragmentAdapter(getSupportFragmentManager(), list);
        vpMaternityHotel.setAdapter(adapter);
    }

    /**
     * 注册事件监听
     */
    private void registerListener() {
        tvIntroduction.setOnClickListener(this);
        tvRoomType.setOnClickListener(this);
        vpMaternityHotel.setOnPageChangeListener(new PageListener());
    }

    @OnClick({R.id.tv_introduction, R.id.tv_room_type, R.id.iv_mha_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_introduction: {
                resetTab();
                tvIntroduction.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                vpMaternityHotel.setCurrentItem(0);
            }
            break;
            case R.id.tv_room_type: {
                resetTab();
                tvRoomType.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                vpMaternityHotel.setCurrentItem(1);
            }
            break;
            case R.id.iv_mha_back:         //  返回
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
                    tvIntroduction.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                    vpMaternityHotel.setCurrentItem(0);
                }
                break;
                case 1: {
                    resetTab();
                    tvRoomType.setTextColor(getResources().getColor(R.color.textcolor_mine_red));
                    vpMaternityHotel.setCurrentItem(1);
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
        tvIntroduction.setTextColor(getResources().getColor(R.color.details));
        tvRoomType.setTextColor(getResources().getColor(R.color.details));
    }
}

