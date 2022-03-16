/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gametrymain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author gmcoa
 */
public class Player extends GameObject{

    Random r = new Random();
    Handler handler;
    
    
    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
       
    }
    
    public Rectangle getBounds(){
        
        
        return new Rectangle(x, y, 32, 32);
        
    }

    public void tick() {
        
        x += velX;
        y += velY;
        
        x = GameTryMain.clamp(x,0, GameTryMain.WIDTH - 40);
        y = GameTryMain.clamp(y,0, GameTryMain.HEIGHT - 72);
        
        handler.addObject((new Trail(x+4, y+4, Color.red, 16, 16, 0.03f, handler, ID.Trail)));
        
        collision();
    }

    private void collision(){
        
        for(int i = 0; i<handler.object.size(); i++){
            
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.BasicEnemy){  //tempObject is now basic enemy
                if(getBounds().intersects(tempObject.getBounds())){
                    //collision code
                    
                    HUD.HEALTH -= 5;
                }
            }
        }
        
    }
    
    public void render(Graphics g) {
        
       
        g.setColor(Color.red);
        g.fillRect(x, y, 32, 32);
        
    }
    
    
    
}
