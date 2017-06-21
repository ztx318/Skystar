package com.example.shanson.myapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.shanson.myapplication.R;
import com.example.shanson.myapplication.base.BaseActivity;

/**
 * Created by Administrator on 2017/6/18.
 */
public class ResetActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psd);
        initActionBar("重置密码",R.mipmap.btn_homeasup_default,null,listener);
    }
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.iv_left:
                    startActivity(LoginActivity.class);
                    break;
            }
        }
    };
}