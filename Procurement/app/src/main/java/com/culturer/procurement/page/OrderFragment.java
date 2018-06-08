package com.culturer.procurement.page;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.culturer.procurement.R;
import com.culturer.procurement.bean.OrderList;
import com.culturer.procurement.event.OrderEvent;
import com.culturer.procurement.util.Cache;
import com.culturer.procurement.util.PreferenceUtil;
import com.google.gson.Gson;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.client.HttpParams;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import static com.culturer.procurement.util.URL.HOST;

public class OrderFragment extends Fragment {
	
	private static final String TAG = "OrderFragment";
	
	private View contentView;
	private ExpandableListView list;
	
	private OrderAdapter adapter;
	
	public OrderFragment() {
		// Required empty public constructor
	}
	
	public static OrderFragment newInstance(String param1, String param2) {
		OrderFragment fragment = new OrderFragment();
		return fragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EventBus.getDefault().register(this);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
	                         ViewGroup container,
	                         Bundle savedInstanceState) {
		contentView = inflater.inflate(R.layout.fragment_order, container, false);
		list = contentView.findViewById(R.id.list);
		init();
		return contentView;
	}
	
	private void init(){
		initData();
	}
	
	private void initData(){
		HttpParams params = new HttpParams();
		params.put("act","getOrderPageByUser");
		params.put("where","");
		params.put("size",10);
		params.put("index",1);
		params.putHeaders("content-type","application/x-www-form-urlencoded");
		params.putHeaders("Cookie", PreferenceUtil.getString("sessionId",""));
		HttpCallback callback = new HttpCallback() {
			@Override
			public void onSuccess(String t) {
				Log.i(TAG, "onSuccess: "+t);
				Gson gson = new Gson();
				Cache.orderList = gson.fromJson(t, OrderList.class);
				adapter = new OrderAdapter(getContext(),Cache.orderList);
				list.setAdapter(adapter);
			}
			
			@Override
			public void onFailure(int errorNo, String strMsg) {
				Log.i(TAG, "onFailure: "+strMsg);
			}
		};
		new RxVolley.Builder()
				.url(HOST+"/order")
				.httpMethod(RxVolley.Method.POST) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
				.cacheTime(0) //default: get 5min, post 0min
				.contentType(RxVolley.ContentType.FORM)//default FORM or JSON
				.params(params)
				.shouldCache(false) //default: get true, post false
				.callback(callback)
				.encoding("UTF-8") //defaultr
				.doTask();
	}
	
	@Subscribe
	public void updateOrder(OrderEvent event){
		Log.i(TAG, "updateOrder: ui changed !");
		initData();
	}
	
}
