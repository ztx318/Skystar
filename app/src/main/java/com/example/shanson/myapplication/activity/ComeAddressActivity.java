package com.example.shanson.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.shanson.myapplication.R;
import com.example.shanson.myapplication.base.BaseActivity;
import com.example.shanson.myapplication.base.adapter.HoyFragment;

public class ComeAddressActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_come_address);
        initActionBar("收件地址", R.mipmap.btn_homeasup_default, "南京市", listener);
        initData();
    }


    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int viewID = v.getId();
            switch (viewID) {
                case R.id.iv_left:
                    startActivity(MainActivity.class);
                    break;
                case R.id.iv_right:
                    startActivity(MapActivity.class);
                    break;
            }
        }
    };

    private void initData() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new HoyFragment()).commit();
    }
}
