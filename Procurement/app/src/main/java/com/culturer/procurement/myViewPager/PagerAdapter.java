package com.culturer.procurement.myViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/9 0009.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
	
	private final List<Fragment> mFragmentList = new ArrayList<>();
	private FragmentManager manager;
	
	
	public PagerAdapter(FragmentManager manager) {
		super(manager);
		this.manager=manager;
	}
	
	@Override
	public Fragment getItem(int position) {
		return mFragmentList.get(position);
	}
	
	@Override
	public int getCount() {
		return mFragmentList.size();
	}
	
	public void addFragment(Fragment fragment) {
		mFragmentList.add(fragment);
	}

}
