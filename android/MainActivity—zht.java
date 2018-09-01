package com.jarod.smzdm;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
        // 判断是否已经有权限
        if ((checkSelfPermission(Manifest.permission_group.STORAGE)) != 0) {
            if (shouldShowRequestPermissionRationale(Manifest.permission_group.STORAGE)) {
                Log.d("zht", "onCreate: 之前拒绝了！");
                Intent mIntent = new Intent();
                mIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                mIntent.setData(Uri.fromParts("", getPackageName(), null));
                startActivity(mIntent);
            } else {
                // 显示授权窗体
                requestPermissions(new String[]{Manifest.permission_group.STORAGE}, 100);
                Log.d("zht", "onCreate: 开始授权");
            }
        } else {
            // 已经有了
            Log.d("zht", "onCreate: 已经有了！");
        }
    }

}
