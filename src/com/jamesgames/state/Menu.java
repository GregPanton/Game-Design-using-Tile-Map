package com.jamesgames.state;

import com.jamesgames.entity.Sprite;
import com.jamesgames.main.Game;
import com.jamesgames.ui.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * Template for a Static Menu Screen
 * @author greg
 */
public class Menu extends AbstractLevel
{
    private Button playButton = new Button(200, 50);
    
    /**
     * Constructor with Level Manager parameter
     * @param lm
     */
    public Menu(LevelManager lm)
    {
       super(lm); //Passes to super class
       
       //Set Sprite 
       Sprite buttonSprite = new Sprite(0);
       buttonSprite.addFrame("/buttons/playbutton.png");
       playButton.setSprite(buttonSprite);
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
        if(playButton.clickedInside(mouseClick))
        {
            lm.goToState(2);
        }
    }
    
    @Override
    public void update() 
    {
        
    }
    
    /**
     * This method draws the title of the menu 
     * The playButton is drawn and the user can click to go to the about screen
     * @param g 
     */
    @Override
    public void draw(Graphics2D g) 
    {
        g.setColor(Color.BLACK);
        g.fillRect(0,0, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.BOLD, 30));
        g.drawString("MENU", 200, 40);
        
        //Draw a button
        playButton.draw(g);
        
        /* PREVIOUS DESIGN FOR PLACEMENT - NOT IN USE
        g.fillRect(200, 50, 350, 150);
        g.setColor(Color.BLACK);
        g.drawString("START", 330, 140);
        
        g.setColor(Color.WHITE);
        g.fillRect(200, 220, 350, 150);
        g.setColor(Color.BLACK);
        g.drawString("QUIT", 340, 310);
        
        g.setColor(Color.WHITE);
        g.fillRect(200, 390, 350, 150);
        g.setColor(Color.BLACK);
        g.drawString("ABOUT GAME", 280, 470);
        */
    } 
}