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
import ylpparihyppely.gameobjects.Block;
import ylpparihyppely.gameobjects.BoxHitboxMaker;
import ylpparihyppely.gameobjects.Location;

/**
 *
 * @author daxda
 */
public class TestBlock {

    Block block;
    BoxHitboxMaker bmkr;

    public TestBlock() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.block = new Block(new Location(30, 30), 40, 40);
        this.bmkr = new BoxHitboxMaker(block, 40, 40);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConstructorHeight() {
        assertEquals(true, this.block.getHeight() == 40);
    }

    @Test
    public void testConstructorWidth() {
        assertEquals(true, this.block.getWidth() == 40);
    }

    @Test
    public void testConstructorLocation() {
        assertEquals(true, this.block.getLocation().equals(new Location(30, 30)));
    }

    @Test
    public void testGetHitbox() {
        assertEquals(true, this.bmkr.makeHitbox().equals(this.block.getHitbox()));
    }
    

}
