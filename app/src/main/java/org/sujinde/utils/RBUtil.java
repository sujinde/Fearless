package org.sujinde.utils;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by Mr.SuJinde on 2016/6/20.
 */
public class RBUtil {
	private final static Subject<Object, Object> _bus = new SerializedSubject<>(PublishSubject.create());
	private static volatile RBUtil instance;

	private RBUtil() {
	}

	public static RBUtil getInstance() {
		if (null == instance) {
			synchronized (RBUtil.class) {
				if (null == instance) {
					instance = new RBUtil();
				}
			}
		}
		return instance;
	}

	public void send(Object o) {
		_bus.onNext(o);
	}

	public Observable<Object> toObservable() {
		return _bus;
	}
}
