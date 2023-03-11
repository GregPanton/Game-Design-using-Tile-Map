package com.jamesgames.state;

import java.awt.Graphics2D;
import java.awt.Point;

public class LevelManager 
{
    private AbstractLevel[] gameStateList;// Polymorphism, can represent any Level
    private int currentState;
    
    // Declare static variables to represent our levels
    // We can call these from elsewhere in the program
    public static final int MENU_SCREEN = 0;
    public static final int LEVEL_1 = 1;
    public static final int LEVEL_2 = 2;
    public static final int VICTORY_SCREEN = 3;
    public static final int DEATH_SCREEN = 4;
    
    public LevelManager()
    {
        currentState = 0; // This will normally be set outside
        gameStateList = new AbstractLevel[5];
        
        // Add levels to level manager array
        Menu m = new Menu(this);
        AboutScreen a = new AboutScreen(this);
        Level1 L1 = new Level1(this);
        EndScreen End = new EndScreen(this);
        
        gameStateList[0] = m;
        gameStateList[1] = a;
        gameStateList[2] = L1;
        gameStateList[3] = End;
        currentState = 0;
        
        // Carry on adding levels as appropriate
    }
    
    public LevelManager(AbstractLevel[] levels)
    {
        
    }
           
    public void setCurrentState(int state)
    {
        this.currentState = state;      
    }
    
    public int getCurrentState()
    {
        return this.currentState;
    }
    
    public void update()
    {
        gameStateList[currentState].update();
    }
    
    public void goToState(int state)
    {
        this.currentState = state;
    }
    
    public void nextState()
    {
        this.currentState++;
        
        if(currentState == gameStateList.length)
            this.currentState = 0;
    }
    
    public void prevousState()
    {
        this.currentState--;
        
        if(currentState < 0)
            this.currentState = gameStateList.length - 1;
    }
    
    /**
     * This method calls the draw method on the current level
     * @param g 
     */
    public void draw(Graphics2D g)
    {
        gameStateList[currentState].draw(g);
    }
    
    /**
     * This method calls the key pressed method of the current level passing on the 
     * key code
     * @param keyCode 
     */
    public void keyPressed(int keyCode)
    {
        gameStateList[currentState].keyPressed(keyCode);
    }
    
    /**
     * This method calls the key released method of the current level passing on the
     * key code
     * @param keyCode 
     */
    public void keyReleased(int keyCode)
    {
        gameStateList[currentState].keyReleased(keyCode);
    }
    
    public void clicked(Point p)
    {
        gameStateList[currentState].mouseClicked(p);  
    }
    
}
