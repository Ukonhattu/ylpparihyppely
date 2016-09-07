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
public interface Physics extends Hitbox{
    
    void applyGravity(int power);
    boolean isMoving();
    boolean isFalling();
    boolean isOnGround();

}
