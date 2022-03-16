/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gametrymain;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author gmcoa
 */
public class Trail extends GameObject{

    private float alpha = 1;
    private float life;
    private Handler handler;
    private Color color;
    
    private int width, height;
    
    //life = 0.01 - 0.1
    
    
    public Trail(int x, int y, Color color, int width, int height, float life, Handler handler, ID id) {
        super(x, y, id);
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
        this.handler = handler;
        
        
    }

    
    public void tick() {
        if(alpha > life){   //the smaller the value of life of particle, the longer it will stay
            alpha -= life - 0.001f;
        }else handler.removeObject(this);
        
        
    }

    
    public void render(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        
        g.setColor(color);
        g.fillRect(x, y, width, height); 
        
        g2d.setComposite(makeTransparent(1)); //to prevent any transparency issues (?)
        
    }

    private AlphaComposite makeTransparent(float alpha){
        
        int type = AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type, alpha));
        
    }
    
    
    public Rectangle getBounds() {
        return null;
    }
    
}
