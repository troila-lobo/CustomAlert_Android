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

    public CustomAlert(Context context) {
        this.context = context;
    }

    /**
     * @param title
     * @param msg
     * @param negativeButtonText
     * @param negativeButtonlistener
     * @param positiveButtonText
     * @param positiveButtonlistener
     */
    public void showDialog(String title,String msg,String negativeButtonText,DialogInterface.OnClickListener negativeButtonlistener,String positiveButtonText,DialogInterface.OnClickListener positiveButtonlistener){
        if (!isCorrectContex())return;
        isShowing();
        builder = new CustomDialog.Builder(context, title, msg);
        builder.setNegativeButton(negativeButtonText,negativeButtonlistener);
        builder.setPositiveButton(positiveButtonText,positiveButtonlistener);
        dia = builder.create();
        dia.show();
    }

    /**
     *
     * @param icon
     * @param msg
     * @param negativeButtonText
     * @param negativeButtonlistener
     * @param positiveButtonText
     * @param positiveButtonlistener
     */
    public void showDialog(int icon,String msg,String negativeButtonText,DialogInterface.OnClickListener negativeButtonlistener,String positiveButtonText,DialogInterface.OnClickListener positiveButtonlistener){
        if (!isCorrectContex())return;
        isShowing();
        builder = new CustomDialog.Builder(context, icon, msg);
        builder.setNegativeButton(negativeButtonText,negativeButtonlistener);
        builder.setPositiveButton(positiveButtonText,positiveButtonlistener);
        dia = builder.create();
        dia.show();
    }

    /**
     *
     * @param title
     * @param msg
     * @param positiveButtonText
     * @param positiveButtonlistener
     */
    public void showDialog(String title,String msg,String positiveButtonText,DialogInterface.OnClickListener positiveButtonlistener){
        if (!isCorrectContex())return;
        isShowing();
        builder = new CustomDialog.Builder(context, title, msg);
        builder.setPositiveButton(positiveButtonText,positiveButtonlistener);
        dia = builder.create();
        dia.show();
    }

    /**
     *
     * @param icon
     * @param msg
     * @param positiveButtonText
     * @param positiveButtonlistener
     */
    public void showDialog(int icon,String msg,String positiveButtonText,DialogInterface.OnClickListener positiveButtonlistener){
        if (!isCorrectContex())return;
        isShowing();
        builder = new CustomDialog.Builder(context, icon, msg);
        builder.setPositiveButton(positiveButtonText,positiveButtonlistener);
        dia = builder.create();
        dia.show();
    }

    /**
     *
     * @param msg
     * @param positiveButtonText
     * @param positiveButtonlistener
     */
    public void showDialog(String msg,String positiveButtonText,DialogInterface.OnClickListener positiveButtonlistener){
        if (!isCorrectContex())return;
        isShowing();
        builder = new CustomDialog.Builder(context, "", msg);
        builder.setPositiveButton(positiveButtonText,positiveButtonlistener);
        dia = builder.create();
        dia.show();
    }
    /**
     * 仅显示内容
     * @param msg
     */
    public void showDialog(String msg){
        if (!isCorrectContex())return;
        isShowing();
        builder = new CustomDialog.Builder(context, "", msg);
        dia = builder.create();
        dia.show();
    }
    /**
     * 标题，图标，内容，两个按钮，不需要显示的内容传"",null,0
     * @param title
     * @param msg
     * @param negativeButtonText
     * @param negativeButtonlistener
     * @param positiveButtonText
     * @param positiveButtonlistener
     */
    public void showDialog(String title,int icon,String msg,String negativeButtonText,DialogInterface.OnClickListener negativeButtonlistener,String positiveButtonText,DialogInterface.OnClickListener positiveButtonlistener){
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
     * @param msg
     * @param negativeButtonText
     * @param negativeButtonlistener
     * @param positiveButtonText
     * @param positiveButtonlistener
     */
    public void showDialog(String title,String titleColor,int titleSize,
                           String msg,String msgColor,int msgSize,
                           int icon,
                           String negativeButtonText, String negativeButtonTextColor,int negativeButtonTextSize,
                           DialogInterface.OnClickListener negativeButtonlistener,
                           String positiveButtonText,String positiveButtonTextColor,int positiveButtonTextSize,
                            DialogInterface.OnClickListener positiveButtonlistener){
        if (!isCorrectContex())return;
        isShowing();

        builder = new CustomDialog.Builder(context, title, msg);
        builder.setIcon(icon);
        builder.setNegativeButton(negativeButtonText,negativeButtonlistener);
        builder.setPositiveButton(positiveButtonText,positiveButtonlistener);
        dia = builder.create();
        dia.show();
    }

    public void showSuccessDialog(String title,String msg,String negativeButtonText,DialogInterface.OnClickListener negativeButtonlistener,String positiveButtonText,DialogInterface.OnClickListener positiveButtonlistener){
        showDialog(title,R.drawable.image_correct,msg,negativeButtonText,negativeButtonlistener,positiveButtonText,positiveButtonlistener);
    }
    public void showErrorDialog(String title,String msg,String negativeButtonText,DialogInterface.OnClickListener negativeButtonlistener,String positiveButtonText,DialogInterface.OnClickListener positiveButtonlistener){
        showDialog(title,R.drawable.img_error,msg,negativeButtonText,negativeButtonlistener,positiveButtonText,positiveButtonlistener);
    }
    public void showPromptDialog(String title,String msg,String negativeButtonText,DialogInterface.OnClickListener negativeButtonlistener,String positiveButtonText,DialogInterface.OnClickListener positiveButtonlistener){
        showDialog(title,R.drawable.image_prompt,msg,negativeButtonText,negativeButtonlistener,positiveButtonText,positiveButtonlistener);
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
