/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ylpparihyppely.gameobjects;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author daniel
 */
public class PlayerController implements Controller, KeyListener {

    private Player player;

    public PlayerController(Player player) {
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
            player.setDx(player.getSpeed());
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            player.setDx(-player.getSpeed());
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            player.setDy(player.getSpeed());
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            player.setDy(-player.getSpeed());
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            player.jump();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_A) {
            player.setDx(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_D) {
            player.setDy(0);
        }

    }

}
