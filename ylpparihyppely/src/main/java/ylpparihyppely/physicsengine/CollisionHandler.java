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

    public boolean isColliding(List<Location> hitbox1, List<Location> hitbox2) {

        hitbox1.addAll(hitbox2);
        Set<Location> set = new HashSet<>(hitbox1);

        return set.size() < hitbox1.size();
    }

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

    public boolean gravityCollideWithPhysics(Physics collider, List<Physics> object) {

        boolean collided = false;
        for (Physics p : object) {
            if (collider.equals(p)) {
                continue;
            }
            if (isColliding(collider.getGravityHitbox(), p.getHitbox())) {
                collider.onHit(p);
                collided = true;
            }
        }
        return collided;
    }
        public boolean gravityCollideWithStatic(Physics collider, List<Static> object) {
        boolean collided = false;
        for (Static s : object) {
            if (isColliding(collider.getGravityHitbox(), s.getHitbox())) {
                collider.onHit(s);
                collided = true;
            }
        }
        return collided;
    }

}
