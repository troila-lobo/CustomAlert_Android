package com.troila.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.troila.customealert.CustomAlert;
import com.troila.customealert.CustomDialog;
import com.troila.customealert.CustomToast;
import com.troila.customealert.ProgressDialog;
import com.troila.customealert.helper.CommonDialogFragment;
import com.troila.customealert.helper.DialogFragmentHelper;

public class ShowActivity extends AppCompatActivity {
    CustomAlert customAlert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        customAlert = new CustomAlert(this);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customAlert.showDialog("文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容内容文字内容文字内容文字内容内容文字内容文字内容文字内容内容文字内容文字内容文字内容");
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragmentHelper.showConfirmDialog(getSupportFragmentManager(), "是否选择 Android？", true);
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonDialogFragment dialogFragment = CommonDialogFragment.newInstance(new CommonDialogFragment.OnCallDialog() {
                    @Override
                    public Dialog getDialog(Context context) {
                        return  new CustomDialog.Builder(context)
                                .setTitle("123")
                                .setMessage("123")
                                .setIconType("fail")
                                .setNegativeButton("no", null)
                                .setPositiveButton("ok", null).create();
                    }
                }, true);
                dialogFragment.show(getSupportFragmentManager(), "123");
            }
        });
        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customAlert.showDialog("", "文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容内容文字内容文字内容文字内容内容文字内容文字内容文字内容内容文字内容文字内容文字内容", "按钮", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }, "", null);
            }
        });
        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customAlert.showDialog("success", "文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容内容文字内容文字内容文字内容内容文字内容文字内容文字内容内容文字内容文字内容文字内容", "", null,"按钮", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
            }
        });
        findViewById(R.id.btn6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.widget.Toast.makeText(ShowActivity.this,"系统",android.widget.Toast.LENGTH_SHORT).show();
                CustomToast.showToast(ShowActivity.this,"", "文字");
                      }
        });
        findViewById(R.id.btn7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomToast.showToast(ShowActivity.this,"success", "文字");
            }
        });
        findViewById(R.id.btn8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ProgressDialog.Builder(ShowActivity.this)
                        .setTitle("").create().show();
            }
        });
        findViewById(R.id.btn9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customAlert.showDialog("标题","#123123",11,
                "内容","#123123",11,"success",

                 "left","#123123",11,
                 null,
                 "right","#123123",11,
                 null);

            }
        });
        findViewById(R.id.btn10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customAlert.showDialog("标题" , "文字内容","success","left",null, "right", null);
                customAlert.showDialog("标题" ,"success","文字内容文字内容文字内字内内容文字内容文字内容文字内容文字内容","left",null, "right", null);

            }
        });
        findViewById(R.id.btn11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog.Builder builder = new CustomDialog.Builder(ShowActivity.this, "标题", "文字内容文字内容文");
                CustomDialog dia = builder.create();
                dia.show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
