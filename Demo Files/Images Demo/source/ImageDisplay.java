package code;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

import static java.lang.Math.*;
import javafx.geometry.Insets;


public class ImageDisplay extends Pane {
 
    /** panes declarations */
    //Pane root = new Pane();
   
    // image and its width and height of image
    Image image ;
    ImageView imageView1,  imageView2 , imageView3;
    
  //      @Override // Override the start method in the Application class
  public ImageDisplay( ) {
    // Create panes to hold the image views
    
      createImageViews();
      this.setPadding(new Insets(5));
      this.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
      
      this.getChildren().addAll(imageView1,imageView2,imageView3);
      
   
  }
  

    public void createImageViews()
    {
        image = new Image("images/Lenna.png");
        double w= image.getWidth();
        double h=image.getHeight();
        imageView1 =new ImageView(image);
        
        double x=w/3,y=h/3,wR,hR,theta=PI/4, diffW,diffH;//use Math.toRadians(angleDegrees)
        wR=x*cos(theta)-y*sin(theta); hR=y*cos(theta)+x*sin(theta);
        diffW=abs(x-wR);diffH=abs(y-hR);
        double minValue = 0.9*min(diffH,diffW);
        
        imageView2 = new ImageView(image);
        imageView2.setFitHeight(h/2);
        imageView2.setFitWidth(w/2);
        imageView2.setLayoutX(w);imageView2.setLayoutY(0);

        imageView3 = new ImageView(image);
        imageView3.setRotate(45);
        imageView3.setFitHeight(h/3);
        imageView3.setFitWidth(w/3);
        
          imageView3.setLayoutX(w+minValue);imageView3.setLayoutY(h/2+minValue);
  
    }
}
