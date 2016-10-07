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
import ylpparihyppely.gameobjects.Location;
import ylpparihyppely.gameobjects.Player;

/**
 *PLayer to be drawn.
 * @author daxda
 */
public class DrawablePlayer implements Drawable {

    private final Player player;
    private Color color;

    /**
     *Construct.
     * @param player Player
     * @param color Color.XXX
     */
    public DrawablePlayer(Player player, Color color) {
        this.player = player;
        this.color = color;
    }

    /**
     *Actual drawing.
     * @param g2d Graphics2D
     */
    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        Location l = player.getLocation();
        g2d.fillRect(l.getX(), l.getY(), 15, 30);
    }

    @Override
    public boolean isHidden() {
        return this.player.isHidden();
    }

}
