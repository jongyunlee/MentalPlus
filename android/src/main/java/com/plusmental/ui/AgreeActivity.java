package com.plusmental.ui;

import com.plusmental.R;

public class AgreeActivity extends BaseFragmentActivity {
    @Override
    public BaseFragment getFragment() {
	int type = getIntent().getIntExtra("TYPE", 1);
	return AgreeFragment.newInstance(type);
    }
}
