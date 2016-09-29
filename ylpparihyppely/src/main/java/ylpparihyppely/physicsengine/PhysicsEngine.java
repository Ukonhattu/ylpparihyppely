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
 * Physics Engines should work like this in this universe on pixels and bad physics.
 * @author daniel
 */
public interface PhysicsEngine {

    /**
     * Apply gravity to every physics-object.
     * @param physicsObject list of physics-objects
     * @param staticObject list of static-objects
     */
    void applyGravity(List<Physics> physicsObject, List<Static> staticObject);

    /**
     *Apply movement to every physics object.
     * @param physicObject list of physics-objects
     * @param staticObject list of static-objects
     */
    void applyMovements(List<Physics> physicObject, List<Static> staticObject);



}
