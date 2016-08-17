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

public class HomeFragment extends BaseFragment {

    @InjectView(R.id.btn_login) Button mLoginButton;

    private BaseActivity mActivity;

    public static HomeFragment newInstance() {
	HomeFragment f = new HomeFragment();
	return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	mActivity = (BaseActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	View v = inflater.inflate(R.layout.fragment_home, null);
	ButterKnife.inject(this, v);
	mLoginButton.setOnClickListener(onButtonsClick);
	return v;
    }

    OnClickListener onButtonsClick = new OnClickListener() {
	    @Override
	    public void onClick(View v) {
		switch(v.getId()) {
		case R.id.btn_login:
		    Intent intent = new Intent(mActivity, SignupActivity.class);
		    startActivity(intent);
		    break;
		}
	    }
	};
}
