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
    
    /*
     * 1 = attack
     * 2 = skill
     * 3 = block
     * 4 = ultimate
     * 0 = nothing
     */


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
                world.enemyAttack();
               
            }else if(world.turnDecision == 2)
            {
                animateSkill();
                world.enemyAttack();
            }else if(world.turnDecision == 3)
            {
                animateBlock();
                world.enemyAttack();
            }else if(world.turnDecision == 4)
            {
                animateUltimate();
                world.enemyAttack();
            }
        } 
    }

    public void animateAttack()
    {
        MyWorld world = (MyWorld) getWorld();
        for(int i = 0; i < pinkAttack.length; i++)
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
    
    public void animateBlock()
    {
        MyWorld world = (MyWorld) getWorld();
        for(int i = 0; i < pinkBlock.length; i++)
        {
            pinkBlock[i] = new GreenfootImage("temp_char/pink_idle/idle" + i + ".PNG");
            pinkBlock[i].scale(50,50);
            setImage(pinkBlock[i]);
            Greenfoot.delay(10);
            animateCount++;
        }
        world.myTurn = false;
        world.turnDecision = 0;
       
    }
    
    public void animateSkill()
    {
        MyWorld world = (MyWorld) getWorld();
        for(int i = 0; i < pinkSkill.length; i++)
        {
            pinkSkill[i] = new GreenfootImage("images/temp_bat/side_swing/swing_" + i + ".jpg");
            pinkSkill[i].scale(50,50);
            setImage(pinkSkill[i]);
            Greenfoot.delay(10);
            animateCount++;
        }
        world.myTurn = false;
        world.turnDecision = 0;
        
    }
    
    public void animateUltimate()
    {
        MyWorld world = (MyWorld) getWorld();
        for(int i = 0; i < pinkUltimate.length; i++)
        {
            pinkUltimate[i] = new GreenfootImage("images/temp_bat/side_swing/swing_" + i + ".jpg");
            pinkUltimate[i].scale(50,50);
            setImage(pinkUltimate[i]);
            Greenfoot.delay(10);
            animateCount++;
        }
        world.myTurn = false;
        world.turnDecision = 0;
        
    }

}
