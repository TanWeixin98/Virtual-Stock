package main.java.Controllers;

import javafx.event.Event;
import javafx.event.EventHandler;

public class MainController{

    public static EventHandler getHandler(Event event, Class c, String data){
        String className = c.getSimpleName();
        switch (className){
            case "MainView":
                System.out.println("MainView");
                return main.java.Controllers.MainViewController.generateHandler(event, data);
            case "MarketView":
                System.out.println("MarketView");
                return main.java.Controllers.MarketViewController.generateHandler(event, data);
            case "SearchView":
                System.out.println("SearchView");
                return main.java.Controllers.SearchViewController.generateHandler(event, data);
            case "StockComparisonView":
                System.out.println("StockComparisonView");
                return main.java.Controllers.StockComparisonController.generateHandler(event, data);
            case "StockProfileView":
                System.out.println("StockProfileView");
                return main.java.Controllers.StockProfileViewController.generateHandler(event, data);
            case "TimelineView":
                System.out.println("TimelineView");
                return main.java.Controllers.TimelineViewController.generateHandler(event, data);
            case "UserProfileView":
                System.out.println("UserProfileView");
                return main.java.Controllers.UserProfileController.generateHandler(event, data);
            default:
                System.out.println("Invalid Class");
                return new EventHandler() {
                    @Override
                    public void handle(Event event) {
                    }
                };
        }
    }

}
