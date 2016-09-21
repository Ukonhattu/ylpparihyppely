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
    public void applyGravity(List<Physics> physicsObject, List<Static> staticObject) {
        for (Physics o : physicsObject) {
            o.applyGravity(gPower);
            boolean collidedPhysics = collisionHandler.handleCollideWithPhysics(o, physicsObject);
            boolean collidedStatic = collisionHandler.handleCollideWithStatic(o, staticObject);
            if (collidedPhysics || collidedStatic) {
                o.deGravity();
            }
        }
    }

    @Override
    public void applyMovements(List<Physics> physicsObject, List<Static> staticObject) {

        for (Physics o : physicsObject) {
            boolean collidedPhysics = collisionHandler.handleCollideWithPhysics(o, physicsObject);
            boolean collidedStatic = collisionHandler.handleCollideWithStatic(o, staticObject);
            if (!collidedPhysics && !collidedStatic) {

                o.moveTo(o.whereYouWannaMove());

            } else {
                o.moveTo(o.getLocation());
            }

        }
    }

}
