package uk.co.sammy.classes;

import uk.co.sammy.interfaces.ErrorType;

/**
 * Created by smlif on 05/01/2016.
 */
public class DispenserFailedException extends Exception {
    public DispenserFailedException(ErrorType errorType, String message){
        super(message);
    }
}
