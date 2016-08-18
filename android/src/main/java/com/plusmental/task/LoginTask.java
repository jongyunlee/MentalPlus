package com.plusmental.task;

import android.content.Context;
import com.plusmental.ApiPaths;
import com.plusmental.model.LoginObject;
import com.plusmental.model.LoginParams;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.POST;
import retrofit.http.Body;
import retrofit.http.Query;

public class LoginTask extends BaseAsyncTask<LoginObject> {

    private Context mContext;

    private LoginTaskListener mListener;
    private String email;
    private String password;

    public interface LoginTaskListener {
	public void onSuccess(LoginObject result);
	public void onFailure(LoginObject result);
    }

    public void setLoginTaskListener(LoginTaskListener listener) {
	mListener = listener;
    }

    public LoginTask(Context context, String email, String password) {
	super(context);
	mContext = context;
	this.email = email;
	this.password = password;
    }

    public interface LoginObjectTaskApi {
	@POST(ApiPaths.LOGIN_PATH)
	LoginObject create(@Body LoginParams params);
    }

    @Override
	protected LoginObject doInBackground(Void... args) {
	RestAdapter restAdapter = getRestAdapter();
	LoginObjectTaskApi register = restAdapter.create(LoginObjectTaskApi.class);
	LoginObject result = null;
	try {
	    result = register.create(new LoginParams(email, password));
	} catch (RetrofitError error) {
	}
	return result;
    }

    @Override
	public void loadFinished(LoginObject result) {
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
