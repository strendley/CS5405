// GUI window output
/*
 To Compile
        javac -d . source/Demo6.java
 To execute
        java code.Demo6
 */
//Demo Example for a label
// Your byte code goes here

package code;


//min imports required for a GUI Application
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

//for Label title
import javafx.scene.text.TextAlignment;

/**
 * @author Chaman Sabharwal
 */
public class Demo6 extends Application {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    StackPane root;
    @Override
    public void start(Stage stage) {
        root = new StackPane(); //stacks all components on top of the other in the center
   //     String str ="Say 'Hello World' from Label/n Static width height"+root.width+","+root.height+
     //   "\nDynamic width, height"+root.widthProperty+","+root.heightProperty;
      //  Pane root = new Pane(); //stacks all components on top of the other in top left corner
        // createLabel();
        label = new Label("Say 'Hello World' from Label:");
        root.getChildren().add(label);
        Scene scene = new Scene(root, 400, 400);
      //  Scene scene = new Scene(label, 400, 400);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Demo by Chaman Sabharwal!");
        label.setText("Say 'Hello World' from Label:(" + root.getWidth()+","+root.getHeight()+")\n");
     //   label.setText("Say 'Hello World' from Label:\n" + root.widthProperty()+"\n"+root.heightProperty()+"\n");
        
    }
    
    //////////Label code goes here//////////////
    /** declare Label and Text variables */
    Label label ;
   
    /** Create label /
    public void createLabel ()
    {
        label = new Label();
        String str ="Say 'Hello World' from Label/n Static width height:"+root.width()+","+root.height()+
        "\nDynamic width, height:"+root.widthProprty()+","+root.heightProprty();
        label.setText(str);
        label.setTextAlignment(TextAlignment.CENTER);
    }
    */
    ////////////your code ends here///////  //
}
