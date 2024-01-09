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
    
    public int buttonHeight = 50;
    public int buttonWidth = 200;
    
    public boolean fighting = false;
    public boolean madeChoice = false;
    public int defaultSize = 70;
    SimpleTimer introTimer = new SimpleTimer();
    FightPlace fightWorld = new FightPlace();

    SimpleTimer turnTimer = new SimpleTimer();

    AttackButton attackButton = new AttackButton();
    BlockButton blockButton = new BlockButton();
    SkillButton skillButton = new SkillButton();

    //Create all bar related stuff
    public int healthMax = 100;

    public int health = 100;
    Label healthBar;
    Color healthColor = new Color(247, 22, 22);
    public int block = 100;
    Label blockBar;
    Color blockColor = new Color(36, 181, 77);
    public int mana = 100;
    Label manaBar;
    Color manaColor = new Color(22, 168, 247);

    public int turnDecision = 0;
    /*
     * 1 = attack
     * 2 = skill
     * 3 = block
     * 4 = ultimate
     * 0 = nothing
     */
    
    public boolean myTurn;

    EnemyOne enemy1 = new EnemyOne();

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        createBat();
        addChoice();     
        createBars();

    }

    public void createBars()
    {
        //Create health mana and block bars
        healthBar = new Label(0,50);
        manaBar = new Label(0, 50);
        blockBar = new Label(0, 50);

        addObject(healthBar, 50, 50);
        addObject(manaBar, 120, 50);
        addObject(blockBar, 190, 50);

        healthBar.setLineColor(healthColor); 
        manaBar.setLineColor(manaColor);
        blockBar.setLineColor(blockColor);
    }

    public void act()
    {
        makeChoice();
        updateBars();

        if(fighting = true)
        {
            fight();
            checkWinLose();
        }
    }
    
    public void fight()
    {
        if(myTurn = true)
        {
            if(Greenfoot.mouseClicked(attackButton))
            {
                turnDecision = 1;
            }
            
            if(Greenfoot.mouseClicked(blockButton))
            {
                turnDecision = 3;
            }
            
            if(Greenfoot.mouseClicked(skillButton))
            {
                turnDecision = 2;
                removeObject(blockButton);
                removeObject(attackButton);
                removeObject(skillButton);
                
            }
        }
        System.out.println(turnDecision);
            
    }
    
    public void checkWinLose()
    {
        //if health bar of either side 0, win or lose screen :>
    }

    public void updateBars()
    {
        healthBar.setValue(health);
        manaBar.setValue(mana);
        blockBar.setValue(block);
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
        addObject(fightWorld, 300, 200);
        GreenfootImage fightImg = fightWorld.getImage();
        fightImg.scale(600,410);
        addFightStuff();
        
    }

    public void addFightStuff()
    {
        addObject(attackButton, 300, 280);
        addObject(blockButton, 300,330);
        addObject(skillButton, 300, 380);
        
        GreenfootImage atkImage = attackButton.getImage();
        GreenfootImage blkImage = blockButton.getImage();
        GreenfootImage sklImage = skillButton.getImage();
        
        atkImage.scale(buttonWidth, buttonHeight);
        blkImage.scale(buttonWidth, buttonHeight);
        sklImage.scale(buttonWidth, buttonHeight);
        fighting = true;
    }
}
