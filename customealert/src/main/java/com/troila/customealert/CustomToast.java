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

public class CustomToast {

    /**
     * 普通Toast
     * @param msg
     */
    public static void showToast(Context context,String msg){
        Toast toast = Toast.makeText(context, msg,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * 带图标和内容的Toast
     * @param icon
     * @param msg
     */
    public static void showToast(Context context,int icon,String msg){
        Toast toast = Toast.makeText(context.getApplicationContext(), msg,
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastView = (LinearLayout) toast.getView();
        ImageView imageCodeProject = new ImageView(context.getApplicationContext());
        imageCodeProject.setImageResource(icon);
        toastView.addView(imageCodeProject, 0);
        toast.show();
    }

    /**
     * 带进度条的Toast
     * @param msg
     */
    public static void showToast(Context context,String msg,boolean showProgress){
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View layout = inflater.inflate(R.layout.cus_toast,
                (ViewGroup) ((Activity)context).findViewById(R.id.llToast));
        ProgressBar image = (ProgressBar) layout
                .findViewById(R.id.loading_progress);
        TextView title = (TextView) layout.findViewById(R.id.message);
        title.setVisibility(TextUtils.isEmpty(msg)?View.GONE:View.VISIBLE);
        title.setText(msg);

        Toast toast = new Toast(context.getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
    public static void showErrorToast(Context context,String msg){
        showToast(context,R.drawable.image_w_error,msg);
    }
    public static void showSuccessToast(Context context,String msg){
        showToast(context,R.drawable.image_w_correct,msg);
    }
}
