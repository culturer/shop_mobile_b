package com.culturer.procurement.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.culturer.procurement.R;
import com.culturer.procurement.bean.OrderList;
import com.culturer.procurement.util.Code;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2018/5/21 0021.
 */

public class OrderAdapter extends BaseExpandableListAdapter {
	
	private Context context;
	private OrderList orderList;
	
	public OrderAdapter(Context context,OrderList orderList) {
		this.context = context;
		this.orderList = orderList;
	}
	
	@Override
	public int getGroupCount() {
		return orderList.getCount();
	}
	
	@Override
	public int getChildrenCount(int groupPosition) {
		return orderList.getDataList().get(groupPosition).getItemCount();
	}
	
	@Override
	public OrderList.DataListBean getGroup(int groupPosition) {
		return  orderList.getDataList().get(groupPosition);
	}
	
	@Override
	public OrderList.DataListBean.OrderItemsBean getChild(int groupPosition, int childPosition) {
		return orderList.getDataList().get(groupPosition).getOrderItems().get(childPosition);
	}
	
	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}
	
	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return orderList.getDataList().get(groupPosition).getOrderItems().get(childPosition).getId();
	}
	
	@Override
	public boolean hasStableIds() {
		return true;
	}
	
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		View gruopView = LayoutInflater.from(context).inflate(R.layout.order_group_item,null);
		TextView order_time = gruopView.findViewById(R.id.order_time);
		TextView group_id = gruopView.findViewById(R.id.group_id);
		TextView all_price = gruopView.findViewById(R.id.all_price);
		
		OrderList.DataListBean dataListBean =  getGroup(groupPosition);
		
		order_time.setText(dataListBean.getOrderInfo().getCreateTime());
		group_id.setText("订单编号:"+dataListBean.getOrderInfo().getOrderNum());
		all_price.setText("金额:￥ "+dataListBean.getOrderInfo().getShouldPrice());
		
		return gruopView;
	}
	
	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		View childView = LayoutInflater.from(context).inflate(R.layout.order_item,null);
		TextView name = childView.findViewById(R.id.name);
		TextView count = childView.findViewById(R.id.count);
		TextView price = childView.findViewById(R.id.price);
		
		OrderList.DataListBean.OrderItemsBean orderItemsBean =  getChild(groupPosition,childPosition);
		try {
			String strName = Code.decode(orderItemsBean.getName());
			name.setText(strName);
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		count.setText("数量: "+orderItemsBean.getSumNum());
		price.setText("￥ "+orderItemsBean.getSumPrice());
		
		return childView;
	}
	
	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}
}
