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
public class SimplePhysicsEngine implements PhysicsEngine{
    
    private int gPower;
    private CollisionHandler collisionHandler;
    
    public SimplePhysicsEngine(int gPower) {
        this.gPower = gPower;
    }

    @Override
    public void applyGravity(List<Physics> object) {
        for(Physics o: object) {
            o.applyGravity(gPower);
        }
    }
    
    @Override
    //Give this every object you have on your map
    public void applyCollisions(List<Physics> physicsObject, List<Static> staticObject) {
        for (Physics o: physicsObject) {
            if (o.isMoving() || o.isFalling()) {
                
            }
        }
    }

    @Override
    public void applyMovements(List<Physics> physicsObject,List<Static> staticObject) {
        /********* !! This does not test if wantedLocation is colliding but if current location is colliding
        this can cause problems with collisions but is good enough for this project    ********/
        for (Physics o: physicsObject) {
           boolean collidedPhysics = collisionHandler.handleCollideWithPhysics(o, physicsObject);
           boolean collidedStatic = collisionHandler.handleCollideWithStatic(o, staticObject);
           if (!(collidedPhysics && collidedStatic)) {
               o.moveTo(o.whereYouWannaMove());
           }
        }
    }


    
}
