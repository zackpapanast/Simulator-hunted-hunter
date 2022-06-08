package simulator;

import java.util.ArrayList;
import java.util.Collections;

public class Field {
    private int numRows;
    private int numCols;
    private Actor [][] plegma;
    
   public Field(int numRows, int numCols){
       this.numCols=numCols;
       this.numRows=numRows;
       plegma=new Actor[numRows][numCols];
   }
   public int getNumCols(){
       return numCols;
   }
   public int getNumRows(){
       return numRows;
   }
   public void clear(){
       for(int i=0;i<numRows;i++){
           for(int j=0;j<numCols;j++){
               plegma[i][j]=null;
           }
       }
   }
   public void clear(Location loc){
       plegma[loc.getRow()][loc.getCol()]=null;       
   }
   public void place(Actor actor,Location loc){
       plegma[loc.getRow()][loc.getCol()]=actor;       
   }
   public Actor getActor(Location loc){
       return plegma[loc.getRow()][loc.getCol()];
   }
   public ArrayList<Location> adjacentLocations(Location loc){
       ArrayList<Location> myArray = new ArrayList<Location>();
       for(int i=0;i<numRows;i++){
           for(int j=0;j<numCols;j++){
             if(i>loc.getRow()-2&&i<loc.getRow()+2&&j>loc.getCol()-2&&j<loc.getCol()+2){
                    if(i!=loc.getRow()||j!=loc.getCol()){
                        Location l=new Location(i,j);
                        myArray.add(l);
                   }//if
                        
             }//if  
           }//for
       }//for
       Collections.shuffle(myArray);
       return myArray;
   }
   public ArrayList<Location> freeAdjacentLocation(Location loc){
       ArrayList<Location> myArray;
       myArray=adjacentLocations(loc);
       for(int i=myArray.size()-1;i>-1;i--){
           
                    if(getActor(myArray.get(i))!=null){
                        myArray.remove(i);
                    }//if
                                   
       }//for
       Collections.shuffle(myArray);
       return myArray;
       
   }
   public Location randomFreeAdjacentLocation(Location loc){
       ArrayList<Location> myArray;
       myArray=freeAdjacentLocation(loc);
       if(myArray.isEmpty()){
           return null;
       }else{
           return myArray.get(0);
       }
   }
   public Location randomFreeLocation(){
       ArrayList<Location> myArray = new ArrayList<Location>();
       for(int i=0;i<numRows;i++){
           for(int j=0;j<numCols;j++){
             if(plegma[i][j]==null){
                 Location l =new Location(i,j);
                 myArray.add(l);
             }//if    
           }//for
       }//for
       if(myArray.isEmpty()){
           return null;
       }else{
           Collections.shuffle(myArray);
           return myArray.get(0);
       }//if
   }
   public void print(){
       for(int i=0;i<numCols;i++){
           System.out.printf("==");
       }
           System.out.println();
       for(int i=0;i<numRows;i++){
           for(int j=0;j<numCols;j++){
               
               System.out.printf(" ");
               if(plegma[i][j]==null){
                   System.out.printf(".");
               }else{
                    if(plegma[i][j].getClass()==Rabbit.class){
                        System.out.printf("R");
                    }else if(plegma[i][j].getClass()==Fox.class){
                        System.out.printf("F");
                    }else if(plegma[i][j].getClass()==Hunter.class){
                        System.out.printf("H");
                    }//if
               }//if
               
               
           }//for
           System.out.println();
       }//for
       for(int i=0;i<numCols;i++){
           System.out.printf("==");
       }
       System.out.println();
       
   }
   public void printStats(){
       int r=0;
       int fx=0;
       int h=0;
       
       for(int i=0;i<numRows;i++){
           for(int j=0;j<numCols;j++){
               if(plegma[i][j]!=null){
                    if(plegma[i][j].getClass()==Rabbit.class){
                       r++;
                    }
                    if(plegma[i][j].getClass()==Fox.class){
                         fx++;
                     }
                    if(plegma[i][j].getClass()==Hunter.class){
                        h++;
                    }
               }//if
           }//for
       }//for
       System.out.println("************************");
       System.out.println("Αυτή τη στιγμή υπάρχουν:");
       System.out.println("     Κυνηγοί: "+h);
       System.out.println("     Κουνέλια: "+r);
       System.out.println("     Αλεπούδες: "+fx);
       System.out.println("************************");
       System.out.println();       
   }
   public ArrayList<Location> randomLocations(){        //Τυχαίες θέσεις από το πλέγμα   (Για τις βολές του κηνυγού)
       ArrayList<Location> myArray = new ArrayList<Location>();
       for(int i=0;i<numRows;i++){
           for(int j=0;j<numCols;j++){
             Location l =new Location(i,j);
             myArray.add(l);    
           }//for
       }//for
       Collections.shuffle(myArray);
       return myArray;
   }  
   
}
