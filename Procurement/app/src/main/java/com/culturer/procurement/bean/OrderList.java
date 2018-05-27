package com.culturer.procurement.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/24 0024.
 */

public class OrderList {
	
	/**
	 * count : 2
	 * dataList : [{"OrderInfo":{"Id":3,"OrderNum":"U1T1527072419972","SortId":0,"UserId":1,"AddressId":0,"Address":"78901214","Position":"","TranslateStatus":"","PayType":"cashPay","RealPrice":0,"ShouldPrice":30,"PriceMsg":"","Receiver":"隔壁老宋宋啊","Phone":"18588263531","PartnerId":0,"CreateTime":"2018-05-23 18:43:03","OrderStatus":0,"IsPay":false,"IsDlivery":false,"IsSign":false,"IsCash":false,"IsComment":false,"IsCancel":false,"Remark":"哈哈哈哈","Comments":"","CancelComments":""},"OrderItems":[{"Id":5,"OrderId":3,"ProductId":1,"SortId":0,"SumNum":3,"SumPrice":30,"CreateTime":"2018-05-23 18:43:03","Name":"带上大哥"}],"ItemCount":1},{"OrderInfo":{"Id":2,"OrderNum":"U1T1527072352995","SortId":0,"UserId":1,"AddressId":0,"Address":"湖北省武汉市","Position":"","TranslateStatus":"","PayType":"cashPay","RealPrice":0,"ShouldPrice":40,"PriceMsg":"","Receiver":"隔壁老宋宋啊","Phone":"18588263531","PartnerId":0,"CreateTime":"2018-05-23 18:41:56","OrderStatus":0,"IsPay":false,"IsDlivery":false,"IsSign":false,"IsCash":false,"IsComment":false,"IsCancel":false,"Remark":"明早送来","Comments":"","CancelComments":""},"OrderItems":[{"Id":4,"OrderId":2,"ProductId":2,"SortId":0,"SumNum":1,"SumPrice":10,"CreateTime":"2018-05-23 18:41:56","Name":"发货iOS的风格v阿婆士大夫"},{"Id":3,"OrderId":2,"ProductId":1,"SortId":0,"SumNum":1,"SumPrice":10,"CreateTime":"2018-05-23 18:41:56","Name":"带上大哥"},{"Id":2,"OrderId":2,"ProductId":4,"SortId":0,"SumNum":1,"SumPrice":10,"CreateTime":"2018-05-23 18:41:56","Name":"啊而放任不管"},{"Id":1,"OrderId":2,"ProductId":3,"SortId":0,"SumNum":1,"SumPrice":10,"CreateTime":"2018-05-23 18:41:56","Name":"奥i个i地方 "}],"ItemCount":4}]
	 * status : 200
	 * time : 2018-05-24 16:11:33
	 */
	
	private int count;
	private int status;
	private String time;
	private List<DataListBean> dataList;
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
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
	
	public List<DataListBean> getDataList() {
		return dataList;
	}
	
	public void setDataList(List<DataListBean> dataList) {
		this.dataList = dataList;
	}
	
	public static class DataListBean {
		/**
		 * OrderInfo : {"Id":3,"OrderNum":"U1T1527072419972","SortId":0,"UserId":1,"AddressId":0,"Address":"78901214","Position":"","TranslateStatus":"","PayType":"cashPay","RealPrice":0,"ShouldPrice":30,"PriceMsg":"","Receiver":"隔壁老宋宋啊","Phone":"18588263531","PartnerId":0,"CreateTime":"2018-05-23 18:43:03","OrderStatus":0,"IsPay":false,"IsDlivery":false,"IsSign":false,"IsCash":false,"IsComment":false,"IsCancel":false,"Remark":"哈哈哈哈","Comments":"","CancelComments":""}
		 * OrderItems : [{"Id":5,"OrderId":3,"ProductId":1,"SortId":0,"SumNum":3,"SumPrice":30,"CreateTime":"2018-05-23 18:43:03","Name":"带上大哥"}]
		 * ItemCount : 1
		 */
		
