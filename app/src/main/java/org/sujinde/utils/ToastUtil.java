package org.sujinde.utils;

import android.widget.Toast;

import org.sujinde.global.FearlessApp;

/**
 * Created by Mr.SuJinde on 2016/6/15.
 */
public class ToastUtil {
	public static void shrMsg(String s) {
		Toast.makeText(FearlessApp.getContext(), s, Toast.LENGTH_SHORT).show();
	}
}
