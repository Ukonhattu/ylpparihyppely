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
 * This is enemy. It extends Pawn and has nothing to do with Class Block.
 *
 * @author daxda
 */
public class DeadlyBlock extends Pawn {

    private final HitboxMaker hitboxMaker;
    private int width;
    private int height;

    /**
     * Construct.
     *
     * @param location location
     * @param health health
     * @param width width
     * @param height height
     */
    public DeadlyBlock(Location location, int health, int width, int height) {
        super(location, health);
        this.width = width;
        this.height = height;
        this.hitboxMaker = new BoxHitboxMaker(this, width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public List<Location> getHitbox() {
        return this.hitboxMaker.makeHitbox();
    }

    @Override
    public void onHit(Static otherObject) {
    }

    @Override
    public void onHit(Physics otherObject) {
    }

}
