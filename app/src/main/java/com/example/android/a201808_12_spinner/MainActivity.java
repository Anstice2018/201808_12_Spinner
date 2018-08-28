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

public class MainActivity extends AppCompatActivity
            implements MyDialogFragment.能處理確定取消,
        AdapterView.OnItemClickListener{

    private static final String TAG = "MainActivity";

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

    @Override
    public void 處理確定() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        Snackbar.make(fab, "收到確定", Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
    }

    @Override
    public void 處理取消() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        Snackbar.make(fab, "收到取消", Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Log.d(TAG, "onItemSelected, posiyion =" + position);
    }


}
