import Views.MainView;
import Views.ViewConfigurations;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApplicationLauncher extends Application{

    private static final Logger LOG = LogManager.getLogger(ApplicationLauncher.class);

    public void start(Stage primaryStage){
        LOG.info("Application Started.");
        ViewInitialization(primaryStage);
    }

    private static void ViewInitialization(Stage primaryStage){
        MainView mainView = new MainView();
        Parent mainViewNode = mainView.getMainView();
        Scene root = new Scene(mainViewNode,ViewConfigurations.MAIN_VIEW_WIDTH, ViewConfigurations.MAIN_VIEW_HEIGHT);
        primaryStage.setScene(root);
        primaryStage.setTitle(ViewConfigurations.APPLICATION_TITLE);
        primaryStage.show();
        LOG.debug("View Initialization Completed.");
    }
}
