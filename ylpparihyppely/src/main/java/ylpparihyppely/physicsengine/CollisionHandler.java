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
    
    public void handleCollideWithPhysics(Physics collider, List<Physics> object) {
        object.remove(collider);
        for (Physics p: object) {
            if(isColliding(collider.getHitbox(), p.getHitbox())) {
                collider.onHit(p);
            }
        }
    
    }
    
    public void handleCollideWithStatic(Physics collider, List<Static> object) {
        for (Static s: object) {
            if (isColliding(collider.getHitbox(), s.getHitbox())) {
                collider.onHit(s);
            }
        }
    }
    
}
