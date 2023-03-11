
package com.jamesgames.ui;

import com.jamesgames.entity.Sprite;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author James
 */
public class UIControl 
{
    private double x;
    private double y;
    private int width;
    private int height;
    private Sprite s;
    
    public UIControl()
    {
        
        
    }
    
    public UIControl(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    
    public UIControl(double x, double y, Sprite s)
    {
        this.x = x;
        this.y = y;
        this.s = s;
    }
    
    public boolean clickedInside(Point p)
    {
        int width = s.getSprite().getWidth();
        int height = s.getSprite().getHeight();
        Rectangle r = new Rectangle((int)x, (int)y, width, height);
         
        return r.contains(p) == true;
    }
    
    public void draw(Graphics2D g)
    {
         g.drawImage(getSprite().getSprite(), (int)x, (int)y, null);
    }
    
    public void interact()
    {
         
    }  
    
    public void setSprite(Sprite s)
    {
        this.s = s;
    }
    
    public Sprite getSprite()
    {
        return s;
    }
        
}
