// GUI window output
/*
 To Compile
 javac -d . Demo.java
 To execute
 java code.Demo
 */
//Demo Example for a label
// Your byte code goes here

package code;


//min imports required for a GUI Application
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.application.Application;

//for Label title
import javafx.scene.text.TextAlignment;

/**
 * @author Chaman Sabharwal
 */
public class Demo8 extends Application {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        
        createLabel();
        
        StackPane root = new StackPane(); //stacks all components on top of the other in the cnter
      //  Pane root = new Pane(); //stacks all components on top of the other in the cnter
        root.getChildren().add(label);
        Scene scene = new Scene(root, 400, 400);
      //  Scene scene = new Scene(label, 400, 400);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Demo by Chaman Sabharwal!");
        
    }
    
    
    //////////Your code goes here//////////////
    /** declare Label and Text variables */
    Label label ;
   
    /** Create label */
    public void createLabel ()
    {
        label = new Label();
        label.setText("Say 'Hello World' from Label");
        label.setTextAlignment(TextAlignment.CENTER);
    }
    ////////////your code ends here///////  //
}
