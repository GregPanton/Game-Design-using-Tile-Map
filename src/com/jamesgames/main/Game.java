 /**
 * This class manages the game window and level panel.
 */
package com.jamesgames.main;

import javax.swing.JFrame;

/**
 * @author James
 */
public class Game
{ 
    public static final int WINDOW_WIDTH = 800; // Make this public so that other parts of the game can access
    public static final int WINDOW_HEIGHT = 600; // Make this public so that other parts of the game can access
    private static final String TITLE = "Meh Game";
    
    private JFrame mainWindow;
    private LevelPanel lp;
    
    public Game()
    {       
        initGame();
        initComponents();
        initWindow();  
    }
    
    /**
     * Initialise the game related objects
     */
    private void initGame()
    {       
        lp = new LevelPanel();
        mainWindow = new JFrame();
    }
    
    /**
     * Initialise any other GUI components such as buttons or menus
     */
    private void initComponents()
    {  
        mainWindow.add(lp);
    }
    
    private void initWindow()
    {
        mainWindow.setTitle(Game.TITLE);
        mainWindow.setSize(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setResizable(false);
        mainWindow.setVisible(true);
    }
    
    public void start()
    {
        lp.startGame();
    }
    
    public static void main(String[] args) 
    {
        Game g = new Game();
        
        
        //Game Asset Abstraction
        // 
        //Create Level Objects
        //Create Tile Map Objects (or do this with the level
        //Assign Tile Map to the Level
        //Create Character Objects
        
        
        g.start();
    }
}