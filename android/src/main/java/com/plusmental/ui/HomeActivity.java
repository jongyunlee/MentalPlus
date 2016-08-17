package com.plusmental.ui;

public class HomeActivity extends BaseFragmentActivity {

    @Override
    public BaseFragment getFragment() {
        return HomeFragment.newInstance();
    }
}
