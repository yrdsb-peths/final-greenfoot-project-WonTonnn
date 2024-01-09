import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    Bat bat = new Bat();
    Pink pink = new Pink();
    Blue blue = new Blue();
    public boolean choice;
    /*
     * choice = true : pink character
     * choice = false : blue character
     */
    GreenfootImage pinkImg;
    GreenfootImage blueImg;
    PinkieSplash choicePink = new PinkieSplash();
    BlueSplash choiceBlue = new BlueSplash();
    public int length = 100;
    public int width = 100;
    public boolean fighting = false;
    public boolean madeChoice = false;
    public int defaultSize = 70;
    SimpleTimer introTimer = new SimpleTimer();
    FightPlace fightWorld = new FightPlace();
    
    public int healthMax = 100;
    
    public int health = 100;
    Label healthBar;
    public int block = 100;
    Label blockBar;
    public int mana = 100;
    Label manaBar;
        
    EnemyOne enemy1 = new EnemyOne();

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        createBat();
        addChoice();     
        
        //Create health mana and block bars
        healthBar = new Label(0,50);
        manaBar = new Label(0, 50);
        blockBar = new Label(0, 50);
        
        addObject(healthBar, 50, 50);
        addObject(manaBar, 100, 50);
        addObject(blockBar, 150, 50);
        
        healthBar.setLineColor("#f71616"); 
        
    }
    
    public void act()
    {
        makeChoice();
    }
    
    public void addEnemies()
    {
        addObject(enemy1, 300, 300);
    }
    
    public void setChoice(boolean x)
    {
        choice = x;
        createChar();
    }

    public void addChoice()
    {
        addObject(choicePink, 450, 200);
        GreenfootImage pinkImg = choicePink.getImage();
        pinkImg.scale(250,250);
        addObject(choiceBlue, 150, 200);
        GreenfootImage blueImg = choiceBlue.getImage();
        blueImg.scale(250, 250);
    }
    
    public void makeChoice()
    {
        if(Greenfoot.mouseClicked(choicePink))
        {
            setChoice(true);
            createChar();
        }
        
        if(Greenfoot.mouseClicked(choiceBlue))
        {
            setChoice(false);
            createChar();
        }
    }

    public void createChar()
    {
        removeObject(choicePink);
        removeObject(choiceBlue);
        if(choice == true)
        {
            GreenfootImage pinkImg = pink.getImage();
            pinkImg.scale(70,70);
            addObject(pink, 20, 300);

        }else if(choice == false){

            GreenfootImage blueImg = blue.getImage();
            blueImg.scale(70,70);
            addObject(blue, 20, 300);
        }
        addEnemies();

    }

    public void createBat()
    {
        GreenfootImage batImg = bat.getImage();
        batImg.scale(1200,800);
        //addObject(bat, 0,0);

    }
    
    public void createFightWorld()
    {
        //System.out.println("hiiii");
        addObject(fightWorld, 300, 200);
        GreenfootImage fightImg = fightWorld.getImage();
        fightImg.scale(600,410);
        
    }
    
    public void addFightStuff()
    {
        
    }
}
