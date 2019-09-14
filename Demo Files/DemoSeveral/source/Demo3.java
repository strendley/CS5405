/*
 compile
        javac -d . source/Demo3.java
 execute
        java code.Demo3
*/
package code;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.shape.Circle;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

public class Demo3 extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        Button button = new Button("Hi I am a Push Button");
        button.setTooltip(new Tooltip("Tooltip for Button"));
        Circle circle = new Circle(50, 200, 200);
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(50);

        HBox pane = new HBox(5);
        pane.getChildren().addAll(button);
     //   pane.getChildren().addAll(button,circle);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Test"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
    
    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
