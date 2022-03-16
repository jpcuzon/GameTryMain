/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gametrymain;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author gmcoa
 */
public class HUD {
    
    public static int HEALTH = 100;
    
    public void tick(){
//        HEALTH --;
        
        HEALTH = GameTryMain.clamp(HEALTH, 0, 100);
        
    }
    
    public void render(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.GREEN);
        g.fillRect(15, 15, HEALTH*2, 32);
        g.setColor(Color.WHITE);
        g.drawRect(15, 15, 200, 32);
    }
    
}
