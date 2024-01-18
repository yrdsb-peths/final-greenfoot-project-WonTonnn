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
    TitleCard titlecard = new TitleCard();
    Label tutorial = new Label(10, 10);
    TutorialButton tutorialbutt = new TutorialButton();

    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addButton();

    }
    public void addButton()
    {
        addObject(titlecard, 300, 200);
        addObject(button, 450, 180);
        
        //addObject(tutorialbutt, 540, 370);
    }

    public void addChoice()
    {
        removeObject(button);
        //removeObject(tutorialbutt);
        MyWorld gameWorld = new MyWorld();
        Greenfoot.setWorld(gameWorld);
    }

}

