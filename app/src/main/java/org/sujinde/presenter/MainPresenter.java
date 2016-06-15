package org.sujinde.presenter;

import org.sujinde.frg.MainActivityFragment;
import org.sujinde.model.User;
import org.sujinde.network.GitHubApi;
import org.sujinde.network.GitHubService;
import org.sujinde.presenter.pi.MainInterface;
import org.sujinde.utils.Logg;
import org.sujinde.whatever.Practise;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Mr.SuJinde on 2016/6/15.
 */
public class MainPresenter implements MainInterface {
	MainActivityFragment mainActivityFragment;

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
				Logg.d(user.email);
			}
		});
	}
}
