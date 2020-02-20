package com.troila.customealert;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import android.text.TextUtils;

import com.troila.customealert.custoast.ToastUtils;

public class CustomToast {

    /**
     * 带图标和内容的Toast
     *
     * @param icon
     * @param msg
     */
    public static void showToast(Context context, String icon, String msg) {
        if (context != null && !TextUtils.isEmpty(icon) && !TextUtils.isEmpty(msg)) {
            if (context instanceof Activity) {
                ToastUtils.makeText(context, msg, icon, ToastUtils.LENGTH_SHORT).show();
            } else {
                Toast toast = Toast.makeText(context, null, Toast.LENGTH_SHORT);
                toast.setText(msg);
                toast.show();
            }
        }else if(context != null && !TextUtils.isEmpty(msg)){
            Toast toast = Toast.makeText(context, null, Toast.LENGTH_SHORT);
            toast.setText(msg);
            toast.show();
        }
    }

    public static void release() {
        ToastUtils.release();
    }

}
