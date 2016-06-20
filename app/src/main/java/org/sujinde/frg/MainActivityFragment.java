package org.sujinde.frg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.components.support.RxAppCompatDialogFragment;

import org.sujinde.fearless.R;
import org.sujinde.helpers.GlideHep;
import org.sujinde.presenter.MainPresenter;
import org.sujinde.utils.Logg;
import org.sujinde.utils.RBUtil;
import org.sujinde.utils.ToastUtil;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements MainViewIF {
	MainPresenter mainPresenter;
	@Bind(R.id.iv)
	ImageView iv;

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
		View view = inflater.inflate(R.layout.fragment_main, container, false);
		ButterKnife.bind(this, view);
		return view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
//		mainPresenter.rxJava();
//		mainPresenter.testNet();
//		mainPresenter.testDagger();
		GlideHep.simPleShow("http://pic55.nipic.com/file/20141208/19462408_171130083000_2.jpg", iv);
		responseRxBus();
		mainPresenter.testRxBus();
		RxView.clicks(iv).subscribe(new Action1<Void>() {
			@Override
			public void call(Void aVoid) {
				ToastUtil.shrMsg("Bite Me !");
			}
		});
	}

	@Override
	public void setText(String s) {
		ToastUtil.shrMsg(s);
	}

	@Override
	public void responseRxBus() {
		RBUtil.getInstance().toObservable().subscribe(new Action1<Object>() {
			@Override
			public void call(Object o) {
				if (o instanceof String) {
					ToastUtil.shrMsg(o.toString());
				}
			}
		});
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		ButterKnife.unbind(this);
	}
}
