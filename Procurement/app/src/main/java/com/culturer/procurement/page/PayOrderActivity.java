package com.culturer.procurement.page;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.culturer.procurement.MainActivity;
import com.culturer.procurement.R;
import com.culturer.procurement.bean.WechatPay;
import com.culturer.procurement.util.wxapi.WxPayUtils;
import com.google.gson.Gson;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.client.HttpParams;
import com.vondear.rxtools.module.alipay.PayResult;


import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class PayOrderActivity extends AppCompatActivity {
	
	private static final String TAG = "PayOrderActivity";
	
	private RelativeLayout payinfo;
	private TextView leaveTime;
	private TextView amount;
	private RelativeLayout wechatpay;
	private RelativeLayout alipay;
	private Button button;
	private CheckBox wechatpay_select;
	private CheckBox alipay_select;
	//倒计时三十分的实现
	private int minute = 30;//这是分钟
	private int second = 0;//这是分钟后面的秒数。这里是以30分钟为例的，所以，minute是30，second是0
	private Timer timer;
	private TimerTask timerTask;
	private String orderId;
	
	private static final int SDK_PAY_FLAG = 1;
	private static final int SDK_AUTH_FLAG = 2;
	
	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler() {
		@SuppressWarnings("unused")
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case SDK_PAY_FLAG: {
					@SuppressWarnings("unchecked")
					PayResult payResult = new PayResult((Map<String, String>) msg.obj);
					/**
					 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
					 */
					String resultInfo = payResult.getResult();// 同步返回需要验证的信息
					String resultStatus = payResult.getResultStatus();
					// 判断resultStatus 为9000则代表支付成功
					if (TextUtils.equals(resultStatus, "9000")) {
						// 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
						Intent intent=new Intent(PayOrderActivity.this,MainActivity.class);
						startActivity(intent);
						PayOrderActivity.this.finish();
						Toast.makeText(PayOrderActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
					} else {
						// 该笔订单真实的支付结果，需要依赖服务端的异步通知。
						Toast.makeText(PayOrderActivity.this, "支付失败", Toast.LENGTH_SHORT).show();
					}
					break;
				}
				case SDK_AUTH_FLAG: {
//					@SuppressWarnings("unchecked")
//					AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
//					String resultStatus = authResult.getResultStatus();
//
//					// 判断resultStatus 为“9000”且result_code
//					// 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
//					if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
//						// 获取alipay_open_id，调支付时作为参数extern_token 的value
//						// 传入，则支付账户为该授权账户
//						Toast.makeText(PayOrderActivity.this,
//								"授权成功\n" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT)
//								.show();
//					} else {
//						// 其他状态值则为授权失败
//						Toast.makeText(PayOrderActivity.this,
//								"授权失败" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT).show();
//
//					}
					break;
				}
				default:
					break;
			}
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pay_order);
		init();
	}
	
	private void init(){
		payinfo = (RelativeLayout) findViewById(R.id.payinfo);
		leaveTime = (TextView) findViewById(R.id.leave_time);
		amount = (TextView) findViewById(R.id.amount);
		wechatpay = (RelativeLayout) findViewById(R.id.wechatpay);
		alipay = (RelativeLayout) findViewById(R.id.alipay);
		button = (Button) findViewById(R.id.zhifu);
		wechatpay_select = findViewById(R.id.wechatpay_select);
		alipay_select = findViewById(R.id.alipay_select);
		wechatpay.setTag("1");
		wechatpay_select.setChecked(true);
		alipay.setTag("0");
		
		//支付倒计时
		leaveTime.setText("支付剩余时间" + minute + ":" + second);
		timerTask = new TimerTask() {
			@Override
			public void run() {
				Message msg = new Message();
				msg.what = 0;
				handler.sendMessage(msg);
			}
		};
		timer = new Timer();
		timer.schedule(timerTask, 0, 1000);
		//显示支付金额
		amount.setText(getIntent().getStringExtra("totalprice"));
		orderId=getIntent().getStringExtra("botId");
		setOnclick();
	}
	
	//初始化点击时间
	public void setOnclick(){
		wechatpay.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				wechatpay_select.setChecked(true);
				alipay_select.setChecked(false);
				wechatpay.setTag("1");
				alipay.setTag("0");
				
			}
		});
		alipay.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				wechatpay_select.setChecked(false);
				alipay_select.setChecked(true);
				wechatpay.setTag("0");
				alipay.setTag("1");
			}
		});
		wechatpay_select.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
					wechatpay.setTag("1");
					alipay.setTag("0");
					alipay_select.setChecked(false);
				}
			}
		});
		alipay_select.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
					alipay.setTag("1");
					wechatpay.setTag("0");
					wechatpay_select.setChecked(false);
				}
			}
		});
		
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (wechatpay.getTag().toString().equals("1")) {
                   /* WxPayUtils wxPayUtils=new WxPayUtils(PayOrderActivity.this);
                    wxPayUtils.pay_wechat("wx5b3eeaf45e146bd5","1419058302","wx201803051504138675b6e5b70088227744",
                            "1520233453173","1520233453","Sign=WXPay","BAF47E505D587CEAA1D3C31F84F17BB2");*/
                    /*Toast.makeText(PayOrderActivity.this, "微信支付", Toast.LENGTH_LONG).show();*/
					netRequst("2",orderId, "1");
					
				} else if (alipay.getTag().toString().equals("1")) {
					netRequst("1",orderId, "1");
				}
			}
		});
	}
	
	//这是接收回来处理的消息
	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			if (minute == 0) {
				if (second == 0) {
					leaveTime.setText("Time out !");
					if (timer != null) {
						timer.cancel();
						timer = null;
					}
					if (timerTask != null) {
						timerTask = null;
					}
				} else {
					second--;
					if (second >= 10) {
						leaveTime.setText("支付剩余时间" + "0" + minute + ":" + second);
					} else {
						leaveTime.setText("支付剩余时间" + "0" + minute + ":0" + second);
					}
				}
			} else {
				if (second == 0) {
					second = 59;
					minute--;
					if (minute >= 10) {
						leaveTime.setText("支付剩余时间" + minute + ":" + second);
					} else {
						leaveTime.setText("支付剩余时间" + "0" + minute + ":" + second);
					}
				} else {
					second--;
					if (second >= 10) {
						if (minute >= 10) {
							leaveTime.setText("支付剩余时间" + minute + ":" + second);
						} else {
							leaveTime.setText("支付剩余时间" + "0" + minute + ":" + second);
						}
					} else {
						if (minute >= 10) {
							leaveTime.setText("支付剩余时间" + minute + ":0" + second);
						} else {
							leaveTime.setText("支付剩余时间" + "0" + minute + ":0" + second);
						}
					}
				}
			}
		}
		
	};
	
	public void netRequst(final String way, String orderId, String payResouce) {
//		RequestParams requestParams = new RequestParams(NetConstant.get_pay_information);
//		requestParams.addBodyParameter("way", way);
//		requestParams.addBodyParameter("orderId", orderId);
//		requestParams.addBodyParameter("payResource", payResouce);
//		x.http().post(requestParams, new Callback.CommonCallback<String>() {
//			@Override
//			public void onSuccess(String result) {
//				Gson gson = new Gson();
//				//获取支付信息后唤起支付宝进行支付
//				if (Integer.parseInt(way) == 1) {
//					final Alipay alipay_info = gson.fromJson(result, Alipay.class);
//					if (alipay_info.getCode() == 100) {
//						Runnable payRunnable = new Runnable() {
//							@Override
//							public void run() {
//								PayTask alipay = new PayTask(PayOrderActivity.this);
//
//								Map<String, String> result = alipay.payV2(alipay_info.getData(), true);
//								Message msg = new Message();
//								msg.what = SDK_PAY_FLAG;
//								msg.obj = result;
//								mHandler.sendMessage(msg);
//
//
//							}
//						};
//						// 必须异步调用
//						Thread payThread = new Thread(payRunnable);
//						payThread.start();
//					}
//
//				}
//				//获取支付信息后唤起微信支付
//				if (Integer.parseInt(way) == 2) {
//					WechatPay wechatPay=gson.fromJson(result,WechatPay.class);
//					if(wechatPay.getCode()==100){
//						WxPayUtils wxPayUtils=new WxPayUtils(PayOrderActivity.this);
//						WechatPay.DataBean info=wechatPay.getData();
//						wxPayUtils.pay_wechat(info.getAppid(),info.getPartnerid(),info.getPrepayid(),info.getNoncestr(),info.getTimestamp(),info.getPackageX(),info.getPaySign());
//						PayOrderActivity.this.finish();
//
//
//					}
//				}
//
//			}
//			@Override
//			public void onError(Throwable ex, boolean isOnCallback) {
//				Toast.makeText(PayOrderActivity.this, "获取支付信息失败", Toast.LENGTH_LONG).show();
//			}
//
//			@Override
//			public void onCancelled(CancelledException cex) {
//				Toast.makeText(PayOrderActivity.this, "获取支付信息取消", Toast.LENGTH_LONG).show();
//			}
//
//			@Override
//			public void onFinished() {
//                /*  Toast.makeText(getActivity(),"请求完成",Toast.LENGTH_LONG).show();*/
//			}
//		});
		
		HttpParams params = new HttpParams();
		params.put("way",way);
		params.put("orderId",orderId);
		params.put("payResource", payResouce);
		HttpCallback callback = new HttpCallback() {
			@Override
			public void onSuccess(String t) {
				Log.i(TAG, "onSuccess: ");
				Gson gson = new Gson();
				//获取支付信息后唤起支付宝进行支付
				if (Integer.parseInt(way) == 1) {
//					final Alipay alipay_info = gson.fromJson(result, Alipay.class);
//					if (alipay_info.getCode() == 100) {
//						Runnable payRunnable = new Runnable() {
//							@Override
//							public void run() {
//								PayTask alipay = new PayTask(PayOrderActivity.this);
//
//								Map<String, String> result = alipay.payV2(alipay_info.getData(), true);
//								Message msg = new Message();
//								msg.what = SDK_PAY_FLAG;
//								msg.obj = result;
//								mHandler.sendMessage(msg);
//
//
//							}
//						};
//						// 必须异步调用
//						Thread payThread = new Thread(payRunnable);
//						payThread.start();
//					}
				}
			//获取支付信息后唤起微信支付
				if (Integer.parseInt(way) == 2) {
					WechatPay wechatPay=gson.fromJson(t,WechatPay.class);
					if(wechatPay.getCode()==100){
						WxPayUtils wxPayUtils=new WxPayUtils(PayOrderActivity.this);
						WechatPay.DataBean info=wechatPay.getData();
						wxPayUtils.pay_wechat(info.getAppid(),info.getPartnerid(),info.getPrepayid(),info.getNoncestr(),info.getTimestamp(),info.getPackageX(),info.getPaySign());
						PayOrderActivity.this.finish();
					}
				}
			}
			
			@Override
			public void onFailure(int errorNo, String strMsg) {
				super.onFailure(errorNo, strMsg);
			}
		};
		
		

	}
	
}
