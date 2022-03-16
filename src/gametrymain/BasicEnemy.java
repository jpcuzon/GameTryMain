/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gametrymain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author gmcoa
 */
public class BasicEnemy extends GameObject{
    
    private Handler handler;
    

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        velX = 10;
        velY = 10;
    }

    public void tick() {
        x += velX;
        y += velY;
        
        if(y<=0 || y >= (GameTryMain.HEIGHT - 48)) velY *= -1;
        if(x<=0 || x >= (GameTryMain.WIDTH - 16)) velX *= -1;
        
        handler.addObject((new Trail(x+4, y+4, Color.yellow, 8, 8, 0.05f, handler, ID.Trail)));
        
    }
    
    public Rectangle getBounds(){
        
        
        return new Rectangle(x, y, 16, 16);
        
    }

    public void render(Graphics g) {
        
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, 16, 16);
        
        
    }
    
    
    
}
