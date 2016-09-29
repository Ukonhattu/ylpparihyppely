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

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import ylpparihyppely.gameobjects.Location;
import ylpparihyppely.gameobjects.Physics;
import ylpparihyppely.gameobjects.Static;

/**
 * Handle collisions.
 * @author daniel
 */
public class CollisionHandler {

    /**
     * Checks if two hitboxs are colliding. Done by checking if those have any
     * common locations.
     * @param hitbox1 hitbox
     * @param hitbox2 hitbox
     * @return True if colliding.
     */
    public boolean isColliding(List<Location> hitbox1, List<Location> hitbox2) {

        hitbox1.addAll(hitbox2);
        Set<Location> set = new HashSet<>(hitbox1);

        return set.size() < hitbox1.size();
    }
    
    /**
     * Checks if collider is colliding with any Physics-object given. O(n)
     * @param collider physics-object
     * @param object list of physics-objects
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
     * @param collider physics-object
     * @param object list of static-objects
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
