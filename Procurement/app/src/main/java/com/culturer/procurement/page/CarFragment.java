package com.culturer.procurement.page;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
import com.culturer.procurement.event.PriceEvent;
import com.culturer.procurement.util.Cache;
import com.culturer.procurement.util.Code;
import com.culturer.procurement.util.PreferenceUtil;
import com.culturer.procurement.util.TimeUtil;
import com.google.gson.Gson;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.client.HttpParams;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.culturer.procurement.util.URL.HOST;


public class CarFragment extends Fragment {
	
	private static final String TAG = "CarFragment";
	
	private View contentView;
	private ListView list;
	private CheckBox isCheck;
	private TextView all_price1;
	private TextView submit;
	
	private CarAdapter adapter;
	
	public CarFragment() {
		// Required empty public constructor
	}
	
	public static CarFragment newInstance(String param1, String param2) {
		CarFragment fragment = new CarFragment();
		return fragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EventBus.getDefault().register(this);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		contentView = inflater.inflate(R.layout.fragment_car, container, false);
		list = contentView.findViewById(R.id.list);
		isCheck = contentView.findViewById(R.id.isCheck);
		all_price1 = contentView.findViewById(R.id.all_price1);
		submit = contentView.findViewById(R.id.submit);
		update();
		setAllPrice();
		isCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				for (int i=0;i<Cache.cars.size();i++){
					Cache.cars.get(i).setSelected(isChecked);
				}
				update();
			}
		});
		submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				View contentView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_order,null);
				
				AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
				final AlertDialog dialog = builder.setTitle("提交订单")
						.setView(contentView)
						.create();
				dialog.show();
				
				final EditText receiver = contentView.findViewById(R.id.receiver);
				final EditText phone = contentView.findViewById(R.id.phone);
				final EditText address = contentView.findViewById(R.id.address);
				final EditText msg = contentView.findViewById(R.id.msg);
				Button commit = contentView.findViewById(R.id.commit);
				
				commit.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						submit(phone.getText().toString(),receiver.getText().toString(),address.getText().toString(),msg.getText().toString());
						Log.i(TAG, "commit msg : "+phone.getText().toString()+receiver.getText().toString()+address.getText().toString()+msg.getText().toString());
						dialog.dismiss();
					}
				});
				
				
			}
		});
		return contentView;
	}
	
	private void update(){
		Log.i(TAG, "Cache.cars: "+Cache.cars.size());
		adapter = new CarAdapter(getContext(), Cache.cars);
		list.setAdapter(adapter);
		setAllPrice();
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

		
		List<ProductBean.ProductsBean> productsBeans = new ArrayList<>();
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
		
		OrderBean.ConfirmOrderBean confirmOrderBean = new OrderBean.ConfirmOrderBean();
		confirmOrderBean.setTmpOrder(tmpOrderBean);
		confirmOrderBean.setModProducts(productsBeans);
		orderBean.setConfirmOrder(confirmOrderBean);
		
		Gson gson = new Gson();
		String strProducts = gson.toJson(productsBeans);
		String strOrderParam = gson.toJson(tmpOrderBean);
		
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
				HttpParams params = new HttpParams();
				params.put("act","createOrder");
				params.put("PayType","cashPay");
				params.putHeaders("content-type","application/x-www-form-urlencoded");
				params.putHeaders("Cookie", PreferenceUtil.getString("sessionId",""));
				HttpCallback callback1 = new HttpCallback() {
					@Override
					public void onSuccess(String t) {
						Log.i(TAG, "create order: "+t);
						Toast.makeText(getContext(),"提交订单成功！",Toast.LENGTH_LONG).show();
						EventBus.getDefault().post(new OrderEvent());
					}
				};
				new RxVolley.Builder()
						.url(HOST+"/order")
						.httpMethod(RxVolley.Method.POST) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
						.cacheTime(0) //default: get 5min, post 0min
						.contentType(RxVolley.ContentType.FORM)//default FORM or JSON
						.params(params)
						.shouldCache(false) //default: get true, post false
						.callback(callback1)
						.encoding("UTF-8") //defaultr
						.doTask();
				
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
	
	private void setAllPrice(){
		int all_price = 0;
		boolean change_bg = false;
		for (int i=0;i<Cache.cars.size();i++){
			if (Cache.cars.get(i).isSelected()){
				all_price=all_price+Cache.cars.get(i).getProductsBean().getStandardPrice()*Cache.cars.get(i).getProductsBean().getBuyNum();
				change_bg=true;
			}
		}
		all_price1.setText("￥ "+all_price);
		if (change_bg){
			submit.setBackground(getContext().getDrawable(R.color.red));
			submit.setTextColor(getResources().getColor(R.color.white,null));
			
		}else {
			submit.setBackground(getContext().getDrawable(R.color.grey));
			submit.setTextColor(getResources().getColor(R.color.black,null));
		}
	}
	
	@Subscribe
	public void updateCar(CarEvent event){
		update();
	}
	
	@Subscribe
	public void updatePrice(PriceEvent event){
		setAllPrice();
	}
	
}
