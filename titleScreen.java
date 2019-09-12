import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class titleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class titleScreen extends Actor
{
    /**
     * When enter is pressed, the title screen will "hide"
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("enter"))
        {
            getWorld().removeObject(this);
        }
    }    
}
