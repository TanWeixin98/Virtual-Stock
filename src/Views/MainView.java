package Views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainView extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button btn = new Button("OK");
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 1024, 768);
        stage.setTitle("Virtual Stock");
        stage.setScene(scene);
        stage.show();
    }
}
