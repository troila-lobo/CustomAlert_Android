package com.troila.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.troila.customealert.CustomDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog.Builder builder = new CustomDialog.Builder(MainActivity.this, "标题", "文字内容文字内容" +
                        "aaaabbbbbbcccccccddddddddrrrrrrrrggggg字内容文字内容");
                builder.setIconType("success");
                builder.setNegativeButton("离开", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"NegativeButton",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("等待", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"PositiveButton",Toast.LENGTH_SHORT).show();
                    }
                });
                CustomDialog dia = builder.create();
                dia.show();
            }
        });
        findViewById(R.id.show2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog.Builder builder = new CustomDialog.Builder(MainActivity.this, "success", "文字内容文字内容\n" +
                        "文字内容文字内容文字内容");
                builder.setNegativeButton("离开", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"NegativeButton",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("等待", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"PositiveButton",Toast.LENGTH_SHORT).show();
                    }
                });
                CustomDialog dia = builder.create();
                dia.show();
            }
        });
        findViewById(R.id.show3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog.Builder builder = new CustomDialog.Builder(MainActivity.this, "", "文字内容文字内容\n" +
                        "文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容文字内容");

//                builder.setNegativeButton("确认", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this,"PositiveButton",Toast.LENGTH_SHORT).show();
//                    }
//                });
                CustomDialog dia = builder.create();
                dia.show();
            }
        });
        findViewById(R.id.show4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog.Builder builder = new CustomDialog.Builder(MainActivity.this, "success", "文字内容文字内容\n" +
                        "文字内容文字内容文字内容");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"PositiveButton",Toast.LENGTH_SHORT).show();
                    }
                });
                CustomDialog dia = builder.create();
                dia.show();
            }
        });
        findViewById(R.id.show5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastDialog.Builder builder = new ToastDialog.Builder(MainActivity.this, R.drawable.img_error, "文字内容文字内容\n" +
                        "文字内容文字内容文字内容");
                ToastDialog dia = builder.create();
                dia.show();
            }
        });
        findViewById(R.id.show6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast toast = Toast.makeText(getApplicationContext(), "带图片的Toast",
                        Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                LinearLayout toastView = (LinearLayout) toast.getView();
                ImageView imageCodeProject = new ImageView(getApplicationContext());
                imageCodeProject.setImageResource(R.drawable.img_error);
                toastView.addView(imageCodeProject, 0);
                toast.show();
            }
        });
       findViewById(R.id.show7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.cus_toast,
                        (ViewGroup) findViewById(R.id.llToast));
                ProgressBar image = (ProgressBar) layout
                        .findViewById(R.id.loading_progress);
                TextView title = (TextView) layout.findViewById(R.id.message);
                title.setText("Attention");
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
            }
        });

    }
}
