import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends greenfoot.World
{
    private String[] bricks =
        { "brick1.png", "brick2.png", "brick3.png", "brick4.png", "brick0.png" };
        
    private paddle pad;
    
    /**
     * This just calls the methods as well as creates the world
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1);
        brickSpawn();
        populate();
    }

    /**
     * Spawns in the instances so the game can function properly
     */
    public void populate()
    {
        pad = new paddle();
        addObject(new paddle(),350, 450);
        addObject(new ball(),350, 420);
        addObject(new titleScreen(),350, 250);
    }
    
    
    public paddle getPaddle() {
        return pad;
    }

    /**
     * If you hit all the bricks, you win!
     */
    public void win()
    {
        addObject(new winScreen(),350, 250);
        Greenfoot.stop();
    }

    /**
     * if the ball gets past the paddle, you lose!
     */
    public void lose()
    {
        addObject(new gameover(),350, 300);
    }

    /**
     * These spawn the Green, Yellow, Orange, and Red bricks into the world
     * they use loops in able for them to spawn in
     */
    public void brickSpawn()
    {
        for(int i = 0; i < bricks.length; i++)
        {
            addObject(new brick(bricks[4]), i*137 + 78, 195);
            //                 distance apart ^ xside^ yside^
        }
        for(int i = 0; i < bricks.length; i++)
        {
            addObject(new brick(bricks[0]), i*137 + 78, 155);
        }    
        for(int i = 0; i < bricks.length; i++)
        {
            addObject(new brick(bricks[1]), i*137 + 78, 115);
        }    
        for(int i = 0; i < bricks.length; i++)
        {
            addObject(new brick(bricks[2]), i*137 + 78, 75);
        } 
        for(int i = 0; i < bricks.length; i++)
        {
            addObject(new brick(bricks[3]), i*137 + 78, 35);
            //                 distance apart ^ xside^ yside^
        }
    }
}
