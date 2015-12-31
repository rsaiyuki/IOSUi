package crazecoder.demo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.crazecoder.ui.dialog.ActionSheetDialog;
import com.crazecoder.ui.progress.ZProgressHUD;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            progressHUD.dismissWithSuccess("success");
        }
    };
    ZProgressHUD progressHUD;
    @Override
    public void onClick(View view) {
        Intent i = new Intent();
        switch (view.getId()){
            case R.id.button:
                progressHUD = ZProgressHUD.getInstance(this);
                progressHUD.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            handler.sendEmptyMessage(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
            case R.id.button1:
                new ActionSheetDialog(this).addSheetItem("1", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
                    @Override
                    public void onClick(int which) {
                        Toast.makeText(MainActivity.this,which+"",Toast.LENGTH_SHORT).show();
                    }
                }).addSheetItem("2", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
                @Override
                public void onClick(int which) {
                    Toast.makeText(MainActivity.this,which+"",Toast.LENGTH_SHORT).show();
                }
            }).builder().show();
//                new AlertDialog(MainActivity.this).builder().setTitle("退出当前账号")
//                        .setMsg("再连续登陆15天，就可变身为QQ达人。退出QQ可能会使你现有记录归零，确定退出？")
//                        .setPositiveButton("确认退出", new OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//
//                            }
//                        }).setNegativeButton("取消", new OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                    }
//                }).show();
                break;
            case R.id.button2:
                i.setClass(this,SwitchButtonActivity.class);
                startActivity(i);
                break;
            case R.id.button3:
                i.setClass(this,PickViewActivity.class);
                startActivity(i);
                break;
            case R.id.button4:
                i.setClass(this,SegmentedActivty.class);
                startActivity(i);
                break;
        }

    }
}
