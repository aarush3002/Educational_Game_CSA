import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class paddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
