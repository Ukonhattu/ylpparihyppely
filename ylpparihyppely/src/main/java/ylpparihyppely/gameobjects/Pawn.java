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
 * Object that can be controlled.
 *
 * @author daniel
 */
abstract class Pawn extends PhysicsObject {

    protected int health;
    private boolean isJumping;
    private int dx;

    private int dy;
    private int speed;
    private int jumpTime;
    private int gravity;
    private int jumpHeigth;

    public Pawn(Location location, int health) {
        super(location);
        this.health = health;
        this.isJumping = false;
        this.dx = 0;
        this.dy = 0;
        this.speed = 1;
        this.jumpTime = 0;
        this.jumpHeigth = 85;
    }

    @Override
    public void tryMove() {
        move();
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    /**
     * Sets the location where pawn would want to move. Does not actually move
     * anything.
     */
    public void move() {
        Location location = this.getLocation();
        if (!location.equals(this.wantedLocation)) {
            location = this.wantedLocation;
        }
        Location newLocation = new Location(location.getX() + this.dx, location.getY() + this.dy);
        if (this.isJumping || this.jumpTime > 0) {
            this.jumpTime--;

            if (this.jumpTime > this.jumpHeigth / 2 / gravity) {
                newLocation = new Location(newLocation.getX(), newLocation.getY() - gravity * 3);

            } else if (this.jumpTime > 0) {
                newLocation = new Location(newLocation.getX(), newLocation.getY() - gravity * 2);
            } else {
                stopJump();
            }
        }
        this.wantedLocation = newLocation;

    }

    /**
     * Sets the jump variables. Actually jumping is happening in move().
     */
    public void jump() {

        if (this.isOnGround()) {
            this.isJumping = true;
            this.jumpTime = this.jumpHeigth / gravity;

        }
    }

    public void stopJump() {
        this.isJumping = false;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getSpeed() {
        return this.speed;
    }

    /**
     * Returns whether pawn is moving or not.
     *
     * @return True if pawn is on move.
     */
    @Override
    public boolean isMoving() {
        return !(dy == 0 && dx == 0);
    }

    public int getHealth() {
        return health;
    }
    
 

}
