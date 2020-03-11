package com.kyungmin.floatingactionmenu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FloatingActionMenu extends LinearLayout {

    private Context mContext;
    private ArrayList<FloatingActionMenu> floatingActionMenus = new ArrayList<>();

    public FloatingActionMenu(Context context) {
        super(context);
        intiLayout(context, null, 0, 0);
    }

    public FloatingActionMenu(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        intiLayout(context, attrs, 0, 0);
    }

    public FloatingActionMenu(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        intiLayout(context, attrs, defStyleAttr, 0);
    }

    public FloatingActionMenu(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        intiLayout(context, attrs, defStyleAttr, defStyleRes);
    }

    private void intiLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        mContext = context;
    }

    public void addFloatingActionMenu(int menuTextRes, Drawable menuIconDrawable) {
        CustomFloatingActionButton fab = new CustomFloatingActionButton(mContext);
        fab.setMenuText(menuTextRes);
        fab.setMenuIcon(menuIconDrawable);

        addView(fab);
    }
}
