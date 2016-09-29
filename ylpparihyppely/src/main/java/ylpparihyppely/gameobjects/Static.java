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
 * Interface for every static object that does not have physics.
 * @author daniel
 */
public interface Static extends Hitbox {

    /**
     * Get location.
     * @return location
     */
    public Location getLocation();

    /**
     * Get height.
     * @return height
     */
    public int getHeight();

    /**
     * Get width.
     * @return width
     */
    public int getWidth();
}
