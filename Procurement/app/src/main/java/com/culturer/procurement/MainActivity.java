package com.culturer.procurement;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
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

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {
	
	private MyViewPager viewPager;
	private MenuItem menuItem;
	private BottomNavigationView navigation;
	
	private PagerAdapter adapter;
	
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
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			Window window = getWindow();

//设置修改状态栏
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

//设置状态栏的颜色，和你的app主题或者标题栏颜色设置一致就ok了
			window.setStatusBarColor(getColor(R.color.black));
		}
		
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
	
}
