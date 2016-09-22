package info.krushik.android.jsonretrofitrx.retrofit;

import info.krushik.android.jsonretrofitrx.api.VideoList;

import retrofit2.http.GET;
import rx.Observable;


public interface ProjectAPI {

    @GET("/TheKrushik/JsonRetrofitRx/master/Video.txt")
    Observable<VideoList> getAllVideo();

}
