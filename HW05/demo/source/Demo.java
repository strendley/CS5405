//@Author: Skylar Trendley
//@Description: JavaFX Demo Project -> Dynamically binded rectangle
package code;

// Minimum requirement
import javafx.scene.layout.*; // Pane, StackPane etc
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

// Other properties
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class Demo extends Application 
{  
    Pane root;
    Scene scene;
    @Override // Override the start method in the Application class
    public void start(Stage stage) 
    {
        root = new StackPane();  // Create layout for scene
        scene = new Scene(root, 400, 400);    // Create a scene for stage
        createRectangle();   // create rectangle and add it to layout
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
        stage.setTitle("Show Rectangle"); // Set the stage title
    }
    
    public void createRectangle()
    {
        // Create a rectangle and set its properties        
        Rectangle rectangle = new Rectangle(110,90,200,100);     
        rectangle.setStroke(Color.BLUE);  
        rectangle.setStrokeWidth(4);      
        rectangle.setFill(Color.WHITE);
        rectangle.heightProperty().bind(scene.heightProperty().divide(2));
        rectangle.widthProperty().bind(scene.widthProperty().divide(2));

        //create label
        Label label= new Label("Skylar Trendley");
        label.setFont(new Font(25));
        label.setTextFill(Color.RED);
        root.getChildren().addAll(rectangle,label);
    }
    
    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
}
