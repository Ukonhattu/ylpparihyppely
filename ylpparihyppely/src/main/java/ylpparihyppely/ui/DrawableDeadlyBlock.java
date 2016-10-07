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
import ylpparihyppely.gameobjects.DeadlyBlock;
import ylpparihyppely.gameobjects.Location;

/**
 * Drawable Deadly Block.
 * @author daxda
 */
public class DrawableDeadlyBlock implements Drawable {

    private final DeadlyBlock dBlock;
/**
 * Construct.
 * @param dBlock DeadlyBlock
 * @param color Color.color
 */
    public DrawableDeadlyBlock(DeadlyBlock dBlock, Color color) {
        this.dBlock = dBlock;
        this.color = color;
    }
    private Color color;

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        Location l = dBlock.getLocation();
        g2d.fillRect(l.getX(), l.getY(), dBlock.getWidth(), dBlock.getHeight());
    }

    @Override
    public boolean isHidden() {
        return this.dBlock.isHidden();
    }

}
