package Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.net.URL;

public class StockComparisonView {
    private static final String resourceName = "";
    private Node stockComparisonViewNode;

    StockComparisonView(){ onInitalize(); }

    public Node getUserProfileNode(){
        return stockComparisonViewNode;
    }

    private void onInitalize(){
        try{
            loadFXMLView();
        }catch (Exception e){
            //TODO: handle error
        }
    }

    private void loadFXMLView() throws Exception {
        URL resourceLocation = getClass().getClassLoader().getResource(resourceName);
        if (resourceLocation == null)
            //TODO: create new exception for ViewInitaliztion
            throw new Exception();
        stockComparisonViewNode = FXMLLoader.load(resourceLocation);
    }
}
