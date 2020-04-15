package com.kyungmin.customfloatingactionbutton;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class FloatingActionDialog extends DialogFragment {

    private final String TAG = "FloatingActionDialog";

    private ArrayList<Integer> mFabIdList;

    public FloatingActionDialog() {
        super();
    }

    public FloatingActionDialog(ArrayList<Integer> fabIdList) {
        mFabIdList = fabIdList;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final View view = LayoutInflater.from(getContext()).inflate(R.layout.floating_action_dialog, null);

        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
        alertDialog.setContentView(view);
        return alertDialog;
    }
}