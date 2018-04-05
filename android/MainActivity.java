package com.jarod.android.smspro;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.jar.Manifest;

// 读取通讯录，动态申请权限
//https://blog.csdn.net/qq_37664986/article/details/79304805
public class MainActivity extends AppCompatActivity {

    ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 浮动按钮
        loadFloatButton();
    }

    // 菜单呈现
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // 菜单点击
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            bingListView();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // 浮动按钮部分代码
    void loadFloatButton() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("申请权限", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                testSnackBar();
                            }
                        }).show();
            }
        });
    }

    // 获取系统联系人信息
    List getContact() {

        List<HashMap<String, String>> list = new ArrayList<>();

        Uri contactsUri = Uri.parse("content://com.android.contacts/raw_contacts");
        Uri dataUri = Uri.parse("content://com.android.contacts/data");

        Cursor contactCursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

        while (contactCursor.moveToNext()) {

            if (contactCursor != null) {
                String contactId = contactCursor.getString(contactCursor.getColumnIndex(ContactsContract.Contacts._ID));

                Cursor dataCursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactId, null, null);

                if (dataCursor != null) {

                    HashMap<String, String> map = new HashMap<>();

                    while (dataCursor.moveToNext()) {

                        String name = dataCursor.getString(dataCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        String phone = dataCursor.getString(dataCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                        String addr = dataCursor.getString(dataCursor.getColumnIndex(ContactsContract.CommonDataKinds.SipAddress.SIP_ADDRESS));

                        map.put("name", name);
                        map.put("phone", phone);

                        Log.d("sms_pro", "name=" + name);
                        Log.d("sms_pro", "phone=" + phone);
//                        Log.d("sms_pro", "addr=" + addr);

                        list.add(map);
                        Log.d("key=", map.hashCode() + "|");
                    }
                }
            }
        }
//        Log.d("sms_pro", "list=" + list.size());
        return list;
    }

    void bingListView() {
        // 主界面 listview
        listView1 = (ListView) findViewById(R.id.listView1);

        // 获取通讯录中的联系人信息
        List<HashMap<String, String>> res = getContact();

        // 创建适配器
        SimpleAdapter sa = new SimpleAdapter(this,
                res,
                android.R.layout.simple_list_item_2,
                new String[]{"name", "phone"},
                new int[]{android.R.id.text1, android.R.id.text2}
        );

        // 设置视频器
        listView1.setAdapter(sa);
    }

    // test snackbar
    void testSnackBar() {
        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_CONTACTS}, 1);

        //拒绝过一次后出现提示
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.READ_CONTACTS)) {
            Toast.makeText(this, "请开通相关权限，否则无法正常使用本APP", Toast.LENGTH_SHORT).show();
        }
    }

//     0    PackageManager.PERMISSION_GRANTED
//    -1    PackageManager.PERMISSION_DENIED

    //检查某个权限是否已经获得
    private boolean checkPermission(String permission) {
        //检查权限（NEED_PERMISSION）是否被授权 PackageManager.PERMISSION_GRANTED表示同意授权
        if (ActivityCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED)
            return true;
        else
            return false;
    }
}






























