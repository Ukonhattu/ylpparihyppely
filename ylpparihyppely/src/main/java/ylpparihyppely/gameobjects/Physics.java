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
public interface Physics extends Hitbox {

    void applyGravity(int power);
    void deGravity();

    boolean isMoving();

    boolean isOnAir();

    boolean isOnGround();

    Location whereYouWannaMove();

    void setWantedLocation(Location location);

    void moveTo(Location location);

    Location getLocation();

    void tryMove();
    
   
    




}
