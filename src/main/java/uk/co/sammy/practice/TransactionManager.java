package uk.co.sammy.practice;

import uk.co.sammy.interfaces.Dispenser;

/**
 * Created by smlif on 05/01/2016.
 */
public class TransactionManager {
    public static TransactionManager forAccount(Account myAccount) {
        return new TransactionManager();
    }

    public void registerMoneyDispenser(Dispenser alwaysFailingDispenserStub) {
       new AlwaysFailingDispenserStub();
    }

    public WithdrawalResponse withdraw(double amount) {

        return new WithdrawalResponse();
    }
}
