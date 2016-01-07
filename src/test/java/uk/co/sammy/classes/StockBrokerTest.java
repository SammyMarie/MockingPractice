package uk.co.sammy.classes;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

/**
 * Created by smlif on 07/01/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class StockBrokerTest {
    @Mock
    MarketWatcher marketWatcher;

    @Mock
    Portfolio portfolio;

    StockBroker broker;

    @Before
    public void setUp(){
        broker = new StockBroker(marketWatcher);
    }

    @Test
    public void sanity() throws Exception{
        assertThat(marketWatcher).isNotNull();
        assertThat(portfolio).isNotNull();
    }

    @Test
    public void checkMarketWatcherRetuensStockStatus(){
        Stock uvsityCorp = new Stock("UV", "Uvsity Corporation", new BigDecimal("100.00"));

        when(marketWatcher.getQuote(anyString())).thenReturn(uvsityCorp);
        assertThat(marketWatcher.getQuote("UV")).isNotNull();
    }

    @Test
    public void checkStockSoldWith10PercentGain(){
        when(portfolio.getAvgPrice(isA(Stock.class))).thenReturn(new BigDecimal("10.00"));
        Stock aCorp = new Stock("A", "A Corp", new BigDecimal("11.20"));
        when(marketWatcher.getQuote(anyString())).thenReturn(aCorp);

        broker.perform(portfolio, aCorp);
        verify(portfolio).sell(aCorp, 10);
    }
}
