package com.example.shanson.myapplication.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.shanson.myapplication.R;
import com.example.shanson.myapplication.base.BaseActivity;
import com.example.shanson.myapplication.base.adapter.AddressFragment;
import com.example.shanson.myapplication.base.adapter.HoyFragment;


/**
 * Created by Administrator on 2017/6/17.
 */
public class GoAddress extends BaseActivity {


    private TextView address_hoy;
    private TextView address_near;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jichu);
        address_hoy = (TextView) findViewById(R.id.address_hoy);
        address_near = (TextView) findViewById(R.id.address_near);
        initActionBar("寄件地址", R.mipmap.btn_homeasup_default, "南京市", listener);
        initData();
        address_hoy.setOnClickListener(new Myclick());
        address_near.setOnClickListener(new Myclick());

    }

    private void initData() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new AddressFragment()).commit();
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

    private class Myclick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.address_hoy:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new HoyFragment()).commit();
                    break;
                case R.id.address_near:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new AddressFragment()).commit();
                    break;
            }

        }
    }
}
