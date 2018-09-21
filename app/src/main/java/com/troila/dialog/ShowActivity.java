package com.troila.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.troila.customealert.CustomAlert;
import com.troila.customealert.CustomDialog;
import com.troila.customealert.CustomToast;

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
                customAlert.showDialogOnlyContent("文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容内容文字内容文字内容文字内容内容文字内容文字内容文字内容内容文字内容文字内容文字内容");
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customAlert.showDialogTCBB("标题", "文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容内容文字内容文字内容文字内容内容文字内容文字内容文字内容内容文字内容文字内容文字内容", "按钮", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }, "按钮", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customAlert.showDialogTCBB("标题", "文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容内容文字内容文字内容文字内容内容文字内容文字内容文字内容内容文字内容文字内容文字内容", "按钮", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }, "按钮", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customAlert.showDialogTCBB("标题", "文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容内容文字内容文字内容文字内容内容文字内容文字内容文字内容内容文字内容文字内容文字内容", "按钮", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }, "按钮", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
            }
        });
        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customAlert.showDialogTCBB("", "文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容内容文字内容文字内容文字内容内容文字内容文字内容文字内容内容文字内容文字内容文字内容", "按钮", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }, "", null);
            }
        });
        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customAlert.showDialogICBB(R.drawable.img_error, "文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容内容文字内容文字内容文字内容内容文字内容文字内容文字内容内容文字内容文字内容文字内容", "", null,"按钮", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
            }
        });
        findViewById(R.id.btn6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomToast.showToast(ShowActivity.this,"文字内容文字内容文字内容文字内容文字内容");
            }
        });
        findViewById(R.id.btn7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomToast.showToastIC(ShowActivity.this,R.drawable.img_error, "文字内容文字内容文字内容文字内容文字内容");
            }
        });
        findViewById(R.id.btn8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomToast.showToastPC(ShowActivity.this,"文字内容文字内容文字内容文字内容文字内容");
            }
        });
        findViewById(R.id.btn9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customAlert.showDialogTCBBStyle("标题",R.style.titleStyle, "文字内容文字内容文字内字内内容文字内容文字内容文字内容文字内容",0,R.style.msgStyle, "left",R.style.titleStyle,null, "right",0, null);

            }
        });
        findViewById(R.id.btn10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customAlert.showDialogAll("标题" ,"文字内容文字内容文字内字内内容文字内容文字内容文字内容文字内容", R.drawable.img_error,"left",null, "right", null);
                customAlert.showDialogAll("标题" ,"文字内容文字内容文字内字内内容文字内容文字内容文字内容文字内容", R.drawable.img_error,"left",null, "right", null);

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
}
