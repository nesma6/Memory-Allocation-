/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourproject;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import static java.lang.Float.parseFloat;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;
import java.util.*;  
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;


public class firstFxmlController implements Initializable ,EventHandler<Event> {
    
    private Label label;   
    @FXML
    private TreeView<Label> ourTree;
    @FXML
    private TabPane ourTabPane;
    
    TreeItem<Label> root = new TreeItem<Label>(new Label("Root Node")); // CREATING THE ROOT NODE
    TreeItem<Label> item1=new TreeItem<Label>(new Label("File Management System")); //CHILD OF THE ROOT NODE
    Label newFile= new Label("create new file"); //CHILD OF THE FILE MANAGEMENT SYSTEM
    TreeItem<Label> item2=new TreeItem<Label>(newFile);
    String fileName="file"; //input from the user //initial value
    
    int memorySize=0; //input from the user //initial value 
    int count =0;
    float f_holeBase; //input from the user //initial value
    float f_holeLimit;  //input from the user //initial value
    float mem_size;     //input from the user //initial value
    String s_processName,s_segmentName;  //input from the user //initial value
    int no_segments;   //input from the user //initial value
    float segment_limit;  //input from the user //initial value
    
    ArrayList<holes> holeList = new ArrayList<holes> ();
    ArrayList<segment> segmentList = new ArrayList<> ();
    
    Tab ourTab;
    operate oper;
    
    Map<String,segment[]> ProcessMap=new HashMap<String,segment[]>();
    Map<TreeItem<Label>,Tab> map=new HashMap<TreeItem<Label>,Tab>();
    Map<Button,String> map_button=new HashMap<Button,String>();
    
    TableView <segment> table;
    
    AnchorPane anchor_pane;
    ScrollPane sp ;
    AnchorPane memory_pane;
    Pane np ;
    Pane limits_pane;
    
