package Views;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.net.URL;

public class SearchView{
    private static final String resourceName = "Views/UserProfile.fxml";
    private Node searchViewNode;

    SearchView(){onInitalize(); }

    public Node getUserProfileView(){
        return searchViewNode;
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
        searchViewNode = FXMLLoader.load(resourceLocation);
    }
}
