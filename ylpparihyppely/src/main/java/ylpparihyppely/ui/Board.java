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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;
import ylpparihyppely.gameobjects.Block;
import ylpparihyppely.gameobjects.Location;
import ylpparihyppely.gameobjects.Physics;
import ylpparihyppely.gameobjects.Player;
import ylpparihyppely.gameobjects.PlayerController;
import ylpparihyppely.gameobjects.Static;
import ylpparihyppely.physicsengine.PhysicsEngine;
import ylpparihyppely.physicsengine.SimplePhysicsEngine;

public class Board extends JPanel implements ActionListener {

    private Timer timer;

    private final int delay = 10;

    private PhysicsEngine physicsEngine;
    private List<Static> staticObject;
    private List<Physics> physicObject;
    private MapCreator mapCreator;

    public Board() {
        
        File map = new File("/home/daniel/ylpparihyppely/ylpparihyppely/src/main/java/ylpparihyppely/ui/firstMap.txt");
        this.mapCreator = new MapCreatorFile(map);
        this.mapCreator.constructMap();
        this.physicsEngine = new SimplePhysicsEngine(1);
        this.staticObject = this.mapCreator.getStaticMapItems();
        this.physicObject = this.mapCreator.getPhysicsMapItems();

        

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

        g2d.setColor(Color.red);
        for (Physics p : this.physicObject) {
            Location l = p.getLocation();
            g2d.fillRect(l.getX(), l.getY(), 40, 40);
        }
        for (Static s : this.staticObject) {
            Location l = s.getLocation();
            g2d.fillRect(l.getX(), l.getY(), s.getWidth(), s.getHeigth());
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
