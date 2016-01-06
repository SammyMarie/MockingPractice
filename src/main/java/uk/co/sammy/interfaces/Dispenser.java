package uk.co.sammy.interfaces;

import uk.co.sammy.classes.DispenserFailedException;

import java.math.BigDecimal;

/**
 * Created by smlif on 05/01/2016.
 */
public interface Dispenser {
    void dispense(BigDecimal amount) throws DispenserFailedException;
}
