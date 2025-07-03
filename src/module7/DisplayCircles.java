package module7;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Objects;

public class DisplayCircles extends Application {
    /*
     * Override the start method in the Application class
     */
    @Override
    public void start(Stage primaryStage) {

        HBox hBox = new HBox(5);
        Scene scene = new Scene(hBox, 400, 250);

        //get style sheet
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        //create pane, first circle, and all the styles
        Pane pane1 = new Pane();
        Circle circle1 = new Circle(50, 100, 30);

        pane1.getChildren().add(circle1);
        pane1.getStyleClass().add("border");

        circle1.getStyleClass().addAll("border", "circle");

        //create pane, 2, 3, 4 circle, and all the styles
        Pane pane2 = new Pane();
        Circle circle2 = new Circle(50, 100, 30);
        Circle circle3 = new Circle(120, 100, 30);
        Circle circle4 = new Circle(190, 100, 30);

        circle2.getStyleClass().add("circle");
        circle4.getStyleClass().add("circleBorder" );
        circle3.setId("redCircle");
        circle4.setId("greenCircle");
        pane2.getChildren().addAll(circle2, circle3, circle4);

        hBox.getChildren().addAll(pane1, pane2);

        /*
         * Set the window title
         */
        primaryStage.setTitle("Module 7.2");
        /*
         * Place the scene in the window
         */
        primaryStage.setScene(scene);
        /*
         * Display the window
         */
        primaryStage.show();
    }

    /*
     * Launch the program from command-line
     */
    public static void main(String[] args) {

        launch(args);
    }
}
