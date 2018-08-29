package com.example.android.a201808_12_spinner;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapter extends BaseAdapter {

    private MainActivity mainActivity;

    public MyListAdapter(MainActivity activity) {
        this.mainActivity = activity;
    }



    @Override
    public int getCount() {
        return mainActivity.getM_coffeeList().size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = mainActivity.getLayoutInflater().inflate(R.layout.listview_layout, null);

        TextView tv_itemId = v.findViewById(R.id.tv_itemId);
        TextView tv_itemTitle = v.findViewById(R.id.tv_itemTitle);
        TextView tv_itemPrice = v.findViewById(R.id.tv_itemPrice);
        ImageView iv_itemImage = v.findViewById(R.id.iv_itemImage);

        Coffee coffee = mainActivity.getM_coffeeList().get(i);

        tv_itemId.setText("id");
        tv_itemPrice.setText(String.valueOf(coffee.getPrice()));
        tv_itemTitle.setText(coffee.getTitle());
        iv_itemImage.setImageResource(coffee.getImg_resource_id());

        return v;
    }
}
