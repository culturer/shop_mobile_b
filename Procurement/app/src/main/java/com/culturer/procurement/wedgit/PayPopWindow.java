package com.culturer.procurement.wedgit;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.culturer.procurement.R;
import com.culturer.procurement.event.OrderEvent;
import com.culturer.procurement.page.CommitOrderActivity;
import com.culturer.procurement.util.PreferenceUtil;
import com.culturer.procurement.util.wxapi.WxPayUtils;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.client.HttpParams;
import com.vondear.rxtools.interfaces.OnSuccessAndErrorListener;
import com.vondear.rxtools.module.wechat.pay.WechatModel;
import com.vondear.rxtools.module.wechat.pay.WechatPay;
import com.vondear.rxtools.module.wechat.pay.WechatPayTools;

import org.greenrobot.eventbus.EventBus;

import static com.culturer.procurement.util.URL.HOST;
import static com.vondear.rxtools.module.wechat.pay.WechatPayTools.wechatPayApp;

//导航底部弹框
public class PayPopWindow extends PopupWindow {
    
    private static final String TAG = "PayPopWindow";
    
    private View mMenuView;
    private Button viPay;
    private Button zhiPay;
    private Button cashPay;
    
    private Context context;
    private Callback callback;
    
    public PayPopWindow(Context context,Callback callback) {
        super(context);
        this.context = context;
        this.callback = callback;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //pop_bottom为自定义布局
        mMenuView = inflater.inflate(R.layout.pop_bottom_pay, null);
        viPay = mMenuView.findViewById(R.id.viPay);
        zhiPay = mMenuView.findViewById(R.id.zhiPay);
        cashPay = mMenuView.findViewById(R.id.cashPay);
        initPay();
    //设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        //设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.popupAnimation);

        //实例化一个ColorDrawable颜色为半透明
        //ColorDrawable dw = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        //this.setBackgroundDrawable(dw);
        this.getBackground().setAlpha(0);
        final Activity activity=(Activity) context;
        WindowManager.LayoutParams params=activity.getWindow().getAttributes();
        params.alpha=0.7f;
        activity.getWindow().setAttributes(params);
        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()== MotionEvent.ACTION_UP){
                    dismiss();
                    WindowManager.LayoutParams params=activity.getWindow().getAttributes();
                    params.alpha=1f;
                    activity.getWindow().setAttributes(params);
                }
                return true;
            }
        });
        this.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams params=activity.getWindow().getAttributes();
                params.alpha=1f;
                activity.getWindow().setAttributes(params);
            }
        });

    }
    public View getView(){
        return mMenuView;
    }
    
    private void initPay(){
        viPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initViPay();
            }
        });
        zhiPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initZhiPay();
            }
        });
        cashPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initCashPay();
            }
        });
    }
    
    private void initViPay(){
        
        WxPayUtils wxPayUtils=new WxPayUtils(context);
        wxPayUtils.pay_wechat("wxf8b4f85f3a794e77","partnerid","prepareid","","","","");
        callback.callback();
        dismiss();
        
    }
    
    private void initZhiPay(){
    
    }
    
    private void initCashPay(){
        createOrder("cashPay");
        this.dismiss();
    }
    
    private void createOrder(String payType){
        HttpParams params = new HttpParams();
        params.put("act","createOrder");
        params.put("PayType",payType);
        params.putHeaders("content-type","application/x-www-form-urlencoded");
        params.putHeaders("Cookie", PreferenceUtil.getString("sessionId",""));
        HttpCallback callback1 = new HttpCallback() {
            @Override
            public void onSuccess(String t) {
                Toast.makeText(context,"提交订单成功！",Toast.LENGTH_LONG).show();
                EventBus.getDefault().post(new OrderEvent());
                callback.callback();
            }
        };
        new RxVolley.Builder()
                .url(HOST+"/order")
                .httpMethod(RxVolley.Method.POST) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
                .cacheTime(0) //default: get 5min, post 0min
                .contentType(RxVolley.ContentType.FORM)//default FORM or JSON
                .params(params)
                .shouldCache(false) //default: get true, post false
                .callback(callback1)
                .encoding("UTF-8") //defaultr
                .doTask();
        
    }

    public interface Callback{
        void callback();
    }
}
