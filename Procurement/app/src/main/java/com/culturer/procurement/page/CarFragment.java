package com.culturer.procurement.page;

import android.app.AlertDialog;
import android.content.Intent;
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
	
	boolean change_bg;
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
				
				//跳转到提交订单页面
				Intent intent = new Intent(getContext(),CommitOrderActivity.class);
				startActivity(intent);
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
	
	
	private void setAllPrice(){
		float all_price = 0;
		change_bg = false;
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
			submit.setEnabled(true);
		}else {
			submit.setBackground(getContext().getDrawable(R.color.grey));
			submit.setTextColor(getResources().getColor(R.color.black,null));
			submit.setEnabled(false);
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