    Pane newpane;
    Pane newpane2;
    Button b;
    Pane newpane3;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        root.setExpanded(true);
        ourTree.setRoot(root);
        root.getChildren().add(item1);
        item1.setExpanded(true);
        newFile.setUnderline(true);
        newFile.setOnMouseClicked(this);
        ourTree.setOnMouseClicked(this);
        item1.getChildren().add(item2);
        item2.setExpanded(true);
        ourTree.setShowRoot(false);
        

        
    }    
    
     
    Stage windowPopUp;
    @Override
    public void handle(Event event) {
        if(event.getSource()==newFile)
        { 
            
            if(Box.display("new File")==1)
            {
				
                TreeItem<Label> item=new TreeItem<Label>(new Label(Box.getFileName()));
                item2.getChildren().add(item);
                ourTab=new Tab(Box.getFileName());
                holeList.clear();
                segmentList.clear();
                ProcessMap.clear();
                map_button.clear();
                mem_size=0;               
                mem_size=parseFloat(Box.getMemorySize());
				
                oper = new operate(mem_size); 
                ourTabPane.getTabs().add(ourTab);
                //main anchor pane
                anchor_pane = new AnchorPane();
                //anchor_pane.setStyle("-fx-border-color :aqua");
                anchor_pane.setLayoutX(0);
                anchor_pane.setLayoutY(0);
                //anchor_pane_Top.setPrefHeight(10);
                anchor_pane.setMaxHeight(545);
                anchor_pane.setMinHeight(545);
                anchor_pane.setPrefWidth(600);
                
                sp = new ScrollPane();
                memory_pane = new AnchorPane(); 
                np = new Pane();
                limits_pane=new Pane();
                
                
        
                //memory Vbox
                
                memory_pane.setLayoutX(0);
                memory_pane.setLayoutY(0);
                memory_pane.setPrefWidth(230);
                memory_pane.setPrefHeight(mem_size*5);
 
                sp.setLayoutX(500);
                sp.setLayoutY(20);

                sp.setMaxHeight(525);
                sp.setMinHeight(525);
                sp.setPrefWidth(270);
                anchor_pane.getChildren().add(sp);
                
                
                //memory Layout
                sp.setHbarPolicy(ScrollBarPolicy.NEVER);
                sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
                
                //commented to come back
                
              
                limits_pane.setStyle("-fx-background-color: #F3F3F3;");//
                limits_pane.setPrefHeight(mem_size*5);
                limits_pane.setLayoutX(0);
                limits_pane.setLayoutY(0);
                limits_pane.setPrefWidth(50);
                
                
                np.setStyle("-fx-background-color: #F3F3F3;");
                np.setPrefHeight(mem_size*5);
                np.setLayoutX(50);
                np.setLayoutY(0);
                np.setPrefWidth(180);
 
                
                memory_pane.getChildren().addAll(limits_pane,np);
                
                sp.setContent(memory_pane);
  
       
			//top anchor pane
     
            AnchorPane anchor_pane_Top = new AnchorPane(); 

            anchor_pane_Top.setLayoutX(20);
            anchor_pane_Top.setLayoutY(20);

            anchor_pane_Top.setMaxHeight(150);
            anchor_pane_Top.setMinHeight(150);
            anchor_pane_Top.setPrefWidth(460);
            anchor_pane.getChildren().add(anchor_pane_Top);
            anchor_pane_Top.setStyle("-fx-border-color :#F3F3F3");
            anchor_pane_Top.setStyle("-fx-background-color:#888888");
       
            
            //textfields and create in topVbox
            
            JFXTextField holeBase=new JFXTextField();
            holeBase.setPromptText("Hole Base");
            holeBase.setFocusColor(Paint.valueOf("#D0CEDB"));
            holeBase.setFocusTraversable(true);
            holeBase.setLabelFloat(true);
            holeBase.setUnFocusColor(Paint.valueOf("#D0CEDB"));
            holeBase.setLayoutX(15);
            holeBase.setLayoutY(40);
            anchor_pane_Top.getChildren().add(holeBase);
            
            JFXTextField holeLimit=new JFXTextField();
            holeLimit.setPromptText("Hole Limit");
            holeLimit.setFocusColor(Paint.valueOf("#D0CEDB"));
            holeLimit.setFocusTraversable(true);
            holeLimit.setLabelFloat(true);
            holeLimit.setUnFocusColor(Paint.valueOf("#D0CEDB"));
            holeLimit.setLayoutX(280);
            holeLimit.setLayoutY(40);
            anchor_pane_Top.getChildren().add(holeLimit);
            
            
            
            Label hole_title=new Label("Holes Information");
            hole_title.setTextFill(Paint.valueOf("#F3F3F3"));
            hole_title.setUnderline(true);
            hole_title.setLayoutX(170);
            hole_title.setLayoutY(5);
            
            anchor_pane_Top.getChildren().add(hole_title);

        
            //button  add hole
            Button addHole=new Button("Add Hole");
            addHole.setLayoutX(120);
            addHole.setLayoutY(100);
            anchor_pane_Top.getChildren().add(addHole);
            addHole.setOnAction(e -> {
                
                //taking inputs of text fields 
                String s_holeBase;
                String s_holeLimit;
                
                s_holeBase=holeBase.getText();
                f_holeBase=parseFloat(s_holeBase);
    
                s_holeLimit=holeLimit.getText();
                f_holeLimit=parseFloat(s_holeLimit);
        
                
                
                holeBase.clear();
                holeLimit.clear();
                holes our_holes=new holes(f_holeBase , f_holeLimit);
                holeList.add(our_holes);
                float SizeofHoles = oper.SizeOfHoles(holeList);
                if(SizeofHoles <= mem_size){
                    
                    oper.ArrangeHoles(holeList);
                    
                }
                else
                {
                    holeList.remove(our_holes);
                    oper.ArrangeHoles(holeList);
                     popUpWindow.displayError("SIZE OF HOLES EXCEEDED THE MEMORY LIMIT !!!");
                }
                
            
             });
        
            //Waiting for basic Memory Layout after inserting holes 
            //Yasmeen
            Button showMemory=new Button("Show Memory");
            showMemory.setLayoutX(220);
            showMemory.setLayoutY(100);
            anchor_pane_Top.getChildren().add(showMemory);
            showMemory.setOnAction(e -> {
               
            oper.ArrangeHoles(holeList);
            showBasicMem(holeList);
                
                
   
                
                
            });
            

        
            //bottom anchor pane
        
            AnchorPane anchor_pane_Bottom = new AnchorPane(); 
            anchor_pane_Bottom.setLayoutX(20);
            anchor_pane_Bottom.setLayoutY(180);

            anchor_pane_Bottom.setMaxHeight(225);
            anchor_pane_Bottom.setMinHeight(225);
            anchor_pane_Bottom.setPrefWidth(460);

            anchor_pane.getChildren().add(anchor_pane_Bottom);
            anchor_pane_Bottom.setStyle("-fx-border-color :#F3F3F3");
            anchor_pane_Bottom.setStyle("-fx-background-color:#888888");
        
            //items in vbox bottom
            
            Label process_title=new Label("Process Information");
            process_title.setTextFill(Paint.valueOf("#F3F3F3"));
            process_title.setLayoutX(170);
            process_title.setLayoutY(5);
            process_title.setUnderline(true);
            anchor_pane_Bottom.getChildren().add(process_title);
            
            JFXTextField processName=new JFXTextField();
            processName.setPromptText("Process Name");
            processName.setFocusColor(Paint.valueOf("#D0CEDB"));
            processName.setFocusTraversable(true);
            processName.setLabelFloat(true);
            processName.setUnFocusColor(Paint.valueOf("#D0CEDB"));
            processName.setLayoutX(15);
            processName.setLayoutY(50);
            anchor_pane_Bottom.getChildren().add(processName);
            
        
            JFXTextField N_segments=new JFXTextField();
            N_segments.setPromptText("no. of segments");
            N_segments.setFocusColor(Paint.valueOf("#D0CEDB"));
            N_segments.setFocusTraversable(true);
            N_segments.setLabelFloat(true);
            N_segments.setUnFocusColor(Paint.valueOf("#D0CEDB"));
            N_segments.setLayoutX(280);
            N_segments.setLayoutY(50);
            anchor_pane_Bottom.getChildren().add(N_segments);
            
            
            JFXTextField segmentName=new JFXTextField();
            segmentName.setPromptText("Segment Name ");
            segmentName.setFocusColor(Paint.valueOf("#D0CEDB"));
            segmentName.setFocusTraversable(true);
            segmentName.setLabelFloat(true);
            segmentName.setUnFocusColor(Paint.valueOf("#D0CEDB"));
            segmentName.setLayoutX(15);
            segmentName.setLayoutY(110);
            anchor_pane_Bottom.getChildren().add(segmentName);
        
            JFXTextField limit=new JFXTextField();
            limit.setPromptText("Segment Limit");
            limit.setFocusColor(Paint.valueOf("#D0CEDB"));
            limit.setFocusTraversable(true);
            limit.setLabelFloat(true);
            limit.setUnFocusColor(Paint.valueOf("#D0CEDB"));
            limit.setLayoutX(280);
            limit.setLayoutY(110);
            anchor_pane_Bottom.getChildren().add(limit);
       
            
            Button addSegment=new Button("Add Segment");
            addSegment.setLayoutX(170);
            addSegment.setLayoutY(175);
            anchor_pane_Bottom.getChildren().add(addSegment);
           
            Button allocate2=new Button("Allocate Best Fit");
            allocate2.setLayoutX(30);
            allocate2.setLayoutY(175);
            anchor_pane_Bottom.getChildren().add(allocate2);
            
            Button allocate=new Button("Allocate First Fit");
            allocate.setLayoutX(300);
            allocate.setLayoutY(175);
            
            anchor_pane_Bottom.getChildren().add(allocate);
            
            AnchorPane anchor_pane_Bottom2 = new AnchorPane(); 
            anchor_pane_Bottom2.setStyle("-fx-background-color:#888888;");
            anchor_pane_Bottom2.setLayoutX(20);
            anchor_pane_Bottom2.setLayoutY(415);
            anchor_pane_Bottom2.setMaxHeight(125);
            anchor_pane_Bottom2.setMinHeight(125);
            anchor_pane_Bottom2.setPrefWidth(460);
            anchor_pane.getChildren().add(anchor_pane_Bottom2);
            
            Label pt=new Label("Segment Table");
            pt.setStyle("-fx-font-size:11pt;");
            pt.setTextFill(Paint.valueOf("#F3F3F3"));
            pt.setUnderline(true);
            pt.setLayoutX(170);
            pt.setLayoutY(15);
            anchor_pane_Bottom2.getChildren().add(pt);
            
            JFXTextField enteredProcess=new JFXTextField();
            enteredProcess.setPromptText("Process Name");
            enteredProcess.setFocusColor(Paint.valueOf("#D0CEDB"));
            enteredProcess.setFocusTraversable(true);
            enteredProcess.setLabelFloat(true);
            enteredProcess.setUnFocusColor(Paint.valueOf("#D0CEDB"));
            enteredProcess.setLayoutX(25);
            enteredProcess.setLayoutY(50);
            anchor_pane_Bottom2.getChildren().add(enteredProcess);
            
            
            Button showSegement=new Button("Show Segment Table");
            showSegement.setLayoutX(275);
            showSegement.setLayoutY(60);
           anchor_pane_Bottom2.getChildren().add(showSegement);
            

       
            
            addSegment.setOnAction(e -> {
                
                s_processName=processName.getText();
                no_segments=Integer.parseInt(N_segments.getText());
                s_segmentName=segmentName.getText();
                segment_limit=parseFloat(limit.getText());
                segmentList.add(new segment(s_segmentName , segment_limit));
                segmentName.clear();
                limit.clear();
                
                
                   
            });
            
            allocate.setOnAction(e -> {
                
                
                segment[] arr = new segment[segmentList.size()]; 
                arr=segmentList.toArray(arr);
                oper.ArrangeHoles(holeList);
                boolean check=oper.FirstFit(s_processName, holeList, segmentList);
                
                if(check==true)
                {
                    oper.AllocateFirstFit(s_processName, holeList, segmentList);
                    ProcessMap.put(s_processName,arr);
                    allocateProcess(s_processName, new ArrayList<segment>(Arrays.asList((ProcessMap.get(s_processName)))),(ProcessMap.get(s_processName)).length);
                    segmentList.clear();
                
                }
                else
                {
                    ProcessMap.put(s_processName,arr);
                    //pop message
                    popUpWindow.displayError("THERE IS NO ENOUGH SPACE PLEASE DEALLOCATE PROCESS !!!!");
                    segmentList.clear();
                }
                

	        
                
                processName.clear();
		N_segments.clear();
               
            
            });
            
            allocate2.setOnAction(e -> {
                
                
                segment[] arr = new segment[segmentList.size()]; 
                arr=segmentList.toArray(arr);
                oper.ArrangeHoles(holeList);
                boolean check_segment=oper.BestFit(s_processName, holeList, segmentList);
                if(check_segment==true)
                {
                    oper.AllocateBestFit(s_processName, holeList, segmentList);
                    ProcessMap.put(s_processName,arr);
                    allocateProcess(s_processName, new ArrayList<segment>(Arrays.asList((ProcessMap.get(s_processName)))),(ProcessMap.get(s_processName)).length);
                    segmentList.clear();
                }
                else
                {
                    //option 2 make another map to save pending processes instead of ProcessMap
                    
                    ProcessMap.put(s_processName,arr);
                    //pop message 
                    popUpWindow.displayError("THERE IS NO ENOUGH SPACE PLEASE DEALLOCATE PROCESS !!!!");
                    segmentList.clear();
                }
                
                
                
              

	        
                
                processName.clear();
                N_segments.clear();
               
            
            });
            
            showSegement.setOnAction(e -> {
                
           
                
	        //segment name column
                TableColumn<segment, String> nameColumn = new TableColumn<>("Segment Name");
                nameColumn.setMinWidth(50);
                nameColumn.setCellValueFactory(new PropertyValueFactory<>("segmentName"));
                nameColumn.setMaxWidth(150);
                nameColumn.setMinWidth(150);

                //segment base column
                TableColumn<segment,Integer> BaseColumn = new TableColumn<>("Segment Base");
                BaseColumn.setMinWidth(50);
                BaseColumn.setCellValueFactory(new PropertyValueFactory<>("segmentBase"));
                BaseColumn.setMaxWidth(150);
                BaseColumn.setMinWidth(150);

                //segment limit column
                TableColumn<segment, Integer> LimitColumn = new TableColumn<>("Segment Limit");
                LimitColumn.setMinWidth(50);
                LimitColumn.setCellValueFactory(new PropertyValueFactory<>("SegmentLimit"));
                LimitColumn.setMaxWidth(150);
                LimitColumn.setMinWidth(150);

                table = new TableView<>();
                table.setStyle("ourCSS.css");
                table.setItems(getProcessTable(enteredProcess.getText()));
                table.getColumns().addAll(nameColumn,BaseColumn,LimitColumn);
                tableBox.display(table, enteredProcess.getText());
                enteredProcess.clear();
                //ourVboxTable.getChildren().addAll(table);
            });
        

       
            
            ourTab.setContent(anchor_pane);
            map.put(item,ourTab);          
                
          }
            
            
        }
        
        else if(event.getSource()==ourTabPane)
        {
            TreeItem<Label> treeItem = ourTree.getSelectionModel().getSelectedItem();
            Tab t=map.get(treeItem);
            System.out.println(t);
            
            
        }
        else  if(event.getSource()==ourTree)
        {
            
            TreeItem<Label> treeItem = ourTree.getSelectionModel().getSelectedItem();
            Tab t=map.get(treeItem);
            
            System.out.println("////////////////////////////////////");
            System.out.println(t);
             Set<Map.Entry<TreeItem<Label>,Tab> > st2 = map.entrySet(); 
             for (Map.Entry< TreeItem<Label>,Tab > me:st2) 
		{ 
                    System.out.println((me.getKey()));
                    System.out.println(me.getValue());
           
                   
		} 
            ourTabPane.getSelectionModel().select(t);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(t);
            System.out.println(ourTabPane.getTabs());
            boolean isInTabPane=false;
            System.out.println("no of tabs "+ourTabPane.getTabs().size());
            for(int i=0;i<ourTabPane.getTabs().size();i++)
            {
                System.out.println(ourTabPane.getTabs().get(i));
                System.out.println(t);
                if(ourTabPane.getTabs().get(i)==t)
                {
                    isInTabPane=true;
                    System.out.println("#########################################");
                    break;
                }
            }

            if(ourTabPane.getTabs().isEmpty())
            {
                System.out.println("=======================================");
            }

            
           
            
        }
  
        else if(event.getSource()==ourTab)
        {
            System.out.println("*************************************");
            ourTabPane.getTabs().remove(ourTab);
            System.out.println(ourTabPane.getTabs());
            Set<Map.Entry<TreeItem<Label>,Tab> > st2 = map.entrySet(); 
             for (Map.Entry< TreeItem<Label>,Tab > me:st2) 
		{ 
                    //System.out.println((me.getKey()));
                    System.out.println(me.getValue());
           
                   
		} 
             
        }
        
        
        
    }
    
   //Get all of the products
    public ObservableList<segment> getProcessTable(String processName){
        ObservableList<segment> processSegements = FXCollections.observableArrayList();
        segment[] arr=ProcessMap.get(processName);
        for (segment ourSegment : arr) {
        
            processSegements.add(ourSegment);
        
        }
        return processSegements;
    }
  
    public void showBasicMem(ArrayList<holes> List)
    {
        ArrayList<partition> arr=new ArrayList();
        int loop;
        Label end1,start;
        if(List.get(0).getBase()>0)
        {
            arr.add(new partition(0,List.get(0).getBase()-1));
            
        }
        
        for(int i=1;i<List.size();i++)
        {
            //calculate partitions
            
            if(List.get(i-1).getEnd()<List.get(i).getBase())
            {
                arr.add(new partition(List.get(i-1).getEnd()+1,List.get(i).getBase()-1));
            }
            
          
            
        }
        if(List.get(List.size()-1).getEnd()<mem_size-1)
        {
            arr.add(new partition(List.get(List.size()-1).getEnd()+1,mem_size-1));
        }
        
        //show holes
        
        
        for(int i=0;i<List.size();i++)
        {
            //pane of the hole
            
            newpane = new Pane();     
            newpane.setStyle( "-fx-background-color: White;");
            newpane.setLayoutY(List.get(i).getBase()*5);
            newpane.setLayoutX(0);
            newpane.setPrefWidth(200);
            newpane.setPrefHeight(List.get(i).getLimit()*5);
            np.getChildren().add(newpane);
            
            
            newpane2 = new Pane();  
            newpane2.setStyle( "-fx-background-color: White;");
            newpane2.setLayoutY(List.get(i).getBase()*5);
            newpane2.setLayoutX(0);
            newpane2.setPrefWidth(45);
            newpane2.setPrefHeight(List.get(i).getLimit()*5);
            
            
            
            float end = List.get(i).getEnd();
            Label end2 = new Label(String.valueOf(end));
            end2.setFont(Font.font(8));
            //end1.setStyle("-fx-font-weight:Bold");
            end2.setLayoutX(0);
            end2.setLayoutY((List.get(i).getLimit()*5)-10);
            Label start2 = new Label(String.valueOf(List.get(i).getBase()));
            start2.setFont(Font.font(8));
            //start.setStyle("-fx-font-weight:Bold");
            start2.setLayoutX(0);
            start2.setLayoutY(0);
            newpane2.getChildren().addAll(start2,end2);
            limits_pane.getChildren().add(newpane2);
            
        }
        
        //show allocated partitions
        
        
        
        for(loop=0;loop<arr.size();loop++)
        {
    
            
            
            b=new Button();
            b.setStyle("-fx-background-color: grey;");
            b.setLayoutX(0);
            b.setLayoutY(arr.get(loop).getStart()*5);
            b.setPrefWidth(200);
            b.setPrefHeight((arr.get(loop).getEnd()-arr.get(loop).getStart()+1)*5);
            b.setText("Reserved");
            
            
            newpane3 = new Pane();  
            newpane3.setStyle( "-fx-background-color: White;");
            newpane3.setLayoutY(arr.get(loop).getStart()*5);
            newpane3.setLayoutX(0);
            newpane3.setPrefWidth(45);
            newpane3.setPrefHeight((arr.get(loop).getEnd()-arr.get(loop).getStart()+1)*5);
            
            
            float end = arr.get(loop).getEnd();
            end1 = new Label(String.valueOf(end));
            end1.setFont(Font.font(8));
            //end1.setStyle("-fx-font-weight:Bold");
            end1.setLayoutX(0);
            end1.setLayoutY(((arr.get(loop).getEnd()-arr.get(loop).getStart()+1)*5)-10);
            start = new Label(String.valueOf(arr.get(loop).getStart()));
            start.setFont(Font.font(8));
            //start.setStyle("-fx-font-weight:Bold");
            start.setLayoutX(0);
            start.setLayoutY(0);
            newpane3.getChildren().addAll(start,end1);
            limits_pane.getChildren().add(newpane3);
            
           
            
            //np.getChildren().add(newpane4);
            np.getChildren().add(b);
           
            final Button b1=b;
            final int x=loop;
            final Label start_limit=start;
            final Label end_limit=end1;
            
            b.setOnAction(e->{
               
            System.out.println("deallocate reserved ************");
            holeList.add(new holes(arr.get(x).getStart(),(arr.get(x).getEnd()-arr.get(x).getStart()+1)));
            oper.ArrangeHoles(holeList);
            allocateHoles(holeList);
           
            
                
           
            });
             
         
            
            
            
            
            
            
            
        }
       
    }
    public void allocateProcess (String ProcessID , ArrayList<segment> segmentList , int segmentNumbers)
    {
        for(int i=0;i<segmentNumbers;i++)
        {  
            Button newbutton = new Button();  
            
            Pane limits  = new Pane();        
            
            //newbutton.setStyle("-fx-border-color: red;" + "-fx-background-color: White;"+"-fx-text-fill:#491076");
            newbutton.setLayoutY(segmentList.get(i).getSegmentBase()*5);   
            newbutton.setLayoutX(0);
            newbutton.setPrefWidth(200);
            newbutton.setPrefHeight(segmentList.get(i).getSegmentLimit()*5);
            //newbutton.setTextFill(Paint.valueOf("#491076"));
            newbutton.setStyle("-fx-border-color:#DEB7E3;"+"-fx-border-radius: 10;");
            newbutton.setText(ProcessID+" -> "+segmentList.get(i).getSegmentName());
            map_button.put(newbutton,ProcessID);
            np.getChildren().add(newbutton);                     
     
            limits.setStyle("-fx-background-color: White;");
            limits.setLayoutY(segmentList.get(i).getSegmentBase()*5);
            limits.setLayoutX(0);
            limits.setPrefWidth(45);
            limits.setPrefHeight(segmentList.get(i).getSegmentLimit()*5);
            limits_pane.getChildren().add(limits);      
           
           
            float end = (segmentList.get(i).getSegmentLimit() + segmentList.get(i).getSegmentBase()-1);
            Label end1 = new Label(String.valueOf(end));
            end1.setFont(Font.font(8));
            end1.setLayoutX(0);
            end1.setLayoutY(segmentList.get(i).getSegmentLimit()*5-10);
            
            Label end2 = new Label(String.valueOf(end+1));
            end2.setFont(Font.font(8));
            end2.setLayoutX(0);
            end2.setLayoutY(((segmentList.get(i).getSegmentLimit()+2)*5)-10);
            
            float start = segmentList.get(i).getSegmentBase();
            Label start1 = new Label(String.valueOf(start));
            start1.setFont(Font.font(8));
            start1.setLayoutX(0);
            start1.setLayoutY(0);
            limits.getChildren().addAll(end2,end1,start1);
            
             
            //add button action
            final Button our_b = newbutton;
            newbutton.setOnAction(new EventHandler<ActionEvent>(){
            
            
            @Override
              public void handle(ActionEvent event){
                  
                  String pn=map_button.get(our_b);
                  ArrayList<segment>segs=new ArrayList<segment>(Arrays.asList(ProcessMap.get(pn)));
                  oper.DeallocateProcess(pn, holeList, segs);
                  //DeallocateProcess(pn,segs);
                  allocateHoles(holeList);
                  
                  // yasmeeeeeennnnnnn
                  
                  
                  System.out.println("---------- deallocating "+pn+"-------------");
                  
                  
                System.out.println("holes after deallocation");
                
                System.out.println("holeBase   " + "holeLimit   " + "holeEnd");
                for(holes op :holeList){
                System.out.println(op.getBase()+"           "+op.getLimit()+"            "+op.getEnd());
                }
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
              }
          });
            
        }
                
    }
    
    public  void DeallocateProcess(String ProcessID , ArrayList<segment> segmentList )
    {
        for(int i=0;i<segmentList.size();i++)
        {
            
            Pane o = new Pane();            
            //Pane limits  = new Pane();                 //for each segment limits(start , end)
            //BorderPane bp = new BorderPane();
            //double ssize = Double.parseDouble(SegmentSize.getText());
            o.setStyle("-fx-background-color: white;");
            o.setLayoutY(segmentList.get(i).getSegmentBase()*5);   
            o.setLayoutX(0);
            o.setPrefWidth(200);
            o.setPrefHeight(segmentList.get(i).getSegmentLimit()*5);
            np.getChildren().add(o);  
            
             //add this  hole to the holeList//////////////////////
            holes h = new holes();
            h.setBase((int)(o.getLayoutY()/5));
            h.setLimit((int)(o.getPrefHeight()/5));
            
            //reallocate holeList  for update
        }
        
    }
    
    
    public void allocateHoles(ArrayList<holes> List)
    {
        
        //show holes
        
        for(int i=0;i<List.size();i++)
        {
            //pane of the hole
            
            newpane = new Pane();     
            newpane.setStyle( "-fx-background-color: White;");
            newpane.setLayoutY(List.get(i).getBase()*5);
            newpane.setLayoutX(0);
            newpane.setPrefWidth(200);
            newpane.setPrefHeight(List.get(i).getLimit()*5);
            np.getChildren().add(newpane);
            
            
            newpane2 = new Pane();  
            newpane2.setStyle( "-fx-background-color: White;");
            newpane2.setLayoutY(List.get(i).getBase()*5);
            newpane2.setLayoutX(0);
            newpane2.setPrefWidth(45);
            newpane2.setPrefHeight(List.get(i).getLimit()*5);
            
     
            float end = List.get(i).getEnd();
            Label end2 = new Label(String.valueOf(end));
            end2.setFont(Font.font(8));
            //end1.setStyle("-fx-font-weight:Bold");
            end2.setLayoutX(0);
            end2.setLayoutY((List.get(i).getLimit()*5)-10);
            Label start2 = new Label(String.valueOf(List.get(i).getBase()));
            start2.setFont(Font.font(8));
            //start.setStyle("-fx-font-weight:Bold");
            start2.setLayoutX(0);
            start2.setLayoutY(0);
            newpane2.getChildren().addAll(start2,end2);
            limits_pane.getChildren().add(newpane2);
            
        }
       
            
    }
       
} 
    
    
    
  
    
    

