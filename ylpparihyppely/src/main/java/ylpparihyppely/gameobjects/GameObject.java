/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ylpparihyppely.gameobjects;

/**
 *
 * @author daniel
 */
public abstract class GameObject {
    
    private Location location;

    public GameObject(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
    
    abstract Location getHitboxLocation();
    abstract Location getGravityHitboxLocation();

    public void setLocation(Location location) {
        this.location = location;
    }
    
    

    
    
}