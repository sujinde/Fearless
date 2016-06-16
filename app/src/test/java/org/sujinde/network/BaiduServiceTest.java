package org.sujinde.network;

import org.junit.Test;
import org.sujinde.model.QRResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import static org.junit.Assert.*;

/**
 * Created by Mr.SuJinde on 2016/6/16.
 */
public class BaiduServiceTest {
	
	@Test
	public void testCreateBaiduService() throws Exception {
		BaiduApi baiduApi = BaiduService.createBaiduService();
		baiduApi.get().subscribeOn(Schedulers.test()).observeOn(Schedulers.test()).subscribe(new Subscriber<QRResult>() {
			@Override
			public void onCompleted() {

			}

			@Override
			public void onError(Throwable e) {

			}

			@Override
			public void onNext(QRResult qrResult) {
				System.out.println(qrResult.getData() + "Hello World !");
			}
		});
		baiduApi.get2().enqueue(new Callback<QRResult>() {
			@Override
			public void onResponse(Call<QRResult> call, Response<QRResult> response) {
				System.out.println("Hello World !" + response.message());
			}

			@Override
			public void onFailure(Call<QRResult> call, Throwable t) {
				System.out.println("Hello World !+failed");
			}
		});
	}
}