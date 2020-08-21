package Models;

import Configurations.APIConfigurations;
import org.json.JSONArray;

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
