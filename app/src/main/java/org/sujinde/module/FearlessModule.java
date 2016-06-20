package org.sujinde.module;

import org.sujinde.whatever.Practise;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mr.SuJinde on 2016/6/16.
 */
@Module
public class FearlessModule {
	@Provides
	@Singleton
	static Practise providePractise() {
		return new Practise();
	}
}
