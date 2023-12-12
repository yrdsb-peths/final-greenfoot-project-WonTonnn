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
    public boolean blueChoice = false;
    public boolean pinkChoice = false; 
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addButton();

        
    }

    public void addButton()
    {
        addObject(button, 200, 300);
    }

    public void addChoice()
    {
        removeObject(button);
        addObject(choicePink, 300, 200);
        GreenfootImage pinkImg = choicePink.getImage();
        pinkImg.scale(200,200);
        
        addObject(choiceBlue, 100, 300);
        GreenfootImage blueImg = choiceBlue.getImage();
        blueImg.scale(200, 200);

        if(Greenfoot.mouseClicked(choicePink))
        {
            pinkChoice = true;
        }

        if(Greenfoot.mouseClicked(choiceBlue))
        {
            blueChoice = true;
        }
    }
}

