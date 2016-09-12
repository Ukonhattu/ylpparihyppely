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
    private boolean onGround;
    private int dx;
    private int dy;
    private int speed;

    public Pawn(Location location, int health) {
        super(location);
        this.health = health;
        this.isJumping = false;
        this.dx = 0;
        this.dy = 0;
        this.speed = 1;
    }

    public void move() {
        Location location = this.getLocation();
        Location newLocation = new Location(location.getX()+this.dx, location.getY()+this.dy);
        this.wantedLocation = newLocation;
    }
    

    public void jump() {
        this.isJumping = true;
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
    
    @Override
    public boolean isOnGround() {
        return onGround;
    }
    
}
