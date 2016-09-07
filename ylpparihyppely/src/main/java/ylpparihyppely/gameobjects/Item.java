/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ylpparihyppely.gameobjects;

/**
 *
 * @author daniel
 */
abstract class Item extends GameObject implements CollectibleGameObject, Static {

    public String name;
    public Item(Location location, String name) {
        super(location);
        this.name = name;
    }

}
