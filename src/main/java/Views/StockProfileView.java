package Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.net.URL;

public class StockProfileView {
    private static final String resourceName = "";
    private Node stockProfilVieweNode;

    StockProfileView(){onInitalize(); }

    public Node getUserProfileView(){
        return stockProfilVieweNode;
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
        stockProfilVieweNode = FXMLLoader.load(resourceLocation);
    }
}
