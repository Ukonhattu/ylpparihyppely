/* 
 * Copyright (C) 2016 daxda
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package ylpparihyppely.gameobjects;

/**
 * GameObject that has physics.
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
     *
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
     *
     * @return location
     */
    @Override
    public Location whereYouWannaMove() {
        return wantedLocation;
    }

    /**
     * Returns location of hitbox if object were on wantedLocation.
     *
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
     *
     * @return True if object is moving on y-axis.
     */
    @Override
    public boolean isOnAir() {
        return this.onAir;
    }

    /**
     * Moves object on specific location. Does not care about hitboxes or
     * anything.
     *
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
     *
     * @return True if not moving on y-axis.
     */
    @Override
    public boolean isOnGround() {
        return !this.onAir;
    }

}
