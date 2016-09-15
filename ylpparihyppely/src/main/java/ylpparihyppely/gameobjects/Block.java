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
public class Block extends GameObject implements Static {

    private int heigth;
    private int width;
    private HitboxMaker hitboxMaker;

    public int getHeigth() {
        return heigth;
    }

    public int getWidth() {
        return width;
    }

    public Block(Location location, int heigth, int width) {
        super(location);
        this.heigth = heigth;
        this.width = width;
        this.hitboxMaker = new BoxHitboxMaker(this, this.width, this.heigth);
    }

    @Override
    public void onHit(Static otherObject) {
    }

    @Override
    public List<Location> getHitbox() {
        return this.hitboxMaker.makeHitbox();
    }

    @Override
    public void onHit(Physics otherObject) {
    }

    @Override
    Location getHitboxLocation() {
        return this.getLocation();

    }

    @Override
    Location getGravityHitboxLocation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
