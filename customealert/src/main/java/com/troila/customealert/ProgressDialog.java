package com.troila.customealert;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * 白色背景，垂直居中
 *
 * @author Administrator
 */

public class ProgressDialog extends Dialog {

    public ProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    public ProgressDialog(Context context) {
        super(context);
    }

    public static class Builder {
        private Context context;
        private String title;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder(Context context, String title) {
            this.context = context;
            this.title = title;
        }
        public Builder setTitle(int title) {
            this.title = (String) context.getText(title);
            return this;
        }
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }
        @SuppressLint("NewApi")
        public ProgressDialog create() {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final ProgressDialog dialog = new ProgressDialog(context, R.style.custom_Progress_nobg);

            View layout = inflater.inflate(R.layout.dialog_progress, null);
            dialog.addContentView(layout, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            // set the dialog title
            if (!TextUtils.isEmpty(title)) {
                TextView tvTitle = (TextView) layout.findViewById(R.id.message);
                tvTitle.setVisibility(View.VISIBLE);
                tvTitle.setText(title);
            }
            dialog.setContentView(layout);
            return dialog;
        }
    }

}
