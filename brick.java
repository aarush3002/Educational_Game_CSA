import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class brick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class brick extends Actor
{
    private String brick1;
    private String brick2;
    private String brick3;
    private String brick4;
    /**
     * Does nothing
     */
    public void act() 
    {
       
    }    
    /**
     * This sets the image for the arrays in able for the bricks to spawn in
     */
    public brick(String green)
    {
        brick1 = green;
        setImage(brick1);
    }

}
