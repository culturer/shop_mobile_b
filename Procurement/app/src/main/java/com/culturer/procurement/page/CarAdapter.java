package com.culturer.procurement.page;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.culturer.procurement.R;
import com.culturer.procurement.bean.CarBean;
import com.culturer.procurement.bean.ProductBean;
import com.culturer.procurement.event.CarEvent;
import com.culturer.procurement.event.PriceEvent;
import com.culturer.procurement.util.Cache;
import com.culturer.procurement.util.Code;

import org.greenrobot.eventbus.EventBus;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static com.culturer.procurement.util.URL.HOST;

/**
 * Created by Administrator on 2018/5/21 0021.
 */

public class CarAdapter extends BaseAdapter {
	
	private static final String TAG = "CarAdapter" ;
	
	private Context context;
	private View contentView;
	
	private List<CarBean> cars;
	
	public CarAdapter(Context context,List<CarBean> cars) {
		this.cars = cars;
		this.context = context;

	}
	
	@Override
	public int getCount() {
		return cars.size();
	}
	
	@Override
	public CarBean getItem(int position) {
		return cars.get(position);
	}
	
	@Override
	public long getItemId(int position) {
		return position;
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		contentView  = LayoutInflater.from(context).inflate(R.layout.car_item,null);
		
		CheckBox selected = contentView.findViewById(R.id.isSelected);
		TextView product_name = contentView.findViewById(R.id.product_name);
		TextView single_price = contentView.findViewById(R.id.single_price);
		TextView count = contentView.findViewById(R.id.count);
		TextView all_price = contentView.findViewById(R.id.price);
		ImageView icon = contentView.findViewById(R.id.icon);
		
		Log.i(TAG, "getView: car icon    "+HOST+"/"+getItem(position).getProductsBean().getCoverUrl());
		
		Glide.with(context)
				.load(HOST+"/"+getItem(position).getProductsBean().getCoverUrl())
				.into(icon);
		
		try {
			String name = Code.decode(getItem(position).getProductsBean().getName());
			product_name.setText(name);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		single_price.setText("单价:￥"+getItem(position).getProductsBean().getStandardPrice());
		count.setText("数量:"+getItem(position).getProductsBean().getBuyNum());
		all_price.setText(""+getItem(position).getProductsBean().getBuyNum()*getItem(position).getProductsBean().getStandardPrice());
		
		contentView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				final View diaViwe = LayoutInflater.from(context).inflate(R.layout.dialog_count,null);
				builder.setTitle("采购数量")
						.setView(diaViwe)
						.setPositiveButton("确定", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								EditText buyNum = diaViwe.findViewById(R.id.buyNum);
								if (!buyNum.getText().toString().equals("")){
									cars.get(position).getProductsBean().setBuyNum(Integer.parseInt(buyNum.getText().toString()));
									Cache.cars.set(position,cars.get(position));
									EventBus.getDefault().post(new CarEvent());
								}
							}
						});
				builder.create().show();
			}
		});
		
		contentView.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				final View diaViwe = LayoutInflater.from(context).inflate(R.layout.dialog_count,null);
				try {
					builder.setTitle("删除商品:"+Code.decode(cars.get(position).getProductsBean().getName()))
							.setPositiveButton("确定", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog, int which) {
									
									Cache.cars.remove(position);
									EventBus.getDefault().post(new CarEvent());
									Log.i(TAG, "onClick: del has done !");
									
								}
							});
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				builder.create().show();
				return true;
			}
		});
		
		selected.setChecked(getItem(position).isSelected());
		
		selected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Cache.cars.get(position).setSelected(isChecked);
				EventBus.getDefault().post(new PriceEvent());
			}
		});
		
		return contentView;
	}
	
	//更新UI显示
	public void update(List<CarBean> cars){
		this.cars = cars;
		notifyDataSetChanged();
	}
	
}
