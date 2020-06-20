package Views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainView extends Application {
    public static final double WIDTH = 1024;
    public static final double HEIGHT = 768;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setTitle("Virtual Stock");
        stage.setScene(scene);
        stage.show();
    }
}


