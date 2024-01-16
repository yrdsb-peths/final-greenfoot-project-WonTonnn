import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Blue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blue extends Actor
{
    public boolean stop = false; 
    public boolean left;
    GreenfootImage blueIdle[] = new GreenfootImage[6];
    GreenfootImage blueRight[] = new GreenfootImage[6];
    GreenfootImage blueLeft[] = new GreenfootImage[6];
    SimpleTimer timer = new SimpleTimer();
    MyWorld world = (MyWorld) getWorld();
    public int health = 100;
    public int block = 100; 
    FightPlace fightWorld = new FightPlace();
    

    public Blue()
    {

        //Idle animation loop
        for(int i = 0; i < blueIdle.length; i++)
        {
            blueIdle[i] = new GreenfootImage("temp_char/blue_idle/idle" + i + ".png");
            blueIdle[i].scale(120, 100);
        }

        // right animation loo
        for(int r = 0; r < blueRight.length; r++)
        {
            blueRight[r] = new GreenfootImage("temp_char/blue_right/" + r + ".png");
            blueRight[r].scale(110, 80);
        }

        //Left animatino Loop

        for(int l = 0; l < blueLeft.length; l++)
        {
            blueLeft[l] = new GreenfootImage("temp_char/blue_left/" + l + ".png");
            blueLeft[l].scale(110, 80);
        }

        timer.mark();

        setImage(blueIdle[0]);

    }

    int imageIndex = 0;
    public void animateIdle()
    {
        if(timer.millisElapsed() < 200)
        {
            return;
        }
        timer.mark();
        imageIndex = (imageIndex + 1) % blueIdle.length;
        setImage(blueIdle[imageIndex]);
    }

    public void animateRight()
    {
        if(timer.millisElapsed() < 100)
        {
            return;
        }
        timer.mark();
        setImage(blueRight[imageIndex]);
        imageIndex = (imageIndex + 1) % blueRight.length;
    }

    public void animateLeft()
    {
        if(timer.millisElapsed() < 100)
        {
            return;
        }
        timer.mark();
        setImage(blueLeft[imageIndex]);
        imageIndex = (imageIndex + 1) % blueLeft.length;
    }

    public void act()
    {

        if(stop != true)
        {
            if(!Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
            {
                int random = Greenfoot.getRandomNumber(10);
                if(random == 9)
                {
                    animateIdle();
                    random = Greenfoot.getRandomNumber(10);
                }
                
                
            }

            if(Greenfoot.isKeyDown("a"))
            {
                setLocation(getX() - 2, getY());
                animateLeft();
            }

            if(Greenfoot.isKeyDown("d"))
            {
                setLocation(getX() + 2, getY());
                animateRight();
            }
        }
        
        if(isTouching(EnemyOne.class))
        {
            MyWorld world = (MyWorld) getWorld();
            world.createFightWorld();
            stop = true;
            setLocation(getX() - 5, getY());

        }

    }
}
