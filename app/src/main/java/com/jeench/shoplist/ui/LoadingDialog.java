package com.jeench.shoplist.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
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
        Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.loading_dialog);
        return dialog;
    }
}
