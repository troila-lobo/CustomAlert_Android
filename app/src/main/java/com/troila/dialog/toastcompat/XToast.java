package com.troila.dialog.toastcompat;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.troila.dialog.R;

public class XToast {
    private static TextView tv;
    public static final int LENGTH_LONG = 3500; // 3.5 seconds
    public static final int LENGTH_SHORT = 2000; // 2 seconds

    private static View mNextView;
    private static int mGravity, mX, mY;
    private static final WindowManager.LayoutParams mParams = new WindowManager.LayoutParams();
    private static WindowManager mWM;
    private static Handler mHanlder = new Handler();

    /**
     * init
     * @param context
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private static void init(Context context) {
        mY = 14;
        mGravity = 7;
        LayoutInflater inflate = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mNextView = inflate.inflate(R.layout.transient_toast, null);
        TextView tv = (TextView) mNextView.findViewById(android.R.id.message);

        mParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        mParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        mParams.format = PixelFormat.TRANSLUCENT;
        mParams.windowAnimations = R.style.Animation_Toast;
        mParams.type = WindowManager.LayoutParams.TYPE_TOAST;
        mParams.setTitle("Toast");
        mParams.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;


        mWM = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        // We can resolve the Gravity here by using the Locale for getting
        // the layout direction
        final Configuration config = mNextView.getContext().getResources().getConfiguration();
        final int gravity = Gravity.getAbsoluteGravity(mGravity, config.getLayoutDirection());
        mParams.gravity = gravity;
        if ((gravity & Gravity.HORIZONTAL_GRAVITY_MASK) == Gravity.FILL_HORIZONTAL) {
            mParams.horizontalWeight = 1.0f;
        }
        if ((gravity & Gravity.VERTICAL_GRAVITY_MASK) == Gravity.FILL_VERTICAL) {
            mParams.verticalWeight = 1.0f;
        }
        mParams.x = mX;
        mParams.y = mY;
//        mParams.verticalMargin = mVerticalMargin;
//        mParams.horizontalMargin = mHorizontalMargin;
        mParams.packageName = context.getPackageName();
    }

    /**
     * Show the view for the specified duration.
     * @param context
     * @param text
     * @param duration
     */
    public static void show(final Context context, final CharSequence text, int duration) {
        if (context == null) {
            throw new RuntimeException("context is null");
        }

        if (mWM == null || mNextView == null) {
            init(context);
        }
        mHanlder.removeCallbacks(cancelRunable);
        mHanlder.post(new Runnable() {
            @Override
            public void run() {
                ((TextView) mNextView.findViewById(R.id.message)).setText(text);
                if (mNextView.getParent() != null)
                    mWM.removeView(mNextView);

                mWM.addView(mNextView, mParams);
            }
        });
        mHanlder.postDelayed(cancelRunable, duration);
    }

    private static Runnable cancelRunable = new Runnable() {
        @Override
        public void run() {
            cancel();
        }
    };

    /**
     * cancel toast
     */
    public static void cancel() {
        if (mNextView != null && mNextView.getParent() != null)
            mWM.removeViewImmediate(mNextView);
    }
}

