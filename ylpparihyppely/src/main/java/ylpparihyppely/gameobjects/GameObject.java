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
 * Basic GameObject for all objects.
 * @author daniel
 */
public abstract class GameObject {
    
    private Location location;

    /**
     *Construct.
     * @param location location
     */
    public GameObject(Location location) {
        this.location = location;
    }

    /**
     *Get current location.
     * @return location
     */
    public Location getLocation() {
        return location;
    }
    
    /**
     * Return the location of imaginary hitbox for testing next positions hits.
     * @return 
     */
    abstract Location getHitboxLocation();

    /**
     *Set location.
     * @param location location
     */
    public void setLocation(Location location) {
        this.location = location;
    }
    
    

    
    
}