/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ylpparihyppely.physicsengine;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ylpparihyppely.gameobjects.Block;
import ylpparihyppely.gameobjects.Location;
import ylpparihyppely.gameobjects.Physics;
import ylpparihyppely.gameobjects.Player;
import ylpparihyppely.gameobjects.Static;

/**
 *
 * @author daxda
 */
public class SimplePhysicsEngineTest {

    private List<Physics> physicsObject;
    private List<Static> staticObject;
    private PhysicsEngine physicsEngine;

    public SimplePhysicsEngineTest() {

    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        physicsObject = new ArrayList();
        staticObject = new ArrayList();

        physicsObject.add(new Player(new Location(30, 30), 100));
        staticObject.add(new Block(new Location(60, 30), 40, 40));
        physicsEngine = new SimplePhysicsEngine(1);
    }

    @After
    public void tearDown() {
    }


    @Test
    public void testApplyGravity() {
        this.physicsEngine.applyGravity(physicsObject, staticObject);
        assertEquals(true, this.physicsObject.get(0).whereYouWannaMove().equals(new Location(30,31)));
        
    }
    
    @Test
    public void testApplyGravityDenial() {
        this.staticObject.add(new Block(new Location(25,60),50,50));
        this.physicsEngine.applyGravity(physicsObject, staticObject);
        assertEquals(false, this.physicsObject.get(0).whereYouWannaMove().equals(new Location(30,31)));
        
    }

 
    @Test
    public void testApplyMovements() {
        Location wantedLocation = new Location(200,200);
        this.physicsObject.get(0).setWantedLocation(wantedLocation);
        this.physicsEngine.applyMovements(physicsObject, staticObject);
        assertEquals(true, this.physicsObject.get(0).getLocation().equals(wantedLocation));
    }
    
    @Test
    public void testApplyMovementsDenial() {
        this.staticObject.add(new Block(new Location(25,60),50,50));
        Location wantedLocation = new Location(30,40);
        this.physicsObject.get(0).setWantedLocation(wantedLocation);
        this.physicsEngine.applyMovements(physicsObject, staticObject);
        assertEquals(false, this.physicsObject.get(0).getLocation().equals(wantedLocation));
    }

}
