package com.jamesgames.entity;

import com.jamesgames.tilemap.TileMapManager;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.HashMap;

/**
 *
 * @author greg
 */
public class Player extends GameObject
{   
    private int speed = 5;
    private final double GRAVITY = 0.15;
    private HashMap<String, Sprite> animatedSprite = new HashMap();
    
    
    public Player()
    {
        super();
        
        x = 82;
        y = 361;
    }
    
    /**
     * Passing TileMapManager
     * @param tmm 
     */
    public Player(TileMapManager tmm)
    {
        super(tmm);
        
        x = 200;
        y = 250;
        
        FALLING = false;
    }
    
    public void setAnimation(String direction, Sprite s)
    {
        animatedSprite.put(direction, s);
        
        if(direction.equals("STATIC"))
        {
            sprite = s;
            cHeight = sprite.getHeight();
            cWidth = sprite.getWidth();
        }
    }
    
    /**
     * Checks for collision and calls move to initiate gravity and jumping
     */
    @Override
    public void update()
    {
        move();
        checkTileMapCollision(x,y);
        
        //x += dx;
        //y += dy;
    }
    
    /**
     * Deal with all character movement
     */
    public void move()
    {
        /*
            If we are falling, check to see if we are also jumping
            If we are jumping - add the jump factor to DY
            otherwise set DY to the value of Gravity
        */
        if(FALLING)
        {
            //If the character is in the air - reduce upward speed
            // JUMPING Mechanism
            
            if(dy <0 && (JUMP == false)) 
            {
                dy += 0.5;
            }
            else
            {
                dy += GRAVITY;
            }
            
            if(dy > 0)
            {
                JUMP = false;
            }         
        }
        
        if(JUMP && (FALLING == false))
        {
           dy =-7;
           FALLING = true;
        }
    }
    
    @Override
    public void draw(Graphics2D g)
    {
        if(MOVE_RIGHT)
        {
            sprite = animatedSprite.get("RIGHT");
        }
        else if(MOVE_LEFT)
        {
            sprite = animatedSprite.get("LEFT");
        }
        else if(STANDING)
        {
            sprite = animatedSprite.get("STATIC");
        }
        else
        {
            sprite = animatedSprite.get("STATIC");
        }
        
        super.draw(g); 
    }
    
    /**
     * Moves player Left
     * @param move 
     */
    public void moveLeft(boolean move)
    {
        if(move)
        {
            MOVE_LEFT = true;
            STANDING = false;
            
            dx = -speed;
        }
        else
        {
            MOVE_LEFT = false;
            STANDING = true;
            
            dx = 0;
        }
    }
    
    /**
     * Moves player Right
     * @param move 
     */
    public void moveRight(boolean move)
    {
        if(move)
        {
            MOVE_RIGHT = true;
            STANDING = false;
            
            dx = speed;
        }
        else
        {
            MOVE_RIGHT = false;
            STANDING = true;
            
            dx = 0;
        }
    }
    
    /**
     * Moves player Up
     * @param move 
     */
    public void moveUp(boolean move)
    {
        if(move)
        {
            dy = -speed;
        }
        else
        {
            dy = 0;
        }
    }
    
    public void jump()
    {
        JUMP = true;
    }
    
    /**
     * Moves player Down
     * @param move 
     */
    public void moveDown(boolean move)
    {
        if(move)
        {
            dy = speed;
        }
        else
        {
            dy = 0;
        }
    }
}