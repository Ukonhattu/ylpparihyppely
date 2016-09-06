/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ylpparihyppely.GameObjects;



/**
 *
 * @author daniel
 */
public class Player extends Pawn {
    

    Inventory inventory;
    String name;

    public Player(Location location, int health) {
        super(location, health);

    }
}
