package com.plusmental.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.plusmental.R;
import com.plusmental.model.SignupObject;
import com.plusmental.task.SignupTask.SignupTaskListener;
import com.plusmental.task.SignupTask;
import com.plusmental.ui.BaseDialogFragment.DialogClickListener;
import com.plusmental.util.UserManager;

public class SignupFragment extends DialogFragment {

    @InjectView(R.id.root) RelativeLayout rootView;
    @InjectView(R.id.btn_cancel) Button mCancelButton;
    @InjectView(R.id.btn_signup) Button mSignupButton;
    @InjectView(R.id.edit_name) EditText mNameEdit;
    @InjectView(R.id.edit_email) EditText mEmailEdit;
    @InjectView(R.id.edit_password) EditText mPasswordEdit;

    private BaseActivity mActivity;
    private Dialog dialog;
    private SignupTask mSignupTask;

    public static SignupFragment newInstance() {
	SignupFragment f = new SignupFragment();
	return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	mActivity = (BaseActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	View v = inflater.inflate(R.layout.fragment_signup, null);
	ButterKnife.inject(this, v);

	rootView.setOnClickListener(onButtonsClick);
	mCancelButton.setOnClickListener(onButtonsClick);
	mSignupButton.setOnClickListener(onButtonsClick);
	return v;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
	dialog = new Dialog(mActivity, android.R.style.Theme_Translucent_NoTitleBar);
        return dialog;
    }

    OnClickListener onButtonsClick = new OnClickListener() {
	    @Override
	    public void onClick(View v) {
		switch(v.getId()) {
		case R.id.root:
		    dismiss();
		    break;
		case R.id.btn_cancel:
		    dismiss();
		    break;
		case R.id.btn_signup:
		    signup();
		    break;
		}
	    }
	};

    public void signup() {
	mSignupTask = new SignupTask(mActivity,
				     mNameEdit.getText().toString(),
				     mEmailEdit.getText().toString(),
				     mPasswordEdit.getText().toString());
	mSignupTask.setSignupTaskListener(new SignupTaskListener() {
		@Override
		public void onSuccess(SignupObject result) {
		    UserManager.setUserNickname(mActivity, result.getName());
		    UserManager.setUserEmail(mActivity, result.getEmail());
		    UserManager.setUserId(mActivity, result.getId());
		    UserManager.setToken(mActivity, result.getToken());
		    Intent intent = new Intent(mActivity, SplashActivity.class);
		    startActivity(intent);
		    mActivity.finish();
		}

		@Override
		public void onFailure(SignupObject result) {
		    if (result != null) {
			showDialogMessage(result.getMessage());
		    } else {
			showDialogMessage("SERVER ERROR");
		    }
		}
	    });
	mSignupTask.execute();
    }

    @Override
    public void onPause() {
	if (mSignupTask != null) {
	    mSignupTask.cancel(true);
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
}
