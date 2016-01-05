package uk.co.sammy.classes;

/**
 * Created by smlif on 05/01/2016.
 */
public class Book {
    private String bookName;
    private String isbn;

    public Book(String bookName, String isbn) {
        this.bookName = bookName;
        this.isbn = isbn;
    }

    public void issueTo(Member member) {
    }

    public int numberOfTimesIssued() {
        return 0;
    }
}
