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
package ylpparihyppely.controllers;

import ylpparihyppely.gameobjects.DeadlyBlock;

/**
 * Controlling the DeadlyBlock.
 *
 * @author daxda
 */
public class DeadlyBlockController implements AIController {

    private final DeadlyBlock deadlyBlock;
    private int timer;
    private boolean direction; //True = left, False = Right
    private int speed;
    private int area;

    /**
     * Construct.
     *
     * @param deadlyBlock DeadlyBlock
     * @param speed speed
     * @param area patrolling area radius
     */
    public DeadlyBlockController(DeadlyBlock deadlyBlock, int speed, int area) {
        this.deadlyBlock = deadlyBlock;
        timer = 0;
        this.direction = true;
        this.speed = speed;
        this.area = area;
    }

    @Override
    public void tick() {
        if (direction) {
            if (timer >= area / speed) {
                direction = false;
                deadlyBlock.setDx(-speed);
            }
            timer++;

        } else {
            if (timer <= 0) {
                direction = true;
                deadlyBlock.setDx(speed);
            }
            timer--;
        }

    }

}
