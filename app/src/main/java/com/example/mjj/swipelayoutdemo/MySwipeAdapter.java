package com.example.mjj.swipelayoutdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.BaseSwipeAdapter;

import java.util.List;

/**
 * Description：适配器
 * <p>
 * Created by Mjj on 2016/12/12.
 */

public class MySwipeAdapter extends BaseSwipeAdapter implements View.OnClickListener {

    private Context context;
    private List<ItemBean> list;
    private final String TAG = "MySwipeAdapter";

    public MySwipeAdapter(Context context, List<ItemBean> list) {
        this.context = context;
        this.list = list;
    }

    /**
     * 返回SwipeLayout的ID
     *
     * @param position
     * @return
     */
    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    /**
     * 绑定布局
     *
     * @param position
     * @param parent
     * @return
     */
    @Override
    public View generateView(int position, ViewGroup parent) {
        View itemView = View.inflate(context, R.layout.item_swipe, null);
        SwipeLayout swipeLayout = (SwipeLayout) itemView.findViewById(getSwipeLayoutResourceId(position));

        // 设置滑动是否可用,默认为true
        swipeLayout.setSwipeEnabled(true);

        /**
         * 打开时调用：循环调用onStartOpen,onUpdate,onHandRelease,onUpdate,onOpen,
         * 关闭时调用：onStartClose,onUpdate,onHandRelease,onHandRelease,onUpdate,onClose
         */
        swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onStartOpen(SwipeLayout layout) {
//                Log.e(TAG, "onStartOpen: ");
            }

            @Override
            public void onOpen(SwipeLayout layout) {
//                Log.e(TAG, "onOpen: ");
            }

            @Override
            public void onStartClose(SwipeLayout layout) {
//                Log.e(TAG, "onStartClose: ");
            }

            @Override
            public void onClose(SwipeLayout layout) {
//                Log.e(TAG, "onClose: ");
            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
//                Log.e(TAG, "onUpdate: ");
            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
//                Log.e(TAG, "onHandRelease: ");
            }
        });

        // 设置为true,在当前一条item(除侧滑以外部分)点击时,可收回侧滑出来部分,默认为false
        swipeLayout.setClickToClose(true);

        // SwipeLayout单击事件,可替代ListView的OnitemClickListener事件.
        swipeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.e(TAG, "onClick: ");
            }
        });

        return itemView;
    }

    /**
     * 绑定数据
     *
     * @param position
     * @param convertView
     */
    @Override
    public void fillValues(int position, View convertView) {
        TextView tvNickName = (TextView) convertView.findViewById(R.id.tv_nickname);
        TextView tvMsg = (TextView) convertView.findViewById(R.id.tv_msg);
        TextView tvSwipeOpen = (TextView) convertView.findViewById(R.id.swipe_open);
        TextView tvSwipeDelete = (TextView) convertView.findViewById(R.id.swipe_delete);
        tvNickName.setText(list.get(position).getNickName());
        tvMsg.setText(list.get(position).getMsg());

        tvSwipeDelete.setOnClickListener(this);
        tvSwipeOpen.setOnClickListener(this);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public ItemBean getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.swipe_open:
                // 关闭所有打开的Swipe的item
                this.closeAllItems();
                Toast.makeText(context, "Swipe--Open", Toast.LENGTH_SHORT).show();
                break;
            case R.id.swipe_delete:
                this.closeAllItems();
                Toast.makeText(context, "Swipe--Delete", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
