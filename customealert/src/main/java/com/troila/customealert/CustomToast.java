package com.troila.customealert;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.troila.customealert.utils.Utils;

public class CustomToast {

    /**
     * 带图标和内容的Toast
     * @param icon
     * @param msg
     */
    public static void showToast(Context context,String icon,String msg){
        EToast2.makeText(context,msg,icon,EToast2.LENGTH_SHORT).show();

    }


}
