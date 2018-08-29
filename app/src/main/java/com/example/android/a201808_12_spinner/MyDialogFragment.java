package com.example.android.a201808_12_spinner;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialogFragment extends DialogFragment {

    private 能處理確定取消 okCancelHandler;
    private View m_dialogView;
    private AlertDialog m_dialog;
    private Spinner m_spinner;
    private MySpinnerAdapter m_spinnerAdapter;

    public interface 能處理確定取消{
        void 處理確定(Coffee coffee);
        void 處理取消();
    }

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

        initOkCancelHandler();
        initDialogView();
        initSpinner();
        m_dialog = initDialog();
        return m_dialog;

    }


    private void initOkCancelHandler() {
        try {
            okCancelHandler = (能處理確定取消) getActivity();
        } catch (ClassCastException cause) {
            String message = "搞什麼嘛，Activity 無法處理確定取消";
            // 將錯誤訊息與原例外(導致例外的真正原因)包裹丟出
            throw new MyDialogFragmentException(message, cause);
        }
    }

    private void initDialogView() {
        // 取得 inflator
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // 從 fragment.xml 取得自訂畫面
        // inflate(resource, viewGroup)
        m_dialogView = inflater.inflate(R.layout.fragment_my_dialog, null);
    }

    private void initSpinner() {
        try{
            m_spinner = (Spinner) m_dialogView.findViewById(R.id.sp_coffee);    //

            Activity activity = getActivity();                                  //

            m_spinnerAdapter = new MySpinnerAdapter(activity);                  //
            m_spinner.setAdapter(m_spinnerAdapter);

            m_spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) activity);

            int position = 0;                                 // 預設所選項目為第0項
            m_spinner.setSelection(position);

        } catch (ClassCastException cause){
            String message = "搞什麼嘛，Activity 無法處理 OnItemSelectedListener";
            // 將錯誤訊息與原例外(導致例外的真正原因)包裹丟出
            throw new MyDialogFragmentException(message, cause);
        }
    }


    private AlertDialog initDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("新增商品")
                .setIcon(android.R.drawable.ic_input_add)
                .setView(m_dialogView)
                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Coffee coffee = getCoffee();
                        okCancelHandler.處理確定(coffee);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        okCancelHandler.處理取消();
                    }
                });

        return builder.create();
    }

    private Coffee getCoffee() {
        int position = m_spinner.getSelectedItemPosition(); // 取得 Spinner 被點選的項目索引
        String title = m_spinnerAdapter.get_titles_coffee().getString(position); // 取得 Spinner 被點選項目的咖啡名稱
        EditText ev_price = (EditText) m_dialogView.findViewById(R.id.ed_price); // 取得 Spinner 被點選項目的價格
        int price = Integer.parseInt(ev_price.getText().toString());
        int img_resource_id = m_spinnerAdapter.getImg_resource_id_array()[position];// 取得 Spinner 被點選項目圖形id
        return new Coffee(title, price, img_resource_id);
    }


}
