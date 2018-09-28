package com.troila.customealert;
import android.content.Context;
import com.troila.customealert.custoast.ToastUtils;

public class CustomToast {

    /**
     * 带图标和内容的Toast
     * @param icon
     * @param msg
     */
    public static void showToast(Context context,String icon,String msg){
        ToastUtils.makeText(context,msg,icon, ToastUtils.LENGTH_SHORT).show();

    }


}
