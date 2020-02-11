package com.troila.customealert;

import android.annotation.SuppressLint;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

import com.troila.customealert.utils.Utils;

/**
 * 白色背景，垂直居中
 *
 * @author Administrator
 */

public class CustomDialog extends Dialog{

    public CustomDialog(Context context, int theme) {
        super(context, theme);
    }

    public CustomDialog(Context context) {
        super(context);
    }

    public static class Builder {
        private Context context;
        private String title;
        private String message;

        private String iconType;
        private String positiveButtonText;
        private String negativeButtonText;
        private OnClickListener positiveButtonClickListener;
        private OnClickListener negativeButtonClickListener;

        private String titleColor;
        private String contentColor;
        private String buttonLeftColor;
        private String buttonRightColor;

        private float titleSize;
        private float contentSize;
        private float buttonLeftSize;
        private float buttonRightSize;


        private boolean showCloseIcon = false;
        private boolean cancelOutSide = true;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder(Context context, String title, String msg) {
            this.context = context;
            this.message = msg;
            this.title = title;
        }
        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setMessage(int message) {
            this.message = (String) context.getText(message);
            return this;
        }

        public Builder setTitle(int title) {
            this.title = (String) context.getText(title);
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setShowCloseIcon(boolean showCloseIcon) {
            this.showCloseIcon = showCloseIcon;
            return this;
        }

        public Builder setTitleColor(String titleColor) {
            this.titleColor = titleColor;
            return this;
        }

        public Builder setContentColor(String contentColor) {
            this.contentColor = contentColor;
            return this;
        }

        public Builder setButtonLeftColor(String buttonLeftColor) {
            this.buttonLeftColor = buttonLeftColor;
            return this;
        }

        public Builder setButtonRightColor(String buttonRightColor) {
            this.buttonRightColor = buttonRightColor;
            return this;
        }

        public Builder setTitleSize(float titleSize) {
            this.titleSize = titleSize;
            return this;
        }

        public Builder setContentSize(float contentSize) {
            this.contentSize = contentSize;
            return this;
        }

        public Builder setButtonLeftSize(float buttonLeftSize) {
            this.buttonLeftSize = buttonLeftSize;
            return this;
        }

        public Builder setButtonRightSize(float buttonRightSize) {
            this.buttonRightSize = buttonRightSize;
            return this;
        }

        public Builder setIconType(String iconType) {
            this.iconType = iconType;
            return this;
        }

        public Builder setPositiveButton(int positiveButtonText, OnClickListener listener) {
            this.positiveButtonText = (String) context.getText(positiveButtonText);
            this.positiveButtonClickListener = listener;
            return this;
        }

        public Builder setPositiveButton(String positiveButtonText, OnClickListener listener) {
            this.positiveButtonText = positiveButtonText;
            this.positiveButtonClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(int negativeButtonText, OnClickListener listener) {
            this.negativeButtonText = (String) context.getText(negativeButtonText);
            this.negativeButtonClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(String negativeButtonText, OnClickListener listener) {
            this.negativeButtonText = negativeButtonText;
            this.negativeButtonClickListener = listener;
            return this;
        }

        public Builder setCancelOutSide(boolean cancelOutSide) {
            this.cancelOutSide = cancelOutSide;
            return this;
        }

        @SuppressLint("NewApi")
        public CustomDialog create() {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // instantiate the dialog with the custom Theme
            final CustomDialog dialog = new CustomDialog(context, R.style.custom_Progress);

            View layout = inflater.inflate(R.layout.dialog_text_layout, null);

            dialog.addContentView(layout, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            dialog.setCanceledOnTouchOutside(cancelOutSide);
            // set the dialog title

            if (!TextUtils.isEmpty(title)) {
                TextView tvTitle = (TextView) layout.findViewById(R.id.lblDialogTitle);
                tvTitle.setVisibility(View.VISIBLE);
                tvTitle.setText(title);
                if (!TextUtils.isEmpty(titleColor)) {
                    tvTitle.setTextColor(Color.parseColor(titleColor));
                }
                if (titleSize != 0) {
                    tvTitle.setTextSize(titleSize);
                }
            }

            //set close icon

            ImageView lblDialogClose = (ImageView) layout.findViewById(R.id.lblDialogClose);
            View lblDialogCloseLine = (View) layout.findViewById(R.id.lblDialogCloseLine);
            lblDialogClose.setVisibility(showCloseIcon ? View.VISIBLE : View.GONE);
            lblDialogCloseLine.setVisibility(showCloseIcon ?View.VISIBLE : View.GONE);
            lblDialogClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });


            //set Icon
            if (0 !=Utils.getIcon(iconType)) {
                ImageView lblDialogIcon = (ImageView) layout.findViewById(R.id.lblDialogIcon);
                lblDialogIcon.setVisibility(View.VISIBLE);
                lblDialogIcon.setImageResource(Utils.getIcon(iconType));
            }

            // set the confirm button
            TextView msg = (TextView) layout.findViewById(R.id.lblDialogMessage);
            msg.setText(message);
            if (!TextUtils.isEmpty(contentColor)) {
                msg.setTextColor(Color.parseColor(contentColor));
            }
            if (contentSize != 0) {
                msg.setTextSize(contentSize);
            }
            // set the cancel button
            if (!TextUtils.isEmpty(negativeButtonText)) {
                TextView lblNegative = (TextView) layout.findViewById(R.id.lblNegative);
                lblNegative.setText(negativeButtonText);
                if (!TextUtils.isEmpty(buttonLeftColor)) {
                    lblNegative.setTextColor(Color.parseColor(buttonLeftColor));
                }
                if (buttonLeftSize != 0) {
                    lblNegative.setTextSize(buttonLeftSize);
                }
                if (negativeButtonClickListener != null) {
                    ((TextView) layout.findViewById(R.id.lblNegative)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            negativeButtonClickListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);
                            if (dialog !=null &&dialog.isShowing()){
                                dialog.dismiss();
                            }
                        }
                    });
                }
            } else {
                layout.findViewById(R.id.lblNegative).setVisibility(View.GONE);
            }
            if (!TextUtils.isEmpty(positiveButtonText)) {
                TextView lblPositive = (TextView) layout.findViewById(R.id.lblPositive);
                if (!TextUtils.isEmpty(buttonRightColor)) {
                    lblPositive.setTextColor(Color.parseColor(buttonRightColor));
                }
                if (buttonRightSize != 0) {
                    lblPositive.setTextSize(buttonRightSize);
                }
                lblPositive.setText(positiveButtonText);
                if (positiveButtonClickListener != null) {
                    lblPositive.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            positiveButtonClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
                            if (dialog !=null &&dialog.isShowing()){
                                dialog.dismiss();
                            }
                        }
                    });
                }
            } else {
                layout.findViewById(R.id.lblPositive).setVisibility(View.GONE);
            }
            if (TextUtils.isEmpty(positiveButtonText) || TextUtils.isEmpty(negativeButtonText)) {
                layout.findViewById(R.id.lblDialogLine).setVisibility(View.GONE);
            }
            if (TextUtils.isEmpty(positiveButtonText) && TextUtils.isEmpty(negativeButtonText)) {
                layout.findViewById(R.id.lblButton).setVisibility(View.GONE);
                layout.findViewById(R.id.lblDialogCenterLine).setVisibility(View.GONE);
                lblDialogClose.setVisibility(View.VISIBLE);
                lblDialogCloseLine.setVisibility(View.VISIBLE);
            }
            dialog.setContentView(layout);
            return dialog;
        }
        private int  getwidth(Context context){
            Resources resources = context.getResources();
            DisplayMetrics dm = resources.getDisplayMetrics();
            float density = dm.density;
            int width = dm.widthPixels;
            return width;
        }
    }


}
