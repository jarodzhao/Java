package com.jarod.smzdm;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 动态权限申请
                requestPower();
            }
        });
    }

    public void requestPower() {

        // 提示框
        TextView text1 = findViewById(R.id.text1);

        // 判断是否已经有权限
        if ((checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) != 0) {

            if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                text1.setText("之前拒绝过。");
                Intent mIntent = new Intent();
                mIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                mIntent.setData(Uri.parse("package:" + getPackageName()));
                startActivity(mIntent);

            } else {

                // 显示授权窗体
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                text1.setText("开始授权...");
            }
        } else {

            // 已经有了
            text1.setText("已经有了!!!");
        }
    }

}
