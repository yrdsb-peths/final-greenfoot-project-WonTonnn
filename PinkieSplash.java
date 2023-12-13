import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PinkieSplash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PinkieSplash extends Actor
{
    /**
     * Act - do whatever the PinkieSplash wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld gameWorld = new MyWorld();
        TitleScreen title = (TitleScreen) getWorld();
        if(Greenfoot.mouseClicked(this))
        {
            //title.choice = true;
            title.choiceCheck();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
