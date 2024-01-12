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

    GreenfootImage pinkAttack[] = new GreenfootImage[3];
    GreenfootImage pinkBlock[] = new GreenfootImage[3];
    GreenfootImage pinkSkill[] = new GreenfootImage[3];
    GreenfootImage pinkUltimate[] = new GreenfootImage[3];

    SimpleTimer fightTimer = new SimpleTimer();
    public int animateCount = 0;

    public PinkHands()
    {
        
    }

    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        if(world.myTurn = true)
        {
            if(world.turnDecision == 1)
            {
                animateAttack();
            }
        } 
    }

    public void animateAttack()
    {
        MyWorld world = (MyWorld) getWorld();
        for(int i = 0; i <= pinkAttack.length; i++)
        {
            pinkAttack[i] = new GreenfootImage("images/temp_bat/side_swing/swing_" + i + ".jpg");
            pinkAttack[i].scale(50,50);
            setImage(pinkAttack[i]);
            Greenfoot.delay(10);
            animateCount++;
        }
        world.myTurn = false;
        world.turnDecision = 0;

    }

}
