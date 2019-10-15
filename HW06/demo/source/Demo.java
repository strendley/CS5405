//@Author: Skylar Trendley
//@Description: JavaFX Demo Project -> Dynamically binded rectangle
package code;

// Minimum requirement
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
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
    GridPane demoPane;

    @Override // Override the start method in the Application class
    public void start(Stage stage) 
    {
        root = new VBox();  // Create layout for scene
        scene = new Scene(root, 600, 600); // Create a scene for stage
        stage.setScene(scene); // Place the scene in the stage
        setUpButtons();
        stage.show(); // Display the stage
        stage.setTitle("HW06 Demo"); // Set the stage title
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

        Button btnImageDemo = new Button("Image Demo");
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
        Label intro = new Label("Write a program with three buttons: ");
        Label bullet1 = new Label("\u2022" + " Button1 action: displays pane with course information, your name on color and some font, and relevant information in different color  and different font, as shown in the class.");
        Label bullet2 = new Label("\u2022" + " Button2 action: Give description of assignment, cover page.");
        Label bullet3 = new Label("\u2022" + " Button3 action: Use your own picture, display it in the center of pane, scale, rotate and display four different variations  of your picture in four corners of the display pane. Sample demos from class may be used to understand how to do it.");
    
        //have the lists wrap the text
        bullet1.setWrapText(true);
        bullet2.setWrapText(true);
        bullet3.setWrapText(true);

        //add the lists to the vertical box pane
        problemPane.getChildren().addAll(intro,bullet1,bullet2,bullet3);

        //add the vbox pane to the root pane
        root.getChildren().add(problemPane);
    }

    public void setUpDemo()
    {
        //create & set up a grid pane to store the demo images
        demoPane = new GridPane();
        demoPane.setPadding(new Insets(20,10,10,50));
        demoPane.setVgap(5.0);
        demoPane.setHgap(5.0);


        //add the demo images to the grid
       // demoPane.add(makeRect(Color.RED),1,0,1,1);
        demoPane.add(rotateImage(0,100),0,0,1,1);
        //demoPane.add(rotateImage(180,100),1,1,1,1);
        demoPane.add(rotateImage(-90,100),2,1,1,1);  
        demoPane.add(rotateImage(90,100),1,2,1,1);
        demoPane.add(rotateImage(180,100),3,3,1,1);
        demoPane.add(rotateImage(0,200),1,1,1,1);    
        
        //add the grid to the root pane
        root.getChildren().add(demoPane);
    }

    public Rectangle makeRect(Color color)
    {

        Rectangle rect = new Rectangle(150,150);
        rect.setFill(color);
        rect.setStroke(Color.BLACK);

        return rect;
    }

    
    public ImageView rotateImage(double angle,double dim)
    {
        //create a new image view that holds an image
        ImageView image = new ImageView(new Image("images/surprise.jpg"));

        //set up the margins of the image with given params
        image.setFitHeight(dim);
        image.setFitWidth(dim);

        //rotate the image with given params
        image.getTransforms().add(new Rotate(angle));
        
        //return the image to the caller
        return image;    
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