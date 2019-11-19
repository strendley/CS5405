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
import javafx.scene.control.Slider;
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
    HBox demoButtons;

    Arc[] arc;
    Circle outerCircle;
    Circle middleCircle;
    Circle innerCircle;
    Timeline timeline;
    int pos = 0;
    Boolean playing=false;
    Boolean reversing=false;
    int BLADES = 1;
    double angle;
    double speed = 100;
    Slider numBladesSlider;
    Slider speedSlider;

    @Override // Override the start method in the Application class
    public void start( Stage stage) 
    {
        root = new VBox();  // Create layout for scene
        scene = new Scene(root, 600, 700); // Create a scene for stage
        stage.setScene(scene); // Place the scene in the stage
        setUpButtons(); //create the default view buttons
        setUpAuthor(); //default to the author view
        stage.show(); // Display the stage
        stage.setTitle("HW10 Demo"); // Set the stage title
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
            public void handle( ActionEvent event) 
            {
                root.getChildren().clear();
                root.getChildren().add(buttons);
                setUpAuthor(); //show the author pane
            }
        });

        Button btnProblem = new Button("Problem");
        btnProblem.setMaxWidth(100);
        btnProblem.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle( ActionEvent event) 
            {
                root.getChildren().clear();
                root.getChildren().add(buttons);
                setUpProblem(); //show the problem pane
            }
        });

        Button btnImageDemo = new Button("Demo");
        btnImageDemo.setMaxWidth(100);
        btnImageDemo.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle( ActionEvent event) 
            {
                root.getChildren().clear();
                root.getChildren().add(buttons);
                setUpDemo(); //show the demo pane
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
        //reset to default => single blade, not spinning
        //speed = 0;
        BLADES = 1;

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

        //create the blade slider
        numBladesSlider = new Slider();//(1, 10, 1);
        numBladesSlider.setMin(1); //set the min value
        numBladesSlider.setValue(1); //set the default value
        numBladesSlider.setMax(10); //set the maximum value
        numBladesSlider.setMajorTickUnit(1); //set the scale to 1
        numBladesSlider.setMinorTickCount(0); //turn off ticks in between numbers 
        numBladesSlider.setShowTickMarks(true); //show tick marks for major numbers
        numBladesSlider.setShowTickLabels(true); //show labels of numbers
        numBladesSlider.setSnapToTicks(true); //snap to the numbers (no decimals)

        //adjust the number of blades on the fan based on the slider
        numBladesSlider.valueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val)
            {
                if(!numBladesSlider.isValueChanging())
                {
                    adjustBlades(new_val);
                }
            }
        });

        speedSlider = new Slider();
        speedSlider.setMin(1);
        speedSlider.setMax(10);

        speedSlider.valueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val)
            {

                //temporarily pause the animation
                pauseAnimation();

                //calculate the new speed: base speed is 100ms. Fan speed = base speed - slider value
                //faster speeds are produced with lower ms. subtract high slider value from base speed results in faster animation
                double sliderVal = floor((double)new_val*10);
                double baseSpeed = 100;
                speed = baseSpeed - sliderVal;

                //restart the animation
                startAnimation();
        
                //System.out.println("slider val:" + new_val + " | " + "adjusted speed:" +  newSpeed + " | " + "slider speed: " + speed);
            }
        });

        //add all of the circles to the pane
        demoPane.getChildren().addAll(outerCircle,middleCircle,innerCircle);

        //create a default fan with 0 blades an add it to the pane
        arc = new Arc[0];
        demoPane.getChildren().addAll(arc);

        //add the sliders to the root (so they will fully stretch across the pane?)
        root.getChildren().add(numBladesSlider);
        root.getChildren().add(speedSlider);

        //set up the default fan
        setUpFan();

        //add the play/pause/reverse buttons to the demo pane
        setUpDemoButtons();
    }

    public void setUpDemoButtons()
    {
        //set up a horizontal box for the buttons
        demoButtons = new HBox(600);
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
            public void handle( ActionEvent event) 
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
            public void handle( ActionEvent event) 
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
            public void handle( ActionEvent event) 
            {
                if(reversing==false)    //if it is not going in the reverse direction
                    reversing=true;     //reverse it
                else                    //if it is going in the reverse direction
                    reversing=false;    //un-reverse it
            }
        });

        //add the buttons to the horizontal box pane
        demoButtons.getChildren().addAll(btnStart, btnPause, btnReverse);

        //add the button box to the demo pane
        demoPane.getChildren().add(demoButtons);

        //add the demo pane to the root
        root.getChildren().add(demoPane);
       
    }

    public void startAnimation()
    {
        //set up an animation timeline
        timeline = new Timeline(new KeyFrame(Duration.millis(speed), e->spinFan()));
        timeline.setCycleCount(Timeline.INDEFINITE); //make it only stop on user input
        timeline.play(); //start the timeline
        playing=true; //notify that it is currently spinning
    }

    public void pauseAnimation()
    {
        if(playing==true)
        {
            timeline.pause(); //stop the timeline
            playing=false; //notify that it is no longer spinning
        }
    }

    public void spinFan()
    {
        demoPane.getChildren().removeAll(arc); //remove the arc from the pane

        if(reversing==false) //if it is not going in the reverse direction
            pos=pos+10;  //increase the blade position to 10 degrees in the positive direction
        else
            pos=pos-10; //decrease the blade position to 10 degress in the negative direction

        //set up the fan based on if it should be playing or not
        setUpFan();
    }

    public Color getRandomColor()
    {
        //create the random number generator
        Random number = new Random();

        //generate a random color for red, blue, and green
        Color color = Color.rgb(number.nextInt(255),number.nextInt(255),number.nextInt(255));

        return color;
    }

    public void adjustBlades(Number numBlades)
    {   
        //must first convert the number to a double before it can be converted to an integer   
        double dub = floor((double)numBlades);

        //reset the fan blades by clearing the pane and readding element
        BLADES = (int)dub;

        //use the number of blades to get the angle of the arc
        angle = (int)(360/BLADES);

        //set up the fan blades based on the slider
        setUpFan();
    }

    public void setUpFan()
    {
        demoPane.getChildren().removeAll(arc);

        arc = new Arc[BLADES];
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
    
    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main( String[] args) 
    {
        launch(args);
    }

}