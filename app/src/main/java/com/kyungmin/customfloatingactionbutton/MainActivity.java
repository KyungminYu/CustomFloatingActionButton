package com.kyungmin.customfloatingactionbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private FloatingActionMenu mFloatingActionMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFloatingActionMenu = findViewById(R.id.floating_action_menu);
        mFloatingActionMenu.addFloatingActionMenu(R.string.fab_text_share, R.drawable.ic_share);
        mFloatingActionMenu.addFloatingActionMenu(R.string.fab_text_reload, R.drawable.ic_refresh);
        mFloatingActionMenu.addFloatingActionMenu(R.string.fab_text_lock, R.drawable.ic_lock);
        mFloatingActionMenu.addFloatingActionMenu(R.string.fab_text_download, R.drawable.ic_download);
    }
}
