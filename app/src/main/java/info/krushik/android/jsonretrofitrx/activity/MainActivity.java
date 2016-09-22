package info.krushik.android.jsonretrofitrx.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import info.krushik.android.jsonretrofitrx.R;
import info.krushik.android.jsonretrofitrx.adapter.BookAdapter;
import info.krushik.android.jsonretrofitrx.adapter.VideoAdapter;
import info.krushik.android.jsonretrofitrx.model.Book;
import info.krushik.android.jsonretrofitrx.model.BookList;
import info.krushik.android.jsonretrofitrx.model.VideoList;
import info.krushik.android.jsonretrofitrx.retrofit.API;
import info.krushik.android.jsonretrofitrx.retrofit.RetrofitService;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getName();

    private Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void callServerFetchVideoList() {

        final API service = RetrofitService.createRetrofitClient();

        subscription = service.getAllVideo()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(videoObserver);
    }

    private void callServerFetchBookList() {
        final API service = RetrofitService.createRetrofitClient();

        subscription = service.getAllBook()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bookObserver);
    }

    Observer<VideoList> videoObserver = new Observer<VideoList>() {

        @Override
        public void onCompleted() {
            subscription.unsubscribe();
        }

        @Override
        public void onError(Throwable e) {
            // Called when the observable encounters an error
            Log.d(TAG, ">>>> onError gets called : " + e.getMessage());
        }

        @Override
        public void onNext(VideoList videoList) {
            findViewAndSetAdapter(videoList);
        }
    };

    Observer<BookList> bookObserver = new Observer<BookList>() {

        @Override
        public void onCompleted() {
            subscription.unsubscribe();
        }

        @Override
        public void onError(Throwable e) {
            // Called when the observable encounters an error
            Log.d(TAG, ">>>> onError gets called : " + e.getMessage());
        }

        @Override
        public void onNext(BookList bookList) {
            findViewAndSetAdapter(bookList);
        }
    };

    private void findViewAndSetAdapter(VideoList videoList) {

        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        VideoAdapter va = new VideoAdapter(videoList.getList());
        recList.setAdapter(va);
        va.notifyDataSetChanged();
    }

    private void findViewAndSetAdapter(BookList bookList) {

        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        BookAdapter ba = new BookAdapter(bookList.getList());
        recList.setAdapter(ba);
        ba.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refreshVideo:
                callServerFetchVideoList();
                return true;
            case R.id.refreshBook:
                callServerFetchBookList();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
