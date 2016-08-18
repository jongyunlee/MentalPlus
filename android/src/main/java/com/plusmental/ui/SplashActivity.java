package com.plusmental.ui;

import com.plusmental.R;

public class SplashActivity extends BaseFragmentActivity {

    @Override
    protected int getLayoutResources() {
	return R.layout.activity_splash;
    }

    @Override
    public BaseFragment getFragment() {
	return SplashFragment.newInstance();
    }
}
