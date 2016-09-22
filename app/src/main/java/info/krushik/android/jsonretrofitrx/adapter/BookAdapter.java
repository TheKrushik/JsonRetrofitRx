package info.krushik.android.jsonretrofitrx.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import info.krushik.android.jsonretrofitrx.R;
import info.krushik.android.jsonretrofitrx.model.Book;
import info.krushik.android.jsonretrofitrx.model.Video;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> bookList;
    private List<Book.BookFiles> bookFilesList;

    public BookAdapter(List<Book> bookList, List<Book.BookFiles> bookFilesList) {
        this.bookList = bookList;
        this.bookFilesList = bookFilesList;
    }

//    public BookAdapter(List<Book> bookList) {
//        this.bookList = bookList;
//    }

    @Override
    public int getItemCount() {

        if (bookList != null) {
            return bookList.size();
        } else {
            return 0;
        }
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.cardview_layout_book, viewGroup, false);

        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BookViewHolder bookViewHolder, int position) {
        Book bi = bookList.get(position);
//        Book.BookFiles bfi = bookFilesList.get(position)
        bookViewHolder.title.setText(bi.getTitle());
        bookViewHolder.author.setText(bi.getAuthor());
        bookViewHolder.anons.setText(bi.getAnons());
        bookViewHolder.picture.setText(bi.getPicture());

//        bookViewHolder.typePdf.setText(bi.getDt());
//        bookViewHolder.urlPdf.setText(bi.getVideo());
//        bookViewHolder.urlEpub.setText(bi.getVideo());
//        bookViewHolder.urlEpub.setText(bi.getVideo());

    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        protected TextView title;
        protected TextView author;
        protected TextView anons;
        protected TextView picture;
        protected TextView typePdf;
        protected TextView urlPdf;
        protected TextView typeEpub;
        protected TextView urlEpub;
        protected LinearLayout container;

        public BookViewHolder(View v) {
            super(v);
            container = (LinearLayout) v.findViewById(R.id.item_layout_container);
            title = (TextView) v.findViewById(R.id.title);
            author = (TextView) v.findViewById(R.id.author);
            anons = (TextView) v.findViewById(R.id.anons);
            picture = (TextView) v.findViewById(R.id.picture);
            typePdf = (TextView) v.findViewById(R.id.typePdf);
            urlPdf = (TextView) v.findViewById(R.id.urlPdf);
            typeEpub = (TextView) v.findViewById(R.id.typeEpub);
            urlEpub = (TextView) v.findViewById(R.id.urlEpub);
        }
    }
}
