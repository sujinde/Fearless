package org.sujinde.helpers;

import android.support.v4.app.Fragment;

import org.sujinde.global.FearlessApp;

import java.util.HashMap;

/**
 * Created by Mr.SuJinde on 2016/6/15.
 */
public class FrgHep {
	static HashMap<String, Fragment> map = new HashMap<>();
	static Fragment frg;

	public static Fragment get(String frgName) {
		frg = map.get(frgName);
		if (frg == null) {
			frg = Fragment.instantiate(FearlessApp.getContext(), frgName);
			map.put(frgName, frg);
		}
		return frg;
	}
}
