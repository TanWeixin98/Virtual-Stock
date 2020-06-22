package Models;

import DataObjects.StockProfile;

import java.util.Comparator;

import DataObjects.StockProfile;

import java.util.Comparator;

public class ComparisonHandler {
    class SortByCompanyName implements Comparator<DataObjects.StockProfile>{
        @Override
        public int compare(StockProfile stock1, StockProfile stock2) {
            return stock1.getCompanyName().compareTo(stock2.getCompanyName());
        }
    }

    class SortByStockCode implements Comparator<DataObjects.StockProfile>{
        @Override
        public int compare(StockProfile stock1, StockProfile stock2) {
            return stock1.getStockCode().compareTo(stock2.getStockCode());
        }
    }
    
    class SortByCurrentPrice implements Comparator<DataObjects.StockProfile>{
        @Override
        public int compare(StockProfile stock1, StockProfile stock2) {
            return (int)(stock1.getCurrPrice() - stock2.getCurrPrice());
        }
    }
}
