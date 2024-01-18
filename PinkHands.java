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
    SimpleTimer swingTimer = new SimpleTimer();

    GreenfootImage pinkAttack = new GreenfootImage("images/temp_bat/pink_attack/1.PNG");
    GreenfootImage pinkBlock[] = new GreenfootImage[23];
    GreenfootImage pinkSkill[] = new GreenfootImage[17];
    GreenfootImage pinkUltimate[] = new GreenfootImage[3];
    GreenfootImage transparent = new GreenfootImage("images/temp_bat/transparent.PNG");
    
    GreenfootSound attackSound = new GreenfootSound("mainAttack.mp3");
    GreenfootSound blockSound = new GreenfootSound("block.mp3");

    SimpleTimer fightTimer = new SimpleTimer();
    public int animateCount = 0;
    int atkx = 400;
    int atky = 300;
    
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
        if(world.myTurn == true)
        {
            setLocation(0,0);
            if(world.turnDecision == 1)
            {
                setLocation(100,450);
                animateAttack();
                world.enemyAttack();
               
            }else if(world.turnDecision == 2)
            {
                setLocation(300,300);
                animateSkill();
                world.enemyAttack();
            }else if(world.turnDecision == 3)
            {
                setLocation(300,300);
                animateBlock();
                world.enemyAttack();
            }else if(world.turnDecision == 4)
            {
                animateUltimate();
                world.enemyAttack();
            }
        }
        
        if(world.myTurn == false)
        {
            setLocation(300, 1000);
        }
    }

    public void animateAttack()
    {
        MyWorld world = (MyWorld) getWorld();
        setImage(pinkAttack);
        for(int i = 0; i < 6; i++)
        {
            this.setLocation(atkx, atky);
            Greenfoot.delay(5);
            animateCount++;
            if(i == (5))
            {
                attackSound.play();
            }
            atkx = atkx - 50;
            atky = atky - 20;
        }
        
        world.myTurn = false;
        world.turnDecision = 0;
        

    }
    
    public void animateBlock()
    {
        MyWorld world = (MyWorld) getWorld();
        for(int i = 0; i < pinkBlock.length; i++)
        {
            pinkBlock[i] = new GreenfootImage("images/temp_bat/pink_block/" + i + ".PNG");
            //pinkBlock[i].scale(50,50);
            setImage(pinkBlock[i]);
            Greenfoot.delay(5);
            animateCount++;
            if(i == (pinkBlock.length - 1))
            {
                blockSound.play();
            }
        }
        world.myTurn = false;
        world.turnDecision = 0;
       
    }
    
    public void animateSkill()
    {
        MyWorld world = (MyWorld) getWorld();
        for(int i = 0; i < pinkSkill.length; i++)
        {
            pinkSkill[i] = new GreenfootImage("images/temp_bat/pink_skill/" + i + ".PNG");
            
            setImage(pinkSkill[i]);
            Greenfoot.delay(5);
            animateCount++;
        }
        setLocation(getX(), getY() + 20);
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
