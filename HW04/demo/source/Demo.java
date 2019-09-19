//@Author: Skylar Trendley
//@Description: JavaFX Demo Project --> Rectangle, Circle & TextField

package code;
// Minimum requirement
import javafx.scene.layout.*; // Pane, StackPane etc
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
// Other Nodes
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Demo extends Application 
{
    Pane root;
    TextField textField;
    Circle circle;
    Rectangle rectangle;
    @Override // Override the start method in the Application class    
    public void start(Stage stage) 
    {
        // Create a pane to hold objects        
        root = new VBox();      

        //create the textfield object
        textField = createTextField(); 

        // Create a scene for layout and place it in the stage
        Scene scene = new Scene(root, 300, 300);         
             
        stage.setScene(scene); // Place the scene in the stag
        stage.show(); // Display the stage      

        // Set the stage title    
        stage.setTitle("Demo TextField Circle Rectangle"); 
    }    

    public Circle createCircle()
    {        
        // Create a circle and set its properties        
        Circle circle = new Circle();        
        circle.setCenterX(100);        
        circle.setCenterY(100);        
        circle.setRadius(50);        
        circle.setStroke(Color.WHITE);        
        circle.setFill(Color.BLUE);

        return circle;    
    }

    public Rectangle createRectangle()
    {        
        // Create a rectangle and set its properties        
        Rectangle rectangle = new Rectangle();        
        rectangle.setX(50);
        rectangle.setY(50);
        rectangle.setWidth(200);
        rectangle.setHeight(100);       
        rectangle.setStroke(Color.WHITE);        
        rectangle.setFill(Color.BLUE);
      
        return rectangle;    
    }

    public TextField createTextField()
    {
        //create the shapes
        circle = createCircle();
        rectangle = createRectangle();

        //create a new textfield
        TextField textField = new TextField();
        textField.setOnAction(new TextFieldHandler());      

        //add the textfield to the VBox
        root.getChildren().addAll(textField);

        //return the created textfield
        return textField;
    }
   
    public static void main(String[] args) 
    {
        launch(args);
    }

class TextFieldHandler implements EventHandler<ActionEvent>
{        
    public void handle(ActionEvent e)        
    {     
        //get the text from the textbox
        String str = textField.getText();

        //if it starts with c, show the circle object
        if(str.toLowerCase().startsWith("c"))
        {
            root.getChildren().removeAll(textField,circle,rectangle); //clear the VBox of objects
            root.getChildren().addAll(textField,circle); //add the relevant objects back in
            textField.clear(); //reset the text
        }

        else if (str.toLowerCase().startsWith("r"))
        {
            root.getChildren().removeAll(textField,circle,rectangle); //clear the VBox of objects
            root.getChildren().addAll(textField,rectangle); //add the relevant objects back in
            textField.clear(); //reset the text
        }
    }
}

}

