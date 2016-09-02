package com.qibei.gugu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * TabFragment 页面适配器
 */
public class MyCouponFragmentAdapter extends FragmentPagerAdapter {

	private List<Fragment> list  = new ArrayList<Fragment>();
	public MyCouponFragmentAdapter(FragmentManager fm, List<Fragment> list) {
		super(fm);
		this.list = list;
	}

	@Override
	public Fragment getItem(int position) {
		Fragment fragment = list.get(position);
		return fragment;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// super.destroyItem(container, position, object);
	}
}
