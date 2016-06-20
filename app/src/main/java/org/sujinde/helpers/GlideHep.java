package org.sujinde.helpers;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.sujinde.global.FearlessApp;

/**
 * Created by Mr.SuJinde on 2016/6/20.
 */
public class GlideHep {
	public static void simPleShow(String url, ImageView imageView) {
		Glide.with(FearlessApp.getContext()).load(url).centerCrop().crossFade().into(imageView);
	}
}
