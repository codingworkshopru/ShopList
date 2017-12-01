package com.jeench.shoplist.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.Window;

import com.jeench.shoplist.R;

/**
 * Created by Radik on 01.12.2017.
 */

public class LoadingDialog extends DialogFragment {
    public static final String TAG = LoadingDialog.class.getCanonicalName();

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new AlertDialog.Builder(getContext())
                .setCancelable(false)
                .setView(R.layout.loading_dialog)
                .create();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }
}
