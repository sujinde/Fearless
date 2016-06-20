package org.sujinde.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import org.sujinde.fearless.R;
import org.sujinde.frg.MainActivityFragment;
import org.sujinde.helpers.FrgHep;
import org.sujinde.utils.Logg;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

public class MainActivity extends RxAppCompatActivity {
	@Bind(R.id.toolbar)
	Toolbar toolbar;
	@Bind(R.id.fab)
	FloatingActionButton fab;
	@Bind(R.id.container_main)
	FrameLayout containerMain;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		setSupportActionBar(toolbar);
		getSupportFragmentManager().beginTransaction().add(R.id.container_main, FrgHep.get(MainActivityFragment.class.getName())).addToBackStack(null).commit();
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});
		Observable.interval(2, TimeUnit.SECONDS).doOnUnsubscribe(new Action0() {
			@Override
			public void call() {
				Logg.i("UnSubscribing from onCreate()");
			}
		}).compose(this.<Long>bindToLifecycle()).subscribe(new Action1<Long>() {
			@Override
			public void call(Long aLong) {
				Logg.i("Damn Administration");
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		Observable.interval(2, TimeUnit.SECONDS).doOnUnsubscribe(new Action0() {
			@Override
			public void call() {
				Logg.i("UnSubscribing from onStart()");
			}
		}).compose(this.<Long>bindToLifecycle()).subscribe(new Action1<Long>() {
			@Override
			public void call(Long aLong) {
				Logg.i("Damn HR");
			}
		});
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
