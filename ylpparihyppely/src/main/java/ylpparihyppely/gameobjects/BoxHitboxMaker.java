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

import java.util.ArrayList;
import java.util.List;

/**
 * Make box hitboxes.
 * @author daniel
 */
public class BoxHitboxMaker implements HitboxMaker {

    private GameObject object;
    private int width;
    private int heigth;

    /**
     *Construct.
     * @param object GameObject
     * @param width width
     * @param heigth height
     */
    public BoxHitboxMaker(GameObject object, int width, int heigth) {
        this.object = object;
        this.width = width;
        this.heigth = heigth;
    }

    /**
     * Make hitbox which is list of locations of edges.
     * @return hitbox
     */
    @Override
    public List<Location> makeHitbox() {
        Location location = object.getHitboxLocation();
        List<Location> hitbox = new ArrayList();
        for (int i = location.getY(); i < location.getY() + heigth; i++) {

            for (int j = location.getX(); j < location.getX() + width; j++) {
                if (j == location.getX() || j == location.getX() + width - 1 || i == location.getY() || i == location.getY() + heigth - 1) {
                    hitbox.add(new Location(j, i));
                }
            }
        }

        return hitbox;
    }

}
