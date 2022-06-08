package simulator;

import java.util.ArrayList;


public class Hunter implements Actor {
    private Field f;
    private Location loc;
    private boolean alive;
    
    public Hunter(Field f,Location loc){
        this.f=f;
        this.loc=loc;
        alive=true;
        
}
    public Location getLocation(){
        return loc;
    }
    public void setLocation(Location loc){
        f.place(this,loc);
        f.clear(this.loc);
        this.loc=loc;
    }
    public Field getField(){
        return f;
    }
    public void fire(){
        Location l;
        ArrayList<Location> myarr;
        myarr=f.randomLocations();
        
        for(int i=0;i<6;i++){
            l=myarr.get(i);
            if(f.getActor(l)instanceof Animal){
                f.clear(l);
            }
        }
    }
    @Override
    public void act() {
        Location l ;
        l=f.randomFreeLocation();
        setLocation(l);
        fire();
    }

    
    @Override
    public boolean isAlive() {
        return alive;
    }
    
    
    
}
