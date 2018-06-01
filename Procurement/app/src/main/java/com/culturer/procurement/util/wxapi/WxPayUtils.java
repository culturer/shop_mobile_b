package com.culturer.procurement.util.wxapi;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


public class WxPayUtils {

    IWXAPI api;

    public WxPayUtils(Context context) {
        this.context = context;

    }

    private Context context;

    public void pay_wechat(String appid, String partnerid, String prepayid,
                           String noncestr, String timestamp, String packageValue, String sign) {
        if (null == api) {
            registerWechatApi(context,appid);
        }
        if (!api.isWXAppInstalled()) {
            Toast.makeText(context.getApplicationContext(), "未安装微信", Toast.LENGTH_SHORT).show();
        }
        PayReq req = new PayReq();
        //req.appId = "wxf8b4f85f3a794e77"; // 测试用appId
        req.appId = appid;
        req.partnerId = partnerid;
        req.prepayId = prepayid;
        req.nonceStr = noncestr;
        req.timeStamp = timestamp;
        req.packageValue = packageValue;
        req.sign = sign;
        api.sendReq(req);
        Log.e("TAG", "发起微信支付请求"+req.appId+"-"+req.partnerId+"-"+ req.prepayId + "-" +req.nonceStr +"-"+req.timeStamp+"-"+req.packageValue+"-"+req.sign);
    }

    /**
     * 注册 微信sdk 到app
     */
    public boolean registerWechatApi(Context context,String appid) {
        if (null == api) {
            api = WXAPIFactory.createWXAPI(context, appid, false);
        }
        return api.registerApp(appid);
    }

}


