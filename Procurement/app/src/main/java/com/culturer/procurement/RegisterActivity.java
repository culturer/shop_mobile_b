package com.culturer.procurement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.culturer.procurement.util.PreferenceUtil;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.client.HttpParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;
import java.util.Set;

import static com.culturer.procurement.util.URL.HOST;

public class RegisterActivity extends AppCompatActivity {
	
	private static final String TAG = "RegisterActivity";
	
	EditText tel;
	EditText pwd;
	
	
	EditText address;
	EditText partnerName;
	EditText position;
	EditText desc;
	Button register;
	
	String sessionId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		tel = findViewById(R.id.tel);
		pwd = findViewById(R.id.pwd);
		address = findViewById(R.id.address);
		partnerName = findViewById(R.id.partnerName);
		position = findViewById(R.id.position);
		desc = findViewById(R.id.desc);
		register = findViewById(R.id.register);
		register.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				HttpParams params = new HttpParams();
				params.put("options",0);
				params.put("tel",tel.getText().toString());
				params.put("pwd",pwd.getText().toString());
				
				HttpCallback callback = new HttpCallback() {
					
					@Override
					public void onSuccess(Map<String, String> headers, byte[] bt) {
						Set<String> keys = headers.keySet();
						for (String key : keys) {
							Log.i(TAG, "onSuccess: "+key);
						}
						Log.i(TAG, "onSuccess: "+headers.get("Set-Cookie"));
						sessionId = headers.get("Set-Cookie").split(";")[0];
						String t = new String(bt);
						Log.i(TAG, "onSuccess: "+t);
						try {
							JSONObject jsonObject = new JSONObject(t);
							int userId = jsonObject.getInt("userId");
							setRegister(userId);
						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
				};
				
				new RxVolley.Builder()
						.url(HOST+"/login")
						.httpMethod(RxVolley.Method.POST) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
						.contentType(RxVolley.ContentType.FORM)//default FORM or JSON
						.params(params)
						.shouldCache(false) //default: get true, post false
						.callback(callback)
						.encoding("UTF-8") //default
						.doTask();
			}
		});
	}
	
	
	private void setRegister(int userId){
		HttpParams params = new HttpParams();
		params.put("options",1);
		params.put("uid",userId);
		params.put("address",address.getText().toString());
		params.put("partnerName",partnerName.getText().toString());
		params.put("position",position.getText().toString());
		params.put("desc",desc.getText().toString());
		params.putHeaders("content-type","application/x-www-form-urlencoded");
		params.putHeaders("Cookie",sessionId);
		
		HttpCallback callback = new HttpCallback() {
			@Override
			public void onSuccess(String t) {
				Log.i(TAG, "onSuccess: "+t);
				Toast.makeText(RegisterActivity.this,"注册为分销商成功！",Toast.LENGTH_LONG).show();
			}
		};
		new RxVolley.Builder()
				.url(HOST+"/partner")
				.httpMethod(RxVolley.Method.POST) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
				.contentType(RxVolley.ContentType.FORM)//default FORM or JSON
				.params(params)
				.shouldCache(false) //default: get true, post false
				.callback(callback)
				.encoding("UTF-8") //default
				.doTask();
	}
}
