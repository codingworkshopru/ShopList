package com.jeench.shoplist.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.jeench.shoplist.R;

import io.reactivex.exceptions.OnErrorNotImplementedException;

/**
 * Created by Radik on 01.12.2017.
 */

public class ErrorDialog extends DialogFragment {
    public static final String TAG = ErrorDialog.class.getCanonicalName();
    public interface OnErrorDialogRetryClickListener {
        void onRetryClick();
    }

    private OnErrorDialogRetryClickListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnErrorDialogRetryClickListener) {
            listener = (OnErrorDialogRetryClickListener) context;
        } else {
            throw new IllegalStateException("Activity must implement " + OnErrorDialogRetryClickListener.class);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog errorDialog = new AlertDialog.Builder(getContext())
                .setTitle(R.string.errorText)
                .setPositiveButton(R.string.retry, (dialog, which) -> listener.onRetryClick())
                .create();

        return errorDialog;
    }
}
