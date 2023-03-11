package com.jamesgames.state;

import com.jamesgames.entity.Sprite;
import com.jamesgames.main.Game;
import com.jamesgames.ui.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author greg
 */
public class EndScreen extends AbstractLevel
{
    /**
     * Constructor with Level Manager parameter
     * @param lm
     */
    public EndScreen(LevelManager lm)
    {
       super(lm); //Passes to super class
    }
    
    @Override
    public void keyPressed(int keyCode) 
    {
       
    }
    
    @Override
    public void keyReleased(int keyCode) 
    {
        
    }
    
    /**
     * When user clicks playButton it will carry out a command
     * @param mouseClick 
     */
    @Override
    public void mouseClicked(Point mouseClick) 
    {
       
    }
    
    @Override
    public void update() 
    {
        
    }
    
    /**
     * This method draws the end screen title
     * @param g 
     */
    @Override
    public void draw(Graphics2D g) 
    {
        g.setColor(Color.BLACK);
        g.fillRect(0,0, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.BOLD, 30));
        g.drawString("End Screen", 200, 40);
        
    } 
    
}
