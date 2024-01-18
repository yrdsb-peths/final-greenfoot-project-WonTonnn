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

    int youAttacks = 0;
    //Create all bar related stuff
    public int healthMax = 100;
    public int manaMax = 100;

    public int health = 100;
    Label healthBar;
    Color healthColor = new Color(247, 22, 22);
    public int block = 100;
    Label blockBar;
    Color blockColor = new Color(36, 181, 77);
    public int mana = 100;
    Label manaBar;
    Color manaColor = new Color(22, 168, 247);

    public int enemOneMaxHealth = 100;
    public int enemOneHealth = 100; 

    public int bossHealth = 300;
    Label bossHealthBar;

    Label enemyOneHealthBar;
    Color enemyHealthColor = new Color(111, 31, 120);

    Label yourAttacks;
    Label enemyAttacks;

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
    public int whichWorld = 0;

    /*
     * world 1 = 0
     * world 2 = 1
     */
    int enemyAtkValue = 0;
    int enemyDamage = 0;
    int youDamage;
    int animateCount = 0;
    boolean lose = false;
    public boolean bossFighting =false;

    int whichEnemy;
    int enemiesBeaten = 0;
    EnemyOne enemy1 = new EnemyOne();
    EnemyTwo enemy2 = new EnemyTwo();

    Boss boss = new Boss();

    //Player attack animations:
    GreenfootImage pinkAttack[] = new GreenfootImage[3];
    GreenfootImage pinkBlock[] = new GreenfootImage[3];
    GreenfootImage pinkSkill[] = new GreenfootImage[3];
    GreenfootImage pinkUltimate[] = new GreenfootImage[3];

    GreenfootSound main = new GreenfootSound("homeForFlowers.mp3");
    GreenfootSound battle = new GreenfootSound("tussleAmongTrees.mp3");
    GreenfootSound loseSound = new GreenfootSound("okToTryAgain.mp3");
    GreenfootSound winSound = new GreenfootSound("howdWeDo.mp3");
    GreenfootSound blockHealSound = new GreenfootSound("block heal.mp3");
    GreenfootSound arachnophobia = new GreenfootSound("arachnophobia.mp3");

    HealthPot healthPot = new HealthPot();
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
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
        Greenfoot.setSpeed(50);
        checkWinWin();
    }

    public void checkWinWin()
    {
        if(enemiesBeaten == 6)
        {
            WinScreen winscreen = new WinScreen();
            Greenfoot.setWorld(winscreen);
            arachnophobia.stop();
        }
    }

    public void playMusic()
    {
        if(fighting == false)
        {
            battle.stop();
            main.playLoop();
        }else{
            main.stop();
            battle.playLoop();
        }

        if(lose == true)
        {
            battle.stop();
            main.stop();
            loseSound.playLoop();
        }

        if(bossFighting == true)
        {
            main.stop();
            battle.stop();
            arachnophobia.playLoop();
        }
    }

    public void fight()
    {
        if(fighting == true)
        {

            if(myTurn == true)
            {

                if(Greenfoot.mouseClicked(attackButton))
                {
                    removeObject(blockButton);
                    removeObject(attackButton);
                    removeObject(skillButton);
                    // System.out.println(turnDecision);
                    turnDecision = 1;
                    //System.out.println(turnDecision);
                    System.out.println("attacked");
                    enemOneHealth = enemOneHealth - 12;
                    Greenfoot.delay(10);
                    youDamage = -12;

                    //animateAttack();

                    //Attack animation and decrease enemy health
                }

                if(Greenfoot.mouseClicked(blockButton))
                {
                    mana = mana - 15;
                    removeObject(blockButton);
                    removeObject(attackButton);
                    removeObject(skillButton);
                    System.out.println("blocked");
                    turnDecision = 3;
                    Greenfoot.delay(10);

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
                    Greenfoot.delay(10);
                    youDamage = -40;

                    //add skill image and ultimate
                    //choose between skill and ultimate in if statement = 2 or 4

                }
            }

            if(myTurn == false)
            {
                enemyAttack();
                checkWinLose();
            }
        }

    }

    public void enemyAttack()
    {
        int enemAtk = Greenfoot.getRandomNumber(2);
        //System.out.println("enemy attackin");
        updateBars();
        updateEnemyBar();

        Greenfoot.delay(100);
        if(enemAtk == 1)
        {
            health = health - 10;
            //enemyDamage = -10;
            
            //System.out.println("enemy attackin 1");
        }else if(enemAtk == 2)
        {
            health = health - 13;
            //enemyDamage = -13;
            //System.out.println("enemy attackin 2");
        }else if(enemAtk == 0)
        {
            health = health - 14;
            //enemyDamage = -14;
            //System.out.println("enemy attackin 3");
        }

        checkWinLose();
    }
    public void bossAttack()
    {
        int enemAtk = Greenfoot.getRandomNumber(2);
        //System.out.println("enemy attackin");
        updateBars();
        updateEnemyBar();

        Greenfoot.delay(100);
        if(enemAtk == 1)
        {
            health = health - 20;
            enemyDamage = -2;
            //System.out.println("enemy attackin 1");
        }else if(enemAtk == 2)
        {
            health = health - 30;
            enemyDamage = -30;
            //System.out.println("enemy attackin 2");
        }else if(enemAtk == 0)
        {
            health = health - 28;
            enemyDamage = -28;
            //System.out.println("enemy attackin 3");
        }

        checkWinLose();

    }

    public void checkWinLose()
    {

        if(health <= 0)
        {
            lose = true;
            act();
            createLoseScreen();
        } else if(enemOneHealth <= 0)
        {
            fighting = false;
            battle.stop();
            enemiesBeaten = enemiesBeaten + 1;
            if(enemiesBeaten == 5)
            {
                whichWorld = 3;
            }
            winSound.play();
            Greenfoot.delay(400);
            removeFightStuff();

        } else {
            addFightStuff();
            myTurn = true;
        }  

    }

    public void healPlayer()
    {
        healthMax = healthMax + 50;
        manaMax = manaMax + 25;
        health = healthMax;
        mana = manaMax;
        removeObject(healthPot);
    }

    public void updateBars()
    {
        if(turnDecision == 3)
        {
            health = health + 10;
        }
        healthBar.setValue(health);
        manaBar.setValue(mana);
        //enemyAttacks.setValue(enemyDamage);
        //yourAttacks.setValue(youDamage);
        //blockBar.setValue(block);
    }

    public void updateEnemyBar()
    {
        if(enemOneHealth > 0)
        {
            enemyOneHealthBar.setValue(enemOneHealth); 
        }

        if(enemOneHealth < 0)
        {
            enemyOneHealthBar.setValue(0);
        }

    }

    public void addEnemies()
    {
        whichEnemy = Greenfoot.getRandomNumber(2);
        System.out.println(enemiesBeaten);
        if(enemiesBeaten < 2)
        {
            if(whichEnemy == 0)
            {
                addObject(enemy1, 300, 300);
            } else if(whichEnemy == 1)
            {
                addObject(enemy2, 300,300);
            }

        }else if(enemiesBeaten == 2)
        {
            addObject(boss, 400, 300); 
        }

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
            pinkImg.scale(110,100);
            addObject(pink, 20, 290);

        }else if(choice == false){

            GreenfootImage blueImg = blue.getImage();
            blueImg.scale(55,70);
            addObject(blue, 20, 300);
        }
        addEnemies();

    }

    public void createFightWorld()
    {
        System.out.println("made fight world");
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
        removeObject(enemy1);
        //removeObject(blockBar);
        addObject(healthBar, 50, 50);
        addObject(manaBar, 120, 50);
        //addObject(blockBar, 190, 50);

        //addObject(enemyAttacks, 500,300);
        //addObject(yourAttacks, 100,300);

        updateEnemyBar();

        GreenfootImage atkImage = attackButton.getImage();
        GreenfootImage blkImage = blockButton.getImage();
        GreenfootImage sklImage = skillButton.getImage();

        if(whichEnemy == 0)
        {
            addObject(enemy1,300,200);
        }else if(whichEnemy == 1)
        {
            addObject(enemy2, 300,200);
        }else if(whichEnemy == 3)
        {
            addObject(boss,300,200);
        }
        addObject(pinkHand, 600, 600);
        GreenfootImage pinkHandImg = pinkHand.getImage();
        //pinkHandImg.scale(100,100);


        fighting = true;
    }

    public void createLoseScreen()
    {
        LoseScreen loseScreen = new LoseScreen();
        Greenfoot.setWorld(loseScreen);
    }

    public void winScreen()
    {
        removeFightStuff();
    }

    public void removeFightStuff()
    {
        System.out.println("renmved fight stuff");
        removeObject(attackButton);
        removeObject(blockButton);
        removeObject(skillButton);
        removeObject(healthBar);
        removeObject(manaBar);
        createBars();
        removeObject(fightWorld);
        removeObject(enemyOneHealthBar);
        removeObject(pinkHand);
        pink.canMove();
        blue.canMove();
        removeObject(enemy1);
        removeObject(enemy2);
        enemOneHealth = enemOneMaxHealth;
        removeObject(yourAttacks);
        removeObject(enemyAttacks);

        addObject(healthPot, 500, 300);
        GreenfootImage healthPotImg = healthPot.getImage();
        healthPotImg.scale(30,30);

    }

    public void changeWorld()
    {
        if(whichWorld == 0)
        {
            GreenfootImage world2 = new GreenfootImage("images/world2pic.jpg");
            this.setBackground(world2);

            addEnemies();
            if(choice == true)
            {
                pink.setLocation(0,300);
                //System.out.println("pinMove");
            }
            if (choice == false)
            {
                blue.setLocation(0,300);
                //System.out.println("Moved");
            }
            whichWorld = 1;

        }else if(whichWorld == 1)
        {
            GreenfootImage world1 = new GreenfootImage("images/world1pic.jpg");
            this.setBackground(world1);
            addEnemies();
            if(choice == true)
            {
                pink.setLocation(0,300);
            }
            if (choice == false)
            {
                blue.setLocation(0,300);
            }
            whichWorld = 0;

        }else if(whichWorld == 3)
        {
            GreenfootImage world3 = new GreenfootImage("images/BossOmori.jpg");
            this.setBackground(world3);
            addEnemies();
            if(choice == true)
            {
                pink.setLocation(0,300);
            }
            if (choice == false)
            {
                blue.setLocation(0,300);
            }
            bossFighting = true;

        }

    }
}
