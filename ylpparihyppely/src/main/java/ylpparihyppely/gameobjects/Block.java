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
public class Block extends GameObject  implements Static{
    int heigth;
    int width;

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
    }



    @Override
    public void onHit(Static otherObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Location> getHitbox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onHit(Physics otherObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
