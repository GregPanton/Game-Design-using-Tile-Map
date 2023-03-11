package com.jamesgames.entity;

import com.jamesgames.tilemap.TileMapManager;
import java.awt.Graphics2D;

/**
 *
 * @author greg
 */
public class Collectable extends GameObject
{
   private boolean isVisible;
   
   public Collectable()
    {
       super();
        
        x = 250;
        y = 361; 
    }
    
    /**
     * Passing TileMapManager
     * @param tmm 
     */
    public Collectable(TileMapManager tmm)
    {
        super(tmm);
        
        x = 920;
        y = 100;
        
        isVisible = true;
    }
    
    /**
     * Checks for collision 
     */
    @Override
    public void update()
    {
       checkTileMapCollision(x,y);
    }
    
    public void move()
    {
       
    }
    
    @Override
    public void draw(Graphics2D g)
    {
        if(isVisible == true)
        {
            super.draw(g);
        }
    }  
    
    public boolean getVisible()
    {
        return isVisible;
    }
    
    public void setVisible(boolean visible)
    {
        this.isVisible = visible;
    }
}
