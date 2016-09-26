/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ylpparihyppely.gameobjects;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daniel
 */
public class BoxHitboxMaker implements HitboxMaker {

    private GameObject object;
    private int width;
    private int heigth;

    public BoxHitboxMaker(GameObject object, int width, int heigth) {
        this.object = object;
        this.width = width;
        this.heigth = heigth;
    }

    @Override
    public List<Location> makeHitbox() {
        Location location = object.getHitboxLocation();
        List<Location> hitbox = new ArrayList();
        for (int i = location.getY(); i < location.getY() + heigth; i++) {

            for (int j = location.getX(); j < location.getX() + width; j++) {
                if (j == location.getX() || j == location.getX() + width - 1 || i == location.getY() || i == location.getY() + heigth - 1) {
                    hitbox.add(new Location(j, i));
                }
            }
        }

        return hitbox;
    }

}
