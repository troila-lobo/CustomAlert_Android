package com.troila.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 透明背景，垂直居中
 *
 * @author Administrator
 *
 */

public class ToastDialog extends Dialog
{
	private static Timer timer;
	private static Handler handler;

	public ToastDialog(Context context, int theme)
	{
		super(context, theme);
	}

	public ToastDialog(Context context)
	{
		super(context);
	}

	public static class Builder
	{
		private Context context;
		private String message;
		private int icon;
		private boolean showCloseIcon =false;
		private boolean showProgressbar =false;
		private Long time = 2000L;

		public Builder(Context context)
		{
			this.context = context;
		}

		public Builder(Context context,String msg,Long time)
		{
			this.context = context;
			this.message = msg;
			this.time=time;

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

        public void setShowCloseIcon(boolean showCloseIcon) {
            this.showCloseIcon = showCloseIcon;
        }

		public void setShowProgressbar(boolean showProgressbar) {
			this.showProgressbar = showProgressbar;
		}

		public void setIcon(int icon) {
            this.icon = icon;
        }


		public ToastDialog create()
		{
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			// instantiate the dialog with the custom Theme
			final ToastDialog dialog = new ToastDialog(context, R.style.custom_Progress_nobg);
			View layout = inflater.inflate(R.layout.transient_toast, null);
			dialog.addContentView(layout, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            //set close icon
            if (showCloseIcon) {
                ImageView lblDialogClose = (ImageView) layout.findViewById(R.id.lblDialogClose);
                lblDialogClose.setVisibility(View.VISIBLE);
                lblDialogClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
            if (showProgressbar) {
				ProgressBar progressBar = (ProgressBar) layout.findViewById(R.id.loading_progress);
				progressBar.setVisibility(View.VISIBLE);
            }
            //set Icon
            if (icon!=0) {
                ImageView lblDialogIcon = (ImageView) layout.findViewById(R.id.lblDialogIcon);
                lblDialogIcon.setVisibility(View.VISIBLE);
                lblDialogIcon.setImageResource(icon);
            }
			// set message
			if (!TextUtils.isEmpty(message)){

				TextView lblmessage = (TextView) layout.findViewById(R.id.message);
				lblmessage.setVisibility(View.VISIBLE);
				lblmessage.setText(message);
			}

			dialog.setContentView(layout);
			if(handler == null){
				handler = new Handler(){
					@Override
					public void handleMessage(Message msg) {
						dialog.dismiss();
					}
				};
			}
			dialog.setOnShowListener(new OnShowListener() {
				@Override
				public void onShow(DialogInterface dialog) {
					timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							handler.sendEmptyMessage(1);
						}
					}, time);
				}
			});
			dialog.setOnDismissListener(new OnDismissListener() {
				@Override
				public void onDismiss(DialogInterface dialog) {
					if (timer!=null){
						timer.cancel();
					}
					if (handler!=null){
						handler.removeCallbacksAndMessages(null);
					}
				}
			});
			return dialog;
		}
	}
}
