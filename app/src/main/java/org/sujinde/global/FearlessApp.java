package org.sujinde.global;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by Mr.SuJinde on 2016/6/15.
 */
public class FearlessApp extends Application {
	final static String LOG_TAG = "王诺诺小姐";
	static Context context;

	static public Context getContext() {
		return context;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		context = getApplicationContext();
		initLogger();
		initStethoscope();
	}

	void initStethoscope() {
		Stetho.initializeWithDefaults(this);
	}

	void initLogger() {
		Logger.init(LOG_TAG)                 // default PRETTYLOGGER or use just init()
				.methodCount(4)                 // default 2
				.hideThreadInfo()               // default shown
				.methodOffset(0)
				.logLevel(LogLevel.FULL);       // default LogLevel.FULL
	}
}
