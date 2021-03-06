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
 * THE PLAYER.
 * @author daniel
 */
public class Player extends Pawn {

    Inventory inventory;
    String name;
    HitboxMaker hitboxMaker;
    private List<Location> hitbox;

    /**
     *Construct.
     * @param location location
     * @param health health
     */
    public Player(Location location, int health) {
        super(location, health);
        this.hitboxMaker = new BoxHitboxMaker(this, 15, 30);
        this.hitbox = this.hitboxMaker.makeHitbox();
        this.inventory = new Inventory();

    }

    /**
     * Get hitbox.
     * @return hitbox
     */
    @Override
    public List<Location> getHitbox() {
        return this.hitboxMaker.makeHitbox();
    }

    /**
     * When something hits.
     * @param otherObject static-object
     */
    @Override
    public void onHit(Static otherObject) {
    }

    /**
     * When something hits.
     * @param otherObject physics-object
     */
    @Override
    public void onHit(Physics otherObject) {
        if (otherObject.getClass() == DeadlyBlock.class) {
            this.health = 0;
            
        }
    }
    
    public Inventory getInventory() {
        return this.inventory;
    }



}
