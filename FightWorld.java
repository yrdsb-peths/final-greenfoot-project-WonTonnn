import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FightWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FightWorld extends World
{

    /**
     * Constructor for objects of class FightWorld.
     * 
     */
    MyWorld myWorld;
    
    public FightWorld(MyWorld myWorld)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.myWorld = myWorld;
        
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(null))
        {
            Greenfoot.setWorld(myWorld);
        }
    }
}
