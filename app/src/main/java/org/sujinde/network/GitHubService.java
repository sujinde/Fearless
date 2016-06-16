package org.sujinde.network;

import android.text.TextUtils;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.github.simonpercic.oklog3.OkLogInterceptor;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Mr.SuJinde on 2016/6/15.
 */
public class GitHubService {
	private GitHubService() {
	}

	public static GitHubApi createGitHubService(final String gitHubToken) {
		Retrofit.Builder builder = new Retrofit.Builder().baseUrl("https://api.github.com/").addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(JacksonConverterFactory.create());
//		if (!TextUtils.isEmpty(gitHubToken)) {
//		}
		OkLogInterceptor okLogInterceptor = OkLogInterceptor.builder().build();
		HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
		httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
			@Override
			public Response intercept(Chain chain) throws IOException {
				Request newReq = chain.request().newBuilder().addHeader("Authorization", String.format("token %s", gitHubToken)).build();
				return chain.proceed(newReq);
			}
		}).connectTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).addInterceptor(okLogInterceptor).addNetworkInterceptor(new StethoInterceptor()).build();
		builder.client(client);

		return builder.build().create(GitHubApi.class);
	}
}
