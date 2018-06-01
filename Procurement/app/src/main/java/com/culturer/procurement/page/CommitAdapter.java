package com.culturer.procurement.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.culturer.procurement.R;
import com.culturer.procurement.bean.ProductBean;
import com.culturer.procurement.util.Code;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Administrator on 2018/5/31 0031.
 */

public class CommitAdapter extends BaseAdapter{
	
	private Context context;
	private List<ProductBean.ProductsBean> productsBeans;
	
	public CommitAdapter( Context context,List<ProductBean.ProductsBean> productsBeans) {
		this.productsBeans = productsBeans;
		this.context = context;
	}
	
	@Override
	public int getCount() {
		if (productsBeans!=null){
			return productsBeans.size();
		}
		return 0;
	}
	
	@Override
	public ProductBean.ProductsBean getItem(int position) {
		return productsBeans.get(position);
	}
	
	@Override
	public long getItemId(int position) {
		return position;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View contentView = LayoutInflater.from(context).inflate(R.layout.order_item,null);
		TextView name = contentView.findViewById(R.id.name);
		TextView count = contentView.findViewById(R.id.count);
		TextView price = contentView.findViewById(R.id.price);
		
		try {
			name.setText(Code.decode(getItem(position).getName()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		count.setText("数量: "+getItem(position).getBuyNum());
		price.setText("￥ "+getItem(position).getStandardPrice());
		return contentView;
	}
}
