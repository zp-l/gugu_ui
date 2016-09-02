package com.qibei.gugu.model;


public class VoucherItem {
    private String tv_voucher_name;
    private String tv_voucher_hospital;
    private String tv_voucher_time;
    private int tv_voucher_money;

    public VoucherItem(String tv_voucher_name, String tv_voucher_hospital, String tv_voucher_time, int tv_voucher_money) {
        this.tv_voucher_name = tv_voucher_name;
        this.tv_voucher_hospital = tv_voucher_hospital;
        this.tv_voucher_time = tv_voucher_time;
        this.tv_voucher_money = tv_voucher_money;
    }

    public String getTv_voucher_name() {
        return tv_voucher_name;
    }

    public void setTv_voucher_name(String tv_voucher_name) {
        this.tv_voucher_name = tv_voucher_name;
    }

    public String getTv_voucher_hospital() {
        return tv_voucher_hospital;
    }

    public void setTv_voucher_hospital(String tv_voucher_hospital) {
        this.tv_voucher_hospital = tv_voucher_hospital;
    }

    public String getTv_voucher_time() {
        return tv_voucher_time;
    }

    public void setTv_voucher_time(String tv_voucher_time) {
        this.tv_voucher_time = tv_voucher_time;
    }

    public int getTv_voucher_money() {
        return tv_voucher_money;
    }

    public void setTv_voucher_money(int tv_voucher_money) {
        this.tv_voucher_money = tv_voucher_money;
    }

    @Override
    public String toString() {
        return "VoucherItem{" +
                "tv_voucher_name='" + tv_voucher_name + '\'' +
                ", tv_voucher_hospital='" + tv_voucher_hospital + '\'' +
                ", tv_voucher_time='" + tv_voucher_time + '\'' +
                ", tv_voucher_money=" + tv_voucher_money +
                '}';
    }
}
