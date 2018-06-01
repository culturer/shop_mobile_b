package com.culturer.procurement.page;

import android.app.AlertDialog;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.culturer.procurement.R;
import com.culturer.procurement.bean.CarBean;
import com.culturer.procurement.bean.OrderBean;
import com.culturer.procurement.bean.ProductBean;
import com.culturer.procurement.event.CarEvent;
import com.culturer.procurement.event.OrderEvent;
import com.culturer.procurement.util.Cache;
import com.culturer.procurement.util.Code;
import com.culturer.procurement.util.PreferenceUtil;
import com.culturer.procurement.util.TimeUtil;
import com.culturer.procurement.wedgit.CustomPopWindow;
import com.culturer.procurement.wedgit.PayPopWindow;
import com.google.gson.Gson;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.client.HttpParams;

import org.greenrobot.eventbus.EventBus;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.culturer.procurement.util.URL.HOST;

public class CommitOrderActivity extends AppCompatActivity implements PayPopWindow.Callback {
	
	private static final String TAG = "CommitOrderActivity";
	
	private ListView listView;
	private TextView all_price1;
	private TextView submit;
	
	private View headerView;
	private View order_address;
	private TextView username;
	private TextView tel;
	private TextView address;
	private TextView time;
	private TextView change_time;
	private TextView shop;
	private TextView ticket;
	private EditText msg;
	
	List<ProductBean.ProductsBean> productsBeans;
	private CommitAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_commit_order);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			Window window = getWindow();

//设置修改状态栏
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

//设置状态栏的颜色，和你的app主题或者标题栏颜色设置一致就ok了
			window.setStatusBarColor(getColor(R.color.black));
		}
		init();
	}
	
	private void init(){
		initData();
		initBaseView();
		initHeader();
		setAll_price1();
		initSubmit();
		initList();
	}
	
	private void initData(){
		productsBeans = new ArrayList<>();
		List<CarBean> carBeans = new ArrayList<>();
		for ( CarBean carBean: Cache.cars) {
			if (carBean.isSelected()){
				productsBeans.add(carBean.getProductsBean());
			}else {
				carBeans.add(carBean);
			}
		}
		Cache.cars = carBeans;
		EventBus.getDefault().post(new CarEvent());
	}
	
	private void initBaseView(){
		listView = findViewById(R.id.list);
		all_price1 = findViewById(R.id.all_price1);
		submit = findViewById(R.id.submit);
		
		headerView = LayoutInflater.from(this).inflate(R.layout.activity_commit_order_header,null);
		order_address = headerView.findViewById(R.id.order_address);
		username = headerView.findViewById(R.id.username);
		tel = headerView.findViewById(R.id.tel);
		address = headerView.findViewById(R.id.address);
		time = headerView.findViewById(R.id.time);
		change_time = headerView.findViewById(R.id.change_time);
		shop = headerView.findViewById(R.id.shop);
		ticket = headerView.findViewById(R.id.ticket);
		msg = headerView.findViewById(R.id.msg);
	}
	
	private void initHeader(){
		
		tel.setText(Cache.user.getUser().getTel());
		try {
			Log.i(TAG, "initHeader: username"+Code.decode(Cache.user.getUser().getName()));
			Log.i(TAG, "initHeader: address"+Code.decode(Cache.user.getPartner().getAddress()));
			username.setText(Code.decode(Cache.user.getUser().getName()));
			address.setText(Code.decode(Cache.user.getPartner().getAddress()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		order_address.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				changeAddress();
			}
		});
		
	}
	
	private void changeAddress(){
		View contentView = LayoutInflater.from(this).inflate(R.layout.dialog_order,null);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		final AlertDialog dialog = builder.setTitle("提交订单")
				.setView(contentView)
				.create();
				dialog.show();
		
		final EditText receiver = contentView.findViewById(R.id.receiver);
		final EditText phone = contentView.findViewById(R.id.phone);
		final EditText address1 = contentView.findViewById(R.id.address);
		final EditText msg = contentView.findViewById(R.id.msg);
		Button commit = contentView.findViewById(R.id.commit);
		
		commit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.i(TAG, "commit msg : "+phone.getText().toString()+receiver.getText().toString()+address1.getText().toString()+msg.getText().toString());
				username.setText(receiver.getText().toString());
				tel.setText(phone.getText().toString());
				address.setText(address1.getText().toString());
				dialog.dismiss();
			}
		});
		
	}
	
	private void initList(){
		listView.addHeaderView(headerView);
		adapter = new CommitAdapter(this,productsBeans);
		listView.setAdapter(adapter);
	}
	
	private void initSubmit(){
		submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				submit(tel.getText().toString(),username.getText().toString(),address.getText().toString(),msg.getText().toString());
			}
		});
	}
	
	private void submit(String phone,String receiver,String address,String remark){
		
		OrderBean orderBean = new OrderBean();
		orderBean.setStatus(100);
		orderBean.setTime(TimeUtil.getCurrentTime());
		
		OrderBean.ConfirmOrderBean.TmpOrderBean tmpOrderBean = new OrderBean.ConfirmOrderBean.TmpOrderBean();
		tmpOrderBean.setCreateTime(TimeUtil.getCurrentTime());
		tmpOrderBean.setOrderNum("U"+Cache.user.getUser().getId()+"T"+System.currentTimeMillis());
		tmpOrderBean.setUserId(Cache.user.getUser().getId());
		tmpOrderBean.setPhone(phone);
		try {
			tmpOrderBean.setRemark(Code.encode(remark));
			tmpOrderBean.setReceiver(Code.encode(receiver));
			tmpOrderBean.setAddress(Code.encode(address));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		OrderBean.ConfirmOrderBean confirmOrderBean = new OrderBean.ConfirmOrderBean();
		confirmOrderBean.setTmpOrder(tmpOrderBean);
		confirmOrderBean.setModProducts(productsBeans);
		orderBean.setConfirmOrder(confirmOrderBean);
		
		Gson gson = new Gson();
		String strProducts = gson.toJson(productsBeans);
		String strOrderParam = gson.toJson(tmpOrderBean);
		conformOrder(strProducts,strOrderParam);
		
	}
	
	private void setAll_price1(){
		float all_price = 0;
		for (int i=0;i<productsBeans.size();i++){
			all_price += productsBeans.get(i).getStandardPrice()*productsBeans.get(i).getBuyNum();
		}
		all_price1.setText("￥ "+all_price);
	}
	
	private void conformOrder(String strProducts,String strOrderParam){
		HttpParams params = new HttpParams();
		params.put("act","confirmOrder");
		params.put("orderType",1);
		params.put("products",strProducts);
		params.put("orderParam",strOrderParam);
		params.putHeaders("content-type","application/x-www-form-urlencoded");
		params.putHeaders("Cookie", PreferenceUtil.getString("sessionId",""));
		HttpCallback callback = new HttpCallback() {
			@Override
			public void onSuccess(String t) {
				Log.i(TAG, "create order: "+t);
				PayPopWindow payPopWindow = new PayPopWindow(CommitOrderActivity.this,CommitOrderActivity.this);
				payPopWindow.showAtLocation(submit, Gravity.BOTTOM,0,0);
			}
			
			@Override
			public void onFailure(int errorNo, String strMsg) {
				Log.i(TAG, "提交订单失败: "+strMsg);
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
	
	@Override
	public void callback() {
		this.finish();
	}
}