		private OrderInfoBean OrderInfo;
		private int ItemCount;
		private List<OrderItemsBean> OrderItems;
		
		public OrderInfoBean getOrderInfo() {
			return OrderInfo;
		}
		
		public void setOrderInfo(OrderInfoBean OrderInfo) {
			this.OrderInfo = OrderInfo;
		}
		
		public int getItemCount() {
			return ItemCount;
		}
		
		public void setItemCount(int ItemCount) {
			this.ItemCount = ItemCount;
		}
		
		public List<OrderItemsBean> getOrderItems() {
			return OrderItems;
		}
		
		public void setOrderItems(List<OrderItemsBean> OrderItems) {
			this.OrderItems = OrderItems;
		}
		
		public static class OrderInfoBean {
			/**
			 * Id : 3
			 * OrderNum : U1T1527072419972
			 * SortId : 0
			 * UserId : 1
			 * AddressId : 0
			 * Address : 78901214
			 * Position :
			 * TranslateStatus :
			 * PayType : cashPay
			 * RealPrice : 0
			 * ShouldPrice : 30
			 * PriceMsg :
			 * Receiver : 隔壁老宋宋啊
			 * Phone : 18588263531
			 * PartnerId : 0
			 * CreateTime : 2018-05-23 18:43:03
			 * OrderStatus : 0
			 * IsPay : false
			 * IsDlivery : false
			 * IsSign : false
			 * IsCash : false
			 * IsComment : false
			 * IsCancel : false
			 * Remark : 哈哈哈哈
			 * Comments :
			 * CancelComments :
			 */
			
			private int Id;
			private String OrderNum;
			private int SortId;
			private int UserId;
			private int AddressId;
			private String Address;
			private String Position;
			private String TranslateStatus;
			private String PayType;
			private int RealPrice;
			private int ShouldPrice;
			private String PriceMsg;
			private String Receiver;
			private String Phone;
			private int PartnerId;
			private String CreateTime;
			private int OrderStatus;
			private boolean IsPay;
			private boolean IsDlivery;
			private boolean IsSign;
			private boolean IsCash;
			private boolean IsComment;
			private boolean IsCancel;
			private String Remark;
			private String Comments;
			private String CancelComments;
			
			public int getId() {
				return Id;
			}
			
			public void setId(int Id) {
				this.Id = Id;
			}
			
			public String getOrderNum() {
				return OrderNum;
			}
			
