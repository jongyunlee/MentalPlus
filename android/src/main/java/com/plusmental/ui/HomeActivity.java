package com.plusmental.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import com.plusmental.ui.BaseDialogFragment.DialogClickListener;
import com.plusmental.R;

public class HomeActivity extends BaseFragmentActivity {

    @Override
    protected int getLayoutResources() {
	return R.layout.activity_home;
    }

    @Override
    public BaseFragment getFragment() {
        return HomeFragment.newInstance();
    }

    public void showSignupDialog() {
	FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
	Fragment prev = getSupportFragmentManager().findFragmentByTag("signup");
	if (prev != null) {
	    ft.remove(prev);
	}
	ft.addToBackStack(null);
	SignupFragment newFragment
	    = SignupFragment.newInstance();
	newFragment.show(ft, "signup");
    }

    public void showLoginDialog() {
	FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
	Fragment prev = getSupportFragmentManager().findFragmentByTag("login");
	if (prev != null) {
	    ft.remove(prev);
	}
	ft.addToBackStack(null);
	LoginFragment newFragment
	    = LoginFragment.newInstance();
	newFragment.show(ft, "login");
    }
}
