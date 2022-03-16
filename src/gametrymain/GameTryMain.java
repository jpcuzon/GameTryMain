/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gametrymain;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 *
 * @author gmcoa
 */
public class GameTryMain extends Canvas implements Runnable{
    
    public static final int WIDTH = 1980, HEIGHT = (WIDTH * 9) / 16;
    
    private Thread thread;
    private boolean running = false;
    
    private Random r;
    private Handler handler;
    private HUD hud;
    
    
    public GameTryMain(){
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        
        new Window(WIDTH, HEIGHT, "Michael's Adventure", this);
        
        r = new Random();
        hud = new HUD();
        
        handler.addObject(new Player(WIDTH/2 - 32, HEIGHT/2, ID.Player, handler)); //creates a player object
        for(int i = 0; i<3;i++){
        handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));}
        

        
    }
    
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
        
    }
    
    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //a popular, commonly used game loop code, we can search about it later
    public void run(){
        
        this.requestFocus(); //automatically sets the focus on the window after running
        
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            
            while(delta >=1){
                tick();
                delta--;
            }
            if(running)
                render();
            
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);  // prints the fps
                frames = 0;
            }
            
        }
        
        stop();
        
    }
    
    private void tick(){
        handler.tick(); //takes the method from the handler class
        hud.tick();
    }
    
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3); //don't recommend to go over 3
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        handler.render(g);
        
        hud.render(g);
        
        g.dispose();
        bs.show();
        
        
        
    }
    
    //sets the bound limits of the object based on the screen size
    public static int clamp(int var, int min, int max){
        
        if(var >= max){
            return var = max;
        }else if(var <= min){
            return var = min;
        }else{return var;}
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new GameTryMain();
        
    }
    
}
