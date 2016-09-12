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
public interface PhysicsEngine {
    
    void applyGravity(List<Physics> object);
    void applyCollisions(List<Physics> physicsObject, List<Static> staticObject);
    void applyMovements(List<Physics> physicObject, List<Static> staticObject);
}
