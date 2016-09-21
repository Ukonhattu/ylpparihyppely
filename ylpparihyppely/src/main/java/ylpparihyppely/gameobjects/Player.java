/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ylpparihyppely.gameobjects;

import java.util.List;

/**
 *
 * @author daniel
 */
public class Player extends Pawn {

    Inventory inventory;
    String name;
    HitboxMaker hitboxMaker;
    private List<Location> hitbox;

    public Player(Location location, int health) {
        super(location, health);
        this.hitboxMaker = new BoxHitboxMaker(this, 40, 40);
        this.hitbox = this.hitboxMaker.makeHitbox();

    }

    @Override
    public List<Location> getHitbox() {
        return this.hitboxMaker.makeHitbox();
    }



    @Override
    public void onHit(Static otherObject) {
    }

    @Override
    public void onHit(Physics otherObject) {
    }

}
