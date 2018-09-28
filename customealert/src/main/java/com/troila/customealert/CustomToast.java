package com.troila.customealert;


import android.content.Context;
public class CustomToast {

    /**
     * 带图标和内容的Toast
     * @param icon
     * @param msg
     */
    public static void showToast(Context context,String icon,String msg){
        Toast.makeText(context,msg,icon,EToast2.LENGTH_SHORT).show();

    }


}
