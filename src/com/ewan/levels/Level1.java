
package com.ewan.levels;

import com.ewan.characters.Player;
import com.ewan.game.Game;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import com.ewan.characters.Cookie;

public class Level1 extends JPanel implements ActionListener{

    private Game game;
    private BufferedImage background;
    private Timer timer;
    private int time;
    private Player player;
    private Cookie cookie;
    private HUD hud;
    public Level1(Game theGame){
        game = theGame;
        player = new Player();
        cookie = new Cookie();
        hud = new HUD();
        init();
    }
    
    private void init(){
        
        try{
            background = ImageIO.read(getClass().getResource("/Images/Grass.jpg"));
        }catch(Exception ex){
            System.out.println("Error loading background image");
        }
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(new TAdapter());
        
        time = 0;
        timer = new Timer(10, this);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 0, 0, null);
        hud.draw(g2d);
        
        player.draw(g2d);
        cookie.draw(g2d);
        g.dispose();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        checkCollisions();
        updateMove();
        checkWinCondition();
        updateTimer();
        repaint();
    }
    
    public void updateTimer(){
        time += 1;
    }
    
    public void startTimer(){
        timer.start();
    }
    
    public void stopTimer(){
        timer.stop();
    }
    
    private void checkCollisions(){
        player.checkCollision(cookie);
    }
    
    private void checkWinCondition(){
        if(player.getScore() == 50){
            
        }
    }
    
    private void updateMove(){
        player.doMove();
        hud.setScore(player.getScore());
    }
    
    private class TAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            int move = 0;
            switch(e.getKeyCode()){
                case KeyEvent.VK_W:
                    move = 1;
                    break;
                    
                case KeyEvent.VK_A:
                    move = 3;
                    break;
                    
                case KeyEvent.VK_S:
                    move = 2;
                    break;
                    
                case KeyEvent.VK_D:
                    move = 4;
                    break;
                    
                default:
                    break;
            }
            player.move(move);
        }
        
        @Override
        public void keyReleased(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_W:
                    player.stopY();
                    break;
                    
                case KeyEvent.VK_A:
                    player.stopX();
                    break;
                    
                case KeyEvent.VK_S:
                    player.stopY();
                    break;
                    
                case KeyEvent.VK_D:
                    player.stopX();
                    break;
                    
                default:
                    break;
            }
        }
    }
}
