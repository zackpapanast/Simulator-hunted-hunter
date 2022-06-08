/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

import java.util.ArrayList;


public class Fox extends Animal{
        private int age;
        private int maxAge;
        private int minBirthAge;
        private int maxNewborn;
        private double birthProbability;
        private  int foodLevel;
        
    public Fox(int age,Field f,Location loc){
        super(f,loc);
        this.age=age;
        maxAge=150;
        minBirthAge=10;
        maxNewborn=5;
        birthProbability=0.35;
        foodLevel=7;
    }

    @Override
    protected int getAge() {
        return age;
    }
    @Override
    protected void setAge(int a) {
        age=a;
    }
    @Override
    protected void incrementAge() {
        age++;
       if(age>maxAge){
        super.setDead();
       }
    }
    @Override
    public Animal createAnimal(int age, Field f, Location loc) {
        Fox fx=new Fox(age,f,loc);
        return fx;
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
           Animal fx;
           fx=createAnimal(1,getField(),myarr.get(i));
           getField().place(fx,myarr.get(i));
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
    protected int getMaxAge() {
        return maxAge;
    }
    @Override
    protected int getMinBirthAge() {
        return minBirthAge;
    }
    @Override
    protected int getMaxNewborn() {
        return maxNewborn;
    }
    
    @Override
    protected double getBirthProbability() {
        return birthProbability;
    }
    @Override
    public void act() {
        incrementAge();
        reduceFoodLevel();
        if(super.isAlive()){
            giveBirth();
            Location l;
            l=findFood();
            if(l!=null){
                getField().clear(l);
                getField().place(this, l);
                getField().clear(getLocation());
                foodLevel+=7;
            }else{ 
                l=getField().randomFreeAdjacentLocation(getLocation());
                if(l==null){
                 setDead();
                }else{
                    getField().place(this, l);
                    getField().clear(getLocation());
                }
            }//if
            
        }//if
    }
    public void reduceFoodLevel(){
        foodLevel--;
        if (foodLevel==0){
            setDead();
        }
    }
    public Location findFood(){
        ArrayList<Location> myarr;
        myarr=getField().adjacentLocations(getLocation());
        for(int i=0;i<myarr.size();i++){
            if(getField().getActor(myarr.get(i)) instanceof Rabbit){
                return myarr.get(i);
            }
        }
        return null;
    }   

}