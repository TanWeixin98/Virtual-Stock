import Views.MainView;
import Views.ViewConfigurations;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

public class ApplicationLauncher extends Application{

    public void start(Stage primaryStage){
        ViewInitialization(primaryStage);
    }

    private static void ViewInitialization(Stage primaryStage){
        MainView mainView = new MainView();
        Scene root = mainView.getMainView();
        primaryStage.setScene(root);
        primaryStage.setTitle(ViewConfigurations.APPLICATION_TITLE);
        primaryStage.show();
    }
}