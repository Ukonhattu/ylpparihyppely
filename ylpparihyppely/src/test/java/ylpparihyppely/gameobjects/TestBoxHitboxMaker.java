package ylpparihyppely.gameobjects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ylpparihyppely.gameobjects.Block;
import ylpparihyppely.gameobjects.BoxHitboxMaker;
import ylpparihyppely.gameobjects.Location;

/**
 *
 * @author daxda
 */
public class TestBoxHitboxMaker {
    
    private BoxHitboxMaker bmaker;
    private Block block;
    
    public TestBoxHitboxMaker() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.block  = new Block(new Location(30,30), 2,2);
        this.bmaker = new BoxHitboxMaker(block, 2,2);
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testMakeHitbox() {
        
        List<Location> hitbox = this.bmaker.makeHitbox();
        List<Location> testbox = new ArrayList();
        testbox.add(new Location(30,30));
        testbox.add(new Location(31,30));
        testbox.add(new Location(30,31));
        testbox.add(new Location(31,31));
        assertEquals(true, hitbox.equals(testbox));
    }
    
    @Test
    public void testMakeGravityHitbox() {
        List<Location> hitbox = this.bmaker.makeHitbox();
        List<Location> testbox = new ArrayList();
        testbox.add(new Location(30,30));
        testbox.add(new Location(31,30));
        testbox.add(new Location(30,31));
        testbox.add(new Location(31,31));
        assertEquals(true, hitbox.equals(testbox));
    }
}
