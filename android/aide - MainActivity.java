package com.jarod.smzdm;

import android.app.*;
import android.os.*;

import android.database.sqlite.*;
import android.widget.*;
import android.database.*;
import java.util.logging.*;
import java.io.*;
import android.util.*;
import android.text.*;
import android.view.*;
import android.content.*;
import android.content.pm.*;
import android.*;
import android.view.View.*;
import java.security.acl.*;
import android.net.*;

public class MainActivity extends Activity 
{
	//String smzdm = "/storage/emulated/0/1";
	TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		//增加动态获取权
		text1 = (TextView) findViewById(R.id.text1);
		Button button1 = (Button) findViewById(R.id.button1);

		button1.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View view)
				{
					checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
					//text1.setText("");
				}
			});
	}

	// 正常获取权限

    private void checkPermission(String permission)
	{
        // 判断是否同意此权限
        if (checkSelfPermission(permission) != 0)
		{
			// 如果应用之前请求过此权限但用户拒绝了请求，此方法将返回 true
			if (shouldShowRequestPermissionRationale(permission))
			{
				text1.setText("之前请求过，但是被拒绝了！");
				Toast.makeText(this, "你之前拒绝过此权限", Toast.LENGTH_SHORT).show();
				
				// 跳到应用设置界面
				Intent mIntent = new Intent();
				mIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
				mIntent.setData(Uri.fromParts("package", getPackageName(), null));
				startActivity(mIntent);
            }
			else
			{
				text1.setText("显示申请！");
                //申请权限
				requestPermissions(new String[]{permission}, 100);
			}
		}
		else
		{
			//callPhone();
			text1.setText("已经有了！");
		}

	}
}


