package uk.co.sammy.classes;

import java.math.BigDecimal;

/**
 * Created by smlif on 07/01/2016.
 */
public class MarketWatcher {
    public Stock getQuote(String symbol) {
        return new Stock("", "", new BigDecimal(200.00));
    }
}
