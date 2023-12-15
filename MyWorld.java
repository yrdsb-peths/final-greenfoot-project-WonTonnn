import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    Bat bat = new Bat();
    Pink pink = new Pink();
    Blue blue = new Blue();
    public boolean choice;
    /*
     * choice = true : pink character
     * choice = false : blue character
     */
    GreenfootImage pinkImg;
    GreenfootImage blueImg;
    PinkieSplash choicePink = new PinkieSplash();
    BlueSplash choiceBlue = new BlueSplash();
    public int length = 100;
    public int width = 100;
    public boolean fighting = false;
    public boolean madeChoice = false;
    public int defaultSize = 70;

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        createBat();
        addChoice();        
    }
    
    public void act()
    {
        makeChoice();
    }
    
    public void setChoice(boolean x)
    {
        choice = x;
        createChar();
    }

    public void addChoice()
    {
        addObject(choicePink, 450, 200);
        GreenfootImage pinkImg = choicePink.getImage();
        pinkImg.scale(250,250);
        addObject(choiceBlue, 150, 200);
        GreenfootImage blueImg = choiceBlue.getImage();
        blueImg.scale(250, 250);
    }
    
    public void makeChoice()
    {
        if(Greenfoot.mouseClicked(choicePink))
        {
            setChoice(true);
            createChar();
        }
        
        if(Greenfoot.mouseClicked(choiceBlue))
        {
            setChoice(false);
            createChar();
        }
    }

    public void createChar()
    {
        removeObject(choicePink);
        removeObject(choiceBlue);
        if(choice == true)
        {
            GreenfootImage pinkImg = pink.getImage();
            pinkImg.scale(70,70);
            addObject(pink, 20, 300);

        }else if(choice == false){

            GreenfootImage blueImg = blue.getImage();
            blueImg.scale(70,70);
            addObject(blue, 20, 300);
        }

    }

    public void createBat()
    {
        GreenfootImage batImg = bat.getImage();
        batImg.scale(1200,800);
        //addObject(bat, 0,0);

    }
}
