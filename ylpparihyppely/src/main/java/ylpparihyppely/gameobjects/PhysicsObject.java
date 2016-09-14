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
    
    protected final int gravityScale;
    private boolean falling;
    protected Location wantedLocation;
    protected Location gravityLocation;

    public PhysicsObject(Location location, int gravityScale) {
        super(location);
        this.gravityScale = gravityScale;
        this.wantedLocation = super.getLocation();
        falling = false;
    }
    public PhysicsObject(Location location) {
        super(location);
        this.wantedLocation = super.getLocation();
        this.gravityScale = 1;
    }
    
    
    @Override
    public void applyGravity(int power){
        Location location = this.getLocation();
        Location newLocation = new Location(location.getX(), location.getY() + (power*this.gravityScale));
        this.gravityLocation = newLocation;
        falling = !location.equals(newLocation);
    }
    
    @Override
    public Location whereYouWannaMove() {
        return wantedLocation;
    }
    @Override
    public Location getHitboxLocation() {
        return wantedLocation;
    }
    
    @Override
    public Location getGravityHitboxLocation() {
        return this.gravityLocation;
    }
    @Override
    public void setWantedLocation(Location location) {
        this.wantedLocation = location;
    }
    
    @Override
    public boolean isFalling() {
        return this.falling;
    }
    
    @Override
    public void moveTo(Location location) {
        this.setLocation(location);
    }
    
    @Override
    public Location getGravityLocation() {
        return this.gravityLocation;
    }

    
    
  
}
