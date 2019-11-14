//@Author: Skylar Trendley
//@Description: JavaFX Demo Project -> Animated Fan Demo

package code;

// Minimum requirement
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.beans.value.ChangeListener;
import javafx.beans.Observable;
import javafx.scene.control.Slider;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import static java.lang.Math.*;

import java.util.Random;

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

    Arc[] arc;
    Circle outerCircle;
    Circle middleCircle;
    Circle innerCircle;
    Timeline timeline;
    int pos = 0;
    Boolean playing=false;
    Boolean reversing=false;
    int numBlades = 4;
    double angle;
    //Slider slider;

    @Override // Override the start method in the Application class
    public void start(Stage stage) 
    {
        root = new VBox();  // Create layout for scene
        scene = new Scene(root, 600, 650); // Create a scene for stage
        stage.setScene(scene); // Place the scene in the stage
        setUpButtons();
        setUpAuthor();
        //setUpDemo();
        stage.show(); // Display the stage
        stage.setTitle("HW09 Demo"); // Set the stage title
    }

    public void setUpButtons()
    {
        //set up a horizontal box for the buttons
        HBox buttons = new HBox(600);
        buttons.setSpacing(120.0);
        buttons.setPadding(new Insets(10,10,10,70));

        //create the three buttons
        Button btnAuthor = new Button("Author");
        btnAuthor.setMaxWidth(100);

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
        btnProblem.setMaxWidth(100);
        btnProblem.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
                root.getChildren().removeAll(authorPane,problemPane,demoPane);
                setUpProblem();
            }
        });

        Button btnImageDemo = new Button("Demo");
        btnImageDemo.setMaxWidth(100);
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
        Label intro = new Label("This Homework is extension of Problem 14.9 page 587. This enforces your learning of color and shapes circle, arc,animation Timeline. Once you have a function for creating one fan, you can call it any number of times to create multiple fans  ( interactively in the next assignment). You may make your display as fancy as possible. Here is a sample of one fan. You may design the fan as you like. Ask me in the class to see fans created by your previous class fellows. Add user interface to start, pause, and reverse buttons.");
        intro.setWrapText(true);
        //add the lists to the vertical box pane
        problemPane.getChildren().addAll(intro);

        //add the vbox pane to the root pane
        root.getChildren().add(problemPane);
    }

    public void setUpDemo()
    {
        angle = floor(360 / numBlades);

        //create a new pane for the demo
        demoPane = new Pane();

        //create the outermost circle
        outerCircle = new Circle(300,250,220,Color.WHITE);
        outerCircle.setStroke(Color.BLACK);
        outerCircle.setStrokeWidth(3);

        //create the middle circle
        middleCircle = new Circle(300,250,140,Color.GREEN);
        middleCircle.setStroke(Color.BLACK);
        middleCircle.setStrokeWidth(3);

        //create the innermost circle
        innerCircle = new Circle(300,250,70,Color.BLUE);
        innerCircle.setStroke(Color.BLACK);
        innerCircle.setStrokeWidth(3);

        //set up the default fan
        arc = new Arc[numBlades];
        for(int i = 0; i < arc.length; i++)
        {
            arc[i] = new Arc(outerCircle.getCenterX(), outerCircle.getCenterY(),200,200,i*angle + 20, 35);
            arc[i].setFill(Color.RED);
            arc[i].setStroke(Color.BLACK);
            arc[i].setStrokeWidth(2);
            arc[i].setType(ArcType.ROUND);
        }

        //add all the elements to the demo pane
        demoPane.getChildren().addAll(outerCircle,middleCircle,innerCircle);
        demoPane.getChildren().addAll(arc);
        
        //add the demo pane to the root -> scene
        root.getChildren().add(demoPane);

        setUpDemoButtons();
    }

    public void setUpDemoButtons()
    {
        //set up a horizontal box for the buttons
        HBox demoButtons = new HBox(600);
        demoButtons.setSpacing(120.0);
        demoButtons.setPadding(new Insets(500,10,10,65));

        //create the start button
        ImageView start = new ImageView(new Image("images/play.png"));
        start.setFitHeight(50);
        start.setFitWidth(50);
        
        Button btnStart = new Button("",start);
        btnStart.setMaxWidth(100);

        btnStart.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
                if(playing==false) //if the fan isn't spinning
                    startAnimation(); //start the animation
            }
        });

        //create the pause button
        ImageView stop = new ImageView(new Image("images/pause.png"));
        stop.setFitHeight(50);
        stop.setFitWidth(50);

        Button btnPause = new Button("",stop);
        btnPause.setMaxWidth(100);

        btnPause.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
                pauseAnimation(); //stop the animation
            }
        });

        //create reverse button
        ImageView reverse = new ImageView(new Image("images/reverse.png"));
        reverse.setFitHeight(50);
        reverse.setFitWidth(50);

        Button btnReverse = new Button("",reverse);
        btnReverse.setMaxWidth(100);

        btnReverse.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
                if(reversing==false) //if it is not going in the reverse direction
                    reversing=true; //reverse it
                else
                    reversing=false; //if it is going in the reverse direction, un-reverse it
            }
        });

        //add the buttons to the horizontal box pane
        demoButtons.getChildren().addAll(btnStart, btnPause, btnReverse);

        //add the button box to the demo pane
        demoPane.getChildren().add(demoButtons);
       
    }

    public void startAnimation()
    {
        //set up an animation timeline
        timeline = new Timeline(new KeyFrame(Duration.millis(50), e->spinFan()));
        timeline.setCycleCount(Timeline.INDEFINITE); //make it only stop on user input
        timeline.play(); //start the timeline
        playing=true; //notify that it is currently spinning
    }

    public void pauseAnimation()
    {
        timeline.pause(); //stop the timeline
        playing=false; //notify that it is no longer spinning
    }

    public void spinFan()
    {
        demoPane.getChildren().removeAll(arc); //remove the arc from the pane

        if(reversing==false) //if it is not going in the reverse direction
            pos=pos+10;  //increase the blade position to 10 degrees in the positive direction
        else
            pos=pos-10; //decrease the blade position to 10 degress in the negative direction

        arc = new Arc[numBlades];
        for(int i = 0; i < arc.length; i++)
        {
            //create a new blade; public Arc(double centerX, double centerY, double radiusX, double radiusY, double startAngle, double length)
            arc[i] = new Arc(outerCircle.getCenterX(), outerCircle.getCenterY(),200,200,i*angle - pos, 35);
            
            //fill the blade with various graphic coloring options
            arc[i].setFill(getRandomColor());
            arc[i].setStroke(Color.BLACK);
            arc[i].setStrokeWidth(2);
            arc[i].setType(ArcType.ROUND);
        }

        //add the arc back to the demo pane
        demoPane.getChildren().addAll(arc);
    }

    public Color getRandomColor()
    {
        Random number = new Random();

        Color color = Color.rgb(number.nextInt(255),number.nextInt(255),number.nextInt(255));
        return color;
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