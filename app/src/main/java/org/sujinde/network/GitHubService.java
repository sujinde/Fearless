package org.sujinde.network;

import android.text.TextUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Mr.SuJinde on 2016/6/15.
 */
public class GitHubService {
	private GitHubService() {
	}

	public static GitHubApi createGitHubService(final String githubToken) {
		Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://api.github.com/").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(JacksonConverterFactory.create());
		if (!TextUtils.isEmpty(githubToken)) {
			OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
				@Override
				public Response intercept(Chain chain) throws IOException {
					Request newReq = chain.request().newBuilder().addHeader("Authorization", String.format("token %s", githubToken)).build();
					return chain.proceed(newReq);
				}
			}).build();
			builder.client(client);
		}
		return builder.build().create(GitHubApi.class);
	}
}
