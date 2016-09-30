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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ylpparihyppely.gameobjects.Block;
import ylpparihyppely.gameobjects.DeadlyBlock;
import ylpparihyppely.gameobjects.Location;
import ylpparihyppely.gameobjects.Physics;
import ylpparihyppely.gameobjects.Player;
import ylpparihyppely.gameobjects.Static;
import ylpparihyppely.controllers.AIController;
import ylpparihyppely.controllers.DeadlyBlockController;
import ylpparihyppely.gameobjects.Finish;

/**
 * Create Map from a text File.
 * @author daniel
 */
public class MapCreatorFile implements MapCreator {

    private List<String> rows;
    private List<Physics> physicObject;
    private List<Static> staticObject;
    private List<Drawable> drawables;
    private List<AIController> aiControllers;
    private Player mainPlayer;
    private Finish finish;
    private final int size;

    /**
     *Construct.
     * @param mapFile File(.txt)
     */
    public MapCreatorFile(File mapFile) {
        size = 40;
        this.rows = new ArrayList();
        this.physicObject = new ArrayList();
        this.staticObject = new ArrayList();
        this.drawables = new ArrayList();
        this.aiControllers = new ArrayList();
        readFile(mapFile);
        constructMap();

    }

    public List<AIController> getAIControllers() {
        return aiControllers;
    }

    private void readFile(File mapFile) {
        try (Scanner reader = new Scanner(mapFile)) {

            while (reader.hasNextLine()) {
                rows.add(reader.nextLine());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Not found!");
        }
    }

    /**
     * Constructs map by adding every object to correct list. Must be used 
     * before getting any items from map.
     */

    private void constructMap() {
        int x = 0;
        int y = 0;
        for (String row : this.rows) {
            for (char c : row.toCharArray()) {
                addToMap(c, x * this.size, y * this.size);
                x++;
            }
            x = 0;
            y++;
        }

    }

    private void addToMap(char c, int x, int y) {
        if (c == '#') {
            Block block = new Block(new Location(x, y), size, size);
            this.staticObject.add(block);
            this.drawables.add(new DrawableBlock(block, Color.RED));
        }
        if (c == 'P') {
            Player player = new Player(new Location(x, y), 100);
            this.physicObject.add(player);
            this.drawables.add(new DrawablePlayer(player, Color.GREEN));
            this.mainPlayer = player;

        }
        if (c == 'D') {
            DeadlyBlock dBlock = new DeadlyBlock(new Location(x,y),100, size, size);
            this.physicObject.add(dBlock);
            this.drawables.add(new DrawableDeadlyBlock(dBlock, Color.ORANGE));
            this.aiControllers.add(new DeadlyBlockController(dBlock, 2, 400));
        }
        
        if (c == 'F') {
            Finish newFinish = new Finish(new Location(x,y), size, size);
            this.staticObject.add(newFinish);
            this.drawables.add(new DrawableFinish(newFinish, Color.WHITE));
            this.finish = newFinish;
        }
    }

    /**
     *Get all physics items.
     * @return list of physics
     */
    @Override
    public List<Physics> getPhysicsMapItems() {
        return this.physicObject;
    }

    /**
     *Get all static items.
     * @return list of static
     */
    @Override
    public List<Static> getStaticMapItems() {
        return this.staticObject;
    }

    /**
     * Get the main player.
     * @return Player
     */
    @Override
    public Player getMainPLayer() {
        return this.mainPlayer;
    }

    /**
     * Get all Drawables.
     * @return all Drawables
     */
    @Override
    public List<Drawable> getDrawables() {
        return this.drawables;
    }

    @Override
    public Finish getFinish() {
        return this.finish;
    }

}
