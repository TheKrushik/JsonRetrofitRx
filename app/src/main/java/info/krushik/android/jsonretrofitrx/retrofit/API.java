package info.krushik.android.jsonretrofitrx.retrofit;

import info.krushik.android.jsonretrofitrx.model.BookList;
import info.krushik.android.jsonretrofitrx.model.VideoList;

import retrofit2.http.GET;
import rx.Observable;


public interface API {

    @GET("TheKrushik/JsonRetrofitRx/master/Video.txt")
    Observable<VideoList> getAllVideo();

    @GET("TheKrushik/JsonRetrofitRx/master/Book.txt")
    Observable<BookList> getAllBook();

}
