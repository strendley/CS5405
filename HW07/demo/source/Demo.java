//@Author: Skylar Trendley
//@Description: JavaFX Demo Project -> Fan Demo
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
    Arc[] arc;
    Circle outerCircle;
    Circle middleCircle;
    Circle innerCircle;
    Slider slider;

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
        stage.setTitle("HW07 Demo"); // Set the stage title
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

        Button btnImageDemo = new Button("Fan Demo");
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
        Label bullet1 = new Label("\u2022" + " Button1 action: displays pane with course information, your name on color and some font,  and relevant informationin different color  and different font, as shown in the class.");
        Label bullet2 = new Label("\u2022" + " Button2 action: Give description of assignment, cover page.");
        Label bullet3 = new Label("\u2022" + " Button3 action: Create a slider with range 1 to 10. Create a circle and read a slider value into an integer n. Divide the circle into n sectors. Fill 1/3 each sector sector with a color say red, the rest 2/3 sector remains unfilled.");
    
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

        //create the slider
        slider = new Slider();//(1, 10, 1);
        slider.setMin(1); //set the min value
        slider.setValue(1); //set the default value
        slider.setMax(10); //set the maximum value
        slider.setMajorTickUnit(1); //set the scale to 1
        slider.setMinorTickCount(0); //turn off ticks in between numbers 
        slider.setShowTickMarks(true); //show tick marks for major numbers
        slider.setShowTickLabels(true); //show labels of numbers
        slider.setSnapToTicks(true); //snap to the numbers (no decimals)

        //adjust the number of blades on the fan based on the slider
        slider.valueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val)
            {
                if(!slider.isValueChanging())
                    adjustBlades(new_val);
            }
        });


        //set up the default fan to have 1 blade
        arc = new Arc[1];
        for(int i = 0; i < arc.length; i++)
        {
            arc[i] = new Arc(outerCircle.getCenterX(), outerCircle.getCenterY(),200,200,i*120 + 20, 35);
            arc[i].setFill(Color.RED);
            arc[i].setStroke(Color.BLACK);
            arc[i].setStrokeWidth(2);
            arc[i].setType(ArcType.ROUND);
        }

        //add all the elements to the demo pane
        demoPane.getChildren().addAll(slider,outerCircle,middleCircle,innerCircle);
        demoPane.getChildren().addAll(arc);
        
        //add the demo pane to the root -> scene
        root.getChildren().add(demoPane);
    }

    public void adjustBlades(Number numBlades)
    {      
        //reset the fan blades by clearing the pane and readding elements
        demoPane.getChildren().clear();
        demoPane.getChildren().addAll(outerCircle,middleCircle,innerCircle,slider);
        
        //convert the number of the slider to a double
        double dub = floor((double)numBlades);

        //use the number to get the angle of the arc
        int angle = (int)(360 / dub);

        System.out.print(dub);
        System.out.print(",");
        System.out.print(angle);
        System.out.print(",");
        System.out.print(arc.length);
        System.out.print(",");
        System.out.print(demoPane.getChildren().size());
        System.out.println("");


        //set up the fan blades based on the slider
        Arc[] arc = new Arc[(int)dub];
        for(int i = 0; i < arc.length; i++)
        {
            arc[i] = new Arc(300,250,200,200,i*angle + 20, 35);
            arc[i].setFill(Color.RED);
            arc[i].setStroke(Color.BLACK);
            arc[i].setStrokeWidth(2);
            arc[i].setType(ArcType.ROUND);
        }

        //add the blades to the demo pane
        demoPane.getChildren().addAll(arc);


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