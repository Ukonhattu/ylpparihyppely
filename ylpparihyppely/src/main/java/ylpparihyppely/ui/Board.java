/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ylpparihyppely.ui;

/**
 *
 * @author daxda
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;
import ylpparihyppely.gameobjects.Physics;
import ylpparihyppely.controllers.PlayerController;
import ylpparihyppely.gameobjects.Static;
import ylpparihyppely.physicsengine.PhysicsEngine;
import ylpparihyppely.physicsengine.SimplePhysicsEngine;

public class Board extends JPanel implements ActionListener {

    private Timer timer;

    private final int delay = 10;
    private final int gravity = 2;

    private PhysicsEngine physicsEngine;
    private List<Static> staticObject;
    private List<Physics> physicObject;
    private List<Drawable> drawables;
    private MapCreator mapCreator;

    public Board() {

        File map = new File("maps/firstMap.txt");

        this.mapCreator = new MapCreatorFile(map);
        this.mapCreator.constructMap();
        this.physicsEngine = new SimplePhysicsEngine(gravity);
        this.staticObject = this.mapCreator.getStaticMapItems();
        this.physicObject = this.mapCreator.getPhysicsMapItems();
        this.mapCreator.getMainPLayer().setGravity(gravity);
        this.drawables = this.mapCreator.getDrawables();

        initBoard(this.mapCreator.getMainPLayer());
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
            d.draw(g2d);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        tryMovements();

        this.physicsEngine.applyMovements(physicObject, staticObject);
        this.physicsEngine.applyGravity(physicObject, staticObject);
        repaint();

    }

    private void tryMovements() {
        for (Physics p : this.physicObject) {
            p.tryMove();
        }
    }

}
