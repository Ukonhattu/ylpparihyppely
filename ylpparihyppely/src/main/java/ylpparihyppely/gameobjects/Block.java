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

import java.util.List;

/**
 *  Block object.
 * @author daniel
 */
public class Block extends GameObject implements Static {

    private int heigth;
    private int width;
    private HitboxMaker hitboxMaker;
    private List<Location> hitbox;

    /**
     * getHeight.
     * @return height
     */
    public int getHeight() {
        return heigth;
    }

    /**
     * getWidth.
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Construct.
     * @param location location
     * @param heigth height
     * @param width width
     */
    public Block(Location location, int heigth, int width) {
        super(location);
        this.heigth = heigth;
        this.width = width;
        this.hitboxMaker = new BoxHitboxMaker(this, this.width, this.heigth);
        this.hitbox = this.hitboxMaker.makeHitbox();
    }

    /**
     * When hits something.
     * @param otherObject static object
     */
    @Override
    public void onHit(Static otherObject) {
    }

    /**
     * Get hitbox.
     * @return hitbox
     */
    @Override
    public List<Location> getHitbox() {
        return this.hitbox;
    }

    /**
     * When hits something.
     * @param otherObject physics object
     */
    @Override
    public void onHit(Physics otherObject) {
    }

    @Override
    Location getHitboxLocation() {
        return this.getLocation();

    }



}
