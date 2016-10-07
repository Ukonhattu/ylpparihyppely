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
public class TestNote {

    private Note note;

    public TestNote() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        note = new Note(new Location(30, 30), "Test", 40, 40);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetText() {
        note.setText("test");
        assertEquals(true, note.getText().equals("test"));
    }

    @Test
    public void testGetHitbox() { //Test if returns hitbox when not hidden
        assertEquals(true, note.getHitbox().size() > 0);
    }

    @Test
    public void testGetHitboxHidden() { //Test if returns hitbox when hidden (should not)
        note.hidden = false;
        assertEquals(true, note.getHitbox().size() > 0);
    }
    
    @Test
    public void testOnHitPhysic() {
        Player player = new Player(new Location(40,40), 100);
        note.onHit(player);
        assertEquals(true, note.isHidden());
    }
}
