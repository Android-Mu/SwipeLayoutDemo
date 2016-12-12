package com.example.mjj.swipelayoutdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：仿QQ侧滑出现删除和置顶
 * <p>
 * Created by Mjj on 2016/12/12.
 */
public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<ItemBean> datas = new ArrayList<>();
    private MySwipeAdapter swipeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
        initView();
    }

    private void initData() {
        for (int i = 0; i < 15; i++) {
            ItemBean itemBean = new ItemBean();
            itemBean.setNickName("昵称 " + (i + 1));
            itemBean.setMsg("Message " + i);
            datas.add(itemBean);
        }
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv_main);
        swipeAdapter = new MySwipeAdapter(MainActivity.this, datas);
        listView.setAdapter(swipeAdapter);
    }

}
