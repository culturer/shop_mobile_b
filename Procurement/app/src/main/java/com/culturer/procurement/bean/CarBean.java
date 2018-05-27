package com.culturer.procurement.bean;

/**
 * Created by Administrator on 2018/5/23 0023.
 */

public class CarBean {
	private boolean isSelected;
	private ProductBean.ProductsBean productsBean;
	
	public CarBean(boolean isSelected, ProductBean.ProductsBean productsBean) {
		
		this.isSelected = isSelected;
		this.productsBean = productsBean;
	}
	
	public boolean isSelected() {
		return isSelected;
	}
	
	public void setSelected(boolean selected) {
		isSelected = selected;
	}
	
	public ProductBean.ProductsBean getProductsBean() {
		return productsBean;
	}
	
	public void setProductsBean(ProductBean.ProductsBean productsBean) {
		this.productsBean = productsBean;
	}
	
	@Override
	public String toString() {
		return "CarBean{" +
				"isSelected=" + isSelected +
				", productsBean=" + productsBean +
				'}';
	}
}
