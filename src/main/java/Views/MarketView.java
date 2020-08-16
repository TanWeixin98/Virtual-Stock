package Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.net.URL;

public class MarketView {
    private static final String resourceName = "";
    private Node marketViewNode;

    MarketView(){onInitalize(); }

    public Node getMarketViewNode(){
        return marketViewNode;
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
        marketViewNode = FXMLLoader.load(resourceLocation);
    }
}
