package com.plusmental.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.plusmental.R;
import com.plusmental.util.UserManager;

public class HomeFragment extends BaseFragment {

    private HomeActivity mActivity;

    public static HomeFragment newInstance() {
	HomeFragment f = new HomeFragment();
	return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	mActivity = (HomeActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	View v = inflater.inflate(R.layout.fragment_home, null);
	ButterKnife.inject(this, v);
	if (!UserManager.isLoggedIn(mActivity)) {
	    mActivity.showLoginDialog();
	} else {
	    load();
	}
	return v;
    }

    public void load() {

    }
}
