//@Author: Skylar Trendley
//@Description: JavaFX Demo Project --> Rectangle, Circle & TextField

package code;
// Minimum requirement
import javafx.scene.layout.*; // Pane, StackPane etc
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
// Other Nodes
import javafx.scene.control.Label;
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
        root = new Pane();      

        //create the textfield object
        textField = createTextField(); 

        // Create a scene for layout and place it in the stage
        Scene scene = new Scene(root, 430, 250);         
          
        stage.setScene(scene); // Place the scene in the stag
        stage.show(); // Display the stage      

        // Set the stage title    
        stage.setTitle("Demo TextField Circle Rectangle"); 
    }    

    public Circle createCircle()
    {        
        // Create a circle and set its properties        
        Circle circle = new Circle();        
        circle.setCenterX(210);        
        circle.setCenterY(140);        
        circle.setRadius(50);        
        circle.setStroke(Color.WHITE);        
        circle.setFill(Color.BLUE);

        return circle;    
    }

    public Rectangle createRectangle()
    {        
        // Create a rectangle and set its properties        
        Rectangle rectangle = new Rectangle();        
        rectangle.setX(110);
        rectangle.setY(90);
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
        Label label = new Label("Skylar Trendley");
        label.setTextFill(Color.BLACK);
        label.setTranslateX(160);
        label.setTranslateY(5);

        //create a new textfield
        TextField textField = new TextField("Type the name of the shape to be displayed.");
        textField.setPrefWidth(400);
        textField.setTranslateX(10);
        textField.setTranslateY(30);
        textField.setOnAction(actionEvent -> 
        {
            //get the text from the textbox
            String str = textField.getText();

            //if it starts with c, show the circle object
            if(str.toLowerCase().startsWith("c"))
            {
                root.getChildren().removeAll(textField,circle,rectangle); //clear the VBox of objects
                root.getChildren().addAll(textField,circle); //add the relevant objects back in
            }

            else if (str.toLowerCase().startsWith("r"))
            {
                root.getChildren().removeAll(textField,circle,rectangle); //clear the VBox of objects
                root.getChildren().addAll(textField,rectangle); //add the relevant objects back in
                
            }
            textField.clear(); //reset the text
        });      

        //add the textfield to the VBox
        root.getChildren().addAll(textField,label);

        //return the created textfield
        return textField;
    }
   
    public static void main(String[] args) 
    {
        launch(args);
    }

}

