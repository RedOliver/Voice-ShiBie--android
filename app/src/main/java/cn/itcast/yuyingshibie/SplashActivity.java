package cn.itcast.yuyingshibie;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private TextView tv_version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//设置竖屏
        init();
    }

    private void init() {
        tv_version = (TextView) findViewById(R.id.tv_version);
        try {
            //获取程序包信息
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), 0);
            tv_version.setText("v" + info.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            tv_version.setText("v");
        }
        //让界面维持3秒后再跳转，timer中有一个线程，这个线程不断执行task
        Timer timer = new Timer();
        //TimerTask类表示一个再指定时间内执行的task
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        };
        timer.schedule(task, 3000);//设置这个task在延时3秒后自动执行
    }
}
