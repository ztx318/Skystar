package com.example.shanson.myapplication.activity;


import android.content.DialogInterface;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.shanson.myapplication.base.BaseActivity;
import com.example.shanson.myapplication.base.adapter.MyAdapter;
import com.example.shanson.myapplication.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {

    private List<View> viewList = new ArrayList<View>();
    public ViewPager viewPager;
    private LinearLayout wp_come;
    private LinearLayout wp_go;
    private RelativeLayout wp_type;
    private RelativeLayout wp_weight;
    private PopupWindow popupWindow;
    private Button btn_cancle;
    private Button btn_command;
    private TextView number_price;
    private NumberPicker number;
    private TextView text_weight;
    private int weight;
    private TextView text_privi;
    private TextView cancle;
    private AlertDialog dialog;
    private EditText phonenumber;
    private Button sendpwd;
    private LinearLayout custom_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initActionBar("绅蓝", R.mipmap.dd, null, clickListener);
        initPagerData();

        wp_come = (LinearLayout) findViewById(R.id.wp_gocome);
        wp_type = (RelativeLayout) findViewById(R.id.wp_type);
        wp_go = (LinearLayout) findViewById(R.id.wp_go);
        wp_weight = (RelativeLayout) findViewById(R.id.wp_weight);
        text_weight = (TextView) findViewById(R.id.text_weight);
        text_privi = (TextView) findViewById(R.id.text_privilege);

        text_privi.setOnClickListener(new MyListener());
        wp_weight.setOnClickListener(new MyListener());
        wp_go.setOnClickListener(new MyListener());
        wp_come.setOnClickListener(new MyListener());
        wp_type.setOnClickListener(new MyListener());
    }

    private View.OnClickListener clickListener =
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()) {
                        case R.id.iv_left:
                            startActivity(LoginActivity.class);
                            break;
                    }
                }
            };

    public class MyListener implements View.OnClickListener {

        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.wp_gocome:
                    startActivity(GoAddress.class);
                    break;
                case R.id.wp_go:
                    startActivity(ComeAddressActivity.class);
                    break;
                case R.id.wp_type:
                    startActivity(WpTypeActivity.class);
                    break;
                case R.id.wp_weight:
                    initPopupWindow();
                    break;
                case R.id.btn_cancle:
                    popupWindow.dismiss();
                    text_weight.setText("5公斤以下");
                    break;
                case R.id.btn_command:
                    popupWindow.dismiss();
                    text_weight.setText("" + weight + "公斤");
                case R.id.wp_time:
                initPopWindow();



                    break;
                case R.id.text_privilege:
                    initDialog();
                    break;
                case R.id.text_cancle:
                    dialog.dismiss();
                    break;
                case R.id.send_check:
                    // TODO: 2017/6/21
                    sendpwd.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));

                    break;

            }

        }

    }

    private void initPopWindow() {


    }

    private void initDialog() {
        custom_dialog = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_dialog, null);
        dialog = new AlertDialog.Builder(this).setView(custom_dialog).create();
        dialog.show();
        cancle = custom_dialog.findViewById(R.id.text_cancle);
        phonenumber = custom_dialog.findViewById(R.id.edit_phonenub);
        sendpwd = custom_dialog.findViewById(R.id.send_check);
        sendpwd.setOnClickListener(new MyListener());
        phonenumber.setOnClickListener(new MyListener());
        cancle.setOnClickListener(new MyListener());


    }


    private void initPopupWindow() {
        //设置contentView
        View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.popup, null);
        popupWindow = new PopupWindow(contentView,
                ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.WRAP_CONTENT);
        //设置各个控件的点击响应
        popupWindow.setContentView(contentView);
        popupWindow.setFocusable(true); // 设置PopupWindow可获得焦点
        popupWindow.setTouchable(true); // 设置PopupWindow可触摸
        number = (NumberPicker) contentView.findViewById(R.id.number);
        number.setMinValue(5);
        number.setValue(weight);
        number.setMaxValue(10000);
        number.setWrapSelectorWheel(false);

        number.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int newval) {
                number_price.setText("" + (newval - 5) * 2);
                weight = newval;

            }
        });

        //点击事件
        btn_cancle = (Button) contentView.findViewById(R.id.btn_cancle);
        btn_command = (Button) contentView.findViewById(R.id.btn_command);
        number_price = contentView.findViewById(R.id.number_price);

        btn_cancle.setOnClickListener(new MyListener());
        btn_command.setOnClickListener(new MyListener());
        number_price.setOnClickListener(new MyListener());

        //显示popupwindow
        View rootview = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main, null);
        popupWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);

    }


    private void initPagerData() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(viewList));
        viewPager.setCurrentItem(Integer.MAX_VALUE / 2);
        ImageView imageView = null;
        imageView = (ImageView) getLayoutInflater().inflate(R.layout.viewpager_list_item, null);
        imageView.setImageResource(R.mipmap.a);
        viewList.add(imageView);
        imageView = (ImageView) getLayoutInflater().inflate(R.layout.viewpager_list_item, null);
        imageView.setImageResource(R.mipmap.b);
        viewList.add(imageView);
        imageView = (ImageView) getLayoutInflater().inflate(R.layout.viewpager_list_item, null);
        imageView.setImageResource(R.mipmap.c);
        viewList.add(imageView);
        imageView = (ImageView) getLayoutInflater().inflate(R.layout.viewpager_list_item, null);
        imageView.setImageResource(R.mipmap.d);
        viewList.add(imageView);

    }


}
