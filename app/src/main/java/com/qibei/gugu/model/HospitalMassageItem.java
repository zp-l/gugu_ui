package com.qibei.gugu.model;

import android.graphics.Bitmap;

/**
 * 找医院   医院  item
 */
public class HospitalMassageItem {
    private String tv_hospital_name;        //  医院名字
    private String tv_hospital_address;     //  医院地址
    private String tv_hospital_expertise;   //  医院专长
    private Bitmap iv_hospital_logo;        //  医院logo

    public HospitalMassageItem(String iv_hospital_name, String tv_hospital_address, String tv_hospital_expertise, Bitmap iv_hospital_logo) {
        this.tv_hospital_name = iv_hospital_name;
        this.tv_hospital_address = tv_hospital_address;
        this.tv_hospital_expertise = tv_hospital_expertise;
        this.iv_hospital_logo = iv_hospital_logo;
    }

    public String getIv_hospital_name() {
        return tv_hospital_name;
    }

    public void setIv_hospital_name(String iv_hospital_name) {
        this.tv_hospital_name = iv_hospital_name;
    }

    public String getTv_hospital_address() {
        return tv_hospital_address;
    }

    public void setTv_hospital_address(String tv_hospital_address) {
        this.tv_hospital_address = tv_hospital_address;
    }

    public String getTv_hospital_expertise() {
        return tv_hospital_expertise;
    }

    public void setTv_hospital_expertise(String tv_hospital_expertise) {
        this.tv_hospital_expertise = tv_hospital_expertise;
    }

    public Bitmap getIv_hospital_logo() {
        return iv_hospital_logo;
    }

    public void setIv_hospital_logo(Bitmap iv_hospital_logo) {
        this.iv_hospital_logo = iv_hospital_logo;
    }

    @Override
    public String toString() {
        return "HospitalMassageItem{" +
                "tv_hospital_name='" + tv_hospital_name + '\'' +
                ", tv_hospital_address='" + tv_hospital_address + '\'' +
                ", tv_hospital_expertise='" + tv_hospital_expertise + '\'' +
                ", iv_hospital_logo='" + iv_hospital_logo + '\'' +
                '}';
    }
}
