package Models;

import Configurations.APIConfigurations;
import DataObjects.StockProfile;
import DataObjects.StockProfiles;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class StockHandler {
    public static void UpdateStock(){
        Future<JSONArray> res = APIEngine.SubmitAPICall(APIConfigurations.FinhubBaseAPI+"/stock/symbol?", "exchange=US&token=" + Credential.API_key , 0, 1);
        while(!res.isDone())
        {
            //TODO: find better way instead of sleeping thread
            //TODO: currently blocking running thread. maybe make it not block
            try
            {
                Thread.sleep(500);
            }
            catch (Exception e)
            {
                //TODO: handle thread intruption
            }
        }

        try
        {
            JSONArray stockSymbolListJsonArray = res.get();
            StockProfiles stockMarketList = new StockProfiles();

            for (Object stockObj : stockSymbolListJsonArray) {
                JSONObject stockJsonObj = (JSONObject) stockObj;
                String stockCode = (String) stockJsonObj.get("symbol");
                String companyName = (String) stockJsonObj.get("description");
                stockMarketList.addStock(new StockProfile(stockCode, companyName));
            }
            System.out.println(stockSymbolListJsonArray);
        }
        catch (ExecutionException | InterruptedException error)
        {
            //TODO: handle error
            System.out.println(error.getMessage());
        }
    }

    public static void main(String[] args){
        UpdateStock();
    }
}
