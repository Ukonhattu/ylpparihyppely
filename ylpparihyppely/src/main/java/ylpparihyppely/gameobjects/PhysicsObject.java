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
abstract class PhysicsObject extends GameObject implements Physics {

    protected final int gravityScale;
    private boolean onAir;
    protected Location wantedLocation;
    private Location oldLocation;

    public PhysicsObject(Location location, int gravityScale) {
        super(location);
        this.gravityScale = gravityScale;
        this.wantedLocation = super.getLocation();
        onAir = false;
    }

    public PhysicsObject(Location location) {
        super(location);
        this.wantedLocation = super.getLocation();
        this.gravityScale = 1;
    }

    /**
     * Applies gravity to object once. Actually is tries to move object one
     * down.
     * @param power The gravitation power, how fast we are going down.
     */
    @Override
    public void applyGravity(int power) {
        this.oldLocation = this.getLocation();
        Location location = this.getLocation();
        Location newLocation = new Location(location.getX(), location.getY() + (power * this.gravityScale));
        this.wantedLocation = newLocation;
    }
    /**
     * Cancels applied gravity. Used when gravity tries to make move that is not
     * allowed.
     */
    @Override
    public void deGravity() {
        this.wantedLocation = this.oldLocation;
    }
    /**
     * Returns the location where object is heading to go on next update.
     * @return 
     */
    @Override
    public Location whereYouWannaMove() {
        return wantedLocation;
    }

    /**
     * Returns location of hitbox if object were on wantedLocation.
     * @return 
     */
    @Override
    public Location getHitboxLocation() {
        return wantedLocation;
    }

    @Override
    public void setWantedLocation(Location location) {
        this.wantedLocation = location;
    }

    /**
     * Returns if object is moving on y-axis.
     * @return True if object is moving on y-axis.
     */
    @Override
    public boolean isOnAir() {
        return this.onAir;
    }

    /**
     * Moves object on specific  location. Does not care about hitboxes or
     * anything.
     * @param location 
     */
    @Override
    public void moveTo(Location location) {
        if (this.getLocation().getY() != location.getY()) {
            this.onAir = true;
        } else {
            this.onAir = false;
        }
        this.setLocation(location);
    }
    
    /**
     * Returns if object is not moving on y-axis.
     * @return True if not moving on y-axis.
     */
    @Override
    public boolean isOnGround() {
        return !this.onAir;
    }

}
