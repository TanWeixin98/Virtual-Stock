package Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.net.URL;

public class MainView{

    private static final String resourceFileName = "Views/Main.fxml";
    private Scene mainViewScene;

    public MainView(){
        OnInitialize();
    }

    private void OnInitialize(){
        try {
            ViewInitialization();
        }catch (Exception e){
            //TODO: handle exception
        }
        //component initialisation
        //component binding
    }


    private void ViewInitialization() throws Exception{
        URL resourceLocation = getClass().getClassLoader().getResource(resourceFileName);
        if(resourceLocation == null)
            //TODO: create new exception for ViewInitaliztion
            throw new Exception();
        Parent mainView = FXMLLoader.load(resourceLocation);
        mainViewScene= new Scene(mainView ,ViewConfigurations.MAIN_VIEW_WIDTH, ViewConfigurations.MAIN_VIEW_HEIGHT);
    }

    public Scene getMainView() {
        return mainViewScene;
    }
}


