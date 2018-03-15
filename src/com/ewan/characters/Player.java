/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ewan.characters;
import com.ewan.levels.Vector;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class Player {
    
    private Vector position;
    private Vector displacement;
    private BufferedImage sprite;
    private int score;
    private int spriteWidth;
    private int spriteHeight;
    
    public Player(){
        position = new Vector(100, 100);
        displacement = new Vector(0, 0);
        score = 0;
        init();
    }
    
    private void init(){
        try{
            sprite = ImageIO.read(getClass().getResource("/Images/Character.png"));
        }catch(Exception ex){
            System.out.println("Exception ex");
        }
        
        spriteWidth = sprite.getWidth();
        spriteHeight = sprite.getHeight();
        
    }
    
    public void setScore(int newScore){
        score = newScore;
    }
    
    public int getScore(){
        return score;
    }
    
    public int getSpriteWidth(){
        return spriteWidth;
    }
    
    public int getSpriteHeight(){
        return spriteHeight;
    }
    
    public Rectangle getBounds(){
        Rectangle playerRect = new Rectangle(position.getX(), position.getY(), spriteWidth, spriteHeight);
        return playerRect;
    }
    
    public void move(int direction){
        switch(direction){
            case 1:
                displacement.setY(-1);
                break;
                
            case 2:
                displacement.setY(1);
                break;
                
            case 3:
                displacement.setX(-1);
                break;
                
            case 4:
                displacement.setX(1);
                break;
                
            default:
                break;
        }
    }
    
    public void doMove(){
        position.add(displacement);
    }
    
    public void stopY(){
        displacement.setY(0);
    }
    
    public void stopX(){
        displacement.setX(0);
    }
    
    public boolean checkCollision(Cookie c){
        if(c.getBounds().intersects(getBounds())){
            score += c.getScore();
            c.move();
            return true;
        }
        return false;
    }
    
    public void draw(Graphics2D g2d){
        g2d.drawImage(sprite, position.getX(), position.getY(), null);
    }
    
}
