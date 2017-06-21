package com.example.shanson.myapplication.activity;

import android.os.Bundle;
import android.view.View;

import com.example.shanson.myapplication.R;
import com.example.shanson.myapplication.base.BaseActivity;

/**
 * Created by Administrator on 2017/6/19.
 */

public class WpTypeActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wptype);
        initActionBar("选择物品类型",R.mipmap.btn_homeasup_default,null, listener);
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int viewID = v.getId();
            switch (viewID) {
                case R.id.iv_left:
                    startActivity(MainActivity.class);
                    break;

            }
        }
    };
}