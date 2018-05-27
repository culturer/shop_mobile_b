package com.culturer.procurement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.client.HttpParams;

public class TestActivity extends AppCompatActivity {
	
	private static final String TAG = "TestActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		
		HttpParams params = new HttpParams();
		params.put("types",0);
		params.put("options",0);
//		params.put("pageNo",0);
//		params.put("pageSize",10);
		
		HttpCallback callback = new HttpCallback() {
			@Override
			public void onSuccess(String t) {
				Log.i(TAG, "onSuccess: "+t);
			}
			
			@Override
			public void onFailure(int errorNo, String strMsg) {
				Log.i(TAG, "onFailure: "+strMsg);
			}
		};
		new RxVolley.Builder()
				.url("http://192.168.43.146:8080/products")
				.httpMethod(RxVolley.Method.POST) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
				.cacheTime(0) //default: get 5min, post 0min
				.contentType(RxVolley.ContentType.FORM)//default FORM or JSON
				.params(params)
				.shouldCache(false) //default: get true, post false
				.callback(callback)
				.encoding("UTF-8") //defaultr
				.doTask();
	}
}
