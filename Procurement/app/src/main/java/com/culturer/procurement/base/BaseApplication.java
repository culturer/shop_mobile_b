package com.culturer.procurement.base;

import android.app.Application;

import com.culturer.procurement.util.PreferenceUtil;

/**
 * Created by Administrator on 2018/5/19 0019.
 */

public class BaseApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		init();
	}
	
	private void init(){
		//初始化Preference工具
		PreferenceUtil.init(this);
	}
}
