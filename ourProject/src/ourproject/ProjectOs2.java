package ourproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class ProjectOs2 {
    

    public static void main(String[] args) {
        
        float base , limit ,limitsegment;
        String segmentname , processname;
        
        Scanner sc= new Scanner(System.in);
        Scanner scc= new Scanner(System.in);
        int size ; 
        float SizeofHoles;
        System.out.print("please Enter Memory size: ");
        size = sc.nextInt();
        
        System.out.print("please Enter number of holes: ");
        int number = sc.nextInt();
        
        ArrayList<holes> holeList = new ArrayList<holes> ();
        ArrayList<segment> segmentList = new ArrayList<> ();
        
        operate oper = new operate(size);
        
        for(int i=0; i<number;i++ ){
            System.out.print("base of hole"+(i+1)+" :" );
            base = sc.nextInt();
            System.out.print("limit of hole"+(i+1)+" :" );
            limit = sc.nextInt();
           // holes hole  = new holes(base , limit);
            holeList.add(new holes(base , limit));
        }
        SizeofHoles = oper.SizeOfHoles(holeList);
        if(SizeofHoles <= size){
            
            oper.ArrangeHoles(holeList); //lw el user d5al hole w b3dha hole el mafrod tb2a hole wa7da akbr
            System.out.print("please Enter number of process: ");
            int processnum = sc.nextInt();
            for(int i=0 ; i<processnum ; i++){
                System.out.print("Name of process"+(i+1)+" :" );
                processname= scc.nextLine();
                System.out.print("please Enter number of segments: ");
                int segmentnum = sc.nextInt();
                for(int j=0; j<segmentnum ; j++){
                    System.out.print("Name of Segment"+(j+1)+" :" );
                    segmentname= scc.nextLine();
                    System.out.print("limit of Segment"+(j+1)+" :" );
                    limitsegment = sc.nextInt();
                    segmentList.add(new segment(segmentname , limitsegment));  // Function mohemaaa


                }
                //oper.FirstFit(processname,holeList, segmentList ,processnum);
                oper.BestFit(processname,holeList, segmentList );



            }
        }
        else{
            System.out.println("Sorry , The Size has exceeded the limit");
        }
        
//         holes sizes = new holes();
//         int kk = sizes.getSizeOfHoles();
//         System.out.println(kk);
        
//        Collections.sort(holeList,new Comparator<holes>()
//        {
//            
//            public int compare(holes h1 , holes h2){
//                
//                return Integer.valueOf(h1.getBase()).compareTo(h2.getBase());
//            
//            
//            }
//        
//        
//        });


//         Collections.sort(holeList, new sortByBase());
//         
//         Collections.sort(holeList, new sortByLimit());

//            System.out.println("/////////");
//            System.out.println("holeBase   " + "holeLimit   " + "holeEnd");
//            for(holes op :holeList){
//            System.out.println(op.getBase()+"           "+op.getLimit()+"            "+op.getEnd());
//            
//            }
        
       
        
        
        
       
        
        

        
        
        
        
    }
    
}
