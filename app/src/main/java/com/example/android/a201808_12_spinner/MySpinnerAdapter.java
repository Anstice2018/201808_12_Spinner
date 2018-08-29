package com.example.android.a201808_12_spinner;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MySpinnerAdapter extends BaseAdapter {

    private static final String TAG = "MySpinnerAdapter";
    private Activity activity;      // MySpinnerAdapter 需仰賴 Activity
    private TypedArray m_titles_coffee;
    private TypedArray m_drawables_coffee;
    private int[] img_resource_id_array = {
            R.drawable.coffee_cappuccino,
            R.drawable.coffee_latte,
            R.drawable.coffee_macchiato,
            R.drawable.coffee_mocha
    };

    // 建構子
    public MySpinnerAdapter(Activity activity){
        this.activity = activity;

        Resources resources = activity.getResources();
        m_titles_coffee = resources.obtainTypedArray(R.array.titles_coffee);
        m_drawables_coffee = resources.obtainTypedArray(R.array.drawables_coffee);
    }


    // getter
    public TypedArray get_titles_coffee() {
        return m_titles_coffee;
    }

    public int[] getImg_resource_id_array() {
        return img_resource_id_array;
    }





    @Override
    public int getCount() {
        return 4;
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
    public View getView(int position, View view, ViewGroup viewGroup) {

        String message = "第" + position + "項 咖啡名稱＝" + m_titles_coffee.getText(position);
        Log.d(TAG, message);

        View v = activity.getLayoutInflater().inflate(R.layout.spinner_layout, null);

        TextView m_tv_coffee = (TextView) v.findViewById(R.id.tv_coffee);
        m_tv_coffee.setText(m_titles_coffee.getText(position));
        ImageView m_iv_coffee = (ImageView) v.findViewById(R.id.iv_coffee);
        m_iv_coffee.setImageDrawable(m_drawables_coffee.getDrawable(position));

        return v;
    }
}
