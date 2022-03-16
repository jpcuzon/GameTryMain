/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gametrymain;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author gmcoa
 */
public class KeyInput extends KeyAdapter {
    
    private Handler handler;
    
    public KeyInput(Handler handler){
        this.handler = handler;
    }
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        for(int i = 0; i < handler.object.size(); i++){
            
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.Player){
                //key events for Player 1
                
                if(key == KeyEvent.VK_W) tempObject.setVelY(-7);
                if(key == KeyEvent.VK_A) tempObject.setVelX(-7);
                if(key == KeyEvent.VK_D) tempObject.setVelX(+7);
                if(key == KeyEvent.VK_S) tempObject.setVelY(+7);
                
                
                 
            }
      
            
        }
        
        if(key == KeyEvent.VK_ESCAPE)System.exit(1); //close the game when esc is pressed
        
    }
    
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        for(int i = 0; i < handler.object.size(); i++){
            
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.Player){
                //key events for Player 1
                
                if(key == KeyEvent.VK_W) tempObject.setVelY(0);
                if(key == KeyEvent.VK_A) tempObject.setVelX(0);
                if(key == KeyEvent.VK_D) tempObject.setVelX(0);
                if(key == KeyEvent.VK_S) tempObject.setVelY(0);
                
                
                 
            }
            
           
            
        }
    }
    
}
