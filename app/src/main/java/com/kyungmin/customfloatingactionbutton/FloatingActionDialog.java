package com.kyungmin.customfloatingactionbutton;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class FloatingActionDialog extends DialogFragment {

    private final String TAG = "FloatingActionDialog";

    private ArrayList<Pair<Integer, Integer>> mFabResIdList;
    private View.OnClickListener mOnClickListener;

    public FloatingActionDialog(ArrayList<Pair<Integer, Integer>> fabResIdList, View.OnClickListener onClickListener) {
        mFabResIdList = fabResIdList;
        mOnClickListener = onClickListener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final View view = LayoutInflater.from(getContext()).inflate(R.layout.floating_action_dialog, null);
        FloatingActionButtonContainer dialogContainer = view.findViewById(R.id.fab_dialog_container);
        for (Pair<Integer, Integer> resId : mFabResIdList) {
            dialogContainer.addFloatingActionMenu(resId.first, resId.second, mOnClickListener);
        }
        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
        alertDialog.setContentView(view);
        return alertDialog;
    }
}