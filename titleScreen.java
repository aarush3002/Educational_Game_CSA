import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class titleScreen here.
 * 
 * @author Yash Raj Singh, Aarush Aitha, Yuvraj Khullar, Zuhair Jafri
 * @version 2.0
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
