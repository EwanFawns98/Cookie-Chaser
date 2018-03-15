
package com.ewan.game;

import com.ewan.levels.Level1;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
public class Game {
    
    JFrame window;
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 600;
    public static final String TITLE = "Cookie Chaser";
    private Level1 level1;
    
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
    
    public Game(){
        initPanel();
        initScreens();
    }
    
    
    private void initPanel(){
        window = new JFrame();
        window.setSize(WINDOW_WIDTH, WINDOW_WIDTH);
        window.setTitle(TITLE);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.getContentPane().setLayout(new CardLayout());
    }
    
    private void initScreens(){
        level1 = new Level1(this);
        level1.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        
        window.getContentPane().add(level1);
    }
    
    public void startGame(){
        CardLayout c1 = (CardLayout)window.getContentPane().getLayout();
        c1.next(window.getContentPane());
        level1.requestFocus();
        level1.startTimer();
        window.setVisible(true);
    }
    
}
