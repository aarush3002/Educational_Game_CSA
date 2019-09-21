import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class paddle here.
 * 
 * @author Yash Raj Singh, Aarush Aitha, Yuvraj Khullar, Zuhair Jafri
 * @version 2.0
 */
public class paddle extends Actor
{
    /**
     * This calls the methods
     */
    public void act() 
    {
        move();
    }    
    /**
     * Basic left to right movement
     * a moves the paddle left while d moves it right
     */
    public void move()
    {
        if(Greenfoot.isKeyDown("a"))
        {
          move(-6);   
        }
        if(Greenfoot.isKeyDown("d"))
        {
          move(6);   
        }
    }
}
