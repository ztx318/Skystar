package com.example.shanson.myapplication.activity;

import android.os.Bundle;
import android.view.View;

import com.example.shanson.myapplication.R;
import com.example.shanson.myapplication.base.BaseActivity;

/**
 * Created by Administrator on 2017/6/17.
 */
public class SkipActivity extends BaseActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip);
        initActionBar("快捷登录",R.mipmap.btn_homeasup_default,null,listener);

    }
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
      switch (view.getId()){
          case R.id.iv_left:
              startActivity(LoginActivity.class);
              break;

      }
        }
    };
}
