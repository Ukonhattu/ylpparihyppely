/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ylpparihyppely.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ylpparihyppely.gameobjects.Block;
import ylpparihyppely.gameobjects.Location;
import ylpparihyppely.gameobjects.Physics;
import ylpparihyppely.gameobjects.Player;
import ylpparihyppely.gameobjects.Static;

/**
 *
 * @author daniel
 */
public class MapCreatorFile implements MapCreator {

    private List<String> rows;
    private List<Physics> physicObject;
    private List<Static> staticObject;
    private Player mainPlayer;
    private final int size;

    public MapCreatorFile(File mapFile) {
        size = 40;
        this.rows = new ArrayList();
        this.physicObject = new ArrayList();
        this.staticObject = new ArrayList();
        readFile(mapFile);

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

    @Override
    public void constructMap() {
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
            this.staticObject.add(new Block(new Location(x, y), size, size));
        }
        if (c == 'P') {
            Player player = new Player(new Location(x, y), 100);
            this.physicObject.add(player);
            this.mainPlayer = player;

        }
    }

    @Override
    public List<Physics> getPhysicsMapItems() {
        return this.physicObject;
    }

    @Override
    public List<Static> getStaticMapItems() {
        return this.staticObject;
    }

    @Override
    public Player getMainPLayer() {
        return this.mainPlayer;
    }

}
