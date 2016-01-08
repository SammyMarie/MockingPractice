package uk.co.sammy.classes;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by smlif on 07/01/2016.
 */
public class Portfolio {
    private Map<String, List<Stock>> stockMap = new HashMap<>();

    public BigDecimal getAvgPrice(Stock stock) {
        List<Stock> stocks = stockMap.get(stock.getSymbol());
        BigDecimal avgPrice = BigDecimal.ZERO;

        if(stocks != null){
            for(Stock aStock : stocks){
                avgPrice = avgPrice.add(aStock.getPrice());
            }
            avgPrice = avgPrice.divide(new BigDecimal(stocks.size()));
        }
        return avgPrice;
    }

    public void buy(Stock stock) {
        List<Stock> stocks = stockMap.get(stock.getSymbol());
        if(stocks != null){
            stocks.add(stock);
        }else {
            stocks = new ArrayList<>();
            stocks.add(stock);
            stockMap.put(stock.getSymbol(), stocks);
        }
    }

    public void sell(Stock stock, int quauntity) {
        List<Stock> stocks = stockMap.get(stock.getSymbol());
        if(stocks == null){
            throw new IllegalStateException(stock.getSymbol() + "not bought");
        }

        if(stocks.size() < quauntity){
            quauntity = stocks.size();
        }

        for(int index = quauntity - 1; index >= 0; index --){
            stocks.remove(index);
        }
    }

    public BigDecimal getCurrentValue(){
        BigDecimal avgPrice = BigDecimal.ZERO;
        for(String stockId : stockMap.keySet()){
            for(Stock stock : stockMap.get(stockId)){
                avgPrice = avgPrice.add(stock.getPrice());
            }
        }
        return avgPrice;
    }
}
