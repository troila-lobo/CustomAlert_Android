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
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View layout = inflater.inflate(R.layout.cus_toast,
                (ViewGroup) ((Activity)context).findViewById(R.id.llToast));
        ImageView image = (ImageView) layout
                .findViewById(R.id.dialog_icon);
        image.setImageResource(Utils.getIconWhite(icon));
        TextView title = (TextView) layout.findViewById(R.id.message);
        title.setVisibility(TextUtils.isEmpty(msg)?View.GONE:View.VISIBLE);
        title.setText(msg);

        Toast toast = new Toast(context.getApplicationContext());
        if (!TextUtils.isEmpty(icon)) {
            toast.setGravity(Gravity.CENTER, 0, 0);
        }else {
            image.setVisibility(View.GONE);
        }
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }


}
