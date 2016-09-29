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
package ylpparihyppely.gameobjects;



/**
 * Interface for every object that should have physics.
 * @author daniel
 */
public interface Physics extends Hitbox {

    /**
     *Apply gravity.
     * @param power Gravitation power
     */
    void applyGravity(int power);

    /**
     *Cancel gravity effect.
     */
    void deGravity();

    /**
     * Is it moving.
     * @return if is moving
     */
    boolean isMoving();

    /**
     * Is it on air.
     * @return if on air
     */
    boolean isOnAir();

    /**
     * Is it on ground.
     * @return if on ground
     */
    boolean isOnGround();

    /**
     * Where it wants to go.
     * @return where this wants to move
     */
    Location whereYouWannaMove();

    /**
     * Set where it wants to go. Slavery.
     * @param location location
     */
    void setWantedLocation(Location location);

    /**
     * Move to location absolutely.
     * @param location location
     */
    void moveTo(Location location);

    /**
     * Get current location.
     * @return location
     */
    Location getLocation();

    /**
     *Try movements.
     */
    void tryMove();
    
   
    




}
