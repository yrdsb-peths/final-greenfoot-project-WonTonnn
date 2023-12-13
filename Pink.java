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
    
    public void pink()
    {
        //Idle animation loop
        for(int i = 0; i < pinkIdle.length; i++)
        {
            pinkIdle[i] = new GreenfootImage("temp_char/pink_idle/" + i + ".png");
        }
        
        // right animation loo
        for(int r = 0; r < pinkRight.length; r++)
        {
            pinkRight[r] = new GreenfootImage("temp_char/pink_right/" + r + ".png");
        }
        
        
        //Left animatino Loop
        
        for(int l = 0; l < pinkLeft.length; l++)
        {
            pinkLeft[l] = new GreenfootImage("temp_char/pink_left/" + l + ".png");
        }
        
        timer.mark();
        
        setImage(pinkIdle[0]);
        MyWorld world = (MyWorld) getWorld();
    
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
        imageIndex = (imageIndex + 1) % pinkRight.length;
        setImage(pinkRight[imageIndex]);
    }
    
    public void animateLeft()
    {
        if(timer.millisElapsed() < 100)
        {
            return;
        }
        timer.mark();
        imageIndex = (imageIndex + 1) % pinkLeft.length;
        setImage(pinkLeft[imageIndex]);
    }
    
    public void act()
    {
        
        if(stop == false)
        {
            if(!Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
            {
                //animateIdle();
            }
            
            if(Greenfoot.isKeyDown("a"))
            {
                //animateLeft();
            }
            
            if(Greenfoot.isKeyDown("d"))
            {
                //animateRight();
            }
        }
        
    }
}
