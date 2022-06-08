package simulator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;


public class FieldBuilder {
    
    
 public static void main(String[] args){
        int rows=12;
        int cols=10;
        Random rnd = new Random();
        
        try  {
            
            FileOutputStream fos = new FileOutputStream("1.txt", true);
            PrintWriter pw = new PrintWriter(fos);
            
            pw.println(rows);
            pw.println(cols);
            
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    double x=(rnd.nextInt(101)/100.0);
                    
                    if(x<0.01){
                        pw.println("H");
                        pw.println(i);
                        pw.println(j);
                    }else if(x<0.02){
                        int age=rnd.nextInt(150)+1;
                        pw.println("F");
                        pw.println(age);
                        pw.println(i);
                        pw.println(j);
                    }else if(x<0.08){
                        int age=rnd.nextInt(50)+1;
                        pw.println("R");
                        pw.println(age);
                        pw.println(i);
                        pw.println(j);
                    }else{
                        pw.println("E");//Empty
                    }
                }
            }
            pw.println();
            
            pw.close();
        }
        catch (FileNotFoundException fnfe)  {
            System.out.println(fnfe);
        }
    }
     
     
     
     
 }   
 
 

