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
public class Block extends GameObject {
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
    
}
