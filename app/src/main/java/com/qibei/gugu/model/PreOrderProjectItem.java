package com.qibei.gugu.model;


import android.graphics.Bitmap;

public class PreOrderProjectItem {
    private String  tv_pre_order_1;
    private String  tv_pre_order_2;
    private String  tv_pre_order_3;
    private Bitmap  tv_pre_order_logo;

    public PreOrderProjectItem(String tv_pre_order_1, String tv_pre_order_2, String tv_pre_order_3, Bitmap tv_pre_order_logo) {
        this.tv_pre_order_1 = tv_pre_order_1;
        this.tv_pre_order_2 = tv_pre_order_2;
        this.tv_pre_order_3 = tv_pre_order_3;
        this.tv_pre_order_logo = tv_pre_order_logo;
    }

    public String getTv_pre_order_1() {
        return tv_pre_order_1;
    }

    public void setTv_pre_order_1(String tv_pre_order_1) {
        this.tv_pre_order_1 = tv_pre_order_1;
    }

    public String getTv_pre_order_2() {
        return tv_pre_order_2;
    }

    public void setTv_pre_order_2(String tv_pre_order_2) {
        this.tv_pre_order_2 = tv_pre_order_2;
    }

    public String getTv_pre_order_3() {
        return tv_pre_order_3;
    }

    public void setTv_pre_order_3(String tv_pre_order_3) {
        this.tv_pre_order_3 = tv_pre_order_3;
    }

    public Bitmap getTv_pre_order_logo() {
        return tv_pre_order_logo;
    }

    public void setTv_pre_order_logo(Bitmap tv_pre_order_logo) {
        this.tv_pre_order_logo = tv_pre_order_logo;
    }

    @Override
    public String toString() {
        return "PreOrderProjectItem{" +
                "tv_pre_order_1='" + tv_pre_order_1 + '\'' +
                ", tv_pre_order_2='" + tv_pre_order_2 + '\'' +
                ", tv_pre_order_3='" + tv_pre_order_3 + '\'' +
                ", tv_pre_order_logo=" + tv_pre_order_logo +
                '}';
    }
}
