package simulator;


import java.util.Random;


public abstract class Animal implements Actor { 
    
   private Field f;
   private Location loc;
   private boolean alive;
   
   Random rnd = new Random();
    
  public Animal(Field f,Location loc){
     this.f=f;
     this.loc=loc;
     alive=true;
  }
  public  void setDead(){
     alive=false;
     f.clear(loc);
  }
  public Location getLocation(){
      return loc;
  }
  public void setLocation(Location newLoc){
     f.place(this,newLoc);
     f.clear(loc);
     loc=newLoc;
  }
  public Field getField(){
      return f;
  }
  protected abstract int getAge();
  protected abstract void setAge(int a);
  protected abstract void incrementAge();
  public abstract Animal createAnimal(int age,Field f,Location loc);
  public abstract void giveBirth();
  protected abstract int numberOfNewborn();
  protected abstract int getMaxAge();
  protected abstract int getMinBirthAge();
  protected abstract int getMaxNewborn();
  protected abstract double getBirthProbability();
    @Override
  public abstract void act();
    @Override
  public  boolean isAlive(){
      return alive;
  }
  
}
