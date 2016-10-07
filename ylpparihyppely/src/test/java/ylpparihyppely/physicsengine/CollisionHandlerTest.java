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
package ylpparihyppely.physicsengine;

import java.util.ArrayList;
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
public class CollisionHandlerTest {

    private CollisionHandler collisionHandler;

    public CollisionHandlerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.collisionHandler = new CollisionHandler();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testIsColliding() {
        ArrayList<Location> hitbox1 = new ArrayList();
        ArrayList<Location> hitbox2 = new ArrayList();
        hitbox1.add(new Location(30, 30));
        hitbox2.add(new Location(30, 30));
        assertEquals(true, collisionHandler.isColliding(hitbox1, hitbox2));
    }

    @Test
    public void testIsColliding2() {
        ArrayList<Location> hitbox1 = new ArrayList();
        ArrayList<Location> hitbox2 = new ArrayList();
        hitbox1.add(new Location(30, 30));
        hitbox2.add(new Location(30, 31));
        assertEquals(false, collisionHandler.isColliding(hitbox1, hitbox2));
    }

    @Test
    public void testHandleCollideWithPhysic() {
        Player player = new Player(new Location(30, 30), 100);
        Player player2 = new Player(new Location(30, 30), 100);
        ArrayList<Physics> physics = new ArrayList();
        physics.add(player);
        physics.add(player2);
        assertEquals(true, collisionHandler.handleCollideWithPhysics(player, physics));
    }

    @Test
    public void testHandleCollideWithPhysic2() {
        Player player = new Player(new Location(30, 30), 100);
        Player player2 = new Player(new Location(60, 60), 100);
        ArrayList<Physics> physics = new ArrayList();
        physics.add(player);
        physics.add(player2);
        assertEquals(false, collisionHandler.handleCollideWithPhysics(player, physics));
    }

    @Test
    public void testHandleCollideWithStatic() {
        Player player = new Player(new Location(30, 30), 100);
        Block block = new Block(new Location(30, 30), 40, 40);
        ArrayList<Static> statics = new ArrayList();
        statics.add(block);
        assertEquals(true, collisionHandler.handleCollideWithStatic(player, statics));

    }

    @Test
    public void testHandleCollideWithStatic2() {
        Player player = new Player(new Location(30, 30), 100);
        Block block = new Block(new Location(60, 30), 40, 40);
        ArrayList<Static> statics = new ArrayList();
        statics.add(block);
        assertEquals(false, collisionHandler.handleCollideWithStatic(player, statics));

    }
}
