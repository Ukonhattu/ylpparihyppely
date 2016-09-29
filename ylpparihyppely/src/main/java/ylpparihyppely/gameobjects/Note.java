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
 * Note-item.
 * @author daniel
 */
public class Note extends Item {

    String text;

    /**
     *Construct.
     * @param location location
     * @param name name
     */
    public Note(Location location, String name) {
        super(location, name);
    }

    /**
     * Get text attached to note.
     * @return text of the note
     */
    public String getText() {
        return text;
    }

    /**
     * Set note text.
     * @param text text to the note
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Get hitbox.
     * @return hitbox
     */
    @Override
    public List<Location> getHitbox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * When something hits.
     * @param otherObject static object
     */
    @Override
    public void onHit(Static otherObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * When something hits.
     * @param otherObject physics object
     */
    @Override
    public void onHit(Physics otherObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get height.
     * @return height
     */
    @Override
    public int getHeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get width.
     * @return width
     */
    @Override
    public int getWidth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    Location getHitboxLocation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
