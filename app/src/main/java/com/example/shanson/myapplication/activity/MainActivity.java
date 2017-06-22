package com.example.shanson.myapplication.activity;


import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.shanson.myapplication.base.BaseActivity;
import com.example.shanson.myapplication.base.adapter.MyAdapter;
import com.example.shanson.myapplication.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MainActivity extends BaseActivity {

    private List<View> viewList = new ArrayList<View>();
    public ViewPager viewPager;
    private LinearLayout wp_come;
    private LinearLayout wp_go;
    private RelativeLayout wp_type;
    private RelativeLayout wp_weight;
    private PopupWindow popupWindow;
    private PopupWindow popupDatePicWindow;
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
    private RelativeLayout wp_gettime;
    private DatePicker date_picker;
    private TimePicker time_picker;
    private TimePicker time_picker2;
    private TextView gettime_wp;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private Button btn_command2;
    private Button btn_cancle2;

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
        wp_gettime = (RelativeLayout) findViewById(R.id.wp_gettime);
        gettime_wp = (TextView) findViewById(R.id.gettime_wp);

        gettime_wp.setOnClickListener(new MyListener());
        text_privi.setOnClickListener(new MyListener());
        wp_weight.setOnClickListener(new MyListener());
        wp_go.setOnClickListener(new MyListener());
        wp_come.setOnClickListener(new MyListener());
        wp_type.setOnClickListener(new MyListener());
        wp_gettime.setOnClickListener(new MyListener());
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
                    break;
                case R.id.text_privilege:
                    initDialog();
                    break;
                case R.id.text_cancle:
                    dialog.dismiss();
                    break;
                case R.id.wp_gettime:
                    initDateWindow();
                    break;
                case R.id.send_check:
                    // TODO: 2017/6/21
                    sendpwd.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));

                    break;
                case R.id.btn_command2:
                    showDate();
                    break;
                case R.id.btn_cancle2:
                    popupDatePicWindow.dismiss();
                    gettime_wp.setText("立即取件");
                    break;

            }

        }

    }

    private void initDateWindow() {
        //设置contentView
        View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.popdate_picker, null);
        popupDatePicWindow = new PopupWindow(contentView,
                ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.WRAP_CONTENT);

        popupDatePicWindow.setContentView(contentView);
        popupDatePicWindow.setFocusable(true); // 设置PopupWindow可获得焦点
        popupDatePicWindow.setTouchable(true); // 设置PopupWindow可触摸

        date_picker = contentView.findViewById(R.id.date_picker);
        time_picker = contentView.findViewById(R.id.time_picker);
        btn_command2 = contentView.findViewById(R.id.btn_command2);
        btn_cancle2 = contentView.findViewById(R.id.btn_cancle2);

        btn_command2.setOnClickListener(new MyListener());
        btn_cancle2.setOnClickListener(new MyListener());

        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        year = c.get(Calendar.YEAR);

        //初始化组件
        date_picker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                MainActivity.this.year = year;
                MainActivity.this.month = month;
                MainActivity.this.day = day;
            }
        });

        time_picker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                MainActivity.this.hour=hour;
                MainActivity.this.minute=minute;
            }
        });

    }

    //
    private void showDate() {
        gettime_wp.setText(""+month+"月"+day+"号"+hour+"时"+minute+"分");

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
