package org.sujinde.module;

import org.sujinde.presenter.MainPresenter;
import org.sujinde.whatever.Practise;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Mr.SuJinde on 2016/6/16.
 */
@Component(modules = {FearlessModule.class})
@Singleton
public interface FearlessComp {
	void inject(MainPresenter mainPresenter);

	Practise getPra();
}
