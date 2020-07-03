package Models;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import DataObjects.StockProfile;
import Models.ComparisonHandler.SortByCompanyName;


public class ComparisonTest {
    private StockProfile appleStock = new StockProfile("AAPL", "Apple", "", 364.11,372.38, 192.58);
    private StockProfile teslaStock = new StockProfile("TSLA", "Tesla Inc.", "", 1208.66,1228.00, 211.00);
    private StockProfile googleStock = new StockProfile("GOOGL", "Alphabet Inc. Class A", "", 1469.93,1530.74, 1008.87);
    private StockProfile amazonStock = new StockProfile("AMZN", "Amazon.com", "", 2890.30,2955.56, 1626.03);

    private SortByCompanyName companyNameComparator = new SortByCompanyName();

    @Test
    void stockCodeComparison(){
        StockProfile stock1 = new StockProfile("ARG", "Company", "", 0, 0, 0);
        StockProfile stock2 = new StockProfile("NRG", "Company", "", 10, 10, 10);
        assertEquals(0, companyNameComparator.compare(stock1, stock2));
    }

}
