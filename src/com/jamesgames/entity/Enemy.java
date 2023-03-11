package com.jamesgames.entity;

import com.jamesgames.tilemap.TileMapManager;
import java.awt.Graphics2D;
import java.util.Random;

/**
 *
 * @author greg
 */
public class Enemy extends GameObject
{
    private double GRAVITY = 0.25;
    private int direction = 0;
    Random rand = new Random();
    
    public Enemy()
    {
       super();
        
        x = 250;
        y = 361; 
    }
    
    /**
     * Passing TileMapManager
     * @param tmm 
     */
    public Enemy(TileMapManager tmm)
    {
        super(tmm);
        
        x = 90;
        y = 100;
    }
    
    /**
     * Checks for collision and initiates gravity
     */
    @Override
    public void update()
    {
       move(rand.nextInt(6));
       checkTileMapCollision(x,y);
    }
    
    public void move(int randNumber)
    {
        /*
            If we are falling, check to see if we are also jumping
            If we are jumping - add the jump factor to DY
            otherwise set DY to the value of Gravity
        */
        if(FALLING)
        {
            //If the character is in the air - reduce upward speed
            //JUMPING Mechanism
            
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
           dy =-12;
           FALLING = true;
        }
        
        // Sets random number between 1 and 2 to control the direction in which is moves
        // 1 is set to move the enemy left and 2 is set to move the enemy right
        // When the character is not moving left or right it is set to 0 it is set to jump when not moving.
        direction = rand.nextInt(3);
        
        // Sets the amount of times it changes direction
        randNumber = rand.nextInt(6);
        
        if(randNumber == 3)
        {
            if(direction == 0)
            {
                jump();
            }
            else if(direction == 1)
            {
                dx = 5;
            }
            else if(direction == 2)
            {
                dx = -5;
            }
        }
    }
    
    public void jump()
    {
        JUMP = true;
    }
    
    @Override
    public void draw(Graphics2D g)
    {
        super.draw(g);
    }
}
