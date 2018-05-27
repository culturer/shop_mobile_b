package com.culturer.procurement.page;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.culturer.procurement.R;
import com.culturer.procurement.bean.ProductBean;
import com.culturer.procurement.bean.TypeBean;
import com.culturer.procurement.util.Cache;
import com.google.gson.Gson;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.client.HttpParams;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.culturer.procurement.util.URL.HOST;

public class MainFragment extends Fragment {
	
	private static final String TAG = "MainFragment";
	
	private View contentView;
	private ExpandableListView list;
	
	private MainAdapter adapter;
	
	private TypeBean typeBean;
	
	private List<TypeBean.ProductTypesBean> types = new ArrayList<>();
	private  List<ProductBean> products = new ArrayList<>();
	
	public MainFragment() {
		// Required empty public constructor
	}
	
	public static MainFragment newInstance(String param1, String param2) {
		MainFragment fragment = new MainFragment();
		return fragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		contentView = inflater.inflate(R.layout.fragment_main, container, false);
		list = contentView.findViewById(R.id.list);
		init();
		return contentView;
	}
	
	private void init(){
		initData();
		initView();
	}

	private void initData(){
		HttpParams params = new HttpParams();
		params.put("types",0);
		params.put("options",0);
		
		HttpCallback callback = new HttpCallback() {
			@Override
			public void onSuccess(String t) {
				Log.i(TAG, "onSuccess: "+t);
				final Gson gson = new Gson();
				typeBean = gson.fromJson(t,TypeBean.class);
				Cache.typeBean = typeBean;
				if (typeBean!=null){
					if (typeBean.getProductTypes()!=null){
						
						if (typeBean!=null){
							for (int i=0;i<typeBean.getProductTypes().size();i++){
								if (typeBean.getProductTypes().get(i)!=null){
									types.add(typeBean.getProductTypes().get(i));
									Log.i(TAG, "initData: addType"+typeBean.getProductTypes().get(i).getTypeName());
								}
							}
						}
						
						for (int i=0;i<typeBean.getProductTypes().size();i++){
							Log.i(TAG, "get Product: "+typeBean.getProductTypes().get(i).getId());
							HttpParams params = new HttpParams();
							params.put("types",1);
							params.put("options",0);
							params.put("getType",0);
							params.put("pageNo",0);
							params.put("pageSize",0);
							params.put("productTypeId",typeBean.getProductTypes().get(i).getId());
							
							final int finalI = i;
							HttpCallback callback1 = new HttpCallback() {
								@Override
								public void onSuccess(String t) {
									Log.i(TAG, "onSuccess: get Id "+typeBean.getProductTypes().get(finalI).getId());
									Log.i(TAG, "onSuccess: "+t);
									ProductBean productBean = gson.fromJson(t,ProductBean.class);
									Cache.productBeans.add(productBean);
									products.add(productBean);
									updateView();
								}
								
								@Override
								public void onFailure(int errorNo, String strMsg) {
									Log.i(TAG, "onFailure: "+strMsg);
								}
							};
							
							new RxVolley.Builder()
									.url(HOST+"/products")
									.httpMethod(RxVolley.Method.POST) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
									.cacheTime(0) //default: get 5min, post 0min
									.contentType(RxVolley.ContentType.FORM)//default FORM or JSON
									.params(params)
									.shouldCache(false) //default: get true, post false
									.callback(callback1)
									.encoding("UTF-8") //defaultr
									.doTask();
						}
					}
				}
			}
			
			@Override
			public void onFailure(int errorNo, String strMsg) {
				Log.i(TAG, "onFailure: "+strMsg);
			}
		};
		new RxVolley.Builder()
				.url(HOST+"/products")
				.httpMethod(RxVolley.Method.POST) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
				.cacheTime(0) //default: get 5min, post 0min
				.contentType(RxVolley.ContentType.FORM)//default FORM or JSON
				.params(params)
				.shouldCache(false) //default: get true, post false
				.callback(callback)
				.encoding("UTF-8") //defaultr
				.doTask();
		
	}
	
	private void updateView(){
		if (adapter == null){
			adapter = new MainAdapter(types,products,getContext());
		}
		adapter.update(types,products);
		list.setAdapter(adapter);
	}
	
	private void initView(){
		list = contentView.findViewById(R.id.list);
		list.setAdapter(adapter);
	}
}
