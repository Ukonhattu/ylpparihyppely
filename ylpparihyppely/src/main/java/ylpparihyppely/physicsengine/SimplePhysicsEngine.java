/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ylpparihyppely.physicsengine;

import java.util.List;
import ylpparihyppely.gameobjects.Physics;
import ylpparihyppely.gameobjects.Static;

/**
 *
 * @author daniel
 */
public class SimplePhysicsEngine implements PhysicsEngine {
    
    private int gPower;
    private CollisionHandler collisionHandler;
    
    public SimplePhysicsEngine(int gPower) {
        this.gPower = gPower;
        this.collisionHandler = new CollisionHandler();
    }
    
    @Override
    public void applyGravity(List<Physics> object) {
        for (Physics o : object) {
            o.applyGravity(gPower);
        }
    }
    
    @Override
    public void applyGravityMovements(List<Physics> physicsObject, List<Static> staticObject) {
        for (Physics o : physicsObject) {
            boolean collidedPhysics = collisionHandler.gravityCollideWithPhysics(o, physicsObject);
            boolean collidedStatic = collisionHandler.gravityCollideWithStatic(o, staticObject);
            if (!collidedPhysics && !collidedStatic) {

                o.moveTo(o.getGravityLocation());

                
            }
        }
    }
    
    @Override
    //Give this every object you have on your map
    public void applyCollisions(List<Physics> physicsObject, List<Static> staticObject) {
        for (Physics o : physicsObject) {
            if (o.isMoving() || o.isFalling()) {
                // DO  NOT USE IS NOT ACTIVE
            }
        }
    }
    
    @Override
    public void applyMovements(List<Physics> physicsObject, List<Static> staticObject) {
        
        for (Physics o : physicsObject) {
            boolean collidedPhysics = collisionHandler.handleCollideWithPhysics(o, physicsObject);
            boolean collidedStatic = collisionHandler.handleCollideWithStatic(o, staticObject);
            if (!collidedPhysics && !collidedStatic) {
                if (o.getLocation().getY() > o.whereYouWannaMove().getY() && !o.isJumping()) {
                    o.setWantedLocation(o.getLocation());
                }
                o.moveTo(o.whereYouWannaMove());
            }
        }
    }
    
}
