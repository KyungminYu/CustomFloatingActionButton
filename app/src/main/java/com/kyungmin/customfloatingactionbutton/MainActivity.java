package com.kyungmin.customfloatingactionbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "MainActivity";

    private FloatingActionButtonContainer mFabContainerForMenu;
    private FloatingActionButtonContainer mFabContainerForDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFabContainerForDialog = findViewById(R.id.floating_action_button_container);
        mFabContainerForDialog.setOnClickListener(this);
    }

    private void showFloatingActionDialog() {
        Log.d(TAG, "showFloatingActionDialog()");
        ArrayList<Pair<Integer, Integer>> fabResIdList = new ArrayList<>();
        fabResIdList.add(new Pair<>(R.string.fab_text_share, R.drawable.ic_share));
        fabResIdList.add(new Pair<>(R.string.fab_text_reload, R.drawable.ic_refresh));
        fabResIdList.add(new Pair<>(R.string.fab_text_lock, R.drawable.ic_lock));
        fabResIdList.add(new Pair<>(R.string.fab_text_download, R.drawable.ic_download));
        FloatingActionDialog floatingActionDialog = new FloatingActionDialog(fabResIdList, this);
        floatingActionDialog.show(getSupportFragmentManager(), null);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "tag: " + v.getTag(), Toast.LENGTH_SHORT).show();
        int viewId = v.getId();
        if (viewId == R.id.floating_action_button_container) {
            showFloatingActionDialog();
        }
    }
}
