/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gametrymain;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *Will handle and project all the objects in the game
 * and individually updates and render them on the screen
 */
public class Handler {
    
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    //loops through every object and update/render them
    public void tick(){
        for(int i= 0; i < object.size(); i++){
            GameObject tempObject = object.get(i); //gets the id of the object that we're at
            
            tempObject.tick();
        }
        
    }
    
    public void render(Graphics g){
        for(int i= 0; i < object.size(); i++){
            GameObject tempObject = object.get(i); 
            
            tempObject.render(g);
            
        }
        
    }
    
    public void addObject(GameObject object){
        this.object.add(object);
    }
    
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
    
    
}
