
package com.ewan.levels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class HUD {
    
    private int score;
    private String sScore;
    private int time;
    private String sTime;
    
    public HUD(){
        score = 0;
        sScore = "";
        time = 0;
        sTime = "";
    }
    
    public void setScore(int newScore){
        score = newScore;
        sScore = String.valueOf(score);
    }
    
    public int getScore(){
        return score;
    }
    
    public void setTime(int newTime){
        time = newTime;
        sTime = String.valueOf(time);
    }
    
    public int getTime(){
        return time;
    }
    
    public void draw(Graphics2D g2d){
        Font font = new Font("Arial", Font.PLAIN, 22);
        g2d.setFont(font);
        g2d.setColor(Color.yellow);
        g2d.drawString("Score:", 10, 20);
        g2d.drawString(sScore, 90, 20);
        g2d.drawString("Time:", 10, 50);
    }
}