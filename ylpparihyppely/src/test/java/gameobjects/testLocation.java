/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ylpparihyppely.gameobjects.Location;

/**
 *
 * @author daxda
 */
public class testLocation {
    Location location;
    public testLocation() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.location = new Location(30,50);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testToString() {
        System.out.println(this.location);
        assertEquals(true, this.location.toString().equals("Location{x=30, y=50}"));
    }
}
