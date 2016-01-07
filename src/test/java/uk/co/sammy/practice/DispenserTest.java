package uk.co.sammy.practice;

import org.junit.Test;
import uk.co.sammy.practice.Account;
import uk.co.sammy.practice.AlwaysFailingDispenserStub;
import uk.co.sammy.practice.TransactionManager;
import uk.co.sammy.practice.WithdrawalResponse;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by smlif on 05/01/2016.
 */
public class DispenserTest {

    @Test
    public void checkFailedTransactionFromHardwareError(){
        Account myAccount = new Account("John", 2000.00);
        TransactionManager txMangr = TransactionManager.forAccount(myAccount);
        txMangr.registerMoneyDispenser(new AlwaysFailingDispenserStub());
        WithdrawalResponse response = txMangr.withdraw(500.00);
        assertThat(false).isEqualTo(response.wasSuccess());
        assertThat(2000.00).isEqualTo(myAccount.remainingAmount());
    }
}
