package org.sujinde.whatever;

import android.util.Log;
import android.widget.Toast;


import com.orhanobut.logger.Logger;

import org.sujinde.utils.Logg;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Mr.SuJinde on 2016/6/15.
 */
public class Practise {

	public String rxJava() {
		String tmp = "";
		Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
			@Override
			public void call(Subscriber<? super String> subscriber) {
				subscriber.onNext("fuck");
			}
		}).subscribeOn(Schedulers.newThread());
		observable.observeOn(Schedulers.io()).subscribe(new Subscriber<String>() {
			@Override
			public void onCompleted() {

			}

			@Override
			public void onError(Throwable e) {

			}

			@Override
			public void onNext(String s) {
				Logg.i(s);
				System.out.print(s);
			}
		});
		Observable.just("fuck", "me", "baby").subscribe(new Action1<String>() {
			@Override
			public void call(String s) {
				Logg.i(s);
				Logger.i(s, "adf");
			}
		});
		Observable.just("Hello", "World").subscribe(new Subscriber<String>() {
			@Override
			public void onCompleted() {

			}

			@Override
			public void onError(Throwable e) {

			}

			@Override
			public void onNext(String s) {
				Log.i("fu", s);
				Logg.i(s);
			}
		});
		return tmp;
	}
}
