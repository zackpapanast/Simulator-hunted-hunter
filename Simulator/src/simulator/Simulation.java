
package simulator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulation {
        private int rows;
        private int cols;
        private Field fld;
        
    public Simulation(String filename){
        
        
        try {
            File f=new File(filename);
            
            Scanner fileScanner = new Scanner(f);
            
            rows = fileScanner.nextInt();
            cols = fileScanner.nextInt();
            fld=new Field(rows,cols);
            
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    
                    Location l;
                    
                    String s=fileScanner.next();
                    
                    if("H".equals(s)){
                        int ii=fileScanner.nextInt();
                        int jj=fileScanner.nextInt();
                        l=new Location(ii,jj);
                        Hunter h=new Hunter(fld,l);
                        fld.place(h, l);
                    }
                    if("R".equals(s)){
                        int age=fileScanner.nextInt();
                        int ii=fileScanner.nextInt();
                        int jj=fileScanner.nextInt();
                        l=new Location(ii,jj);
                        Rabbit r=new Rabbit(age,fld,l);
                        fld.place(r, l);
                    }
                    if("F".equals(s)){
                        int age=fileScanner.nextInt();
                        int ii=fileScanner.nextInt();
                        int jj=fileScanner.nextInt();
                        l=new Location(ii,jj);
                        Fox fx=new Fox(age,fld,l);
                        fld.place(fx, l);
                    }
                    if("E".equals(s)){
                        l=new Location(i,j);
                        fld.place(null, l);
                    }
                }
            }
            
            //fld.print();
            //Location loc=new Location(0,2);
            //fld.getActor(loc).act();
            //fld.print();
            //fld.printStats();
        }
        catch (FileNotFoundException fe)  {
            System.out.println("Cannot open file");
        }
        
        
    }
    public void simulate(int numSteps){
        fld.print();
        for(int i=0;i<numSteps;i++){
            simulateOneStep();
            fld.print();
        }
        fld.print();
    }
    public void simulateOneStep(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                Location loc=new Location(i,j);
                if(fld.getActor(loc)!=null){
                     fld.getActor(loc).act();
                }
            }            
        }
    }
    public void reset(String filename){
        try {
            File f=new File(filename);
            
            Scanner fileScanner = new Scanner(f);
                       
            rows = fileScanner.nextInt();
            cols = fileScanner.nextInt();
            fld=new Field(rows,cols);
            
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    
                    Location l;
                    
                    String s=fileScanner.next();
                    
                    if("H".equals(s)){
                        int ii=fileScanner.nextInt();
                        int jj=fileScanner.nextInt();
                        l=new Location(ii,jj);
                        Hunter h=new Hunter(fld,l);
                        fld.place(h, l);
                    }
                    if("R".equals(s)){
                        int age=fileScanner.nextInt();
                        int ii=fileScanner.nextInt();
                        int jj=fileScanner.nextInt();
                        l=new Location(ii,jj);
                        Rabbit r=new Rabbit(age,fld,l);
                        fld.place(r, l);
                    }
                    if("F".equals(s)){
                        int age=fileScanner.nextInt();
                        int ii=fileScanner.nextInt();
                        int jj=fileScanner.nextInt();
                        l=new Location(ii,jj);
                        Fox fx=new Fox(age,fld,l);
                        fld.place(fx, l);
                    }
                    if("E".equals(s)){
                        l=new Location(i,j);
                        fld.place(null, l);
                    }
                }
            }            
        }
        catch (FileNotFoundException fe)  {
            System.out.println("Cannot open file");
        }
    }
    public Field getField(){
        return fld;
    }

}

