package com.xiang.viewswicherproject;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   /* public  class DataItem {
        public String dataName;
        public Drawable drawable;

        public String getDataName() {
            return dataName;
        }

        public void setDataName(String dataName) {
            this.dataName = dataName;
        }

        public Drawable getDrawable() {
            return drawable;
        }

        public void setDrawable(Drawable drawable) {
            this.drawable = drawable;
        }
    }
    ViewSwitcher switcher;
    //定义一个常量 用于显示每屏显示的数量
    public static final int NUMBER_PER_SCREEN = 6;
    private ArrayList<DataItem> items = new ArrayList<DataItem>();
    //记录当前显示的第几屏
    private int screenNo = -1;
    private int screenCount;


    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflater = LayoutInflater.from(MainActivity.this);
        for (int i = 0; i < 20; i++) {
            String label = "" + i;
            Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
            DataItem item = new DataItem();
            item.dataName = label;
            item.drawable = drawable;
            items.add(item);
        }
        *//*
        * 计算总应用占的总屏幕
        * 如果总数量可以整除NUMBER_PER_SCREEN  结果就是总评总屏
        * 如果不可以整除，总屏结果+1
        *
        * *//*
        screenCount = items.size() % NUMBER_PER_SCREEN == 0 ? items.size() / NUMBER_PER_SCREEN : items.size() / NUMBER_PER_SCREEN + 1;
        switcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            //返回一个grid view组件
            @Override
            public View makeView() {
                View view = inflater.inflate(R.layout.grid_view, null);
                return view;

            }
        });
        //页面加载时先显示第一屏
        next(null);

    }

    public void next(View v) {
        if (screenNo < screenCount - 1) {
            screenNo++;
            //为ViewSwitcher 显示过程显示东画
            switcher.setInAnimation(this, R.anim.r);
            //组件的影藏过程设置动画
            switcher.setInAnimation(this, R.anim.l);
            //控制下一屏将要显示adapter
            ((GridView) switcher.getNextView()).setAdapter(adapter);
            switcher.showNext();
        }
    }

    public void prev(View v) {
        if (screenNo > 0) {
            screenNo--;
            //为ViewSwitcher 显示过程显示东画
            switcher.setInAnimation(this, R.anim.l);
            //组件的影藏过程设置动画
            switcher.setInAnimation(this, R.anim.r);
            //控制下一屏将要显示adapter
            ((GridView) switcher.getNextView()).setAdapter(adapter);
            switcher.showPrevious();
        }
    }


    public BaseAdapter adapter = new BaseAdapter() {
        @Override
        public int getCount() {
            // 如果到最后一屏，并且不能整除
            if (screenNo == screenCount - 1 && items.size() % NUMBER_PER_SCREEN != 0) {
                //
                return items.size() % NUMBER_PER_SCREEN;

            }
            return NUMBER_PER_SCREEN;
        }

        @Override
        public Object getItem(int position) {
            return items.get(screenNo * NUMBER_PER_SCREEN + position);

        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (convertView == null) {
                view = inflater.inflate(R.layout.item, null);
                ImageView imageView = (ImageView) view.findViewById(R.id.image);
                TextView text = (TextView) view.findViewById(R.id.text);
               // imageView.setImageDrawable( getItem(position));
               // text.setText( getItem(position));

            }
            return view;
        }
    };*/


    // 定义一个常量，用于显示每幕显示应用程序的数量
    private static final int NUMBER_PER_SCREEN = 12;

    // 代表应用程序的内部类
    public static class DataItem {
        // 应用程序的名称
        public String dataName;
        // 应用程序的图标
        public Drawable drawable;
    }

    // 保存系统所有应用程序的List集合
    private ArrayList<DataItem> items = new ArrayList<MainActivity.DataItem>();

    // 记录当前正在显示第几屏的程序
    private int screenNo = -1;

    // 保存程序所占的总屏数
    private int screenCount;
    ViewSwitcher switcher;
    // 创建 LayoutInflater 对象
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflater = LayoutInflater.from(MainActivity.this);
        // 创建一个包含40个元素的List集合，用于模拟包含40个应用程序
        for (int i = 0; i < 40; i++) {
            String label = "" + i;
            Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
            DataItem item = new DataItem();
            item.dataName = label;
            item.drawable = drawable;
            items.add(item);
        }
        // 计算应用程序所占的总屏数
        // 如果应用程序的数量能整除NUMBER_PER_SCREEN，除法的结果就是总屏数
        // 如果不能整除，总屏数应该是除法的结果再加 1.
        screenCount = items.size() % NUMBER_PER_SCREEN == 0 ?
                items.size() / NUMBER_PER_SCREEN :
                items.size() / NUMBER_PER_SCREEN + 1;
        switcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            // 实际上就是返回一个GridView组件
            @Override
            public View makeView() {
                // 加载R.layout.slidelistview组件，实际上就是一个GridView组件
                return inflater.inflate(R.layout.grid_view, null);
            }
        });
        // 页面加载时先显示第一屏
        next(null);
    }

    public void next(View v) {
        if (screenNo < screenCount - 1) {
            screenNo ++;
            // 为ViewSwitcher的组件显示过程设置动画
            switcher.setInAnimation(this, R.anim.r);
            // 为ViewSwitcher的组件隐藏过程设置动画
            switcher.setOutAnimation(this, R.anim.l);
            ((GridView)switcher.getNextView()).setAdapter(adapter);
            switcher.showNext();
        }
    }

    public void prev(View v) {
        if (screenNo > 0) {
            screenNo--;
            // 为viewSwitcher的组件显示过程设置动画
            switcher.setInAnimation(this, android.R.anim.slide_in_left);
            // 为viewSwitcher的组件隐藏过程设置动画
            switcher.setOutAnimation(this, android.R.anim.slide_out_right);
            // 控制下一屏将要显示的GridView对应的Adapter
            ((GridView)switcher.getNextView()).setAdapter(adapter);
            switcher.showPrevious();
        }
    }

    private BaseAdapter adapter = new BaseAdapter() {

        @Override
        public int getCount() {
            // 如果已经到了最后一屏，且应用程序数量不能整除NUMBER_PER_SCREEN
            if (screenNo == screenCount - 1
                    && items.size() % NUMBER_PER_SCREEN != 0) {
                // 最后一屏显示的程序数为应用程序的数量对NUMBER_PER_SCREEN求余
                return items.size() % NUMBER_PER_SCREEN;
            }
            // 否则每屏显示的程序数量为NUMBER_PER_SCREEN
            return NUMBER_PER_SCREEN;
        }

        @Override
        public DataItem getItem(int position) {
            // 根据screenNo计算第position个列表项的数据
            return items.get(screenNo * NUMBER_PER_SCREEN + position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (convertView == null) {
                // 加载R.layout.labelicon布局文件
                view = inflater.inflate(R.layout.item, null);
            }
            // 获取R.layout.labelicon布局文件中的ImageView组件，并为之设置图标
            ImageView imageView = (ImageView)view.findViewById(R.id.image);
            imageView.setImageDrawable(getItem(position).drawable);
            // 获取
            TextView textview = (TextView) view.findViewById(R.id.text);
            textview.setText(getItem(position).dataName);
            return view;
        }
    };
}
