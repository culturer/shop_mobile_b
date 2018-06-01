package com.culturer.procurement;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.culturer.procurement.myViewPager.BottomNavigationViewHelper;
import com.culturer.procurement.myViewPager.MyViewPager;
import com.culturer.procurement.myViewPager.PagerAdapter;
import com.culturer.procurement.page.CarFragment;
import com.culturer.procurement.page.MainFragment;
import com.culturer.procurement.page.OrderFragment;
import com.culturer.procurement.util.PreferenceUtil;
import com.kymjs.okhttp3.OkHttpStack;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.http.RequestQueue;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {
	
	private MyViewPager viewPager;
	private MenuItem menuItem;
	private BottomNavigationView navigation;
	
	private PagerAdapter adapter;
	
	//Android6.0以上动态权限
	//定位需要的权限
	protected String[] needPermissions = {
			Manifest.permission.ACCESS_COARSE_LOCATION,
			Manifest.permission.ACCESS_FINE_LOCATION,
			Manifest.permission.WRITE_EXTERNAL_STORAGE,
			Manifest.permission.READ_EXTERNAL_STORAGE,
			Manifest.permission.READ_PHONE_STATE,
	};
	private static final int PERMISSON_REQUESTCODE = 0;
	
	private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
			= new BottomNavigationView.OnNavigationItemSelectedListener() {
		
		@Override
		public boolean onNavigationItemSelected(@NonNull MenuItem item) {
			switch (item.getItemId()) {
				case R.id.navigation_home:
					viewPager.setCurrentItem(0);
					return true;
				case R.id.navigation_dashboard:
					viewPager.setCurrentItem(1);
					return true;
				case R.id.navigation_notifications:
					viewPager.setCurrentItem(2);
					return true;
			}
			return false;
		}
	};
	
	ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
		@Override
		public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
		
		}
		
		@Override
		public void onPageSelected(int position) {
			if (menuItem != null) {
				menuItem.setChecked(false);
			} else {
				navigation.getMenu().getItem(0).setChecked(false);
			}
			menuItem = navigation.getMenu().getItem(position);
			menuItem.setChecked(true);
		}
		
		@Override
		public void onPageScrollStateChanged(int state) {
		
		}
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Window window = getWindow();
		//设置修改状态栏
		window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
		//设置状态栏的颜色，和你的app主题或者标题栏颜色设置一致就ok了
		window.setStatusBarColor(getColor(R.color.black));
		checkPermissions(needPermissions);
		
		setContentView(R.layout.activity_main);
		//使用okhttp代替httpurlconnection
		RxVolley.setRequestQueue(RequestQueue.newRequestQueue(RxVolley.CACHE_FOLDER, new OkHttpStack(new OkHttpClient())));
		initView();
	}
	
	void initView() {
		navigation = findViewById(R.id.navigation);
		//默认 >3 的选中效果会影响ViewPager的滑动切换时的效果，故利用反射去掉
		BottomNavigationViewHelper.disableShiftMode(navigation);
		navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
		viewPager = findViewById(R.id.viewpager);
		viewPager.addOnPageChangeListener(pageChangeListener);
		setupViewPager(viewPager);
	}
	
	public void setupViewPager(MyViewPager viewPager) {
		adapter = new PagerAdapter(getSupportFragmentManager());
		adapter.addFragment(MainFragment.newInstance("",""));
		adapter.addFragment(CarFragment.newInstance("",""));
		adapter.addFragment(OrderFragment.newInstance("",""));
		viewPager.setOffscreenPageLimit(3);
		viewPager.setAdapter(adapter);
	}
	
	/**
	 * 检查定位权限
	 *
	 * @param needPermissions
	 */
	private void checkPermissions(String[] needPermissions) {
		List<String> needRequestPermissionList = findDeniedPermission(needPermissions);
		if (needRequestPermissionList != null && needRequestPermissionList.size() > 0) {
			ActivityCompat.requestPermissions(this,
					needRequestPermissionList.toArray(new String[needRequestPermissionList.size()]),
					PERMISSON_REQUESTCODE);
		}
	}
	
	/**
	 * 获取集中需要申请权限的列表
	 *
	 * @param needPermissions
	 * @return
	 */
	private List<String> findDeniedPermission(String[] needPermissions) {
		List<String> needRequestPermissionList = new ArrayList<String>();
		for (String permisson : needPermissions) {
			if (ContextCompat.checkSelfPermission(this, permisson) != PackageManager.PERMISSION_GRANTED
					|| ActivityCompat.shouldShowRequestPermissionRationale(this, permisson)) {
				needRequestPermissionList.add(permisson);
			}
		}
		return needRequestPermissionList;
	}
	
}
