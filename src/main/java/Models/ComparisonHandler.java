package Models;

import DataObjects.StockProfile;

import java.util.Comparator;

public class ComparisonHandler {
    static class SortByCompanyName implements Comparator<DataObjects.StockProfile>{
        @Override
        public int compare(StockProfile stock1, StockProfile stock2) {
            return stock1.getCompanyName().compareTo(stock2.getCompanyName());
        }
    }
    static class SortByStockCode implements Comparator<DataObjects.StockProfile>{
        @Override
        public int compare(StockProfile stock1, StockProfile stock2) {
            return stock1.getStockCode().compareTo(stock2.getStockCode());
        }
    }
    static class SortByCurrentPrice implements Comparator<DataObjects.StockProfile>{
        @Override
        public int compare(StockProfile stock1, StockProfile stock2) {
            return (int)(stock1.getCurrPrice() - stock2.getCurrPrice());
        }
    }

    static class SortByHighestPrice implements Comparator<DataObjects.StockProfile>{
        @Override
        public int compare(StockProfile stock1, StockProfile stock2) {
            return (int)(stock1.getHighestPrice() - stock2.getHighestPrice());
        }
    }

    static class SortByLowestPrice implements Comparator<DataObjects.StockProfile>{
        @Override
        public int compare(StockProfile stock1, StockProfile stock2) {
            return (int)(stock1.getLowestPrice() - stock2.getLowestPrice());
        }
    }
}
