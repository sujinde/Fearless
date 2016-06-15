package org.sujinde.frg;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.sujinde.fearless.R;
import org.sujinde.presenter.MainPresenter;
import org.sujinde.utils.ToastUtil;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements MainViewIF {
	MainPresenter mainPresenter;

	public MainActivityFragment() {
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initVariable();
	}

	void initVariable() {
		mainPresenter = new MainPresenter(this);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_main, container, false);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mainPresenter.rxJava();
	}

	@Override
	public void setText(String s) {
		ToastUtil.shrMsg(s);
	}
}
