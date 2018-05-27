package com.culturer.procurement.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/20 0020.
 */

public class ProductBean {
	
	/**
	 * products : [{"Id":7,"SortId":0,"UserId":0,"ProductTypeId":4,"PartnerId":0,"Name":"a啊手动阀手动阀我v额","Count":100,"Price":10,"StandardPrice":8,"Desc":"发货iOS的风格v阿婆士大夫","Msg":"发货iOS的风格v阿婆士大夫","CreateTime":"2018-04-25 22:06:20","CoverUrl":"","BuyNum":0,"SumPrice":0,"IsCarousel":0,"IsHot":0},{"Id":8,"SortId":0,"UserId":0,"ProductTypeId":4,"PartnerId":0,"Name":"艾尔法撒旦v个WQFAEKBV","Count":100,"Price":10,"StandardPrice":8,"Desc":"发货iOS的风格v阿婆士大夫","Msg":"发货iOS的风格v阿婆士大夫","CreateTime":"2018-04-25 22:06:20","CoverUrl":"","BuyNum":0,"SumPrice":0,"IsCarousel":0,"IsHot":0}]
	 * status : 200
	 * time : 2018-05-20 19:26:54
	 * totalPage : 2
	 */
	
	private int status;
	private String time;
	private int totalPage;
	private List<ProductsBean> products;
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public List<ProductsBean> getProducts() {
		return products;
	}
	
	public void setProducts(List<ProductsBean> products) {
		this.products = products;
	}
	
	public static class ProductsBean {
		/**
		 * Id : 7
		 * SortId : 0
		 * UserId : 0
		 * ProductTypeId : 4
		 * PartnerId : 0
		 * Name : a啊手动阀手动阀我v额
		 * Count : 100
		 * Price : 10
		 * StandardPrice : 8
		 * Desc : 发货iOS的风格v阿婆士大夫
		 * Msg : 发货iOS的风格v阿婆士大夫
		 * CreateTime : 2018-04-25 22:06:20
		 * CoverUrl :
		 * BuyNum : 0
		 * SumPrice : 0
		 * IsCarousel : 0
		 * IsHot : 0
		 */
		
		private int Id;
		private int SortId;
		private int UserId;
		private int ProductTypeId;
		private int PartnerId;
		private String Name;
		private int Count;
		private int Price;
		private int StandardPrice;
		private String Desc;
		private String Msg;
		private String CreateTime;
		private String CoverUrl;
		private int BuyNum;
		private int SumPrice;
		private int IsCarousel;
		private int IsHot;
		
		public int getId() {
			return Id;
		}
		
		public void setId(int Id) {
			this.Id = Id;
		}
		
		public int getSortId() {
			return SortId;
		}
		
		public void setSortId(int SortId) {
			this.SortId = SortId;
		}
		
		public int getUserId() {
			return UserId;
		}
		
		public void setUserId(int UserId) {
			this.UserId = UserId;
		}
		
		public int getProductTypeId() {
			return ProductTypeId;
		}
		
		public void setProductTypeId(int ProductTypeId) {
			this.ProductTypeId = ProductTypeId;
		}
		
		public int getPartnerId() {
			return PartnerId;
		}
		
		public void setPartnerId(int PartnerId) {
			this.PartnerId = PartnerId;
		}
		
		public String getName() {
			return Name;
		}
		
		public void setName(String Name) {
			this.Name = Name;
		}
		
		public int getCount() {
			return Count;
		}
		
		public void setCount(int Count) {
			this.Count = Count;
		}
		
		public int getPrice() {
			return Price;
		}
		
		public void setPrice(int Price) {
			this.Price = Price;
		}
		
		public int getStandardPrice() {
			return StandardPrice;
		}
		
		public void setStandardPrice(int StandardPrice) {
			this.StandardPrice = StandardPrice;
		}
		
		public String getDesc() {
			return Desc;
		}
		
		public void setDesc(String Desc) {
			this.Desc = Desc;
		}
		
		public String getMsg() {
			return Msg;
		}
		
		public void setMsg(String Msg) {
			this.Msg = Msg;
		}
		
		public String getCreateTime() {
			return CreateTime;
		}
		
		public void setCreateTime(String CreateTime) {
			this.CreateTime = CreateTime;
		}
		
		public String getCoverUrl() {
			return CoverUrl;
		}
		
		public void setCoverUrl(String CoverUrl) {
			this.CoverUrl = CoverUrl;
		}
		
		public int getBuyNum() {
			return BuyNum;
		}
		
		public void setBuyNum(int BuyNum) {
			this.BuyNum = BuyNum;
		}
		
		public int getSumPrice() {
			return SumPrice;
		}
		
		public void setSumPrice(int SumPrice) {
			this.SumPrice = SumPrice;
		}
		
		public int getIsCarousel() {
			return IsCarousel;
		}
		
		public void setIsCarousel(int IsCarousel) {
			this.IsCarousel = IsCarousel;
		}
		
		public int getIsHot() {
			return IsHot;
		}
		
		public void setIsHot(int IsHot) {
			this.IsHot = IsHot;
		}
		
		@Override
		public String toString() {
			return "ProductsBean{" +
					"Id=" + Id +
					", SortId=" + SortId +
					", UserId=" + UserId +
					", ProductTypeId=" + ProductTypeId +
					", PartnerId=" + PartnerId +
					", Name='" + Name + '\'' +
					", Count=" + Count +
					", Price=" + Price +
					", StandardPrice=" + StandardPrice +
					", Desc='" + Desc + '\'' +
					", Msg='" + Msg + '\'' +
					", CreateTime='" + CreateTime + '\'' +
					", CoverUrl='" + CoverUrl + '\'' +
					", BuyNum=" + BuyNum +
					", SumPrice=" + SumPrice +
					", IsCarousel=" + IsCarousel +
					", IsHot=" + IsHot +
					'}';
		}
	}
}
