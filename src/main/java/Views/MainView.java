package Views;

import DataObjects.UserProfile;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;

public class MainView{

    private static final String resourceFileName = "Views/Main.fxml";
    private Parent mainViewNode;

    public MainView(){
        onInitialize();
    }

    private void onInitialize(){
        try {
            loadFXMLView();
            UserProfileView userProfileView = new UserProfileView();
            ((Pane)mainViewNode).getChildren().add(userProfileView.getUserProfileView());
        }catch (Exception e){
            //TODO: handle exception
            System.out.println(e);
        }
        //component initialisation
        //component binding
    }


    private void loadFXMLView() throws Exception{
        URL resourceLocation = getClass().getClassLoader().getResource(resourceFileName);
        if(resourceLocation == null)
            //TODO: create new exception for ViewInitaliztion
            throw new Exception();
        mainViewNode = FXMLLoader.load(resourceLocation);
    }

    public Parent getMainView() {
        return mainViewNode;
    }
}


