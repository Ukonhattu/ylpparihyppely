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
 *
 * @author daxda
 */
public class Finish extends GameObject implements Static{
    
    private HitboxMaker hitboxMaker;
    private int width;
    private int height;
    private boolean playerInFinish;

    public Finish(Location location, int width, int height) {
        super(location);
        this.width = width;
        this.height = height;
        this.hitboxMaker = new BoxHitboxMaker(this, width, height);
        this.playerInFinish = false;
    }

    @Override
    Location getHitboxLocation() {
        return this.getLocation();
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getWidth() {
        return this.width;
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
        if (otherObject.getClass() == Player.class ) {
            this.playerInFinish = true;
        }
    }

    public boolean isPlayerInFinish() {
        return playerInFinish;
    }
    
    
    
}
