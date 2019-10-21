package code;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SliderDemo extends Application {
    Pane root = new Pane();
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(root, 500, 600);
      createSliders();
    primaryStage.setTitle("SliderDemo"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage   
  }

// create textlable , sliders
    public void createSliders()
    {
        Text text = new Text(20, 20, "JavaFX Programming");
     //   text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 36));
           
        Slider slHorizontal = new Slider();
        Slider slVertical = new Slider();
        slVertical.setOrientation(Orientation.VERTICAL);
          
        // Create a text in a pane
        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        
        // Create a border pane to hold text and scroll bars
        BorderPane bpane = new BorderPane();
        bpane.setCenter(paneForText);
        bpane.setBottom(slHorizontal);
        bpane.setRight(slVertical);
       // bpane.relocate(0,200);
        slHorizontal.valueProperty().addListener(ov ->
          text.setX(slHorizontal.getValue() * paneForText.getWidth() /
            slHorizontal.getMax()));
        
        slVertical.valueProperty().addListener(ov ->
          text.setY((slVertical.getMax() - slVertical.getValue())
            * paneForText.getHeight() / slVertical.getMax()));
        root.getChildren().add(bpane);
        
    }
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
