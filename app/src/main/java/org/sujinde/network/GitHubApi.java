package org.sujinde.network;

import org.sujinde.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Mr.SuJinde on 2016/6/15.
 */
public interface GitHubApi {
	@GET("users/{user}")
	Observable<User> user(@Path("user") String user);

	@GET("users/{user}")
	Call<User> user2(@Path("user") String user);
}
