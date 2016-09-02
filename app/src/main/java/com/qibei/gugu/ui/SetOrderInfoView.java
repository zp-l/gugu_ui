package com.qibei.gugu.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qibei.gugu.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetOrderInfoView extends LinearLayout {

    @Bind(R.id.tv_soiv_left_title)
    TextView tvSoivLeftTitle;
    @Bind(R.id.tv_soiv_right_title)
    EditText tvSoivRightTitle;
    @Bind(R.id.iv_soiv_next)
    ImageView ivSoivNext;

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

    @OnClick({R.id.iv_soiv_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_soiv_next:
                if (ivSoivNext != null) icallBack.onClickBack();
                break;
        }
    }

    //////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    public SetOrderInfoView(Context context) {
        this(context, null);
    }

    public SetOrderInfoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SetOrderInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View.inflate(context, R.layout.item_navigation, this);
        ButterKnife.bind(this);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SetOrderInfoView);

        boolean type = typedArray.getBoolean(R.styleable.SetOrderInfoView_image_show, true);
        if (type == false) {
            ivSoivNext.setVisibility(View.GONE);
        }
        ;
        tvSoivLeftTitle.setText(typedArray.getString(R.styleable.SetOrderInfoView_left_title));
        tvSoivRightTitle.setText(typedArray.getString(R.styleable.SetOrderInfoView_right_title));

        int textColor = typedArray.getColor(R.styleable.SetOrderInfoView_text_color, 0xFFFFFF);
        tvSoivLeftTitle.setTextColor(textColor);
        tvSoivRightTitle.setTextColor(textColor);

        boolean right_title_show = typedArray.getBoolean(R.styleable.SetOrderInfoView_right_title_show, true);
        if (right_title_show == false) {
            tvSoivRightTitle.setVisibility(View.GONE);
        }
    }


}
