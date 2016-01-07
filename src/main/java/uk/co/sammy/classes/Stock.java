package uk.co.sammy.classes;

import java.math.BigDecimal;

/**
 * Created by smlif on 07/01/2016.
 */
public class Stock {
    private String name;
    private String symbol;
    private BigDecimal price;

    public Stock(String symbol, String name, BigDecimal price){
        this.name = name;
        this.price = price;
        this.symbol = symbol;
    }

    public String getName(){
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void updatePrice(BigDecimal newPrice){
        price = newPrice;
    }
}
