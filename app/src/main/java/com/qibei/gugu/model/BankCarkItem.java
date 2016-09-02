package com.qibei.gugu.model;

import android.graphics.Bitmap;

public class BankCarkItem {
	private String tv_bank_name;        //    银行名
	private String tv_bankcard_type;   //    银行卡类型
	private String tv_bankcard_num; //       银行卡号
	private Bitmap iv_bank_logo;    //    	 银行logo


	public BankCarkItem(String tv_bank_name, String tv_bankcard_type, String tv_bankcard_num, Bitmap iv_bank_logo) {
		this.tv_bank_name = tv_bank_name;
		this.tv_bankcard_type = tv_bankcard_type;
		this.tv_bankcard_num = tv_bankcard_num;
		this.iv_bank_logo = iv_bank_logo;
	}

	public String getTv_bank_name() {
		return tv_bank_name;
	}

	public void setTv_bank_name(String tv_bank_name) {
		this.tv_bank_name = tv_bank_name;
	}

	public String getTv_bankcard_type() {
		return tv_bankcard_type;
	}

	public void setTv_bankcard_type(String tv_bankcard_type) {
		this.tv_bankcard_type = tv_bankcard_type;
	}

	public String getTv_bankcard_num() {
		return tv_bankcard_num;
	}

	public void setTv_bankcard_num(String tv_bankcard_num) {
		this.tv_bankcard_num = tv_bankcard_num;
	}

	public Bitmap getIv_bank_logo() {
		return iv_bank_logo;
	}

	public void setIv_bank_logo(Bitmap iv_bank_logo) {
		this.iv_bank_logo = iv_bank_logo;
	}

	@Override
	public String toString() {
		return "BankCarkItem{" +
				"tv_bank_name='" + tv_bank_name + '\'' +
				", tv_bankcard_type='" + tv_bankcard_type + '\'' +
				", tv_bankcard_num='" + tv_bankcard_num + '\'' +
				", iv_bank_logo=" + iv_bank_logo +
				'}';
	}
}
