import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    StartButton button = new StartButton();
    public static boolean askChoice;
    public static boolean choice;
    TitleCard titleCard = new TitleCard();
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addButton();

    }
    public void addButton()
    {
        addObject(button, 300, 350);
        //addObject(titleCard, 300, 200);
    }

    public void addChoice()
    {
        removeObject(button);
        MyWorld gameWorld = new MyWorld();
        Greenfoot.setWorld(gameWorld);
    }

}

