package com.plusmental.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.plusmental.R;
import com.plusmental.model.HomeObject;
import com.plusmental.task.HomeTask.HomeTaskListener;
import com.plusmental.task.HomeTask;
import com.plusmental.ui.BaseDialogFragment.DialogClickListener;
import com.plusmental.util.UserManager;

public class HomeFragment extends BaseFragment {

    @InjectView(R.id.txt_name) TextView mNameView;
    @InjectView(R.id.txt_email) TextView mEmailView;
    @InjectView(R.id.txt_hearts_count) TextView mHeartsCountView;
    @InjectView(R.id.txt_level) TextView mLevelView;
    @InjectView(R.id.txt_total_xp) TextView mTotalXpView;
    @InjectView(R.id.txt_current_xp) TextView mCurrentXpView;
    @InjectView(R.id.btn_start) Button mStartButton;

    private HomeActivity mActivity;
    private HomeTask mHomeTask;

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
	mStartButton.setOnClickListener(onButtonsClick);
	return v;
    }

    public void load() {
	mHomeTask = new HomeTask(mActivity);
	mHomeTask.setHomeTaskListener(new HomeTaskListener() {
		@Override
		public void onSuccess(HomeObject result) {
		    mNameView.setText("NAME : " + result.getProfile().getName());
		    mEmailView.setText("EMAIL : " + result.getProfile().getEmail());
		    mHeartsCountView.setText("HEARTS : " + result.getHeartsCount() + "개");
		    mLevelView.setText("Lv. " + result.getLevel());
		    mTotalXpView.setText("Total XP : " + result.getTotalXp());
		    mCurrentXpView.setText("Current XP : " + result.getCurrentXp());
		}

		@Override
		public void onFailure(HomeObject result) {
		    if (result != null) {
			showDialogMessage(result.getMessage());
		    } else {
			showDialogMessage("SERVER ERROR");
		    }
		}
	    });
	mHomeTask.execute();
    }

    @Override
    public void onPause() {
	if (mHomeTask != null) {
	    mHomeTask.cancel(true);
	}
	super.onPause();
    }

    public void showDialogMessage(String message) {
	FragmentTransaction ft = getFragmentManager().beginTransaction();
	Fragment prev = getFragmentManager().findFragmentByTag("dialog");
	if (prev != null) {
	    ft.remove(prev);
	}
	ft.addToBackStack(null);
	BaseDialogFragment newFragment
	    = BaseDialogFragment.newInstance("",
					     message,
					     false);
	newFragment.show(ft, "dialog");
    }

    OnClickListener onButtonsClick = new OnClickListener() {
	    @Override
	    public void onClick(View v) {
		switch(v.getId()) {
		case R.id.btn_start:
		    Intent intent = new Intent(mActivity, GameActivity.class);
		    mActivity.startActivity(intent);
		    break;
		}
	    }
	};
}
