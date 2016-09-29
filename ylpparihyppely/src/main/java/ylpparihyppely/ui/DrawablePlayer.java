/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ylpparihyppely.ui;

import java.awt.Color;
import java.awt.Graphics2D;
import ylpparihyppely.gameobjects.Location;
import ylpparihyppely.gameobjects.Player;

/**
 *
 * @author daxda
 */
public class DrawablePlayer implements Drawable {

    private final Player player;
    private Color color;

    public DrawablePlayer(Player player, Color color) {
        this.player = player;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        Location l = player.getLocation();
        g2d.fillRect(l.getX(), l.getY(), 15, 30);
    }

}
