package com.jamesgames.sprite;

import com.jamesgames.entity.Sprite;
import java.util.HashMap;

/**
 *  A cache is a store for resources so they can be accessed quickly
 * This cache uses a hashmap to store images - each image is referenced by
 * a tag.  The class will return the image associated with a given tag.
 * 
 * The advantages here is that each image will be stored exactly once.  
 * @author James
 */

public class SpriteCache
{
    private HashMap<String, Sprite> imageCache;
    
    public SpriteCache()
    {
        imageCache = new HashMap(); 
    }
    
    public void addSprite(String tag, Sprite img)
    {
        imageCache.put(tag, img);
    }
    
    public void removeSprite(String tag)
    {
        imageCache.remove(tag);
    }
    
    public Sprite getSprite(String tag)
    {
        return imageCache.get(tag);
    }        
    
    public void clearCache()
    {
        imageCache.clear();
        imageCache = null;
    }
    
}
