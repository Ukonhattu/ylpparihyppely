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
abstract class Pawn extends PhysicsObject {

    private int health;
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

    public void move() {
        Location location = this.getLocation();
        if (!location.equals(this.wantedLocation)) {
            location = this.wantedLocation;
        }
        Location newLocation = new Location(location.getX() + this.dx, location.getY() + this.dy);
        if (this.isJumping || this.jumpTime > 0) {
            this.jumpTime--;

            if (this.jumpTime > this.jumpHeigth/2/gravity) {
                newLocation = new Location(newLocation.getX(), newLocation.getY() - gravity*3);

            } else if (this.jumpTime > 0) {
                newLocation = new Location(newLocation.getX(), newLocation.getY() - gravity*2);
            }
            else {
                stopJump();
            }
        }
        this.wantedLocation = newLocation;
        
    }

    public void jump() {

        if (this.isOnGround()) {
            this.isJumping = true;
            this.jumpTime = this.jumpHeigth/gravity;

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

    @Override
    public boolean isMoving() {
        return !(dy == 0 && dx == 0);
    }



}
