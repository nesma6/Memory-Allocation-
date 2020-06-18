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
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author moh1969
 */
public class Box {
    //Create variable
    static String memorySize;
    static String fileName;
    static int flag=0;

    public static String getMemorySize()
    {
        return memorySize;
    }
    public static String getFileName()
    {
        return fileName;
    }
   
    public static int display(String title) {
        
        flag=0;
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(500);
        window.setMinHeight(250);
     
        
        //Create two buttons
        Button createButton = new Button("create");
        createButton.getStylesheets().add("ourCSS.css");
        
        // two text fields
        JFXTextField memory_Field=new JFXTextField();
        memory_Field.setPromptText("Memory Size");
        memory_Field.setFocusColor(Paint.valueOf("#D0CEDB"));
        memory_Field.setFocusTraversable(true);
        memory_Field.setLabelFloat(true);
        memory_Field.setUnFocusColor(Paint.valueOf("#D0CEDB"));
        memory_Field.setPrefWidth(150.0);
        
        JFXTextField file_Name=new JFXTextField();
        file_Name.setPromptText("File Name");
        file_Name.setFocusColor(Paint.valueOf("#D0CEDB"));
        file_Name.setFocusTraversable(true);
        file_Name.setLabelFloat(true);
        file_Name.setUnFocusColor(Paint.valueOf("#D0CEDB"));
        
        //Clicking will set answer and close window
        createButton.setOnAction((ActionEvent e) -> {
            memorySize=memory_Field.getText();
            fileName=file_Name.getText();
            flag=1;
            window.close();
        });
  

        HBox layout = new HBox(15);

        //Add buttons
        layout.getChildren().addAll(file_Name,memory_Field,createButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        //createButton.;
        String css = Box.class.getResource("ourCSS.css").toExternalForm();
        scene.getStylesheets().clear();
        scene.getStylesheets().addAll(css);
        window.setScene(scene);
        window.showAndWait();
        return flag;
    }
    
}