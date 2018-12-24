package com.troila.dialog.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.troila.customealert.CustomToast;
import com.troila.customealert.custoast.ToastUtils;
import com.troila.dialog.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n);
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),TestActivity.class));
                CustomToast.showToast(MainActivity.this,"warning",""+App.num);
                App.num++;

            }
        });
    }
//
    @Override
    protected void onPause() {
        super.onPause();
        ToastUtils.reset();
    }
}
