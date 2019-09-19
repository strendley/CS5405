package code;

import javafx.scene.control.Label;// set the actors
import javafx.scene.Scene;// set the scene
import javafx.stage.Stage;// set the stage
import javafx.application.Application;// raise the curtain


/// default rootpane is StackPane
public class JavaFXLabelDemo extends Application {
   
    @Override // Override the start method in the Application class
     public void start(Stage stage) {
        // Create a button and place it in the scene
        Label label= new Label("Hello World - CS5405 ");
        // Scene scene = new Scene(label);
         Scene scene = new Scene(label, 300,300);
       // stage.setTitle("JavaFXDemo"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
         //optional
         stage.setTitle("Label Demo");
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
