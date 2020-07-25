package Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import java.net.URL;

public class UserProfileView{
    private static final String resourceName = "Views/UserProfile.fxml";
    private Node userProfileViewNode;

    UserProfileView(){onInitalize(); }

    public Node getUserProfileView(){
        return userProfileViewNode;
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
        userProfileViewNode = FXMLLoader.load(resourceLocation);
    }
}
