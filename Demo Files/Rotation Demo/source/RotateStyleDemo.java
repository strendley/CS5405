package code;

import javafx.scene.control.Button;
import javafx.scene.layout.*; //StackPane, Pane

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

public class RotateStyleDemo extends Application {
    Pane pane;
  @Override // Override the start method in the Application class
  public void start(Stage stage) {
    // Create a scene and place a button in the scene
    pane = new StackPane();
    rotatePane();
    Scene scene = new Scene(pane, 400, 450);
    stage.setScene(scene); // Place the scene in the stage
    stage.show(); // Display the stage
    stage.setTitle("RotateStyleDemo"); // Set the stage title
  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
    public void rotatePane()
    {Button buton = new Button("OK");
        buton.setStyle("-fx-border-color: blue;");
        pane.getChildren().add(buton);
        
        pane.setRotate(-45);
        pane.setStyle( "-fx-border-color: red; -fx-background-color: lightgray;");
    }
}
