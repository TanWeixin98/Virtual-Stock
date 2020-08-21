package DataObjects;

import java.util.ArrayList;
import java.util.List;

//TODO: Need to implement comparator for sorting and stock comparison
public class StockProfile {

    private String stockCode, companyName, description;
    private double currPrice, highestPrice, lowestPrice;
    private List<String> tags;

    public StockProfile(String stockCode, String companyName){
        this.stockCode = stockCode;
        this.companyName = companyName;
    }

    public StockProfile(String stockCode, String companyName, String description,
                        double currPrice,double highestPrice, double lowestPrice){
        this.stockCode = stockCode;
        this.companyName = companyName;
        this.description = description;
        this.currPrice = currPrice;
        this.highestPrice = highestPrice;
        this.lowestPrice = lowestPrice;
        tags = new ArrayList<>();
    }

    public String getStockCode() {return stockCode;}

    public String getCompanyName() {return companyName;}

    public String getDescription() {return description;}

    public List<String> getTags() {return tags;}

    public double getCurrPrice() {return currPrice;}

    public double getHighestPrice() {return highestPrice;}

    public double getLowestPrice() {return lowestPrice;}

    public void setCurrPrice(double currPrice) {
        this.currPrice = currPrice;

        if(currPrice < lowestPrice){ lowestPrice = currPrice;}
        else if(currPrice > highestPrice) { highestPrice = currPrice;}
    }

    public StockProfile addTag(String tag) {
        tags.add(tag);
        return this;
    }

    public boolean containsTag(String tag){return tags.contains(tag);}

}
