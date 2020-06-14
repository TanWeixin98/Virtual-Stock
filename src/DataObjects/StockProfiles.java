package DataObjects;

import java.util.ArrayList;
import java.util.List;

public class StockProfiles {

    private List<StockProfile> stockProfiles;

    public StockProfiles(){
        stockProfiles = new ArrayList<>();
    }

    public List<StockProfile> getStockProfiles() {return stockProfiles;}

    public List<StockProfile> addStock(StockProfile stock){
        stockProfiles.add(stock);
        return stockProfiles;
    }

    public StockProfile removeStock(StockProfile stock){
        if(stockProfiles.remove(stock)){
            return stock;
        } else{
            return null;
        }
    }


}
