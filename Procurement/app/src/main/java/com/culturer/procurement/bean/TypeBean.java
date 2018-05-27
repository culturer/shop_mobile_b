package com.culturer.procurement.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/20 0020.
 */

public class TypeBean {
	
	/**
	 * productTypes : [{"Id":1,"TypeName":"西瓜","CreateTime":"2018-04-25 22:04:35","SortId":1},{"Id":2,"TypeName":"芒果","CreateTime":"2018-04-25 22:05:10","SortId":1},{"Id":3,"TypeName":"栗子","CreateTime":"2018-04-25 22:05:27","SortId":1},{"Id":4,"TypeName":"栗子数","CreateTime":"2018-04-25 22:05:35","SortId":1},{"Id":5,"TypeName":"橘子","CreateTime":"2018-04-25 22:05:45","SortId":1}]
	 * status : 200
	 * time : 2018-05-20 18:04:58
	 * totalPage : 5
	 */
	
	private int status;
	private String time;
	private int totalPage;
	private List<ProductTypesBean> productTypes;
	
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
	
	public List<ProductTypesBean> getProductTypes() {
		return productTypes;
	}
	
	public void setProductTypes(List<ProductTypesBean> productTypes) {
		this.productTypes = productTypes;
	}
	
	public static class ProductTypesBean {
		/**
		 * Id : 1
		 * TypeName : 西瓜
		 * CreateTime : 2018-04-25 22:04:35
		 * SortId : 1
		 */
		
		private int Id;
		private String TypeName;
		private String CreateTime;
		private int SortId;
		
		public int getId() {
			return Id;
		}
		
		public void setId(int Id) {
			this.Id = Id;
		}
		
		public String getTypeName() {
			return TypeName;
		}
		
		public void setTypeName(String TypeName) {
			this.TypeName = TypeName;
		}
		
		public String getCreateTime() {
			return CreateTime;
		}
		
		public void setCreateTime(String CreateTime) {
			this.CreateTime = CreateTime;
		}
		
		public int getSortId() {
			return SortId;
		}
		
		public void setSortId(int SortId) {
			this.SortId = SortId;
		}
	}
}
