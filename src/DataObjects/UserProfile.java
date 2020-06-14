package DataObjects;

import java.util.HashMap;
import java.util.Map;

public class UserProfile {

    private double totalInvestment, stocksValue, buyingPower, profit;
    private String username;
    private Map<String, Integer> stocksOwned;

    public UserProfile(double totalInvestment, double stocksValue, double buyingPower, double profit,
                        String username){
        this.totalInvestment = totalInvestment;
        this.stocksValue = stocksValue;
        this.buyingPower = buyingPower;
        this.profit = profit;
        this.username = username;
        this.stocksOwned =  new HashMap<>();
    }

    public double getTotalInvestment() {return totalInvestment;}

    public double getStocksValue() {return stocksValue;}

    public double getBuyingPower() {return buyingPower;}

    public double getProfit() {return profit;}

    public String getUsername() {return username;}

    public void setTotalInvestment(double totalInvestment) {this.totalInvestment = totalInvestment;}

    public void setStocksValue(double stocksValue) {this.stocksValue = stocksValue;}

    public void setBuyingPower(double buyingPower) {this.buyingPower = buyingPower;}

    public void setProfit(double profit) {this.profit = profit;}

    public void setUsername(String username) {this.username = username;}

    public void addStockOwned(StockProfile stock, Integer numberOfShares){
        stocksOwned.put(stock.getStockCode(), numberOfShares);
    }
}
