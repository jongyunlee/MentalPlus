package com.plusmental.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.plusmental.R;
import java.lang.Thread;

public class SplashFragment extends BaseFragment {

    private BaseActivity mActivity;

    public static SplashFragment newInstance() {
	SplashFragment f = new SplashFragment();
	return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	mActivity = (BaseActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	View v = inflater.inflate(R.layout.fragment_splash, null);
	ButterKnife.inject(this, v);
	Thread t = new Thread() {
		public void run() {
		    try {
			Thread.sleep(2000);
		    } catch (InterruptedException ignore) { }
		    mHandler.sendEmptyMessage(0);
		}
	    };
	t.start();
	return v;
    }

    Handler mHandler = new Handler() {
	    @Override
	    public void handleMessage(Message msg) {
		Intent intent = new Intent(mActivity, HomeActivity.class);
		startActivity(intent);
		mActivity.finish();
	    }
	};
}
