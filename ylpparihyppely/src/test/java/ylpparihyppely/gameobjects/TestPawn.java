/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ylpparihyppely.gameobjects;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daxda
 */
public class TestPawn {
    
    private Pawn player;
    
    public TestPawn() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.player = new Player(new Location(30,30), 100);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testMethod() {
        
    }
    
    @Test
    public void testMove() {
        player.setDx(1);
        player.move();
        assertEquals(true, player.wantedLocation.equals(new Location(31,30)));
    }
    
    @Test
    public void testJump() {
        player.setGravity(1);
        player.jump();
        player.move();
        assertEquals(true, player.wantedLocation.equals(new Location(30,27)));
    }
}
