import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PinkHands here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PinkHands extends Actor
{
    /**
     * Act - do whatever the PinkHands wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public int health = 100;
    public int block = 100;
    public int attack = 20;
    public int mouse;
    GreenfootImage downSwing[] = new GreenfootImage[3];
    GreenfootImage sideSwing[] = new GreenfootImage[3];
    GreenfootImage blockSwing[] = new GreenfootImage[2];
    SimpleTimer swingTimer = new SimpleTimer();

    public PinkHands()
    {
        for(int i = 0; i < downSwing.length; i++)
        {
            downSwing[i] = new GreenfootImage("temp_bat/down_swing/down_" + i + ".png");

        }
        
        for(int s = 0; s < sideSwing.length; s++)
        {
            sideSwing[s] = new GreenfootImage("temp_bat/side_swing/side_" + s + ".png");
        }

        swingTimer.mark();
    }

    public void act()
    {
        mouse = (Greenfoot.getMouseInfo()).getButton();
        if(mouse == 1)
        {
            System.out.println("attack 1");

        }else if(mouse == 2)
        {
            System.out.println("Attack 2");
            
        }else if(mouse == 3)
        {
            System.out.println("Attack 3");
        }
    }

}
