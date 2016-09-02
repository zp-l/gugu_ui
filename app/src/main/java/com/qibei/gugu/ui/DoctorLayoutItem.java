package com.qibei.gugu.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qibei.gugu.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 自定义医生帧布局Item
 */
public class DoctorLayoutItem extends LinearLayout {


    @Bind(R.id.iv_image)    //背景图
    ImageView ivImage;
    @Bind(R.id.tv_doctor_name)  //  医生名
    TextView tvDoctorName;
    @Bind(R.id.iv_Title)    //  医生职称
    TextView ivTitle;
    @Bind(R.id.fl_doctorlayout) // 整个布局
    FrameLayout flDoctorlayout;

    //  等到整个View
    public View getView() {
        return view;
    }

    //   设置整个View
    public void setView(View view) {
        this.view = view;
    }

    private View view = null;


    /**
     * 一定一个接口
     */
    public interface ICoallBack {
        public void onClickBack();

    }

    /**
     * 初始化接口变量
     */
    ICoallBack icallBack = null;

    /**
     * 自定义控件的自定义事件
     *
     * @param iBack 接口类型
     */
    public void setonClick(ICoallBack iBack) {
        icallBack = iBack;
    }

    //////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    public DoctorLayoutItem(Context context) {
        this(context, null);
    }

    public DoctorLayoutItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DoctorLayoutItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        view = View.inflate(context, R.layout.show_doctor_framelayout, this);
        ButterKnife.bind(this);

    }
    @OnClick({R.id.tv_doctor_name, R.id.fl_doctorlayout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_doctor_name:   //  点击了医生名字
                break;
            case R.id.fl_doctorlayout:  //  点击整个布局
                icallBack.onClickBack();
                break;
            default:
                break;
        }
    }
}
