package com.culturer.procurement.util;

import com.culturer.procurement.bean.CarBean;
import com.culturer.procurement.bean.OrderBean;
import com.culturer.procurement.bean.OrderList;
import com.culturer.procurement.bean.ProductBean;
import com.culturer.procurement.bean.TypeBean;
import com.culturer.procurement.bean.UserInfoBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/21 0021.
 */

public class Cache {
	public static List<ProductBean> productBeans = new ArrayList<>();
	public static List<CarBean> cars = new ArrayList<>();
	public static UserInfoBean user = new UserInfoBean();
	public static List<OrderBean> orders = new ArrayList<>();
	public static TypeBean typeBean = new TypeBean();
	public static OrderList orderList = new OrderList();
}
