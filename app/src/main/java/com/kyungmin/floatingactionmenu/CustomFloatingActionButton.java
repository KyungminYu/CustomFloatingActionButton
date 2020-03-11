package com.kyungmin.floatingactionmenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CustomFloatingActionButton extends LinearLayout {

    private Context mContext;
    private TextView mTextView;
    private FloatingActionButton mFloatingActionButton;

    private int mMenuTextRes;
    private Drawable mMenuIconDrawable;

    public CustomFloatingActionButton(Context context) {
        super(context);
        intiLayout(context, null, 0, 0);
    }

    public CustomFloatingActionButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        intiLayout(context, attrs, 0, 0);
    }

    public CustomFloatingActionButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        intiLayout(context, attrs, defStyleAttr, 0);
    }

    public CustomFloatingActionButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        intiLayout(context, attrs, defStyleAttr, defStyleRes);
    }

    private void intiLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        mContext = context;
        View.inflate(mContext, R.layout.custom_floating_action_button, (ViewGroup) getRootView());
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.CustomFloatingActionButtonAttr, defStyleAttr, defStyleRes);
        try {
            mMenuTextRes = typedArray.getResourceId(R.styleable.CustomFloatingActionButtonAttr_menu_text, 0);
            mMenuIconDrawable = typedArray.getDrawable(R.styleable.CustomFloatingActionButtonAttr_menu_icon);
        } finally {
            typedArray.recycle();
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setMenuText(mMenuTextRes);
        setMenuIcon(mMenuIconDrawable);
    }

    public void setMenuText(int menuTextRes) {
        mMenuTextRes = menuTextRes;
        if (mMenuTextRes > 0) {
            mTextView = findViewById(R.id.fab_menu_text);
            mTextView.setText(mMenuTextRes);
        }
    }

    public void setMenuIcon(Drawable menuIconDrawable) {
        mMenuIconDrawable = menuIconDrawable;
        if (mMenuIconDrawable != null) {
            mFloatingActionButton = findViewById(R.id.fab_menu_icon);
            mFloatingActionButton.setForeground(mMenuIconDrawable);
        }
    }
}