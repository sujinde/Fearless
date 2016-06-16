package org.sujinde.network;

import org.junit.Test;
import org.sujinde.model.User;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import static org.junit.Assert.*;

/**
 * Created by Mr.SuJinde on 2016/6/16.
 */
public class GitHubServiceTest {
	
	@Test
	public void testCreateGitHubService() throws Exception {
		GitHubApi gitHubApi = GitHubService.createGitHubService("91ee4676b551cd66fb6b57c97fde240dbc794c0e");
		gitHubApi.user("sujinde").subscribeOn(Schedulers.newThread()).subscribe(new Action1<User>() {
			@Override
			public void call(User user) {
				System.out.println(user.getEmail());
			}
		});
	}
}