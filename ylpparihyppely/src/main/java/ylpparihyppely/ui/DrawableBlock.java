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
package ylpparihyppely.ui;

import java.awt.Color;
import java.awt.Graphics2D;
import ylpparihyppely.gameobjects.Block;
import ylpparihyppely.gameobjects.Location;

/**
 * Block to be drawn.
 * @author daxda
 */
public class DrawableBlock implements Drawable {

    private final Block block;
    private Color color;

    /**
     *Construct.
     * @param block Block
     * @param color Color.XXX
     */
    public DrawableBlock(Block block, Color color) {
        this.block = block;
        this.color = color;
    }

    /**
     *The actual drawing.
     * @param g2d Graphics2D
     */
    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        Location l = block.getLocation();
        g2d.fillRect(l.getX(), l.getY(), block.getWidth(), block.getHeight());
    }
}
