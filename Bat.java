import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bat extends Actor
{
    /**
     * Act - do whatever the Bat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    GreenfootImage[] down_swing = new GreenfootImage[3];
    GreenfootImage[] side_swing = new GreenfootImage[3];
    GreenfootImage[] bat_idle = new GreenfootImage[5];

    public void act()
    {
        MyWorld myWorld = (MyWorld) getWorld();
        if(myWorld.fighting == true)
        {
            if(Greenfoot.mouseClicked(myWorld))
            {
                System.out.println("attack :D");
            }
        }

    }

    public Bat()
    {
        //swing down animation
        for(int i = 0; i < down_swing.length; i++)
        {
            down_swing[i] = new GreenfootImage("temp_bat/down_swing/down_" + i + ".jpg");
            
        }

    }

    public void animateDownSwing()
    {

    }

    public void animateSideSwing()
    {

    }

    public void animateIdleBat()
    {

    }
}
