package com.troila.customealert.custoast;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.troila.customealert.R;
import com.troila.customealert.utils.Utils;

public class ToastUtils {

    public static final int LENGTH_SHORT = 0x00;
    public static final int LENGTH_LONG = 0x01;
    private static ToastUtils mInstance;
    // 动画时间
    private final int ANIMATION_DURATION = 600;
    private static TextView mTextView;
    private static ImageView iconImage;
    private ViewGroup container;
    private View mView;
    // 默认展示时间
    private int HIDE_DELAY = 2000;
    private static LinearLayout mContainer;
    private static AlphaAnimation mFadeOutAnimation;
    private AlphaAnimation mFadeInAnimation;
    private static boolean isShow = false;
    private static Context mContext;
    private static Handler mHandler = new Handler();

    private ToastUtils(Context context) {
        mContext = context;
        container = (ViewGroup) ((Activity) context)
                .findViewById(android.R.id.content);

        mView = ((Activity) context).getLayoutInflater().inflate(
                R.layout.toast_layout, container);

        mContainer = (LinearLayout) mView.findViewById(R.id.mbContainer);

        mContainer.setVisibility(View.GONE);
        mTextView = (TextView) mView.findViewById(R.id.mbMessage);
        iconImage = (ImageView) mView.findViewById(R.id.dialog_icon);
    }

    public static ToastUtils makeText(Context context, String message,String icon,
                                      int HIDE_DELAY) {
//         if (mInstance == null) {
//             mInstance = new ToastUtils(context);
//         } else {
//             // 考虑Activity切换时，Toast依然显示
//             if (!mContext.getClass().getName().endsWith(context.getClass().getName())) {
//                 mInstance = new ToastUtils(context);
//             }
//         }
          reset();
            mInstance = new ToastUtils(context);

        if (HIDE_DELAY == LENGTH_LONG) {
            mInstance.HIDE_DELAY = 2500;
        } else {
            mInstance.HIDE_DELAY = 1500;
        }
        mTextView.setText(message);
        mTextView.setVisibility(View.VISIBLE);
        if (!TextUtils.isEmpty(icon)) {
            mContainer.setGravity(Gravity.CENTER);
            iconImage.setVisibility(View.VISIBLE);
        }else {
            mContainer.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL);
            iconImage.setVisibility(View.GONE);
        }
        iconImage.setImageResource(Utils.getIconWhite(icon));
        return mInstance;
    }

    public static ToastUtils makeText(Context context, int resId, int HIDE_DELAY) {
        String mes = "";
        try {
            mes = context.getResources().getString(resId);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
        return makeText(context, mes,"", HIDE_DELAY);
    }

    public void show() {
        if (isShow) {
            // 若已经显示，则不再次显示
            return;
        }
        isShow = true;
        // 显示动画
        mFadeInAnimation = new AlphaAnimation(0.0f, 1.0f);
        // 消失动画
        mFadeOutAnimation = new AlphaAnimation(1.0f, 0.0f);
        mFadeOutAnimation.setDuration(ANIMATION_DURATION);
        mFadeOutAnimation
                .setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        // 消失动画后更改状态为 未显示
                        isShow = false;
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        // 隐藏布局，不使用remove方法为防止多次创建多个布局
                        mContainer.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
        mContainer.setVisibility(View.VISIBLE);

        mFadeInAnimation.setDuration(ANIMATION_DURATION);

        mContainer.startAnimation(mFadeInAnimation);
        mHandler.postDelayed(mHideRunnable, HIDE_DELAY);
    }

    private static final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            mContainer.startAnimation(mFadeOutAnimation);
        }
    };

    public static void cancel() {
        if (isShow) {
            isShow = false;
            mContainer.setVisibility(View.GONE);
            mHandler.removeCallbacks(mHideRunnable);
        }
    }

    /**
     * 此方法主要为了解决用户在重启页面后单例还会持有上一个context，
     * 且上面的mContext.getClass().getName()其实是一样的
     * 所以使用上还需要在BaseActivity的onDestroy()方法中调用
     */
    public static void reset() {
//        mInstance = null;
        cancel();

    }

    public void setText(CharSequence s) {
        if (mInstance == null) return;

        TextView mTextView = (TextView) mView.findViewById(R.id.mbMessage);
        if (mTextView == null) {
            throw new RuntimeException(
                    "This Toast was not created with Toast.makeText()"
            );
        }
        mTextView.setText(s);
    }

    public void setText(int resId) {
        setText(mContext.getText(resId));
    }
}