package com.culturer.procurement.wedgit;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.culturer.procurement.R;

//导航底部弹框
public class CustomPopWindow extends PopupWindow {
    private View mMenuView;
    private ImageView pop_picture;
    private TextView pop_title;
    private TextView pop_address;
    private TextView pop_distant;
    private TextView pop_navi;

    public CustomPopWindow(Context context, String picture , String title, String address, String distant , View.OnClickListener listener) {
        super(context);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //pop_bottom为自定义布局
        mMenuView = inflater.inflate(R.layout.pop_bottom, null);

        pop_picture = mMenuView.findViewById(R.id.pop_picture);
        pop_title = mMenuView.findViewById(R.id.pop_title);
        pop_address = mMenuView.findViewById(R.id.pop_address);
        pop_distant = mMenuView.findViewById(R.id.pop_distant);
        pop_navi = mMenuView.findViewById(R.id.pop_navi);

        Glide.with(context)
                .load(picture)
                .into(pop_picture);
        pop_title.setText(title);
        pop_address.setText(address);
        pop_distant.setText(distant);
        pop_navi.setOnClickListener(listener);

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

}