			public void setOrderNum(String OrderNum) {
				this.OrderNum = OrderNum;
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
			
			public int getAddressId() {
				return AddressId;
			}
			
			public void setAddressId(int AddressId) {
				this.AddressId = AddressId;
			}
			
			public String getAddress() {
				return Address;
			}
			
			public void setAddress(String Address) {
				this.Address = Address;
			}
			
			public String getPosition() {
				return Position;
			}
			
			public void setPosition(String Position) {
				this.Position = Position;
			}
			
			public String getTranslateStatus() {
				return TranslateStatus;
			}
			
			public void setTranslateStatus(String TranslateStatus) {
				this.TranslateStatus = TranslateStatus;
			}
			
			public String getPayType() {
				return PayType;
			}
			
			public void setPayType(String PayType) {
				this.PayType = PayType;
			}
			
			public int getRealPrice() {
				return RealPrice;
			}
			
			public void setRealPrice(int RealPrice) {
				this.RealPrice = RealPrice;
			}
			
			public int getShouldPrice() {
				return ShouldPrice;
			}
			
			public void setShouldPrice(int ShouldPrice) {
				this.ShouldPrice = ShouldPrice;
			}
			
			public String getPriceMsg() {
				return PriceMsg;
			}
			
			public void setPriceMsg(String PriceMsg) {
				this.PriceMsg = PriceMsg;
			}
			
			public String getReceiver() {
				return Receiver;
			}
			
			public void setReceiver(String Receiver) {
				this.Receiver = Receiver;
			}
			
			public String getPhone() {
				return Phone;
			}
			
			public void setPhone(String Phone) {
				this.Phone = Phone;
			}
			
			public int getPartnerId() {
				return PartnerId;
			}
			
			public void setPartnerId(int PartnerId) {
				this.PartnerId = PartnerId;
			}
			
			public String getCreateTime() {
				return CreateTime;
			}
			
			public void setCreateTime(String CreateTime) {
				this.CreateTime = CreateTime;
			}
			
			public int getOrderStatus() {
				return OrderStatus;
			}
			
			public void setOrderStatus(int OrderStatus) {
				this.OrderStatus = OrderStatus;
			}
			
			public boolean isIsPay() {
				return IsPay;
			}
			
			public void setIsPay(boolean IsPay) {
				this.IsPay = IsPay;
			}
			
			public boolean isIsDlivery() {
				return IsDlivery;
			}
			
			public void setIsDlivery(boolean IsDlivery) {
				this.IsDlivery = IsDlivery;
			}
			
			public boolean isIsSign() {
				return IsSign;
			}
			
			public void setIsSign(boolean IsSign) {
				this.IsSign = IsSign;
			}
			
			public boolean isIsCash() {
				return IsCash;
			}
			
			public void setIsCash(boolean IsCash) {
				this.IsCash = IsCash;
			}
			
			public boolean isIsComment() {
				return IsComment;
			}
			
			public void setIsComment(boolean IsComment) {
				this.IsComment = IsComment;
			}
			
			public boolean isIsCancel() {
				return IsCancel;
			}
			
			public void setIsCancel(boolean IsCancel) {
				this.IsCancel = IsCancel;
			}
			
			public String getRemark() {
				return Remark;
			}
			
			public void setRemark(String Remark) {
				this.Remark = Remark;
			}
			
			public String getComments() {
				return Comments;
			}
			
			public void setComments(String Comments) {
				this.Comments = Comments;
			}
			
			public String getCancelComments() {
				return CancelComments;
			}
			
			public void setCancelComments(String CancelComments) {
				this.CancelComments = CancelComments;
			}
		}
		
		public static class OrderItemsBean {
			/**
			 * Id : 5
			 * OrderId : 3
			 * ProductId : 1
			 * SortId : 0
			 * SumNum : 3
			 * SumPrice : 30
			 * CreateTime : 2018-05-23 18:43:03
			 * Name : 带上大哥
			 */
			
			private int Id;
			private int OrderId;
			private int ProductId;
			private int SortId;
			private int SumNum;
			private int SumPrice;
			private String CreateTime;
			private String Name;
			
			public int getId() {
				return Id;
			}
			
			public void setId(int Id) {
				this.Id = Id;
			}
			
			public int getOrderId() {
				return OrderId;
			}
			
			public void setOrderId(int OrderId) {
				this.OrderId = OrderId;
			}
			
			public int getProductId() {
				return ProductId;
			}
			
			public void setProductId(int ProductId) {
				this.ProductId = ProductId;
			}
			
			public int getSortId() {
				return SortId;
			}
			
			public void setSortId(int SortId) {
				this.SortId = SortId;
			}
			
			public int getSumNum() {
				return SumNum;
			}
			
			public void setSumNum(int SumNum) {
				this.SumNum = SumNum;
			}
			
			public int getSumPrice() {
				return SumPrice;
			}
			
			public void setSumPrice(int SumPrice) {
				this.SumPrice = SumPrice;
			}
			
			public String getCreateTime() {
				return CreateTime;
			}
			
			public void setCreateTime(String CreateTime) {
				this.CreateTime = CreateTime;
			}
			
			public String getName() {
				return Name;
			}
			
			public void setName(String Name) {
				this.Name = Name;
			}
		}
	}
}
