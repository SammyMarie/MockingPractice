package uk.co.sammy.practice;

import uk.co.sammy.interfaces.Dispenser;
import uk.co.sammy.interfaces.ErrorType;

import java.math.BigDecimal;

/**
 * Created by smlif on 05/01/2016.
 */
public class AlwaysFailingDispenserStub implements Dispenser{
    @Override
    public void dispense(BigDecimal amount) throws DispenserFailedException {
        throw new DispenserFailedException(ErrorType.HARDWARE, "not responding");
    }
}
