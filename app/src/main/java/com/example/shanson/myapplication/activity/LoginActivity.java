package com.example.shanson.myapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.shanson.myapplication.R;
import com.example.shanson.myapplication.base.BaseActivity;

/**
 * Created by Administrator on 2017/6/17.
 */
public class LoginActivity extends BaseActivity {

    private TextView for_psd;
    private TextView now_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        for_psd = (TextView) findViewById(R.id.forget_psd);
        for_psd.setOnClickListener(new MyListener());
        now_login = (TextView) findViewById(R.id.now_login);
        now_login.setOnClickListener(new MyListener());
        String title = "登录";
        initActionBar(title, R.mipmap.btn_homeasup_default, "快捷登录", listener);

    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.iv_left:
                    startActivity(MainActivity.class);
                    break;
                case R.id.iv_right:
                    startActivity(SkipActivity.class);
                    break;
            }
        }
    };

    public class MyListener implements View.OnClickListener {

        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.forget_psd:
                    startActivity(ResetActivity.class);
                    break;
                case R.id.now_login:
                    startActivity(LoginActivity1.class);
            }

        }
    }
}
