//@Author: Skylar Trendley
//@Description: JavaFX Demo Project -> Free Hand Poly Line Demo
package code;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.beans.property.Property;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import static java.lang.Math.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Demo extends Application 
{  
    Pane root;
    Scene scene;
    VBox authorPane;
    VBox problemPane;
    Pane demoPane;

    // Declare parameters   
    boolean draw=true, first=true, notDone=true;    
    int x=0, y=0;     
    Path path;    
    LineTo lineTo;   
    MoveTo moveTo;
    int lineCount = 0;

    @Override // Override the start method in the Application class
    public void start(Stage stage) 
    {
        root = new VBox();  // Create layout for scene
        scene = new Scene(root, 600, 600); // Create a scene for stage
        stage.setScene(scene); // Place the scene in the stage
        setUpButtons();
        setUpAuthor();
        //setUpDemo();
        stage.show(); // Display the stage
        stage.setTitle("HW08 Demo"); // Set the stage title
    }

    public void setUpButtons()
    {
        //set up a horizontal box for the buttons
        HBox buttons = new HBox(600);
        buttons.setSpacing(120.0);
        buttons.setPadding(new Insets(10,10,10,45));

        //create the three buttons
        Button btnAuthor = new Button("Author");

        btnAuthor.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
                root.getChildren().removeAll(authorPane,problemPane,demoPane);
                setUpAuthor();
            }
        });

        Button btnProblem = new Button("Problem");
        btnProblem.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
                root.getChildren().removeAll(authorPane,problemPane,demoPane);
                setUpProblem();
            }
        });

        Button btnImageDemo = new Button("Free Line Demo");
        btnImageDemo.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
                root.getChildren().removeAll(authorPane,problemPane,demoPane);
                setUpDemo();
            }
        });

        //add the buttons to the horizontal box pane
        buttons.getChildren().addAll(btnAuthor, btnProblem, btnImageDemo);

        //add the button box to the root pane
        root.getChildren().add(buttons);
    }


    public void setUpAuthor()
    {
        //create & set up a vertical box pane
        authorPane = new VBox();
        authorPane.setSpacing(20.0);
        authorPane.setPadding(new Insets(10,10,10,10));
        authorPane.setAlignment(Pos.CENTER);

        //create three labels with different font size, color, and styles.
        Label info = new Label("Demonstration of Assignment for Java, \nGUI, and Visualization CS5405");
        info.setStyle("-fx-font-family: \"Comic Sans MS\"; -fx-font-size: 20; -fx-text-fill: darkred;"); 

        Label name = new Label("Presented by: \nSKYLAR TRENDLEY \nstbrb@mst.edu");
        name.setStyle("-fx-font-family: \"Times New Roman\"; -fx-font-size: 18; -fx-text-fill: blue;"); 

        Label academic = new Label("This is my original code, No IDE was used in the submission. \nI did not give my code to anyone or did not use anyone's code in this work. \nI follow the rules of academic honesty.");
        academic.setStyle("-fx-font-family: \"Calibri\"; -fx-font-size: 15; -fx-text-fill: green;"); 
        academic.setWrapText(true);

        //add the labels to the vertical box pane
        authorPane.getChildren().addAll(info,name,academic);

        //add the vbox pane to the root pane
        root.getChildren().add(authorPane);
    }

    public void setUpProblem()
    {
        //create & setup a vertical box pane
        problemPane = new VBox();
        problemPane.setSpacing(20);
        problemPane.setPadding(new Insets(10,10,10,10));
        problemPane.setAlignment(Pos.CENTER);

        //display the guidelines for the demo
        Label intro = new Label("Draw two free hand polylines or paths. Be as artistic as you can. ON Canvas, Demo code for one polyline is for your guidance. Refer to how two functions of mouse are used: MouseMoved, and MouseClicked ");

        intro.setWrapText(true);
        //add the lists to the vertical box pane
        problemPane.getChildren().addAll(intro);

        //add the vbox pane to the root pane
        root.getChildren().add(problemPane);
    }

    public void setUpDemo()
    {
        //set up initial vars
        draw=true;
        first=true;
        notDone=true;    
        x=0;
        y=0;     
        lineCount = 0;

        demoPane = new Pane();
        Label label = new Label("Click once to begin drawing a line. \nDouble click to end the line. Once two polylines have been created, \nno more can be added.");
        label.setWrapText(true);

        //add the label to explain demo
        demoPane.getChildren().add(label);

        path = new Path();     
        lineTo = new LineTo(); 
        moveTo = new MoveTo();    

        path.getElements().add(new MoveTo(x,y));        

        //set up the mouse events          
        scene.setOnMouseMoved(mouseHandler);        
        scene.setOnMouseClicked(mouseEvent->{            
            // freeze the point and get to a new point            
            if (first)            
            { 
                if (mouseEvent.getClickCount()==1)            
                {       
                    //remove the label when drawing begins
                    demoPane.getChildren().remove(label); 

                    first=false;                
                    x = (int) mouseEvent.getX();
                    y = (int) mouseEvent.getY();           
                    demoPane.getChildren().remove(path);                
                    lineTo.setX(x);
                    lineTo.setY(y);    

                    path = new Path();                
                    path.getElements().add(new MoveTo(x,y));

                    // path initialization
                    path.setStrokeWidth(2);   
                    if(lineCount == 0)             
                        path.setStroke(Color.GREEN);
                    
                    else             
                        path.setStroke(Color.RED);

                    // add the start point of the path                
                    demoPane.getChildren().add(path);
                } 
            }          
            //if it is not the first line, attach the line to the previous line  
            else if (mouseEvent.getClickCount()==1)                
                {   
                    x = (int) mouseEvent.getX();                    
                    y = (int) mouseEvent.getY();                    
                    lineTo= new LineTo();                    
                    lineTo.setX(x);                    
                    lineTo.setY(y);                    
                    moveTo.setX(x);                    
                    moveTo.setY(y);                    
                    if (draw)                    
                    {                         
                        path.getElements().add(new LineTo(x,y));                    
                    }                
                }     
                //if double click, stop drawing       
                if (mouseEvent.getClickCount() > 1)  
                {             
                    draw=false;
                    lineCount++;            
                }

                if(draw == false && mouseEvent.getClickCount() == 1 && lineCount < 2)
                {
                    first = true;
                    draw = true;
                    path = new Path();  
                    
                    path.setStrokeWidth(2);                
                    path.setStroke(Color.RED); 
                    
                    lineTo = new LineTo(); 
                    moveTo = new MoveTo();    
            
                    path.getElements().add(new MoveTo(x,y));

                }
        });
        
        //add the demo pane to the root
        root.getChildren().add(demoPane);
    }
       
    //mouse event for adding lines on single click 
    EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() 
    {
        @Override        
        public void handle(MouseEvent mouseEvent) 
        {            
            double x = mouseEvent.getX();
            double y = mouseEvent.getY();
            if (draw)                    
            {                      
                lineTo.setX(x);                        
                lineTo.setY(y);                        
                path.getElements().add(lineTo);                    
            }            
        }    
    };
        
    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) 
    {
        launch(args);
    }

}