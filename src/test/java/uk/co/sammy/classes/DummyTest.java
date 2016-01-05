package uk.co.sammy.classes;

import org.junit.Test;
import uk.co.sammy.dummy.DummyMember;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by smlif on 05/01/2016.
 */
public class DummyTest {
    @Test
    public void checkDummy(){
        Book javaBook = new Book("Java 101", "1234567");

        DummyMember dummyMember = new DummyMember();

        javaBook.issueTo(dummyMember);

        assertThat(javaBook.numberOfTimesIssued()).isEqualTo(1);
    }
}
