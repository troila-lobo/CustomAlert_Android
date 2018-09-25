package com.troila.customealert.utils;

import android.text.TextUtils;

import com.troila.customealert.R;

public class Utils {
    public static  int getIcon(String type){
        if (TextUtils.isEmpty(type))  return 0;

        if (type.equalsIgnoreCase("success")){
            return R.drawable.image_correct;
        }else if(type.equalsIgnoreCase("fail")){
            return R.drawable.img_error;
        }else if(type.equalsIgnoreCase("warning")){
            return R.drawable.image_prompt;
        }else {
            return 0;
        }

    }
    public static  int getIconWhite(String type){
        if (TextUtils.isEmpty(type))  return 0;

        if (type.equalsIgnoreCase("success")){
            return R.drawable.image_w_correct;
        }else if(type.equalsIgnoreCase("fail")){
            return R.drawable.image_w_error;
        }else if(type.equalsIgnoreCase("warning")){
            return R.drawable.image_w_prompt;
        }else {
            return 0;
        }

    }
}
