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
    public int length = 100;
    public int width = 100;
    public boolean fighting = false;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        createBat();
        createChar();
    }
    
    public void checkChoice()
    {
        TitleScreen title = new TitleScreen();
        choice = title.setChoice();
        System.out.println(choice);
    }
    
    public void createChar()
    {
        checkChoice();
        if(choice == true)
        {
            GreenfootImage pinkImg = pink.getImage();
            pinkImg.scale(100,100);
            addObject(pink, 300, 200);
            
        }else if(choice == false){
            
            GreenfootImage blueImg = blue.getImage();
            blueImg.scale(100,100);
            addObject(blue, 300, 200);
        }
        
    }
    
    public void createBat()
    {
        GreenfootImage batImg = bat.getImage();
        batImg.scale(1200,800);
        //addObject(bat, 0,0);
        
    }
}
