package complex2.task3;

public class BookProxy {
    private final Book book;
    private String bookcontent;


    public BookProxy(Book book) {
        this.book = book;
    }

    public String getBookcontent() {
        if (bookcontent == null) {
            bookcontent = book.getContent();
        } else {
            System.out.println("content was already loaded");
        }
        return bookcontent;
    }
}
