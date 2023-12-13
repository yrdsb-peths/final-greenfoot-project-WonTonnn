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
    PinkieSplash choicePink = new PinkieSplash();
    BlueSplash choiceBlue = new BlueSplash();
    public boolean choice;
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addButton();

        
    }

    public void addButton()
    {
        addObject(button, 300, 200);
    }

    public void addChoice()
    {
        removeObject(button);
        addObject(choicePink, 450, 200);
        GreenfootImage pinkImg = choicePink.getImage();
        pinkImg.scale(250,250);
        
        addObject(choiceBlue, 150, 200);
        GreenfootImage blueImg = choiceBlue.getImage();
        blueImg.scale(250, 250);
    }
    
    public boolean getChoice(boolean x)
    {
        choice = x;
        return x;
    }
    
    public boolean setChoice()
    {
        return choice;
    }
}

