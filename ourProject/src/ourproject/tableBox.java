/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourproject;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class tableBox {
    
    public static void display(TableView<segment> table,String processName) {
        
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(processName+" Segment Table");
        window.setMinWidth(450);
        window.setMinHeight(450);
        HBox layout = new HBox();
        layout.setStyle("-fx-border:black;");
        table.setLayoutX(0);
        table.setLayoutY(0);
        table.setMinWidth(451);
        table.setMaxWidth(451);
        
        
        layout.getChildren().addAll(table);
        //layout.setAlignment(Pos.CENTER);
        String css = Box.class.getResource("treeViewCss.css").toExternalForm();
        Scene scene=new Scene(layout);
        scene.getStylesheets().clear();
        scene.getStylesheets().addAll(css);
        window.setScene(scene);
        window.showAndWait();
    }
    
}