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
    
    public void applyCollisions(List<Physics> physicsObject, List<Static> staticObject) {
        for (Physics o: physicsObject) {
            if (o.isMoving() || o.isFalling()) {
                
            }
        }
    }
    
}
