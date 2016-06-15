package org.sujinde.utils;

import com.orhanobut.logger.Logger;

/**
 * Created by Mr.SuJinde on 2016/6/15.
 */
public class Logg {
	static public void i(String s) {
		Logger.i(s);
	}

	static public void v(String s) {
		Logger.v(s);
	}

	static public void d(String s) {
		Logger.d(s);
	}

	static public void w(String s) {
		Logger.w(s);
	}

	static public void e(String s) {
		Logger.e(s);
	}

	static public void e(Exception e, String s) {
		Logger.e(e, s);
	}

	static public void j(String s) {
		Logger.json(s);
	}
}
