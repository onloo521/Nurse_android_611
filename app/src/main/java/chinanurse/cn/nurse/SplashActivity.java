package chinanurse.cn.nurse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

/*
*2016-6-2
* 欢迎界面
 */
public class SplashActivity extends AppCompatActivity {


    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sp = getSharedPreferences("config", MODE_PRIVATE);
        new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //判断是否登录，如果已经登录，跳转到主界面
                if (sp.getBoolean("isLogin", true)){
                    Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(intent);
                }else {
                    //进入登录界面
                }
            }
        }.sendEmptyMessageDelayed(0,3000);

    }
}
