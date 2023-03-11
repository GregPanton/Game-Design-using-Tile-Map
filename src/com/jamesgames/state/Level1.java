package com.jamesgames.state;

import com.jamesgames.entity.Collectable;
import com.jamesgames.entity.Enemy;
import com.jamesgames.entity.Player;
import com.jamesgames.entity.Sprite;
import com.jamesgames.main.Game;
import com.jamesgames.main.LevelPanel;
import com.jamesgames.sprite.SpriteLoader;
import com.jamesgames.tilemap.TileMapManager;
import com.jamesgames.ui.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

/**
 * Template for a Static Menu Screen
 * @author greg
 */
public class Level1 extends AbstractLevel
{
    private Player p;
    private Enemy e;
    private Collectable c;
    private Button playButton = new Button(200, 50);
    
    /**
     * Constructor with Level Manager parameter
     * @param lm
     */
    public Level1(LevelManager lm)
    {
       super(lm); //Passes to super class
       tmm = new TileMapManager();
       
       p = new Player(tmm);
       e = new Enemy(tmm);
       c = new Collectable(tmm);
       
       loadPlayerResources();
       loadEnemyResources();
       loadCollectableResources();
       
       //Set Back Sprite Button
       Sprite buttonSprite = new Sprite(0);
       buttonSprite.addFrame("/buttons/backbutton.png");
       playButton.setSprite(buttonSprite);
    }
    
    /**
     * Loads and sets Sprite to Player
     * Sets animations
     */
    private void loadPlayerResources()
    {
        Sprite s;
        SpriteLoader sp = new SpriteLoader("/images/level1/character");
        
        s = sp.loadFileSequence("walk_left", 6, "png");
        p.setAnimation("LEFT", s);
        
        s = sp.loadFileSequence("walk_right", 6, "png");
        p.setAnimation("RIGHT", s);
        
        s = sp.loadFileSequence("static", 1, "png");
        p.setAnimation("STATIC", s);
    }
    
    /**
     * Loads and sets Sprite to Enemy
     */
    private void loadEnemyResources()
    {
      Sprite s;
      SpriteLoader sp = new SpriteLoader("/images/level1/enemy");
      s = sp.loadFileSequence("enemy_static", 1, "png");
      
      e.setSprite(s);
      
    }
    
    /**
     * Loads and set Sprite to Collectable
     */
    private void loadCollectableResources()
    {
       Sprite s;
       SpriteLoader sp = new SpriteLoader("/images/level1/collectable");
       s = sp.loadFileSequence("coin_static", 1, "png");
       
       c.setSprite(s);
    }
    
    /**
     * Takes user input to move Player
     * @param keyCode 
     */
    @Override
    public void keyPressed(int keyCode) 
    {
        if(keyCode == KeyEvent.VK_A)
        {
            p.moveLeft(true);
        }
        
        if(keyCode == KeyEvent.VK_D)
        {
            p.moveRight(true);  
        } 
        
        if(keyCode == KeyEvent.VK_W)
        {
            p.jump();
        }
    }
    
    /**
     * Stops player from constantly moving
     * @param keyCode 
     */
    @Override
    public void keyReleased(int keyCode) 
    {
        if(keyCode == KeyEvent.VK_A)
        {
            p.moveLeft(false);
        }
        
        if(keyCode == KeyEvent.VK_D)
        {
            p.moveRight(false);  
        }
    }
    
    /**
     * When user clicks playButton it will carry out a command
     * @param mouseClick 
     */
    @Override
    public void mouseClicked(Point mouseClick) 
    {
        /*
        if(playButton.clickedInside(mouseClick))
        {
            lm.goToState(0);
        }
        */
    }
    
    /**
     * Sets camera position to follow Player
     * Checks for collisions with Enemy 
     * Checks for collisions with Collectable
     */
    @Override
    public void update() 
    {  
        p.update();
        
        if(p.collidesWith(e))
        {
            System.out.println("Collided with Enemy");
            lm.goToState(3); // End the game to the about screen
        }
        
        e.update();
        
        c.update();
        
        if(p.collidesWith(c) && c.getVisible() == true)//If visible collectable is collided with them set it to false 
        {
            System.out.println("Collided with collectable");//Debug to show that the player is colliding with collectable
            c.setVisible(false);
        }
        
        tmm.setCameraPosition(LevelPanel.PANEL_WIDTH/2 - p.getX(), LevelPanel.PANEL_HEIGHT/2 - p.getY());
    }
    
    /**
     * This method draws the title of the menu 
     * The playButton is drawn and the user can click to go to the about screen
     * @param g 
     */
    @Override
    public void draw(Graphics2D g) 
    {
        g.setColor(Color.PINK);
        g.fillRect(0,0, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.BOLD, 30));
        g.drawString("Level 1", 200, 40);
        
        tmm.draw(g);
        
        //Draw a button
        //playButton.draw(g);
        
        //Draw player
        p.draw(g);
        
        //Draw enemy
        e.draw(g);
        
        //Draw Collectable
        c.draw(g);
        
    } 
}