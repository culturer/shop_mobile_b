package com.culturer.procurement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.client.HttpParams;
import com.vondear.rxtools.module.wechat.pay.WechatModel;
import com.vondear.rxtools.module.wechat.pay.WechatPayTools;

public class TestActivity extends AppCompatActivity {
	
	private static final String TAG = "TestActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		WechatPayTools.wechatPayUnifyOrder(TestActivity.this,
				WX_APP_ID, //微信分配的APP_ID
				WX_PARTNER_ID, //微信分配的 PARTNER_ID (商户ID)
				WX_PRIVATE_KEY, //微信分配的 PRIVATE_KEY (私钥)
				new WechatModel(order_id, //订单ID (唯一)
						money, //价格
						name, //商品名称
						detail), //商品描述详情
				new onRequestListener() {
					@Override
					public void onSuccess(String s) {}
					
					@Override
					public void onError(String s) {}
				});
	}
}
