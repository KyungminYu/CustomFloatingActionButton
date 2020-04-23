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

        mFabContainerForMenu = findViewById(R.id.floating_action_button_container_for_menu);
        mFabContainerForMenu.setOnClickListener(this);
        mFabContainerForMenu.addFloatingActionMenu(R.string.fab_text_share, R.drawable.ic_share, this);
        mFabContainerForMenu.addFloatingActionMenu(R.string.fab_text_reload, R.drawable.ic_refresh, this);
        mFabContainerForMenu.addFloatingActionMenu(R.string.fab_text_lock, R.drawable.ic_lock, this);
        mFabContainerForMenu.addFloatingActionMenu(R.string.fab_text_download, R.drawable.ic_download, this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "tag: " + v.getTag(), Toast.LENGTH_SHORT).show();
    }
}
