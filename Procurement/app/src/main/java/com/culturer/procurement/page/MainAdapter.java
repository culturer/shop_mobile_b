package com.culturer.procurement.page;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.culturer.procurement.R;
import com.culturer.procurement.bean.CarBean;
import com.culturer.procurement.bean.ProductBean;
import com.culturer.procurement.bean.TypeBean;
import com.culturer.procurement.event.CarEvent;
import com.culturer.procurement.util.Cache;
import com.culturer.procurement.util.Code;

import org.greenrobot.eventbus.EventBus;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.culturer.procurement.util.URL.HOST;

public class MainAdapter extends BaseExpandableListAdapter {
	
	private static final String TAG = "MainAdapter";
	
	private List<TypeBean.ProductTypesBean> types = new ArrayList<>();
	private  List<ProductBean> products = new ArrayList<>();
	
	
	Context context;
	
	int groupLayout = R.layout.main_group_item;
	int friendLayout =  R.layout.main_item;
	
	public MainAdapter(List<TypeBean.ProductTypesBean> types, List<ProductBean> products, Context context) {
		this.types = types;
		this.products = products;
		this.context = context;
	}
	
	@Override
	public int getGroupCount() {
		return types.size();
	}
	
	@Override
	public int getChildrenCount(int i) {
		return products.get(i).getProducts().size();
	}
	
	@Override
	public Object getGroup(int i) {
		return types.get(i);
	}
	
	@Override
	public ProductBean.ProductsBean getChild(int i, int i1) {
		for (int i2 = 0;i2<types.size();i2++){
			try {
				Log.i(TAG, "getChild: type_name --- "+Code.decode(types.get(i2).getTypeName()));
				Log.i(TAG, "getChild: "+products.size());
				Log.i(TAG, "getChild: "+	products.get(i2).getProducts().size());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		int typeId = types.get(i).getId();

		if (products.size()>0){
			for (int j = 0;j<products.size();j++){
				
				if (products.get(j).getProducts().size()>0 && typeId == products.get(j).getProducts().get(0).getProductTypeId()){
					if (i1<products.get(j).getProducts().size()){
						return products.get(j).getProducts().get(i1);
					}
				}
			
			}
		}
		return null;
	}
	
	@Override
	public long getGroupId(int i) {
		return i;
	}
	
	@Override
	public long getChildId(int i, int i1) {
		return 1000*i+i1;
	}
	
	@Override
	public boolean hasStableIds() {
		return false;
	}
	
	@Override
	public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
		View view1;
		if (view == null){
			view1 = LayoutInflater.from(context).inflate(groupLayout,null);
		}else {
			view1 = view;
		}
		TextView friend_group = view1.findViewById(R.id.friend_group);
		try {
			String type_name = Code.decode(types.get(i).getTypeName());
			friend_group.setText(type_name);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return view1;
	}
	
	@Override
	public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
		View view1 = LayoutInflater.from(context).inflate(friendLayout,null);
		ImageView product_icon =  view1.findViewById(R.id.product_icon);
		TextView product_name = view1.findViewById(R.id.product_name);
		TextView product_msg = view1.findViewById(R.id.product_msg);
		TextView product_price = view1.findViewById(R.id.product_price);
		Button buy = view1.findViewById(R.id.buy);
		
		final ProductBean.ProductsBean productBean = getChild(i,i1);
		if (productBean!=null){
			Log.i(TAG, "getChildView: "+productBean.toString());
			Glide.with(context)
					.load(HOST+"/"+productBean.getCoverUrl())
					.into(product_icon);
			
			try {
				String name = Code.decode(productBean.getName());
				product_name.setText(name);
				String desc = Code.decode(productBean.getMsg());
				product_msg.setText(desc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			product_price.setText("￥ "+productBean.getStandardPrice());
			buy.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Log.i(TAG, "onClick: click!!!");
					//添加购物车
					boolean isExit = false;
					if (Cache.cars!=null && Cache.cars.size()>0){
						for (int j = 0;j<Cache.cars.size();j++){
							if (Cache.cars.get(j).getProductsBean().getId() == productBean.getId()){
								Cache.cars.get(j).getProductsBean().setBuyNum(Cache.cars.get(j).getProductsBean().getBuyNum()+1);
								Log.i(TAG, "isExit cars add BuyNum: "+Cache.cars.get(j).getProductsBean().getBuyNum());
								Log.i(TAG, "add to cars : "+Cache.cars.size());
								Log.i(TAG, "Icon: "+Cache.cars.get(j).getProductsBean().getCoverUrl());
								isExit = true;
								break;
							}
						}
						if (!isExit){
							productBean.setBuyNum(1);
							Cache.cars.add(new CarBean(false,productBean));
							Log.i(TAG, "not isExit add to cars : "+productBean.toString());
							Log.i(TAG, "add to cars : "+Cache.cars.size());
							Log.i(TAG, "Icon: "+productBean.getCoverUrl());
						}
					}else {
						productBean.setBuyNum(1);
						Cache.cars.add(new CarBean(false,productBean));
						Log.i(TAG, "not isExit add to cars : "+productBean.toString());
						Log.i(TAG, "add to cars : "+Cache.cars.size());
						Log.i(TAG, "Icon: "+productBean.getCoverUrl());
						
					}
					EventBus.getDefault().post(new CarEvent());
					Toast.makeText(context,"商品已添加到购物车",Toast.LENGTH_LONG).show();
				}
			});
		}
		return view1;
	}
	
	@Override
	public boolean isChildSelectable(int i, int i1) {
		return true;
	}
	
	//更新数据源和UI显示
	public void update(List<TypeBean.ProductTypesBean> types,  List<ProductBean> products){
		this.products = products;
		this.types = types;
		this.notifyDataSetChanged();
	}
	
}
