/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ylpparihyppely.physicsengine;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import ylpparihyppely.gameobjects.Location;
import ylpparihyppely.gameobjects.Physics;
import ylpparihyppely.gameobjects.Static;

/**
 *
 * @author daniel
 */
public class CollisionHandler {

    /**
     * Checks if two hitboxs are colliding. Done by checking if those have any
     * common locations.
     * @param hitbox1
     * @param hitbox2
     * @return True if colliding.
     */
    public boolean isColliding(List<Location> hitbox1, List<Location> hitbox2) {

        hitbox1.addAll(hitbox2);
        Set<Location> set = new HashSet<>(hitbox1);

        return set.size() < hitbox1.size();
    }
    
    /**
     * Checks if collider is colliding with any Physics-object given. O(n)
     * @param collider
     * @param object
     * @return True if collided with any physics-object.
     */
    public boolean handleCollideWithPhysics(Physics collider, List<Physics> object) {

        boolean collided = false;
        for (Physics p : object) {
            if (collider.equals(p)) {
                continue;
            }
            if (isColliding(collider.getHitbox(), p.getHitbox())) {
                collider.onHit(p);
                collided = true;
            }
        }
        return collided;

    }

    /**
     * Checks if collider is colliding with any Static-object given. O(n)
     * @param collider
     * @param object
     * @return True if collided with any Static-object.
     */
    public boolean handleCollideWithStatic(Physics collider, List<Static> object) {
        boolean collided = false;
        for (Static s : object) {
            if (isColliding(collider.getHitbox(), s.getHitbox())) {
                collider.onHit(s);
                collided = true;
            }
        }
        return collided;
    }

}
