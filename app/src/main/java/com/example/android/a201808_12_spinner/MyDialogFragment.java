package com.example.android.a201808_12_spinner;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialogFragment extends DialogFragment {


    public MyDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_dialog, container, false);
    }





    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        // 取得 inflator
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // 從 fragment.xml 取得自訂畫面
        // inflate(resource, viewGroup)
        View view = inflater.inflate(R.layout.fragment_my_dialog, null);

        Spinner spinner = (Spinner) view.findViewById(R.id.sp_coffee);      //
        Activity activity = getActivity();                                  //
        SpinnerAdapter adapter = new MySpinnerAdapter(activity);            //
        spinner.setAdapter(adapter);                                        //

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("新增商品")
                .setIcon(android.R.drawable.ic_input_add)
                .setView(view)
                .setPositiveButton("確定", null)
                .setNegativeButton("取消", null);

        return builder.create();

    }
}
