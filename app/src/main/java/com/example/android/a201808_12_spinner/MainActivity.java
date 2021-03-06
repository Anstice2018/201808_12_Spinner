package com.example.android.a201808_12_spinner;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
            implements MyDialogFragment.能處理確定取消,
        AdapterView.OnItemSelectedListener{

    private static final String TAG = "MainActivity";
    private ListView m_listView;
    private List<Coffee> m_coffeeList = new ArrayList<>();

    //getter
    public List<Coffee> getM_coffeeList() {
        return m_coffeeList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                DialogFragment dialog = new MyDialogFragment();
                dialog.show(getSupportFragmentManager(), "MyDialogFragment");
            }
        });

        initListView();
    }

    private void initListView() {
        m_listView = (ListView) findViewById(R.id.lv_listview);
        m_listView.setEmptyView(findViewById(R.id.tv_empty));
        m_listView.setAdapter(new MyListAdapter(this));
        m_listView.setOnItemSelectedListener(this);
    }



    @Override
    public void 處理確定(Coffee coffee) {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        Snackbar.make(fab, "收到確定 coffee = " + coffee, Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
        // add coffee
        m_coffeeList.add(coffee);

        MyListAdapter myListAdapter = (MyListAdapter) m_listView.getAdapter();
        myListAdapter.notifyDataSetChanged();
    }

    @Override
    public void 處理取消() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        Snackbar.make(fab, "收到取消", Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        Log.d(TAG, "onItemSelected, posiyion =" + position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }









    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
