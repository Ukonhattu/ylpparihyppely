/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ylpparihyppely.ui;

import java.util.List;
import ylpparihyppely.gameobjects.Physics;
import ylpparihyppely.gameobjects.Player;
import ylpparihyppely.gameobjects.Static;

/**
 *
 * @author daniel
 */
public interface MapCreator {
    
    
    List<Physics> getPhysicsMapItems();
    List<Static> getStaticMapItems();
    Player getMainPLayer();
    void constructMap();
}
