package main.java.Controllers;

import javafx.event.Event;
import javafx.event.EventHandler;

public class MarketViewController {
    public MarketViewController() {

    }
    public static EventHandler generateHandler(Event event, String data){
        return new EventHandler() {
            @Override
            public void handle(Event event) {

            }
        };
    }
}
