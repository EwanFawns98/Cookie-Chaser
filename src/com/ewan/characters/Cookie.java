package com.ewan.characters;
import com.ewan.levels.Vector;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.imageio.ImageIO;
public class Cookie {
    
    private Vector position;
    private BufferedImage sprite;
    private int points;
    private int spriteWidth;
    private int spriteHeight;
    
    public Cookie(){
        position = new Vector(500, 500);
        points = 10;
        init();
    }
    
    private void init(){
        try{
            sprite = ImageIO.read(getClass().getResource("/Images/Cookie.png"));
        }catch(Exception ex){
            System.out.println("Exception ex");
        }
        
        spriteWidth = sprite.getWidth();
        spriteHeight = sprite.getHeight();
        
    }
    
    public void setScore(int newPoints){
        points = newPoints;
    }
    
    public int getScore(){
        return points;
    }
    
    public int getSpriteWidth(){
        return spriteWidth;
    }
    
    public int getSpriteHeight(){
        return spriteHeight;
    }
    
    public Rectangle getBounds(){
        Rectangle cookieRect = new Rectangle(position.getX(), position.getY(), spriteWidth, spriteHeight);
        return cookieRect;
    }
    
    public void move(){
        Random rand = new Random();
        int randX = 0;
        int randY = 0;
        randX = rand.nextInt(600 - 64);
        randY = rand.nextInt(600 - 64);
        position.setX(randX);
        position.setY(randY);
    }
    
    

    public void draw(Graphics2D g2d){
        g2d.drawImage(sprite, position.getX(), position.getY(), null);
    }
}
