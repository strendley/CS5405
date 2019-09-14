/*
To Compile
    javac -d . source/Demo1.java
 To execute
    java code.Demo1
 */

package code;

import javafx.application.Application;
import javafx.stage.Stage;


public class Demo1 extends Application {
   
    public Demo1() {
        System.out.println("\t\t2. constructor is invoked.");
    }
    
    @Override // Override the start method in the Application class
    public void start(Stage stage) {
        System.out.println("\t\t\t3. start method is invoked.\n");
        System.exit(0);
    }
    
    public static void main(String[] args) {
        System.out.println("\t1. main method is invoked to launch the application.");
        Application.launch(args);
    }
     
}
