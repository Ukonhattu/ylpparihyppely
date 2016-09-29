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
package ylpparihyppely.physicsengine;

import java.util.List;
import ylpparihyppely.gameobjects.Physics;
import ylpparihyppely.gameobjects.Static;

/**
 * The Most simple physics.
 * @author daniel
 */
public class SimplePhysicsEngine implements PhysicsEngine {

    private int gPower;
    private CollisionHandler collisionHandler;

    /**
     *Construct.
     * @param gPower Gravitation power
     */
    public SimplePhysicsEngine(int gPower) {
        this.gPower = gPower;
        this.collisionHandler = new CollisionHandler();
    }

    /**
     * Applies gravity on this update to every object given.Checks if gravity
     * movement is allowed and cancels it if not.
     * @param physicsObject list of physics
     * @param staticObject list of static
     */
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
    
    /**
     * Applies movements to physics objects. Moves each object to location it
     * wants to move if possible (not colliding). If not possible "moves" to 
     * location where it is already.
     * @param physicsObject list of physics
     * @param staticObject list of static
     */
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
