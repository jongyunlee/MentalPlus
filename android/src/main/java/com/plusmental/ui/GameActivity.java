package com.plusmental.ui;

public class GameActivity extends BaseFragmentActivity {

    @Override
    public BaseFragment getFragment() {
	return GameFragment.newInstance();
    }

}
