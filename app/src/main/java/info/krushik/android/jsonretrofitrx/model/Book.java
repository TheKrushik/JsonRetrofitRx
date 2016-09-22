package info.krushik.android.jsonretrofitrx.model;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private String title;
    private String author;
    private String anons;
    private String picture;
    private List<BookFiles> files = new ArrayList<BookFiles>();



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<BookFiles> getFiles() {
        return files;
    }

    public void setFiles(List<BookFiles> files) {
        this.files = files;
    }

    public class BookFiles {
        private String type;
        private String url;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
