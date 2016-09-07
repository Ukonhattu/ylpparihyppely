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
abstract class PhysicsObject extends GameObject implements Physics{
    
    private final int gravityScale;
    private boolean falling;

    public PhysicsObject(Location location, int gravityScale) {
        super(location);
        this.gravityScale = gravityScale;
        falling = false;
    }
    public PhysicsObject(Location location) {
        super(location);
        this.gravityScale = 1;
    }
    
    
    @Override
    public void applyGravity(int power){
        Location location = this.getLocation();
        Location newLocation = new Location(location.getX(), location.getY() - power*this.gravityScale);
        this.setLocation(newLocation);
        falling = (!location.equals(newLocation));
    }
    
    @Override
    public boolean isFalling() {
        return this.falling;
    }

    
    
  
}
