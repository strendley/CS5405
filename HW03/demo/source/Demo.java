//@Author: Skylar Trendley
//@Description: JavaFX Demo Project

package code;
// Minimum requirementimport 
import javafx.scene.layout.*; // Pane, StackPane etc
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
// Other Nodes
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

/// default rootpane is StackPane
public class Demo extends Application 
{
    Pane root;    
    @Override // Override the start method in the Application class    
    public void start(Stage stage) 
    {
        // Create a pane to hold objects        
        root = new StackPane();        
        createCircle();   
        // create circle and add it to layout        
        // Create a scene for layout and place it in the stage        
        Scene scene = new Scene(root, 300, 300);        
        stage.setScene(scene); 
        // Place the scene in the stage        
        stage.show(); // Display the stage      
        //optional        
        stage.setTitle("Demo"); 
        // Set the stage title    
    }    
public Circle createCircle()
{        
    // Create a circle and set its properties        
    Circle circle = new Circle();        
    circle.setCenterX(100);        
    circle.setCenterY(100);        
    circle.setRadius(50);        
    circle.setStroke(Color.WHITE);        
    circle.setFill(Color.BLACK);

    // null for no color or white, default black       
    Label label = new Label("Skylar Trendley");
    label.setTextFill(Color.WHITE);
    root.getChildren().addAll(circle,label);        
    return circle;    
}
    
    public static void main(String[] args) 
    {
        launch(args);
    }
}
