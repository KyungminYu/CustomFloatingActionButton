package com.kyungmin.customfloatingactionbutton;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FloatingActionMenu extends FrameLayout implements View.OnClickListener {

    private static final String TAG = "FloatingActionMenu";

    private Context mContext;
    private FrameLayout mFrameLayout;
    private CustomFloatingActionButton mMenuFab;

    private boolean mIsFabShown = false;
    private float mMenuHeight;

    private ArrayList<CustomFloatingActionButton> mFabList = new ArrayList<>();

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
        mIsFabShown = false;
        mFabList.clear();
        mMenuHeight = getResources().getDimensionPixelOffset(R.dimen.fab_size) + getResources().getDimensionPixelOffset(R.dimen.fab_menu_padding) * 2;
        View.inflate(mContext, R.layout.floating_action_menu, (ViewGroup) getRootView());
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mFrameLayout = findViewById(R.id.fab_menu_container);
        mMenuFab = mFrameLayout.findViewById(R.id.menu_fab);
        mMenuFab.setOnClickListener(this);
    }

    public void addFloatingActionMenu(int menuTextRes, int menuIconRes) {
        CustomFloatingActionButton fab = new CustomFloatingActionButton(mContext);
        fab.setMenuIconRes(menuIconRes);
        fab.setMenuText(menuTextRes);
        fab.setVisibility(View.GONE);
        mFrameLayout.addView(fab, 0);
        mFabList.add(0, fab);

        ViewGroup.LayoutParams params = mFrameLayout.getLayoutParams();
        params.height = (int) (mMenuHeight * mFrameLayout.getChildCount());
        mFrameLayout.setLayoutParams(params);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick()");
        toggleFabMenu();
    }

    private void toggleFabMenu() {
        Log.d(TAG, "toggleFabMenu()");
        mIsFabShown = !mIsFabShown;
        mMenuFab.rotateIcon(mIsFabShown ? 45 : 0);
        for (int idx = 0; idx < mFabList.size(); ++idx) {
            toggleFab(mFabList.get(idx), idx, mIsFabShown);
        }
    }

    private void toggleFab(final View view, int idx, boolean isFabShown) {
        if (isFabShown) {
            view.animate().alpha(1).translationY((-1) * mMenuHeight * (idx + 1)).withStartAction(new Runnable() {
                @Override
                public void run() {
                    view.setVisibility(View.VISIBLE);
                }
            }).start();
        } else {
            view.animate().alpha(0).translationY(0).withEndAction(new Runnable() {
                @Override
                public void run() {
                    view.setVisibility(View.GONE);
                }
            }).start();
        }
    }
}
