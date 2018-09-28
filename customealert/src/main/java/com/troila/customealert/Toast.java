package com.troila.customealert;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.troila.customealert.utils.Utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Author: sj.
 * Date: 2018/9/28.
 * Description:
 */

public class Toast {
    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    private static int checkNotification = 0;
    private Object mToast;
    private Toast(Context context, String message,String icon, int duration) {
        if(context instanceof Application)
            checkNotification = 0;
        else
            checkNotification = isNotificationEnabled(context) ? 0 : 1;
        if (checkNotification == 1) {
            mToast = EToast2.makeText(context, message,icon, duration);
        } else {
            mToast = showSysToast(context, message,icon);
        }
    }
    private Toast(Context context, int resId, int duration) {
        if(context instanceof Application)
            checkNotification = 0;
        else
            checkNotification = isNotificationEnabled(context) ? 0 : 1;
        if (checkNotification == 1 && context instanceof Activity) {
//            mToast = EToast2.makeText(context, resId, duration);
        } else {
            mToast = android.widget.Toast.makeText(context, resId, duration);
        }
    }

    public static Toast makeText(Context context, String message, String icon,int duration) {
        return new Toast(context,message,icon,duration);
    }
    public static Toast makeText(Context context, int resId, int duration) {
        return new Toast(context,resId,duration);
    }

    public void show() {
        if(mToast instanceof EToast2){
            ((EToast2) mToast).show();
        }else if(mToast instanceof android.widget.Toast){
            ((android.widget.Toast) mToast).show();
        }
    }
    public void cancel(){
        if(mToast instanceof EToast2){
            ((EToast2) mToast).cancel();
        }else if(mToast instanceof android.widget.Toast){
            ((android.widget.Toast) mToast).cancel();
        }
    }
    public void setText(CharSequence s){
        if(mToast instanceof EToast2){
            ((EToast2) mToast).setText(s);
        }else if(mToast instanceof android.widget.Toast){
            ((android.widget.Toast) mToast).setText(s);
        }
    }
    /**
     * 用来判断是否开启通知权限
     * */
    private static boolean isNotificationEnabled(Context context){
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT){
            AppOpsManager mAppOps = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
            ApplicationInfo appInfo = context.getApplicationInfo();

            String pkg = context.getApplicationContext().getPackageName();

            int uid = appInfo.uid;

            Class appOpsClass = null; /* Context.APP_OPS_MANAGER */

            try {
                appOpsClass = Class.forName(AppOpsManager.class.getName());
                Method checkOpNoThrowMethod = appOpsClass.getMethod(CHECK_OP_NO_THROW, Integer.TYPE, Integer.TYPE, String.class);
                Field opPostNotificationValue = appOpsClass.getDeclaredField(OP_POST_NOTIFICATION);
                int value = (int)opPostNotificationValue.get(Integer.class);
                return ((int)checkOpNoThrowMethod.invoke(mAppOps,value, uid, pkg) == AppOpsManager.MODE_ALLOWED);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }else{
            return false;
        }
    }
    public android.widget.Toast showSysToast(Context context,  String msg,String icon){
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View layout = inflater.inflate(R.layout.cus_toast,
                null);
        ImageView image = (ImageView) layout
                .findViewById(R.id.dialog_icon);
        image.setImageResource(Utils.getIconWhite(icon));
        TextView title = (TextView) layout.findViewById(R.id.message);
        title.setVisibility(TextUtils.isEmpty(msg)?View.GONE:View.VISIBLE);
        title.setText(msg);

        android.widget.Toast toast = new android.widget.Toast(context);
        if (!TextUtils.isEmpty(icon)) {
            toast.setGravity(Gravity.CENTER, 0, 0);
        }else {
            image.setVisibility(View.GONE);
        }
        toast.setDuration(android.widget.Toast.LENGTH_LONG);
        toast.setView(layout);
        return toast;
    }
}