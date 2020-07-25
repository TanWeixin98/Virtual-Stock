package Views;

import DataObjects.UserProfile;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;

public class MainView{

    private static final String resourceFileName = "Views/Main.fxml";
    private BorderPane mainViewNode;

    public MainView(){
        onInitialize();
    }

    private void onInitialize(){
        try {
            loadFXMLView();

            //initalize all nodes and default display is currently user profile
            //TODO: maybe make each node into singleton in future?
            //TODO: decide which is the default display node
            UserProfileView userProfileView = new UserProfileView();
            mainViewNode.setCenter(userProfileView.getUserProfileView());
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

        //set property
        //maybe can be done in fxml too?
        mainViewNode.setRight(new Pane());
        mainViewNode.getRight().maxWidth(0);
        mainViewNode.getRight().maxHeight(0);

        mainViewNode.setTop(new Pane());
        mainViewNode.getTop().maxWidth(0);
        mainViewNode.getTop().maxHeight(0);

        mainViewNode.setBottom(new Pane());
        mainViewNode.getBottom().maxWidth(0);
        mainViewNode.getBottom().maxHeight(0);
    }

    public Parent getMainView() {
        return mainViewNode;
    }
}


