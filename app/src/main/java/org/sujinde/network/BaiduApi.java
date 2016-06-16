package org.sujinde.network;

import org.sujinde.model.QRResult;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Mr.SuJinde on 2016/6/16.
 */
public interface BaiduApi {
	@GET("about/erweima")
	Observable<QRResult> get();

	@GET("about/erweima")
	Call<QRResult> get2();

}
