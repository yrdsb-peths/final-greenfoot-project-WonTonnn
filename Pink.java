import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pink here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pink extends Actor
{
    /**
     * Act - do whatever the Pink wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean stop = false; 
    public boolean left;
    GreenfootImage pinkIdle[] = new GreenfootImage[3];
    GreenfootImage pinkRight[] = new GreenfootImage[5];
    GreenfootImage pinkLeft[] = new GreenfootImage[5];
    SimpleTimer timer = new SimpleTimer();
    MyWorld world = (MyWorld) getWorld();
    public int health = 100;
    public int block = 100; 
    

    public Pink()
    {

        //Idle animation loop
        for(int i = 0; i < pinkIdle.length; i++)
        {
            pinkIdle[i] = new GreenfootImage("temp_char/pink_idle/idle" + i + ".png");
            pinkIdle[i].scale(70, 70);
        }

        // right animation loo
        for(int r = 0; r < pinkRight.length; r++)
        {
            pinkRight[r] = new GreenfootImage("temp_char/pink_right/" + r + ".png");
            pinkRight[r].scale(70, 70);
        }

        //Left animatino Loop

        for(int l = 0; l < pinkLeft.length; l++)
        {
            pinkLeft[l] = new GreenfootImage("temp_char/pink_left/" + l + ".png");
            pinkLeft[l].scale(70, 70);
        }

        timer.mark();

        setImage(pinkIdle[0]);

    }

    int imageIndex = 0;
    public void animateIdle()
    {
        if(timer.millisElapsed() < 100)
        {
            return;
        }
        timer.mark();
        imageIndex = (imageIndex + 1) % pinkIdle.length;
        setImage(pinkIdle[imageIndex]);
    }

    public void animateRight()
    {
        if(timer.millisElapsed() < 100)
        {
            return;
        }
        timer.mark();
        setImage(pinkRight[imageIndex]);
        imageIndex = (imageIndex + 1) % pinkRight.length;
    }

    public void animateLeft()
    {
        if(timer.millisElapsed() < 100)
        {
            return;
        }
        timer.mark();
        setImage(pinkLeft[imageIndex]);
        imageIndex = (imageIndex + 1) % pinkLeft.length;
    }

    public void act()
    {

        if(stop != true)
        {
            if(!Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
            {
                animateIdle();
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
            Greenfoot.delay(50);
            Greenfoot.setWorld(world.fightWorld);
        }

    }
}
