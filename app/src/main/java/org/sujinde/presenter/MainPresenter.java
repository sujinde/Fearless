package org.sujinde.presenter;

import org.sujinde.frg.MainActivityFragment;
import org.sujinde.helpers.GlideHep;
import org.sujinde.model.QRResult;
import org.sujinde.model.User;
import org.sujinde.module.DaggerFearlessComp;
import org.sujinde.module.FearlessComp;
import org.sujinde.network.BaiduApi;
import org.sujinde.network.BaiduService;
import org.sujinde.network.GitHubApi;
import org.sujinde.network.GitHubService;
import org.sujinde.presenter.pi.MainInterface;
import org.sujinde.utils.Logg;
import org.sujinde.utils.RBUtil;
import org.sujinde.whatever.Practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.inject.Inject;

import dagger.Lazy;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Mr.SuJinde on 2016/6/15.
 */
public class MainPresenter implements MainInterface {
	MainActivityFragment mainActivityFragment;
	@Inject
	Lazy<Practise> practiseLazy;
	FearlessComp fearlessComp;

	public MainPresenter(MainActivityFragment mainActivityFragment) {
		this.mainActivityFragment = mainActivityFragment;
	}

	private MainPresenter() {
	}

	@Override
	public void rxJava() {
		Logg.i("Here");
		GitHubApi gitHubApi = GitHubService.createGitHubService("91ee4676b551cd66fb6b57c97fde240dbc794c0e");
		gitHubApi.user("sujinde").subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<User>() {
			@Override
			public void onCompleted() {

			}

			@Override
			public void onError(Throwable e) {

			}

			@Override
			public void onNext(User user) {
				Logg.d(user.getEmail() + "fuck");
			}
		});
		gitHubApi.user2("sujinde").enqueue(new Callback<User>() {
			@Override
			public void onResponse(Call<User> call, Response<User> response) {
				Logg.i(response.body().getEmail());
			}

			@Override
			public void onFailure(Call<User> call, Throwable t) {
				t.printStackTrace();
			}
		});
	}

	@Override
	public void testNet() {
		BaiduApi baiduApi = BaiduService.createBaiduService();
		baiduApi.get2().enqueue(new Callback<QRResult>() {
			@Override
			public void onResponse(Call<QRResult> call, Response<QRResult> response) {
				Logg.i(response.message() + "--fuck");
			}

			@Override
			public void onFailure(Call<QRResult> call, Throwable t) {
				Logg.i("Failed--");
				t.printStackTrace();
			}
		});
		baiduApi.get().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<QRResult>() {
			@Override
			public void onCompleted() {

			}

			@Override
			public void onError(Throwable e) {

			}

			@Override
			public void onNext(QRResult qrResult) {
				Logg.i(qrResult.getData() + "--Yes");
			}
		});
	}

	@Override
	public void testDagger() {
		fearlessComp = DaggerFearlessComp.create();
		fearlessComp.inject(this);
//		practiseLazy.get().rxJava();
//		fearlessComp.getPra().rxJava();
	}

	@Override
	public void testRxBus() {
		RBUtil.getInstance().send("Hello World !");
	}
}
