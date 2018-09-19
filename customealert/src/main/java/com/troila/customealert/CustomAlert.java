package com.troila.customealert;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
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

/**
 * T :title
 * C :content
 * B :Button
 * I :icon
 * 什么内容不需要什么内容不传，传""，NULL,的值，默认控件不显示，样式传0显示默认样式
 */
public class CustomAlert {
    private Context context;
    private CustomDialog.Builder builder;
    CustomDialog dia;
    Toast toast;
    public CustomAlert(Context context) {
        this.context = context;
    }

    /**
     * 仅显示内容
     * @param msg
     */
    public void showDialogOnlyContent(String msg){
        if (!isCorrectContex())return;
        isShowing();
        builder = new CustomDialog.Builder(context, "", msg);
        dia = builder.create();
        dia.show();
    }

    /**
     * 标题，内容，两个按钮，不需要显示的内容传"",null,0
     * @param title
     * @param msg
     * @param negativeButtonText
     * @param negativeButtonlistener
     * @param positiveButtonText
     * @param positiveButtonlistener
     */
    public void showDialogTCBB(String title,String msg,String negativeButtonText,DialogInterface.OnClickListener negativeButtonlistener,String positiveButtonText,DialogInterface.OnClickListener positiveButtonlistener){
        if (!isCorrectContex())return;
        isShowing();
        builder = new CustomDialog.Builder(context, title, msg);
        builder.setNegativeButton(negativeButtonText,negativeButtonlistener);
        builder.setPositiveButton(positiveButtonText,positiveButtonlistener);
        dia = builder.create();
        dia.show();
    }
    public void showDialogAll(String title,String msg,int icon,String negativeButtonText,DialogInterface.OnClickListener negativeButtonlistener,String positiveButtonText,DialogInterface.OnClickListener positiveButtonlistener){
        if (!isCorrectContex())return;
        isShowing();
        builder = new CustomDialog.Builder(context, title, msg);
        builder.setIcon(icon);
        builder.setNegativeButton(negativeButtonText,negativeButtonlistener);
        builder.setPositiveButton(positiveButtonText,positiveButtonlistener);
        dia = builder.create();
        dia.show();
    }

    /**
     * 标题，内容，两个按钮，可设置样式"，默认样式传0
     * @param title
     * @param titleStyle
     * @param msg
     * @param msgStyle
     * @param negativeButtonText
     * @param leftStyle
     * @param negativeButtonlistener
     * @param positiveButtonText
     * @param rightStyle
     * @param positiveButtonlistener
     */
    public void showDialogTCBB(String title,int titleStyle,String msg,int msgStyle,String negativeButtonText,int leftStyle,DialogInterface.OnClickListener negativeButtonlistener,String positiveButtonText,int rightStyle,DialogInterface.OnClickListener positiveButtonlistener){
        if (!isCorrectContex())return;
        isShowing();
        builder = new CustomDialog.Builder(context, title, msg);
        builder.setTitleStyle(titleStyle);
        builder.setContentStyle(msgStyle);
        builder.setButtonLeftStyle(leftStyle);
        builder.setButtonRightStyle(rightStyle);
        builder.setNegativeButton(negativeButtonText,negativeButtonlistener);
        builder.setPositiveButton(positiveButtonText,positiveButtonlistener);
        dia = builder.create();
        dia.show();
    }

    /**
     * 图标，内容，两个按钮，不需要显示的内容传"",null,0
     * @param icon
     * @param msg
     * @param negativeButtonText
     * @param negativeButtonlistener
     * @param positiveButtonText
     * @param positiveButtonlistener
     */
    public void showDialogICBB(int icon,String msg,String negativeButtonText,DialogInterface.OnClickListener negativeButtonlistener,String positiveButtonText,DialogInterface.OnClickListener positiveButtonlistener){
        if (!isCorrectContex())return;
        isShowing();
        builder = new CustomDialog.Builder(context, icon, msg);
        builder.setNegativeButton(negativeButtonText,negativeButtonlistener);
        builder.setPositiveButton(positiveButtonText,positiveButtonlistener);
        dia = builder.create();
        dia.show();
    }

    /**
     * 普通Toast
     * @param msg
     */
    public void showToast(String msg){
        toast = Toast.makeText(context.getApplicationContext(), msg,
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 带图标和内容的Toast
     * @param icon
     * @param msg
     */
    public void showToastIC(int icon,String msg){
        toast = Toast.makeText(context.getApplicationContext(), msg,
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
    public void showToastPC(String msg){
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View layout = inflater.inflate(R.layout.cus_toast,
                (ViewGroup) ((Activity)context).findViewById(R.id.llToast));
        ProgressBar image = (ProgressBar) layout
                .findViewById(R.id.loading_progress);
        TextView title = (TextView) layout.findViewById(R.id.message);
        title.setVisibility(TextUtils.isEmpty(msg)?View.GONE:View.VISIBLE);
        title.setText(msg);

        toast = new Toast(context.getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
    private boolean isCorrectContex(){
        if (context instanceof Activity){
            return true;
        }
        return false;

    }
    private void isShowing(){
        if (dia !=null&&dia.isShowing()){
            dia.dismiss();
        }
    }

}
