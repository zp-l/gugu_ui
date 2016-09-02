package com.qibei.gugu.model;

import android.graphics.Bitmap;

/**
 * 找医生  医生  item
 */
public class DoctorMassageItem {
    private String tv_doctor_name;
    private String tv_doctor_title;
    private String  tv_doctor_hospital;
    private String  tv_doctor_time;
    private String  tv_doctor_autograph;
    private Bitmap  tv_doctor_logo;

    public DoctorMassageItem(String tv_doctor_name, String tv_doctor_title, String tv_doctor_hospital, String tv_doctor_time, String tv_doctor_autograph, Bitmap tv_doctor_logo) {
        this.tv_doctor_name = tv_doctor_name;
        this.tv_doctor_title = tv_doctor_title;
        this.tv_doctor_hospital = tv_doctor_hospital;
        this.tv_doctor_time = tv_doctor_time;
        this.tv_doctor_autograph = tv_doctor_autograph;
        this.tv_doctor_logo = tv_doctor_logo;
    }

    public String getTv_doctor_name() {
        return tv_doctor_name;
    }

    public void setTv_doctor_name(String tv_doctor_name) {
        this.tv_doctor_name = tv_doctor_name;
    }

    public String getTv_doctor_title() {
        return tv_doctor_title;
    }

    public void setTv_doctor_title(String tv_doctor_title) {
        this.tv_doctor_title = tv_doctor_title;
    }

    public String getTv_doctor_hospital() {
        return tv_doctor_hospital;
    }

    public void setTv_doctor_hospital(String tv_doctor_hospital) {
        this.tv_doctor_hospital = tv_doctor_hospital;
    }

    public String getTv_doctor_time() {
        return tv_doctor_time;
    }

    public void setTv_doctor_time(String tv_doctor_time) {
        this.tv_doctor_time = tv_doctor_time;
    }

    public String getTv_doctor_autograph() {
        return tv_doctor_autograph;
    }

    public void setTv_doctor_autograph(String tv_doctor_autograph) {
        this.tv_doctor_autograph = tv_doctor_autograph;
    }

    public Bitmap getTv_doctor_logo() {
        return tv_doctor_logo;
    }

    public void setTv_doctor_logo(Bitmap tv_doctor_logo) {
        this.tv_doctor_logo = tv_doctor_logo;
    }
}
