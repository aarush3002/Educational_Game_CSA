import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ball extends Actor
{
    MyWorld world;
    
    private boolean end;
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    private boolean ballRelease;
    public int gameend;
    GreenfootSound backgroundMusic = new GreenfootSound("background.mp3");
    /**
     * Sets all of the booleans to fit the direction the ball is going to launch in
     */
    public ball()
    {
        end = false;
        ballRelease = false;
        right = true;
        up = true;
        left = false;
        down = false;
        setRotation(-25);
        gameend = 0;
        
    }
    /**
     * This calls the other methods and launches the ball when space is pressed
     */
    public void act() 
    {
        brick();
        move();
        paddle();
        music();
        if(Greenfoot.isKeyDown("space"))
        {
            ballRelease = true;
        }
       
    }
    /**
     * As long as the game is running, the music will loop play
     * when the player dies, the music stops as well as the scenario
     */
    public void music()
    {
         if(end == true)
        {
          MyWorld myWorld = (MyWorld) getWorld();
          myWorld.lose();
          Greenfoot.stop(); 
          backgroundMusic.stop();
        }  
        else
        
       {
            backgroundMusic.playLoop();
        }
    }
    /**
     * Sets the directions of the ball so whenever it hits a side
     * of the wall, it will rotate in a specific direction
     */
    public void move()
    {
        int x = getX();
        int y = getY();
        if(ballRelease == true)
        {
          
          move(4);
          if(x==699) 
          {
               //if the ball is hitting the right wall
              if(down == true)
              {
                  turn(-83);
                  right = false;
                  left = true;
                }
              if(up == true)
              {
                  turn(83);
                  right = false;
                  left = true;
                }
              
            }
          if(x==0)
          {
                //if the ball is hitting the left wall
              if(down == true)
              {
                  turn(84);
                  right = true;
                  left = false;
                }
              if(up == true)
              {
                  turn(-84);
                  right = true;
                  left = false;
                }
              
            }
          if(y==0)
          {
              //if the ball is hitting the top of the screen
              if(up == true & left == true)
              {
                  turn(-84);
                  down = true;
                  up = false;
                }
               if(up == true & right == true)
              {
                  turn(84);
                  down = true;
                  up = false;
                }
            }
          if(y==499)
          {
              end = true; //if the ball gets past the paddle
              Greenfoot.playSound("gameover.mp3"); //game over music
            }  
        }
    }
    /**
     * Whenever the ball hits the paddle, depending on the direction
     * it should rotate in a specific way whenever it hits
     */
    public void paddle()
    {
        Actor paddle = getOneObjectAtOffset(15, 15, paddle.class);
        
        if (paddle != null)
          {
              if(down == true & right == true)
              {
                  turn(-80);
                  down = false;
                  up = true;
                  Greenfoot.playSound("beep.mp3");
                }
                if(down == true & left == true)
              {
                  turn(80);
                  down = false;
                  up = true;
                  Greenfoot.playSound("beep.mp3");
                }
               if(down == true & right == true)
              {
                  turn(80);
                  down = false;
                  up = true;
                  Greenfoot.playSound("beep.mp3");
                }
               if(down == true & left == true)
              {
                  turn(-80);
                  down = false;
                  up = true;
                  Greenfoot.playSound("beep.mp3");
                }
    }
}
/**
 * Whatever direction it is going in, it will destroy and bounce off of
 * the brick. This also plays sound effects and chances true and false values
 */
public void brick()
{
    if(isTouching(brick.class ))
    {
        gameend = gameend +1;
        if(up == true & left == true) //if the ball is going up and left
        {
            removeTouching(brick.class);
            turn(-80);
            Greenfoot.playSound("beep.mp3");
            down = true;
            up = false;
        }
        if(up == true & right == true) //if the ball is going up and right
        {
            removeTouching(brick.class);
            turn(80);
            Greenfoot.playSound("beep.mp3");
            down = true;
            up = false;
        }
        if(down == true & left == true) //if the ball is going down and left
        {
            removeTouching(brick.class);
            Greenfoot.playSound("beep.mp3");
        }
        if(down == true & right == true) //if the ball is going down and right
        {
            
            removeTouching(brick.class);
            Greenfoot.playSound("beep.mp3");
        }
        if(gameend >= 25) //attempt one for trying to win the game
        //also this calls the "win" method from the world class
        {
            backgroundMusic.stop();
            Greenfoot.playSound("victory.mp3");
            MyWorld myWorld = (MyWorld) getWorld();
            myWorld.win();
        }
        if(gameend >= 26) //attempt two for trying to win the game
        {
            backgroundMusic.stop();
            Greenfoot.playSound("victory.mp3");
            MyWorld myWorld = (MyWorld) getWorld();
            myWorld.win();
        }
}
}
}
