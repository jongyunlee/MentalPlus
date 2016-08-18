package com.plusmental.task;

import android.content.Context;
import com.plusmental.ApiPaths;
import com.plusmental.model.SignupObject;
import com.plusmental.model.SignupParams;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.POST;
import retrofit.http.Query;
import retrofit.http.Body;

public class SignupTask extends BaseAsyncTask<SignupObject> {

    private Context mContext;

    private SignupTaskListener mListener;
    private String name;
    private String email;
    private String password;

    public interface SignupTaskListener {
	public void onSuccess(SignupObject result);
	public void onFailure(SignupObject result);
    }

    public void setSignupTaskListener(SignupTaskListener listener) {
	mListener = listener;
    }

    public SignupTask(Context context, String name, String email, String password) {
	super(context);
	mContext = context;
	this.name = name;
	this.email = email;
	this.password = password;
    }

    public interface SignupObjectTaskApi {
	@POST(ApiPaths.SIGNUP_PATH)
	SignupObject create(@Body SignupParams params);
    }

    @Override
	protected SignupObject doInBackground(Void... args) {
	RestAdapter restAdapter = getRestAdapter();
	SignupObjectTaskApi register = restAdapter.create(SignupObjectTaskApi.class);
	SignupObject result = null;
	try {
	    result = register.create(new SignupParams(name, email, password));
	} catch (RetrofitError error) {
	}
	return result;
    }

    @Override
	public void loadFinished(SignupObject result) {
	if (mListener != null && result != null) {
	    mListener.onSuccess(result);
	} else {
	    mListener.onFailure(result);
	}
    }

    @Override
	public String getLoadingMessage() {
	return "로딩중...";
    }

    @Override
	public String getLoadingId() {
	return "loading";
    }
}
