package Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainView{

    private Scene mainViewScene;

    public MainView(){
        OnInitialize();
    }

    private void OnInitialize(){
        try {
            ViewInitialization();
        }catch (Exception e){
            System.out.println(e.getMessage());
            //TODO: handle exception
        }
        //component initialisation
        //component binding
    }


    private void ViewInitialization() throws Exception{
        Parent mainView = FXMLLoader.load(getClass().getResource("Main.fxml"));
        mainViewScene= new Scene(mainView ,ViewConfigurations.MAIN_VIEW_WIDTH, ViewConfigurations.MAIN_VIEW_HEIGHT);
    }


    public Scene getMainView() {
        return mainViewScene;
    }
}


