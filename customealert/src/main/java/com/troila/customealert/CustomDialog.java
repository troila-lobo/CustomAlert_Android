package com.troila.customealert;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 白色背景，垂直居中
 *
 * @author Administrator
 *
 */

public class CustomDialog extends Dialog
{

	public CustomDialog(Context context, int theme)
	{
		super(context, theme);
	}

	public CustomDialog(Context context)
	{
		super(context);
	}

	public static class Builder
	{
		private Context context;
		private String title;
		private String message;
		private int icon;
		private String positiveButtonText;
		private String negativeButtonText;
		private OnClickListener positiveButtonClickListener;
		private OnClickListener negativeButtonClickListener;
		private int titleStyle;
		private int contentStyle;
		private int buttonLeftStyle;
		private int buttonRightStyle;
		private boolean showCloseIcon =false;

		public Builder(Context context)
		{
			this.context = context;
		}

		public Builder(Context context,String title,String msg)
		{
			this.context = context;
			this.message = msg;
			this.title = title;
		}
		public Builder(Context context,int icon,String msg)
		{
			this.context = context;
			this.message = msg;
			this.icon = icon;
		}

		public Builder setMessage(String message)
		{
			this.message = message;
			return this;
		}
		public Builder setMessage(int message)
		{
			this.message = (String) context.getText(message);
			return this;
		}

		public Builder setTitle(int title)
		{
			this.title = (String) context.getText(title);
			return this;
		}
		public Builder setTitle(String title)
		{
			this.title = title;
			return this;
		}

        public void setShowCloseIcon(boolean showCloseIcon) {
            this.showCloseIcon = showCloseIcon;
        }

        public void setIcon(int icon) {
            this.icon = icon;
        }

        public Builder setPositiveButton(int positiveButtonText, OnClickListener listener)
		{
			this.positiveButtonText = (String) context.getText(positiveButtonText);
			this.positiveButtonClickListener = listener;
			return this;
		}

		public Builder setPositiveButton(String positiveButtonText,OnClickListener listener)
		{
			this.positiveButtonText = positiveButtonText;
			this.positiveButtonClickListener = listener;
			return this;
		}

		public Builder setNegativeButton(int negativeButtonText,OnClickListener listener)
		{
			this.negativeButtonText = (String) context.getText(negativeButtonText);
			this.negativeButtonClickListener = listener;
			return this;
		}

		public Builder setNegativeButton(String negativeButtonText,OnClickListener listener)
		{
			this.negativeButtonText = negativeButtonText;
			this.negativeButtonClickListener = listener;
			return this;
		}

		public void setTitleStyle(int titleStyle) {
			this.titleStyle = titleStyle;
		}

		public void setContentStyle(int contentStyle) {
			this.contentStyle = contentStyle;
		}

		public void setButtonLeftStyle(int buttonLeftStyle) {
			this.buttonLeftStyle = buttonLeftStyle;
		}

		public void setButtonRightStyle(int buttonRightStyle) {
			this.buttonRightStyle = buttonRightStyle;
		}

		@SuppressLint("NewApi")
		public CustomDialog create()
		{
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			// instantiate the dialog with the custom Theme
			final CustomDialog dialog = new CustomDialog(context, R.style.custom_Progress);

			View layout = inflater.inflate(R.layout.dialog_text_layout, null);
			dialog.addContentView(layout, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

			// set the dialog title

            if (!TextUtils.isEmpty(title)) {
                TextView tvTitle = (TextView) layout.findViewById(R.id.lblDialogTitle);
                tvTitle.setVisibility(View.VISIBLE);
                tvTitle.setText(title);
                tvTitle.setTextAppearance(context,titleStyle);
            }

            //set close icon

                ImageView lblDialogClose = (ImageView) layout.findViewById(R.id.lblDialogClose);
                lblDialogClose.setVisibility(showCloseIcon?View.VISIBLE:View.GONE);
                lblDialogClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


            //set Icon
            if (icon!=0) {
                ImageView lblDialogIcon = (ImageView) layout.findViewById(R.id.lblDialogIcon);
                lblDialogIcon.setVisibility(View.VISIBLE);
                lblDialogIcon.setImageResource(icon);
            }
			// set the confirm button
			TextView msg = (TextView) layout.findViewById(R.id.lblDialogMessage);
			msg.setText(message);
			msg.setTextAppearance(contentStyle);
			// set the cancel button
			if (!TextUtils.isEmpty(negativeButtonText) )
			{
				TextView lblNegative = (TextView) layout.findViewById(R.id.lblNegative);
				lblNegative.setText(negativeButtonText);
				lblNegative.setTextAppearance(buttonLeftStyle);
				if (negativeButtonClickListener != null)
				{
					((TextView) layout.findViewById(R.id.lblNegative)).setOnClickListener(new View.OnClickListener()
					{
						public void onClick(View v)
						{
							negativeButtonClickListener.onClick(dialog,DialogInterface.BUTTON_NEGATIVE);
						}
					});
				}
			}
			else
			{
				layout.findViewById(R.id.lblNegative).setVisibility(View.GONE);
			}
			if (!TextUtils.isEmpty(positiveButtonText ))
			{
				TextView lblPositive = (TextView) layout.findViewById(R.id.lblPositive);
				lblPositive.setTextAppearance(buttonRightStyle);
				lblPositive.setText(positiveButtonText);
				if (positiveButtonClickListener != null)
				{
					lblPositive.setOnClickListener(new View.OnClickListener()
					{
						public void onClick(View v)
						{
							positiveButtonClickListener.onClick(dialog,DialogInterface.BUTTON_POSITIVE);
						}
					});
				}
			}
			else
			{
				layout.findViewById(R.id.lblPositive).setVisibility(View.GONE);
			}
			if (TextUtils.isEmpty(positiveButtonText)  || TextUtils.isEmpty(negativeButtonText) ){
                layout.findViewById(R.id.lblDialogLine).setVisibility(View.GONE);
            }
            if (TextUtils.isEmpty(positiveButtonText)  && TextUtils.isEmpty(negativeButtonText) ){
                layout.findViewById(R.id.lblButton).setVisibility(View.GONE);
                layout.findViewById(R.id.lblDialogCenterLine).setVisibility(View.GONE);
				lblDialogClose.setVisibility(View.VISIBLE);
            }
			dialog.setContentView(layout);
			return dialog;
		}
	}
}
