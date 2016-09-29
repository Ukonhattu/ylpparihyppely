/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ylpparihyppely.ui;

import java.awt.Color;
import java.awt.Graphics2D;
import ylpparihyppely.gameobjects.Block;
import ylpparihyppely.gameobjects.Location;

/**
 *
 * @author daxda
 */
public class DrawableBlock implements Drawable {

    private final Block block;
    private Color color;

    public DrawableBlock(Block block, Color color) {
        this.block = block;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        Location l = block.getLocation();
        g2d.fillRect(l.getX(), l.getY(), block.getWidth(), block.getHeigth());
    }
}
