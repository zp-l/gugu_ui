package com.qibei.gugu.model;

import android.graphics.Bitmap;

/**
 * 医生所属产品  item
 */
public class DoctorProductItem {
    private String tv_dpf_hospital;        //    所属医院
    private String tv_dpf_money;   //            产品价格
    private String tv_dpf_describe; //              产品描述
    private Bitmap iv_dpf_product_logo;    //    产品logo


    public DoctorProductItem(String tv_dpf_hospital, String tv_dpf_money, String tv_dpf_describe, Bitmap iv_dpf_product_logo) {
        this.tv_dpf_hospital = tv_dpf_hospital;
        this.tv_dpf_money = tv_dpf_money;
        this.tv_dpf_describe = tv_dpf_describe;
        this.iv_dpf_product_logo = iv_dpf_product_logo;
    }

    public String getTv_dpf_hospital() {
        return tv_dpf_hospital;
    }

    public void setTv_dpf_hospital(String tv_dpf_hospital) {
        this.tv_dpf_hospital = tv_dpf_hospital;
    }

    public String getTv_dpf_money() {
        return tv_dpf_money;
    }

    public void setTv_dpf_money(String tv_dpf_money) {
        this.tv_dpf_money = tv_dpf_money;
    }

    public String getTv_dpf_describe() {
        return tv_dpf_describe;
    }

    public void setTv_dpf_describe(String tv_dpf_describe) {
        this.tv_dpf_describe = tv_dpf_describe;
    }

    public Bitmap getIv_dpf_product_logo() {
        return iv_dpf_product_logo;
    }

    public void setIv_dpf_product_logo(Bitmap iv_dpf_product_logo) {
        this.iv_dpf_product_logo = iv_dpf_product_logo;
    }

    @Override
    public String toString() {
        return "DoctorProductItem{" +
                "tv_dpf_hospital='" + tv_dpf_hospital + '\'' +
                ", tv_dpf_money='" + tv_dpf_money + '\'' +
                ", tv_dpf_describe='" + tv_dpf_describe + '\'' +
                ", iv_dpf_product_logo=" + iv_dpf_product_logo +
                '}';
    }
}
