package com.example.shanson.myapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.shanson.myapplication.R;
import com.example.shanson.myapplication.base.BaseActivity;
import com.example.shanson.myapplication.base.adapter.AddressFragment;

/**
 * Created by Administrator on 2017/6/17.
 */
public class MapActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        initActionBar("选择城市", R.mipmap.btn_homeasup_default, null, listener);
        initData();
    }

    private void initData() {

        getSupportFragmentManager().beginTransaction().replace(R.id.list_sity,new AddressFragment()).commit();
    }

    private View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            int viewID = view.getId();
            switch (viewID) {
                case R.id.iv_left:
                    startActivity(MainActivity.class);
                    break;
            }
        }
    };

}