package com.culturer.procurement.bean;

/**
 * Created by Administrator on 2018/5/21 0021.
 */

public class UserInfoBean {
	
	/**
	 * partner : {"Id":1,"UserId":1,"PartnerName":"隔壁老宋宋啊","Address":"湖北省武汉市","Credits":0,"Pro":0,"SortId":0,"Position":"","Desc":"","Add_time":""}
	 * status : 200
	 * time : 2018-05-21 14:04:20
	 * user : {"Id":1,"Name":"","Tel":"18588263531","Password":"78901214","Vid":"","Prov":1,"CreateTime":""}
	 */
	
	private PartnerBean partner;
	private int status;
	private String time;
	private UserBean user;
	
	public PartnerBean getPartner() {
		return partner;
	}
	
	public void setPartner(PartnerBean partner) {
		this.partner = partner;
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
	
	public UserBean getUser() {
		return user;
	}
	
	public void setUser(UserBean user) {
		this.user = user;
	}
	
	public static class PartnerBean {
		/**
		 * Id : 1
		 * UserId : 1
		 * PartnerName : 隔壁老宋宋啊
		 * Address : 湖北省武汉市
		 * Credits : 0
		 * Pro : 0
		 * SortId : 0
		 * Position :
		 * Desc :
		 * Add_time :
		 */
		
		private int Id;
		private int UserId;
		private String PartnerName;
		private String Address;
		private int Credits;
		private int Pro;
		private int SortId;
		private String Position;
		private String Desc;
		private String Add_time;
		
		public int getId() {
			return Id;
		}
		
		public void setId(int Id) {
			this.Id = Id;
		}
		
		public int getUserId() {
			return UserId;
		}
		
		public void setUserId(int UserId) {
			this.UserId = UserId;
		}
		
		public String getPartnerName() {
			return PartnerName;
		}
		
		public void setPartnerName(String PartnerName) {
			this.PartnerName = PartnerName;
		}
		
		public String getAddress() {
			return Address;
		}
		
		public void setAddress(String Address) {
			this.Address = Address;
		}
		
		public int getCredits() {
			return Credits;
		}
		
		public void setCredits(int Credits) {
			this.Credits = Credits;
		}
		
		public int getPro() {
			return Pro;
		}
		
		public void setPro(int Pro) {
			this.Pro = Pro;
		}
		
		public int getSortId() {
			return SortId;
		}
		
		public void setSortId(int SortId) {
			this.SortId = SortId;
		}
		
		public String getPosition() {
			return Position;
		}
		
		public void setPosition(String Position) {
			this.Position = Position;
		}
		
		public String getDesc() {
			return Desc;
		}
		
		public void setDesc(String Desc) {
			this.Desc = Desc;
		}
		
		public String getAdd_time() {
			return Add_time;
		}
		
		public void setAdd_time(String Add_time) {
			this.Add_time = Add_time;
		}
	}
	
	public static class UserBean {
		/**
		 * Id : 1
		 * Name :
		 * Tel : 18588263531
		 * Password : 78901214
		 * Vid :
		 * Prov : 1
		 * CreateTime :
		 */
		
		private int Id;
		private String Name;
		private String Tel;
		private String Password;
		private String Vid;
		private int Prov;
		private String CreateTime;
		
		public int getId() {
			return Id;
		}
		
		public void setId(int Id) {
			this.Id = Id;
		}
		
		public String getName() {
			return Name;
		}
		
		public void setName(String Name) {
			this.Name = Name;
		}
		
		public String getTel() {
			return Tel;
		}
		
		public void setTel(String Tel) {
			this.Tel = Tel;
		}
		
		public String getPassword() {
			return Password;
		}
		
		public void setPassword(String Password) {
			this.Password = Password;
		}
		
		public String getVid() {
			return Vid;
		}
		
		public void setVid(String Vid) {
			this.Vid = Vid;
		}
		
		public int getProv() {
			return Prov;
		}
		
		public void setProv(int Prov) {
			this.Prov = Prov;
		}
		
		public String getCreateTime() {
			return CreateTime;
		}
		
		public void setCreateTime(String CreateTime) {
			this.CreateTime = CreateTime;
		}
	}
}
