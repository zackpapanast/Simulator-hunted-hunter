package simulator;

import java.util.ArrayList;
//import java.util.Random;


public class Rabbit extends Animal{
   private int age;
   private int maxAge;
   private int minBirthAge;
   private int maxNewborn;
   private double birthProbability;
   
    
   public Rabbit(int age,Field f,Location loc){
       super(f,loc);
       this.age=age;
       maxAge=50;
       minBirthAge=5;
       maxNewborn=5;
       birthProbability=0.15;
       
   } 
    @Override
   protected int getAge(){
       return age;
   }
    @Override
   protected void setAge(int a){
   age=a;
   }
    @Override
   protected void incrementAge(){
       age++;
       if(age>maxAge){
           super.setDead();
       }
   }
    @Override
   public Animal createAnimal(int age,Field f,Location loc){
       Rabbit r=new Rabbit(age,f,loc);
       return r;
   }
    @Override
   public  void giveBirth(){
       ArrayList<Location> myarr;
       myarr=getField().freeAdjacentLocation(getLocation());
       
       int newborn=numberOfNewborn();
       if(newborn>myarr.size()){
           newborn=myarr.size();
       }
       for(int i=0;i<newborn;i++){
           Animal r;           
           r=createAnimal(1,getField(),myarr.get(i));
           getField().place(r,myarr.get(i));           
       }      
  } 
    @Override
   protected  int numberOfNewborn(){
            int newborn=0;
    if(getAge()>getMinBirthAge()){
       
       double x=(rnd.nextInt(11))/10.0;
       if(x<getBirthProbability()){
           newborn=rnd.nextInt(getMaxNewborn())+1;
       }
     }//if
    return newborn; 
   }   
    @Override
   protected int getMaxAge(){
       return maxAge;
   }
    @Override
   protected int getMinBirthAge(){
       return minBirthAge;
   }
    @Override
   protected int getMaxNewborn(){
       return maxNewborn;
   }
    @Override
   protected double getBirthProbability(){
       return birthProbability;
   }
    @Override
   public void act(){
        incrementAge();
        if(super.isAlive()){
            giveBirth();
            Location l;
            l=getField().randomFreeAdjacentLocation(getLocation());
            if(l!=null){
                getField().place(this, l);
                getField().clear(getLocation());
            }else{
                setDead();
            }//if
            
        }//if
       
   }//act
   
}
