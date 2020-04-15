package com.kyungmin.customfloatingactionbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButtonContainer mFloatingActionButtonContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFloatingActionButtonContainer = findViewById(R.id.floating_action_menu);
        mFloatingActionButtonContainer.addFloatingActionMenu(R.string.fab_text_share, R.drawable.ic_share);
        mFloatingActionButtonContainer.addFloatingActionMenu(R.string.fab_text_reload, R.drawable.ic_refresh);
        mFloatingActionButtonContainer.addFloatingActionMenu(R.string.fab_text_lock, R.drawable.ic_lock);
        mFloatingActionButtonContainer.addFloatingActionMenu(R.string.fab_text_download, R.drawable.ic_download);
    }
}
