package uk.co.sammy.practice;

import org.junit.Test;
import uk.co.sammy.dummy.DummyMember;
import uk.co.sammy.practice.Book;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by smlif on 05/01/2016.
 */
public class BookTest {
    @Test
    public void checkDummy(){
        Book javaBook = new Book("Java 101", "1234567");

        DummyMember dummyMember = new DummyMember();

        javaBook.issueTo(dummyMember);

        assertThat(javaBook.numberOfTimesIssued()).isEqualTo(1);
    }
}
