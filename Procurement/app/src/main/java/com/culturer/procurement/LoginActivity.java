package com.culturer.procurement;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.culturer.procurement.bean.UserInfoBean;
import com.culturer.procurement.util.Cache;
import com.culturer.procurement.util.PreferenceUtil;
import com.google.gson.Gson;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.client.HttpParams;
import com.vondear.rxtools.RxAnimationTool;
import com.vondear.rxtools.RxBarTool;
import com.vondear.rxtools.RxKeyboardTool;
import com.vondear.rxtools.activity.AndroidBug5497Workaround;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;
import java.util.Set;

import static com.culturer.procurement.util.URL.HOST;

public class LoginActivity extends AppCompatActivity{
	
	private static final String TAG = "LoginActivity" ;
	
	ImageView mLogo;
	EditText mEtMobile;
	ImageView mIvCleanPhone;
	EditText mEtPassword;
	ImageView mCleanPassword;
	ImageView mIvShowPwd;
	Button mBtnLogin;
	TextView mRegist;
	TextView mForgetPassword;
	LinearLayout mContent;
	ScrollView mScrollView;
	LinearLayout mService;
	RelativeLayout mRoot;
	
	private int screenHeight = 0;//屏幕高度
	private int keyHeight = 0; //软件盘弹起后所占高度
	private float scale = 0.6f; //logo缩放比例
	private int height = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		init();
		RxBarTool.setTransparentStatusBar(this);//状态栏透明化
		RxBarTool.StatusBarLightMode(this);
		if (isFullScreen(this)) {
			AndroidBug5497Workaround.assistActivity(this);
		}

	}
	
	private void init(){
		initData();
		initView();
	}
	
	private void initView(){
		initBaseView();
		initRView();
		initREvent();
	}
	
	private void initBaseView(){
		
		mLogo = findViewById(R.id.logo);
		mEtMobile = findViewById(R.id.et_mobile);
		mIvCleanPhone = findViewById(R.id.iv_clean_phone);
		mEtPassword = findViewById(R.id.et_password);
		mCleanPassword = findViewById(R.id.clean_password);
		mIvShowPwd = findViewById(R.id.iv_show_pwd);
		mBtnLogin = findViewById(R.id.btn_login);
		mRegist = findViewById(R.id.regist);
		mForgetPassword = findViewById(R.id.forget_password);
		mContent = findViewById(R.id.content);
		mScrollView = findViewById(R.id.scrollView);
		mService = findViewById(R.id.service);
		mRoot = findViewById(R.id.root);
		
		mRegist.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
				startActivity(intent);
			}
		});
		
		mIvCleanPhone.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mEtMobile.setText("");
			}
		});
		
		mCleanPassword.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mEtPassword.setText("");
			}
		});
		
		mIvShowPwd.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mEtPassword.getInputType() != InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
					mEtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
					mIvShowPwd.setImageResource(R.drawable.pass_visuable);
				} else {
					mEtPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
					mIvShowPwd.setImageResource(R.drawable.pass_gone);
				}
				String pwd = mEtPassword.getText().toString();
				if (!TextUtils.isEmpty(pwd))
					mEtPassword.setSelection(pwd.length());
			}
		});
	}
	
	private void initRView() {
		screenHeight = this.getResources().getDisplayMetrics().heightPixels; //获取屏幕高度
		keyHeight = screenHeight / 3;//弹起高度为屏幕高度的1/3
	}
	
	private void initREvent() {
		mEtMobile.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			
			}
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				if (!TextUtils.isEmpty(s) && mIvCleanPhone.getVisibility() == View.GONE) {
					mIvCleanPhone.setVisibility(View.VISIBLE);
				} else if (TextUtils.isEmpty(s)) {
					mIvCleanPhone.setVisibility(View.GONE);
				}
			}
		});
		mEtPassword.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			
			}
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				if (!TextUtils.isEmpty(s) && mCleanPassword.getVisibility() == View.GONE) {
					mCleanPassword.setVisibility(View.VISIBLE);
				} else if (TextUtils.isEmpty(s)) {
					mCleanPassword.setVisibility(View.GONE);
				}
				if (s.toString().isEmpty())
					return;
				if (!s.toString().matches("[A-Za-z0-9]+")) {
					String temp = s.toString();
					Toast.makeText(LoginActivity.this, "请输入数字或字母", Toast.LENGTH_SHORT).show();
					s.delete(temp.length() - 1, temp.length());
					mEtPassword.setSelection(s.length());
				}
			}
		});
		/**
		 * 禁止键盘弹起的时候可以滚动
		 */
		mScrollView.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return true;
			}
		});
		mScrollView.addOnLayoutChangeListener(new ViewGroup.OnLayoutChangeListener() {
			@Override
			public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
              /* old是改变前的左上右下坐标点值，没有old的是改变后的左上右下坐标点值
              现在认为只要控件将Activity向上推的高度超过了1/3屏幕高，就认为软键盘弹起*/
				if (oldBottom != 0 && bottom != 0 && (oldBottom - bottom > keyHeight)) {
					Log.e("wenzhihao", "up------>" + (oldBottom - bottom));
					int dist = mContent.getBottom() - bottom;
					if (dist > 0) {
						ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(mContent, "translationY", 0.0f, -dist);
						mAnimatorTranslateY.setDuration(300);
						mAnimatorTranslateY.setInterpolator(new LinearInterpolator());
						mAnimatorTranslateY.start();
						RxAnimationTool.zoomIn(mLogo, 0.6f, dist);
					}
					mService.setVisibility(View.INVISIBLE);
					
				} else if (oldBottom != 0 && bottom != 0 && (bottom - oldBottom > keyHeight)) {
					Log.e("wenzhihao", "down------>" + (bottom - oldBottom));
					if ((mContent.getBottom() - oldBottom) > 0) {
						ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(mContent, "translationY", mContent.getTranslationY(), 0);
						mAnimatorTranslateY.setDuration(300);
						mAnimatorTranslateY.setInterpolator(new LinearInterpolator());
						mAnimatorTranslateY.start();
						//键盘收回后，logo恢复原来大小，位置同样回到初始位置
						RxAnimationTool.zoomOut(mLogo, 0.6f);
					}
					mService.setVisibility(View.VISIBLE);
				}
			}
		});
		
		mBtnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				RxKeyboardTool.hideSoftInput(LoginActivity.this);
				HttpParams params = new HttpParams();
				
				params.put("tel", mEtMobile.getText().toString());
				params.put("pwd", mEtPassword.getText().toString());
				
				HttpCallback callBack = new HttpCallback(){
					
					@Override
					public void onSuccess(Map<String, String> headers, byte[] t) {
						Set<String> keys = headers.keySet();
						for (String key : keys) {
							Log.i(TAG, "onSuccess: "+key);
						}
						Log.i(TAG, "onSuccess: "+headers.get("Set-Cookie"));
						String sessionId = headers.get("Set-Cookie").split(";")[0];
						PreferenceUtil.commitString("sessionId",sessionId);
						Log.i(TAG, "session: "+sessionId);
						Log.i(TAG, "onSuccess: "+new String(t));
						String t1 = new String(t);
						try {
							JSONObject jsonObject = new JSONObject(t1);
							int status = jsonObject.getInt( "status");
							Log.i(TAG, "status: "+status);
							if (status == 200){
								//登录成功
								PreferenceUtil.commitString("userInfo",t1);
								Gson gson = new Gson();
								Cache.user = gson.fromJson(t1, UserInfoBean.class);
								Intent intent = new Intent(LoginActivity.this,MainActivity.class);
								startActivity(intent);
								finish();
							}else {
								Toast.makeText(LoginActivity.this,"登录失败，请检查账号密码后再次登录!",Toast.LENGTH_LONG).show();
							}
						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
					
					@Override
					public void onFailure(int errorNo, String strMsg) {
						Log.i(TAG, "onFailure: "+strMsg);
					}
				};
				
				new RxVolley.Builder()
						.url(HOST+"/p_login")
						.httpMethod(RxVolley.Method.POST) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
						.contentType(RxVolley.ContentType.FORM)//default FORM or JSON
						.params(params)
						.shouldCache(false) //default: get true, post false
						.callback(callBack)
						.encoding("UTF-8") //default
						.doTask();
			}
		});
	}
	
	private void initData(){
	
	}
	
	public boolean isFullScreen(Activity activity) {
		return (activity.getWindow().getAttributes().flags &
				WindowManager.LayoutParams.FLAG_FULLSCREEN) == WindowManager.LayoutParams.FLAG_FULLSCREEN;
	}
	
}
