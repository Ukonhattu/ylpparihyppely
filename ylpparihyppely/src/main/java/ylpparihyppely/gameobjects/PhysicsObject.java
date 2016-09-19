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

    @Override
    public void applyGravity(int power) {
        this.oldLocation = this.getLocation();
        Location location = this.getLocation();
        Location newLocation = new Location(location.getX(), location.getY() + (power * this.gravityScale));
        this.wantedLocation = newLocation;
    }
    
    @Override
    public void deGravity() {
        this.wantedLocation = this.oldLocation;
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
    public void setWantedLocation(Location location) {
        this.wantedLocation = location;
    }

    @Override
    public boolean isOnAir() {
        return this.onAir;
    }

    @Override
    public void moveTo(Location location) {
        if (this.getLocation().getY() != location.getY()) {
            this.onAir = true;
        } else {
            this.onAir = false;
        }
        this.setLocation(location);
    }
    
    @Override
    public boolean isOnGround() {
        return !this.onAir;
    }

}
