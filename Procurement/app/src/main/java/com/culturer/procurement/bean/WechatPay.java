package com.culturer.procurement.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2018/6/7 0007.
 */

public class WechatPay {
	
	/**
	 * code : 100
	 * optSuc : true
	 * msg : 统一下单成功
	 * data : {"package":"Sign=WXPay","paySign":"BAF47E505D587CEAA1D3C31F84F17BB2","appid":"wx5b3eeaf45e146bd5","partnerid":"1419058302","prepayid":"wx201803051504138675b6e5b70088227744","noncestr":"1520233453173","timestamp":"1520233453"}
	 */
	
	private int code;
	private boolean optSuc;
	private String msg;
	private DataBean data;
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public boolean isOptSuc() {
		return optSuc;
	}
	
	public void setOptSuc(boolean optSuc) {
		this.optSuc = optSuc;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public DataBean getData() {
		return data;
	}
	
	public void setData(DataBean data) {
		this.data = data;
	}
	
	public static class DataBean {
		/**
		 * package : Sign=WXPay
		 * paySign : BAF47E505D587CEAA1D3C31F84F17BB2
		 * appid : wx5b3eeaf45e146bd5
		 * partnerid : 1419058302
		 * prepayid : wx201803051504138675b6e5b70088227744
		 * noncestr : 1520233453173
		 * timestamp : 1520233453
		 */
		
		@SerializedName("package")
		private String packageX;
		private String paySign;
		private String appid;
		private String partnerid;
		private String prepayid;
		private String noncestr;
		private String timestamp;
		
		public String getPackageX() {
			return packageX;
		}
		public void setPackageX(String packageX) {
			this.packageX = packageX;
		}
		
		public String getPaySign() {
			return paySign;
		}
		
		public void setPaySign(String paySign) {
			this.paySign = paySign;
		}
		
		public String getAppid() {
			return appid;
		}
		
		public void setAppid(String appid) {
			this.appid = appid;
		}
		
		public String getPartnerid() {
			return partnerid;
		}
		
		public void setPartnerid(String partnerid) {
			this.partnerid = partnerid;
		}
		
		public String getPrepayid() {
			return prepayid;
		}
		
		public void setPrepayid(String prepayid) {
			this.prepayid = prepayid;
		}
		
		public String getNoncestr() {
			return noncestr;
		}
		
		public void setNoncestr(String noncestr) {
			this.noncestr = noncestr;
		}
		
		public String getTimestamp() {
			return timestamp;
		}
		
		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}
	}
}
