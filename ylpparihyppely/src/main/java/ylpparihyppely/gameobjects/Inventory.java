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
class Inventory {

    List<CollectibleGameObject> collectedObjects;

    public Inventory() {
        this.collectedObjects = new ArrayList<>();
    }

    public void addCollectible(CollectibleGameObject object) {
    }

}
