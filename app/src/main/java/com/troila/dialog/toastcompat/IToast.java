package com.troila.dialog.toastcompat;

import android.content.Context;

import com.troila.customealert.EToast2;


/**
 * Created by admin on 2017/3/20.
 */

public class IToast {
    public static void show(Context context, String text) {
        com.troila.dialog.toastcompat.Toast.makeText(context, text, EToast2.LENGTH_SHORT).show();
    }

}
