package com.troila.customealert;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;

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

    //    AntiShake util = new AntiShake();
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
    public void showDialog(String title, String msg, String negativeButtonText, DialogInterface.OnClickListener negativeButtonlistener, String positiveButtonText, DialogInterface.OnClickListener positiveButtonlistener) {
        if (!isCorrectContex()) return;
        isShowing();
        builder = new CustomDialog.Builder(context, title, msg);
        builder.setNegativeButton(negativeButtonText, negativeButtonlistener);
        builder.setPositiveButton(positiveButtonText, positiveButtonlistener);
        builder.setCancelOutSide(false);
        dia = builder.create();
        dia.show();
    }


    /**
     * @param title
     * @param msg
     * @param positiveButtonText
     * @param positiveButtonlistener
     */
    public void showDialog(String title, String msg, String positiveButtonText, DialogInterface.OnClickListener positiveButtonlistener) {
//        if (util.check("111111")) return;
        if (!isCorrectContex()) return;
        isShowing();
        builder = new CustomDialog.Builder(context, title, msg);
        builder.setPositiveButton(positiveButtonText, positiveButtonlistener);
        dia = builder.create();
        dia.show();
    }

    /**
     * @param msg
     * @param positiveButtonText
     * @param positiveButtonlistener
     */
    public void showDialog(String msg, String positiveButtonText, DialogInterface.OnClickListener positiveButtonlistener) {
        if (!isCorrectContex()) return;
        isShowing();
        builder = new CustomDialog.Builder(context, "", msg);
        builder.setPositiveButton(positiveButtonText, positiveButtonlistener);
        dia = builder.create();
        dia.show();
    }

    /**
     * 仅显示内容
     *
     * @param msg
     */
    public void showDialog(String msg) {
        if (!isCorrectContex()) return;
        isShowing();
        builder = new CustomDialog.Builder(context, "", msg);
        dia = builder.create();
        dia.show();
    }

    /**
     * 标题，内容，两个按钮，可设置样式"，默认样式传0
     *
     * @param title
     * @param msg
     * @param negativeButtonText
     * @param negativeButtonlistener
     * @param positiveButtonText
     * @param positiveButtonlistener
     */
    public void showDialog(String title, String titleColor, int titleSize,
                           String msg, String msgColor, int msgSize,
                           String iconType,
                           String negativeButtonText, String negativeButtonTextColor, int negativeButtonTextSize,
                           DialogInterface.OnClickListener negativeButtonlistener,
                           String positiveButtonText, String positiveButtonTextColor, int positiveButtonTextSize,
                           DialogInterface.OnClickListener positiveButtonlistener) {
        if (!isCorrectContex()) return;
        isShowing();
        new CustomDialog.Builder(context, title, msg).setTitleColor(titleColor).setTitleSize(titleSize)
                .setContentColor(msgColor).setContentSize(msgSize)
                .setButtonLeftColor(negativeButtonTextColor).setContentSize(negativeButtonTextSize)
                .setButtonRightColor(positiveButtonTextColor).setContentSize(positiveButtonTextSize)
                .setIconType(iconType)

                .setNegativeButton(negativeButtonText, negativeButtonlistener)
                .setPositiveButton(positiveButtonText, positiveButtonlistener);
        dia = builder.create();
        dia.show();
    }

    public void showDialog(String title,
                           String msg,
                           String iconType,
                           String negativeButtonText,
                           DialogInterface.OnClickListener negativeButtonlistener,
                           String positiveButtonText,
                           DialogInterface.OnClickListener positiveButtonlistener) {
        if (!isCorrectContex()) return;
        isShowing();
        builder = new CustomDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(msg)
                .setIconType(iconType)
                .setCancelOutSide(true)
                .setNegativeButton(negativeButtonText, negativeButtonlistener)
                .setPositiveButton(positiveButtonText, positiveButtonlistener).create().show();
    }


    private boolean isCorrectContex() {
        if (context instanceof Activity) {
            return true;
        }
        return false;

    }

    private void isShowing() {
        if (dia != null && dia.isShowing()) {
            dia.dismiss();
        }
    }


}
