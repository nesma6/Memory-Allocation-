/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourproject;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author moh1969
 */
public class popUpWindow {

   
    public static void displayError(String Message) {
        
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("ERROR WINDOW !!!!");
        window.setMinWidth(500);
        window.setMinHeight(250);
     
        Label message=new Label(Message);
        
       
        HBox layout = new HBox(15);

        //Add buttons
        layout.getChildren().addAll(message);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        //createButton.;
        String css = popUpWindow.class.getResource("ourCSS.css").toExternalForm();
        scene.getStylesheets().clear();
        scene.getStylesheets().addAll(css);
        message.setStyle("-fx-text-fill:#F3F3F3;");
        //window.getIcons().add(new Image(ClassLoader.getSystemResourceAsStream("memoryManager1.jpg")));
        window.setScene(scene);
        window.showAndWait();
        
    }
    
}

