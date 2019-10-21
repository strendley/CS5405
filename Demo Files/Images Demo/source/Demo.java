/*Demo of text fields, a label   and drawing of circles
 Create two circles for for manipulation one for drawing
*/
package code;
/*
 import library packages
 */

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.application.Application;
//actions items
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//paint and othe useful classes
import javafx.scene.paint.Color;
import javafx.scene.text.*;//Font,FontWeight,FontPosture,TextAlignment

/**
 *
 * @author Chaman Sabharwal
 */

public class Demo extends Application {
       /** create layouts*/
       // Panes 
    Pane pane1 = new Pane();
    Pane pane2 = new Pane();
    Pane pane3 = new Pane();
    Pane pane4 = new Pane();
    Pane root = new Pane();
    Scene scene;
    Stage stage;

    
    public void start(Stage stage) {
       
       // root.getChildren().addAll(pane1,button1,button2,button3);//first panne the controls
        root = createFrontPage();
        scene= new Scene(root,700,700,Color.GRAY);
        stage.setTitle("Demo by Dr. Chaman Lal Sabharwal");
        stage.setScene(scene);
        stage.show();
    }
    
    Text name,course,author,disclaimer, problem;
    Button button1,button2,button3;
    public Pane createFrontPage()
    {
        name = new Text(10, 0, "This is a test");
        name.setText("Demonstration of Assignment for\nJava, GUI and Visualization: CS5405\n\nThis is my orignal code, No IDE used in the submission. \n I did not give my code to anyone or \nI did not use anyone's code in this work\n\nLink: url address for reference to specific page and quotation\nThis HW will demonstrate my highest standard of professionalism, integrity, and ethical conduct.");
            name.setStyle("-fx-font-size:30;-fx-text-inner-color:blue");
                      
        course = new Text(10, 20, "This is a test");
        course.setText("Demonstration of Assignment for\nJava, GUI and Visualization: CS5405");
        //course.setFont(new Font(20));
       // course.setFill(Color.RED);
        course.setStyle("-fx-font-size:20;-fx-text-inner-color:red");
        course.setWrappingWidth(500);
        course.setTextAlignment(TextAlignment.CENTER);
       
        author = new Text(10, 50, "\nPresented by\n\nYOUR NAME, \n\nEmail address\n");
        author.setFont(new Font(20));
        author.setFill(Color.GREEN);
        author.setWrappingWidth(500);
        author.setTextAlignment(TextAlignment.CENTER);
        
        disclaimer = new Text(10, 240, "This is my orignal code, No IDE used in the submission. \nI did not give my code to anyone or I did not use anyone's code in this work. \nThis HW will demonstrate my highest standard of professionalism, integrity, and ethical conduct.");
        disclaimer.setFont(new Font(30));
        disclaimer.setFill(Color.BLUE);
        disclaimer.setWrappingWidth(600);
        disclaimer.setTextAlignment(TextAlignment.CENTER);
        problem = new Text(10, 20,
                      "  Describe this assignment here");
        problem.setFont(new Font(20));
        problem.setFill(Color.BLUE);
        problem.setWrappingWidth(600);
        problem.setTextAlignment(TextAlignment.JUSTIFY);
        
       //
        pane1.getChildren().addAll(new ImageDisplay());
        pane2.getChildren().addAll(course,author,disclaimer);
        pane3.getChildren().addAll(problem);
        pane4.getChildren().addAll(pane1);
        
        pane1.relocate(10,40);
        pane2.relocate(10,40);
        pane3.relocate(10,40);
        pane4.relocate(10,40);
    
        button1 =  new Button("ImageDemo");
        button2 =  new Button("Author");
        button3 =  new Button("Problem");
        
        button1.relocate(500,20);
        button2.relocate(200,20);
        button3.relocate(350,20);
    
       
        root.getChildren().addAll(button1, button2,button3,pane4);
        button1.setOnAction(ae->
                            {pane4.getChildren().clear();pane4.getChildren().add(pane1);});
        
        button2.setOnAction(ae->
                            {pane4.getChildren().clear();pane4.getChildren().add(pane2);});
        button3.setOnAction(ae->
                            {pane4.getChildren().clear();pane4.getChildren().add(pane3);});
        
        return root;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

}
