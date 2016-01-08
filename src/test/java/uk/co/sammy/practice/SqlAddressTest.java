package uk.co.sammy.practice;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.Times;
import uk.co.sammy.interfaces.Dispenser;

import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

/**
 * Created by smlif on 06/01/2016.
 */
public class SqlAddressTest {
    @Mock
    Dispenser failingDispenser;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Ignore("This test doesn't interact with the Mock")
    public void checkRolledBackTransaction() throws DispenserFailedException {
        Account myAccount = new Account("John", 2000.00);
        TransactionManager txMangr = TransactionManager.forAccount(myAccount);
        txMangr.registerMoneyDispenser(failingDispenser);

        doThrow(new DispenserFailedException()).when(failingDispenser).dispense(isA(BigDecimal.class));
        txMangr.withdraw(500);

        assertThat(2000.00).isEqualTo(myAccount.getRemainingBalance());
        verify(failingDispenser, new Times(1)).dispense(isA(BigDecimal.class));
    }
}
