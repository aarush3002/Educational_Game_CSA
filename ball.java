import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
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
          
          move(3);
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
    String alkali = "alkali";
    String earth = "earth";
    String lan = "lanthanoids";
    String acti = "actinoids";
    String transition = "transition";
    String post = "post";
    String metal = "metalloids";
    String non = "non";
    String noble = "noble";
    String halo = "halogen";
    if(isTouching(brick.class ))
    {
        //for (int i = 0; i < 56; i++) {
        Actor brick = getOneIntersectingObject(brick.class);
        GreenfootImage elm = brick.getImage();
        String a = elm.toString();
        if(a.contains("actinide.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("actinide")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(post)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("aluminum.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("aluminum")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(post)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("americium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("americium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(acti)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("antimony.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("antimony")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(metal)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("argon.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("argon")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(noble)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("arsenic.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("arsenic")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(metal)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("astatine.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("astatine")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(halo)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("barium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("barium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(earth)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("berkelium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("berkelium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(acti)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("beryllium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("beryllium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(earth)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("bismuth.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("bismuth")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(non)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("bohrium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("bohrium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("boron.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("boron")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(metal)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("bromine.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("bromine")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(halo)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("cadmium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("cadmium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("caesium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("caesium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(alkali)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("calcium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("calcium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(earth)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("californium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("californium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(acti)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("carbon.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("carbon")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(non)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("cerium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("cerium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(lan)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("chlorine.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("chlorine")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(halo)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("chromium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("chromium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("cobalt.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("cobalt")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("copernicium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("copernicium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("copper.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("copper")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("curium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("curium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(acti)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("darmstadtium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("darmstadtium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("dubnium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("dubnium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("dysprosium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("dysprosium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(lan)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("einsteinium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("einsteinium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(acti)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("erbium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("erbium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(lan)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("europium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("europium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(lan)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("fermium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("fermium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(acti)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("fluorine.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("fluorine")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(halo)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("francium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("francium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(alkali)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("gadolinum.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("gadolinium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(lan)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("gallium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("gallium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(post)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("germanium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("germanium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(metal)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("gold.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("gold")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("hafnium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("hafnium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("hassium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("hassium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("helium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("helium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(noble)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.mp3");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("holmium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("holmium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(lan)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("hydrogen.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("hydrogen")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(alkali)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("indium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("indium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(post)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("iodine.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("iodine")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(halo)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("iridium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("iridium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("iron.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("iron")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("krypton.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("krypton")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(noble)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("lanthanide.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("lanthanide")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(lan)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("lawrencium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("lawrencium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(acti)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("lead.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("lead")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(post)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("lithium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("lithium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(alkali)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("lutetium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("lutetium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(lan)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("magnesium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("magnesium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(earth)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("manganese.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("manganese")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }  else if(a.contains("meitnerium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("meitnerium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("mendelevium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("mendelevium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(acti)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("mercury.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("mercury")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(post)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("molybdenum.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("molybdenum")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("neodymium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("neodymium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(lan)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("neon.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("neon")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(noble)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("neptunium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("neptunium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(acti)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("nickel.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("nickel")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("niobium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("niobium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("nitrogen.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("nitrogen")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(non)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("nobelium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("nobelium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(acti)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("osmium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("osmium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("oxygen.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("oxygen")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(non)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("palladium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("palladium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("phosphorus.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("phosphorus")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(non)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("platinum.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("platinum")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("plutonium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("plutonium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(acti)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("polonium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("polonium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(post)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("potassium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("potassium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(alkali)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("praseodymium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("praseodymium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(lan)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("promethium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("promethium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(lan)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("protactinium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("protactinium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(acti)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("radium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("radium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(earth)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("radon.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("radon")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(noble)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("rhenium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("rhenium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("rhodium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("rhodium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("roentgenium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("roentgenium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("rubidium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("rubidium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(alkali)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("ruthenium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("ruthenium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("rutherfordium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("rutherfordium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("samarium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("samarium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(lan)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("scandium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("scandium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("seaborgium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("seaborgium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("selenium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("selenium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(non)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("silicon.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("silicon")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(metal)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("silver.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("silver")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("sodium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("sodium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(alkali)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("strontium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("strontium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(earth)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("blast.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("sulfur.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("sulfur")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(non)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("tantalum.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("tantalum")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("technetium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("technetium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("tellurium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("tellurium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(metal)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("terbium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("terbium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(lan)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("thallium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("thallium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(post)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("thorium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("thorium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(acti)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("thulium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("thulium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(lan)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("tin.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("tin")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(post)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("titanium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("titanium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("tungsten.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("tungsten")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("ununaquadium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("flerovium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(post)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("ununhexium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("livermorium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(post)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("ununoctium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("oganesson")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(noble)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("ununpentium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("moscovium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(post)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("ununseptium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("tennessine")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(halo)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("ununtrium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("nihonium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(post)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.mp3");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("uranium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("uranium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(acti)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("vanadium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("vanadium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        } else if(a.contains("xenon.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("xenon")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(noble)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("woosh.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("ytterbium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("ytterbium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(lan)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("yttrium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("yttrium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("zinc.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("zinc")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }else if(a.contains("zirconium.PNG")) {
            String ans = Greenfoot.ask("What is the name of this element?");
            if (ans.contains("zirconium")) {
                ans = Greenfoot.ask("What group does it belong to?");
                if (ans.contains(transition)) {
                    gameend = gameend +1;
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        removeTouching(brick.class);
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        removeTouching(brick.class);
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    
                } else {
                    if(up == true & left == true) //if the ball is going up and left
                    {
                        turn(-80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                    if(up == true & right == true) //if the ball is going up and right
                    {
                        turn(80);
                        Greenfoot.playSound("clank.wav");
                        down = true;
                        up = false;
                    }
                }
            }
               
        }
      
        
        if(up == true & left == true) //if the ball is going up and left
        {
            turn(-80);
            Greenfoot.playSound("x");
            down = true;
            up = false;
        }
        if(up == true & right == true) //if the ball is going up and right
        {
            turn(80);
            Greenfoot.playSound("beep.mp3");
            down = true;
            up = false;
        }
        if(down == true & left == true) //if the ball is going down and left
        {
            //turn(80);
            Greenfoot.playSound("beep.mp3");
            //down = false;
            //up = true;
        }
        if(down == true & right == true) //if the ball is going down and right
        {
            //turn(-80);
            Greenfoot.playSound("beep.mp3");
            //down = false;
            //up = true;
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

