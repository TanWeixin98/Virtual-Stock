package Models;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import DataObjects.StockProfile;
import Models.ComparisonHandler.SortByCompanyName;
import Models.ComparisonHandler.SortByStockCode;
import Models.ComparisonHandler.SortByCurrentPrice;
import Models.ComparisonHandler.SortByHighestPrice;
import Models.ComparisonHandler.SortByLowestPrice;


public class ComparisonTest {
    private StockProfile appleStock = new StockProfile("AAPL", "Apple", "", 364.11,372.38, 192.58);
    private StockProfile teslaStock = new StockProfile("TSLA", "Tesla Inc.", "", 1208.66,1228.00, 211.00);
    private StockProfile googleStock = new StockProfile("GOOGL", "Alphabet Inc. Class A", "", 1469.93,1530.74, 1008.87);
    private StockProfile amazonStock = new StockProfile("AMZN", "Amazon.com", "", 2890.30,2955.56, 1626.03);

    private SortByCompanyName companyNameComparator = new SortByCompanyName();
    private SortByStockCode stockCodeComparator = new SortByStockCode();
    private SortByCurrentPrice currentPriceComparator = new SortByCurrentPrice();
    private SortByHighestPrice highestPriceComparator = new SortByHighestPrice();
    private SortByLowestPrice lowestPriceComparator = new SortByLowestPrice();

    @Test
    void stockNameComparison(){
        StockProfile stock1 = new StockProfile("ARG", "Company", "", 0, 0, 0);
        StockProfile stock2 = new StockProfile("NRG", "Company", "", 10, 10, 10);
        StockProfile stock3 = new StockProfile("BFG", "Google", "", 5, 5, 5);
        StockProfile stock4 = new StockProfile("AMZ", "Amazon", "", 1, 1, 1);
        assertEquals(0, companyNameComparator.compare(stock1, stock2));
        assertEquals(-4, companyNameComparator.compare(stock2, stock3));
        assertEquals(2, companyNameComparator.compare(stock2, stock4));
        assertEquals(4, companyNameComparator.compare(stock3, stock2));
        assertEquals(-2, companyNameComparator.compare(stock4, stock2));
    }

    @Test
    void stockCodeComparison(){
        StockProfile stock1 = new StockProfile("ABC", "", "", 0, 0, 0);
        StockProfile stock2 = new StockProfile("ABC", "", "", 0, 0, 0);
        StockProfile stock3 = new StockProfile("QIA", "", "", 0, 0, 0);
        StockProfile stock4 = new StockProfile("AMZ", "", "", 0, 0, 0);
        assertEquals(0, stockCodeComparator.compare(stock1, stock2));
        assertEquals(-16, stockCodeComparator.compare(stock1, stock3));
        assertEquals(-11, stockCodeComparator.compare(stock1, stock4));
        assertEquals(16, stockCodeComparator.compare(stock3, stock4));
    }

    @Test
    void currentPriceComparison(){
        StockProfile stock1 = new StockProfile("", "", "", 0, 0, 0);
        StockProfile stock2 = new StockProfile("", "", "", 10, 0, 0);
        StockProfile stock3 = new StockProfile("", "", "", 5, 0, 0);
        assertEquals(0, currentPriceComparator.compare(stock1, stock1));
        assertEquals(-10, currentPriceComparator.compare(stock1, stock2));
        assertEquals(5, currentPriceComparator.compare(stock2, stock3));
    }

    @Test
    void highestPriceComparison(){
        StockProfile stock1 = new StockProfile("", "", "", 0, 0, 0);
        StockProfile stock2 = new StockProfile("", "", "", 0, 10, 0);
        StockProfile stock3 = new StockProfile("", "", "", 0, 5, 0);
        assertEquals(0, highestPriceComparator.compare(stock1, stock1));
        assertEquals(-10, highestPriceComparator.compare(stock1, stock2));
        assertEquals(5, highestPriceComparator.compare(stock2, stock3));
    }

    @Test
    void lowestPriceComparison(){
        StockProfile stock1 = new StockProfile("", "", "", 0, 0, 0);
        StockProfile stock2 = new StockProfile("", "", "", 0, 0, 10);
        StockProfile stock3 = new StockProfile("", "", "", 0, 0, 5);
        assertEquals(0, lowestPriceComparator.compare(stock1, stock1));
        assertEquals(-10, lowestPriceComparator.compare(stock1, stock2));
        assertEquals(5, lowestPriceComparator.compare(stock2, stock3));
    }
}
