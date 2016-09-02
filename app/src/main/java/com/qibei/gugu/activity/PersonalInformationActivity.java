package com.qibei.gugu.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.qibei.gugu.MainActivity;
import com.qibei.gugu.R;
import com.qibei.gugu.ui.CommonTopView;
import com.qibei.gugu.ui.WheelView;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonalInformationActivity extends Activity {
    private static final String TAG = TestActivity.class.getSimpleName();

    @Bind(R.id.tv_pia_next)    //  下一步
            TextView tvPiaNext;
    @Bind(R.id.ctv_pia_perfect_info)
    CommonTopView ctvPiaPerfectInfo;

    private View inflate;
    private TextView choosePhoto;
    private TextView takePhoto;
    private Dialog dialog;

    private static final String[] PLANETS = new String[]{"男", "女"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
        ButterKnife.bind(this);
        initView();

        registerListeners();
    }

    private void initView() {

    }

    //  注册监听事件
    private void registerListeners() {
        //返回监听
        ctvPiaPerfectInfo.setonClick(new CommonTopView.ICoallBack() {
            @Override
            public void onClickBack() {
                finish();
            }

            @Override
            public void onClickSeting() {
            }
        });
    }

    /*
    显示竖直选择器
     */
    public void ShowWheelView() {
        WheelView wv = (WheelView) inflate.findViewById(R.id.main_wv);
        wv.setOffset(1);
        wv.setItems(Arrays.asList(PLANETS));
        wv.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                Log.d(TAG, "selectedIndex: " + selectedIndex + ", item: " + item);
            }
        });
    }

    public void ShowDialog() {
        dialog = new Dialog(this, R.style.ActionSheetDialogStyle);
        //填充对话框的布局
        inflate = LayoutInflater.from(this).inflate(R.layout.wheel_main, null);

        ShowWheelView();

        //将布局设置给Dialog
        dialog.setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = dialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.BOTTOM);
//        //获得窗体的属性
//        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
//        lp.y = 20;//设置Dialog距离底部的距离
////       将属性设置给窗体
//        dialogWindow.setAttributes(lp);

        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = dialogWindow.getAttributes();
        p.width = d.getWidth(); //设置dialog的宽度为当前手机屏幕的宽度
        dialogWindow.setAttributes(p);

        dialog.show();//显示对话框

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @OnClick({R.id.ctv_pia_perfect_info, R.id.tv_pia_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ctv_pia_perfect_info:
                break;
            case R.id.tv_pia_next:
                Intent intent_order_details = new Intent(PersonalInformationActivity.this, MyOrderDetailsActivity.class);
                startActivity(intent_order_details);
                break;
        }
    }
}
