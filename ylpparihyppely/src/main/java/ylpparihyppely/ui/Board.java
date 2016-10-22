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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;
import ylpparihyppely.controllers.AIController;
import ylpparihyppely.gameobjects.Physics;
import ylpparihyppely.controllers.PlayerController;
import ylpparihyppely.gameobjects.Finish;
import ylpparihyppely.gameobjects.Player;
import ylpparihyppely.gameobjects.Static;
import ylpparihyppely.physicsengine.PhysicsEngine;
import ylpparihyppely.physicsengine.SimplePhysicsEngine;

/**
 * Board a.k.a the screen.
 *
 * @author daxda
 */
public class Board extends JPanel implements ActionListener {

    private Timer timer;

    private final int delay = 10;
    private final int gravity = 2;

    private PhysicsEngine physicsEngine;
    private List<Static> staticObject;
    private List<Physics> physicObject;
    private List<Drawable> drawables;
    private List<AIController> aiControllers;
    private MapCreator mapCreator;
    private Player mainPlayer;
    private Finish mapFinish;
    private int collectibleQuanity;

    private List<File> maps;
    private File currentMap;

    /**
     * Make it.
     */
    public Board() {

        this.physicsEngine = new SimplePhysicsEngine(gravity);
        this.maps = getMaps();
        
        nextMap();
        
        initMap(currentMap);
        initBoard(mainPlayer);

    }

    private void initMap(File map) {

        this.mapCreator = new MapCreatorFile(map);
        this.staticObject = this.mapCreator.getStaticMapItems();
        this.physicObject = this.mapCreator.getPhysicsMapItems();
        this.mapCreator.getMainPLayer().setGravity(gravity);
        this.drawables = this.mapCreator.getDrawables();
        this.aiControllers = this.mapCreator.getAIControllers();
        this.mainPlayer = this.mapCreator.getMainPLayer();
        this.mapFinish = this.mapCreator.getFinish();
        this.collectibleQuanity = this.mapCreator.getCollectibleQuanity();

    }

    private void initBoard(Physics player) {
        addKeyListener(new PlayerController(player));
        setFocusable(true);
        setBackground(Color.BLACK);

        timer = new Timer(delay, this);
        timer.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        for (Drawable d : this.drawables) {
            if (!d.isHidden()) {
                d.draw(g2d);
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        tryMovements();
        controlAI();
        this.physicsEngine.applyMovements(physicObject, staticObject);
        this.physicsEngine.applyGravity(physicObject, staticObject);
        repaint();
        if (mainPlayer.getHealth() <= 0) {
            reset();
            
        }
        if (mapFinish.isPlayerInFinish() && this.mainPlayer.getInventory().getInventorySize() == this.collectibleQuanity) {
            if (!nextMap()) {
                System.exit(0); 
            }
            reset();
        }
        
        if (this.mainPlayer.getLocation().getY() > 750) {
            reset();
        }

    }

    private void tryMovements() {
        for (Physics p : this.physicObject) {
            p.tryMove();
        }
    }

    private void controlAI() {
        for (AIController aic : this.aiControllers) {
            aic.tick();
        }
    }

    private void reset() {
        initMap(currentMap);
        initBoard(mainPlayer);
    }

    private boolean nextMap() {
        if (this.maps.isEmpty()) {
            return false;
        }
        this.currentMap = this.maps.get(0);
        this.maps.remove(0);
        return true;

    }

    private List<File> getMaps() {
        File folder = new File("maps");
        return new ArrayList(Arrays.asList(folder.listFiles()));
    }

}
