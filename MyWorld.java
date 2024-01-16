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
    PinkHands pinkHand = new PinkHands();
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
    SimpleTimer fightTimer = new SimpleTimer();
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

    public int enemOneHealth = 500; 
    Label enemyOneHealthBar;
    Color enemyHealthColor = new Color(111, 31, 120);
    
    
    public int turnDecision = 0;
    /*
     * 1 = attack
     * 2 = skill
     * 3 = block
     * 4 = ultimate
     * 0 = nothing
     */

    public boolean myTurn = false;
    public boolean win;
    int animateCount = 0;

    EnemyOne enemy1 = new EnemyOne();
    EnemyTwo enemy2 = new EnemyTwo();

    //Player attack animations:
    GreenfootImage pinkAttack[] = new GreenfootImage[3];
    GreenfootImage pinkBlock[] = new GreenfootImage[3];
    GreenfootImage pinkSkill[] = new GreenfootImage[3];
    GreenfootImage pinkUltimate[] = new GreenfootImage[3];
    
    GreenfootSound main = new GreenfootSound("homeForFlowers.mp3");
    GreenfootSound battle = new GreenfootSound("tussleAmongTrees.mp3");
    GreenfootSound loseSound = new GreenfootSound("okToTryAgain.mp3");
    GreenfootSound winSound = new GreenfootSound("howdWeDo.mp3");

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
        //blockBar = new Label(0, 50);

        addObject(healthBar, 50, 50);
        addObject(manaBar, 120, 50);
        //addObject(blockBar, 190, 50);

        healthBar.setLineColor(healthColor); 
        manaBar.setLineColor(manaColor);
        //blockBar.setLineColor(blockColor);
    }
    
    public void createEnemyBars()
    {
        enemyOneHealthBar = new Label(0,50);
        addObject(enemyOneHealthBar, 500,50);
        enemyOneHealthBar.setLineColor(enemyHealthColor);
    }

    public void act()
    {
        playMusic();
        makeChoice();
        updateBars();
        fight();
    }
    
    public void playMusic()
    {
        if(fighting = false)
        {
            main.playLoop();
        }else{
            battle.playLoop();
        }
    }

    public void fight()
    {
        if(fighting = true)
        {

            if(myTurn = true)
            {

                if(Greenfoot.mouseClicked(attackButton))
                {
                    removeObject(blockButton);
                    removeObject(attackButton);
                    removeObject(skillButton);
                    System.out.println(turnDecision);
                    turnDecision = 1;
                    System.out.println(turnDecision);
                    enemOneHealth = enemOneHealth - 12;

                    //animateAttack();

                    //Attack animation and decrease enemy health
                }

                if(Greenfoot.mouseClicked(blockButton))
                {
                    mana = mana - 15;
                    removeObject(blockButton);
                    removeObject(attackButton);
                    removeObject(skillButton);
                    turnDecision = 3;

                    //Block image on until my turn true again
                }

                if(Greenfoot.mouseClicked(skillButton))
                {
                    mana = mana - 25;
                    removeObject(blockButton);
                    removeObject(attackButton);
                    removeObject(skillButton);
                    enemOneHealth = enemOneHealth - 40;
                    turnDecision = 2;

                    //add skill image and ultimate
                    //choose between skill and ultimate in if statement = 2 or 4

                }
            }

            if(myTurn = false)
            {
                enemyAttack();
                checkWinLose();
            }
        }

    }

    public void enemyAttack()
    {
        int enemAtk = Greenfoot.getRandomNumber(2);
        System.out.println("enemy attackin");
        updateBars();
        updateEnemyBar();
        Greenfoot.delay(100);
        if(enemAtk == 1)
        {
            health = health - 10;
            System.out.println("enemy attackin 1");
        }else if(enemAtk == 2)
        {
            health = health - 13;
            System.out.println("enemy attackin 2");
        }else if(enemAtk == 0)
        {
            health = health - 14;
            System.out.println("enemy attackin 3");
        }
        checkWinLose();

    }

    public void checkWinLose()
    {

        if(health <= 0)
        {
            System.out.println("dead u woe");
        } else if(enemOneHealth == 0)
        {
            System.out.println("Enemy dead");
        } else {
            addFightStuff();
            myTurn = true;
        }  

    }
    public void updateBars()
    {
        healthBar.setValue(health);
        manaBar.setValue(mana);
        //blockBar.setValue(block);
    }
    
    public void updateEnemyBar()
    {
        enemyOneHealthBar.setValue(enemOneHealth);
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
            pinkImg.scale(120,100);
            addObject(pink, 20, 290);

        }else if(choice == false){

            GreenfootImage blueImg = blue.getImage();
            blueImg.scale(60,70);
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
        createEnemyBars();
        addFightStuff();

    }

    public void addFightStuff()
    {
        addObject(attackButton, 300,290);
        addObject(blockButton, 300,335);
        addObject(skillButton, 300,380);
        removeObject(healthBar);
        removeObject(manaBar);
        //removeObject(blockBar);
        addObject(healthBar, 50, 50);
        addObject(manaBar, 120, 50);
        //addObject(blockBar, 190, 50);
        
        updateEnemyBar();

        GreenfootImage atkImage = attackButton.getImage();
        GreenfootImage blkImage = blockButton.getImage();
        GreenfootImage sklImage = skillButton.getImage();

        addObject(pinkHand, 100, 100);
        GreenfootImage pinkHandImg = pinkHand.getImage();
        pinkHandImg.scale(100,100);

        fighting = true;
    }
}
