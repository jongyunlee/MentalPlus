package com.plusmental.task;

import android.content.Context;
import com.plusmental.ApiPaths;
import com.plusmental.model.HomeObject;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Query;

public class HomeTask extends BaseAsyncTask<HomeObject> {

    private Context mContext;

    private HomeTaskListener mListener;

    public interface HomeTaskListener {
	public void onSuccess(HomeObject result);
	public void onFailure(HomeObject result);
    }

    public void setHomeTaskListener(HomeTaskListener listener) {
	mListener = listener;
    }

    public HomeTask(Context context) {
	super(context);
	mContext = context;
    }

    public interface HomeObjectTaskApi {
	@GET(ApiPaths.HOME_PATH)
	HomeObject create();
    }

    @Override
	protected HomeObject doInBackground(Void... args) {
	RestAdapter restAdapter = getRestAdapter();
	HomeObjectTaskApi register = restAdapter.create(HomeObjectTaskApi.class);
	HomeObject result = null;
	try {
	    result = register.create();
	} catch (RetrofitError error) {
	}
	return result;
    }

    @Override
	public void loadFinished(HomeObject result) {
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
