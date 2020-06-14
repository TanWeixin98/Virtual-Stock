package Views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MainView extends Application {
    public static final double WIDTH = 1024;
    public static final double HEIGHT = 768;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        root.setLeft(addVBox());
        root.setTop(addSearchBar());
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setTitle("Virtual Stock");
        stage.setScene(scene);
        stage.show();
    }

    public VBox addVBox() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        Hyperlink options[] = new Hyperlink[] {
                new Hyperlink("Home"),
                new Hyperlink("History"),
                new Hyperlink("Setting")
        };

        for (int i=0; i<3; i++) {
            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            vbox.getChildren().add(options[i]);
        }

        return vbox;
    }

    public HBox addSearchBar() {
        HBox hbox = new HBox();
        Label searchLabel = new Label("Search Stock");
        searchLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        TextField searchBar = new TextField();
        searchBar.setPrefWidth(WIDTH * 0.75);

        Button stockSearch = new Button("search");

        HBox.setMargin(searchBar, new Insets(5, 10, 5, 10));
        HBox.setMargin(searchLabel, new Insets(5, 0, 0, 10));
        HBox.setMargin(stockSearch, new Insets(5, 0, 0, 0));

        hbox.getChildren().add(searchLabel);
        hbox.getChildren().add(searchBar);
        hbox.getChildren().add(stockSearch);
        return hbox;
    }
}


