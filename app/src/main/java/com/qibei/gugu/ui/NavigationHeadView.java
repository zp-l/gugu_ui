package com.qibei.gugu.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qibei.gugu.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 自定义导航头
 */
public class NavigationHeadView extends LinearLayout {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_more)
    TextView tvMore;
    @Bind(R.id.iv_next)
    ImageView ivNext;
    @Bind(R.id.ll_more)
    LinearLayout llMore;

    // 设置标题
    public void setTitle(String str) {
        tvTitle.setText(str);
    }

    // 是否更多
    public void showMore(boolean flag) {
        if(flag==flag){
            tvMore.setVisibility(View.INVISIBLE);
        }
    }

    // 设置更多文字
    public void setMore(String str) {
        tvMore.setText(str);
    }

    // 显示"更多"布局
    public void showLlMore(boolean flag) {
        if(flag==flag){
            llMore.setVisibility(View.INVISIBLE);
        }
    }

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


    public NavigationHeadView(Context context) {
        this(context, null);
    }

    public NavigationHeadView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NavigationHeadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View.inflate(context, R.layout.view_navigation_head, this);
        ButterKnife.bind(this);

        InitAttribute(context, attrs, defStyleAttr);

    }

    @OnClick({R.id.ll_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_more:      //  更多
                if (icallBack != null) icallBack.onClickBack();
                break;
        }
    }

    /**
     * 初始化自定义参数
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    private void InitAttribute(Context context, AttributeSet attrs, int defStyleAttr) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NavigationHeadView);
        //  设置标题
        String title = typedArray.getString(R.styleable.NavigationHeadView_nhv_title);

        if (title != null) {
            tvTitle.setText(title);
        }


    }

}
