/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ylpparihyppely.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import ylpparihyppely.gameobjects.Physics;
import ylpparihyppely.gameobjects.Player;

/**
 *
 * @author daniel
 */
public class PlayerController implements Controller, KeyListener {

    private final Player player;

    public PlayerController(Physics player) {
        this.player = (Player) player;
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

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            player.jump();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_A) {
            player.setDx(0);
        }

    }

}
