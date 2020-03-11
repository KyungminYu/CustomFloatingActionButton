package com.kyungmin.floatingactionmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private FloatingActionMenu mFloatingActionMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFloatingActionMenu = findViewById(R.id.floating_action_menu);
        mFloatingActionMenu.addFloatingActionMenu(R.string.fab1, null);
        mFloatingActionMenu.addFloatingActionMenu(R.string.fab2, null);
        mFloatingActionMenu.addFloatingActionMenu(R.string.fab3, null);
        mFloatingActionMenu.addFloatingActionMenu(R.string.fab4, null);
    }
}
