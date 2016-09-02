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
 * 自定义公共头
 */
public class CommonTopView extends LinearLayout {

    @Bind(R.id.iv_back)             //  返回按钮
    ImageView ivBack;
    @Bind(R.id.tv_title)            //  标题
    TextView tvTitle;
    @Bind(R.id.iv_function)         //  功能键
    ImageView ivFunction;
    @Bind(R.id.ll_top)              //  整个顶部 布局
    LinearLayout llTop;
    @Bind(R.id.tv_underline)        //  下划线
    TextView tvUnderline;

    /**
     * 一定一个接口
     */
    public interface ICoallBack {
        public void onClickBack();

        public void onClickSeting();
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

    public CommonTopView(Context context) {
        this(context, null);
    }

    public CommonTopView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommonTopView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View.inflate(context, R.layout.common_top, this);
        ButterKnife.bind(this);

        InitAttribute(context, attrs, defStyleAttr);

    }

    @OnClick({R.id.iv_back, R.id.iv_function})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                if (icallBack != null) icallBack.onClickBack();
                break;
            case R.id.iv_function:
                if (icallBack != null) icallBack.onClickSeting();
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

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CommonTopView);
        //  设置标题
        String title = typedArray.getString(R.styleable.CommonTopView_top_title);
        tvTitle.setText(title);
        //  设置返回按键
        boolean back_type = typedArray.getBoolean(R.styleable.CommonTopView_top_back, true);
        boolean function_type = typedArray.getBoolean(R.styleable.CommonTopView_top_function, true);

        if (back_type) {
            ivBack.setVisibility(View.VISIBLE);
        } else {
            ivBack.setVisibility(View.INVISIBLE);
        }

        //  设置功能图标
        if (function_type) {
            int backgroundId = typedArray.getResourceId(R.styleable.CommonTopView_top_src,-1);
            if (backgroundId != -1) {
                ivFunction.setBackgroundResource(backgroundId);
            } else {
                ivFunction.setImageResource(R.drawable.seting);
            }
            ivFunction.setVisibility(View.VISIBLE);

        } else {
            ivFunction.setVisibility(View.INVISIBLE);
        }
    }

    public void setMyBackground(int num) {
        llTop.getBackground().setAlpha(num);
        //  影长下划线
        tvUnderline.setVisibility(View.INVISIBLE);
    }

    public ImageView getIvBack() {
        return ivBack;
    }

    public ImageView getIvFunction() {
        return ivFunction;
    }

    public void setTvTitle(String title){
        tvTitle.setText(title);
    }
}
