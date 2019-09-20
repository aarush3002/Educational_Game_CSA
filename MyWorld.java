import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends greenfoot.World
{
    
    private String[] bricks =
    {"actinide.PNG", "aluminum.PNG", "americium.PNG", "antimony.PNG", "argon.PNG", "arsenic.PNG", "astatine.PNG", "barium.PNG", "berkelium.PNG", "beryllium.PNG", "bismuth.PNG", "bohrium.PNG", "boron.PNG", "bromine.PNG", "cadmium.PNG", "caesium.PNG", "calcium.PNG", "californium.PNG", "carbon.PNG", "cerium.PNG", "chlorine.PNG", "chromium.PNG", "cobalt.PNG", "copernicium.PNG", "copper.PNG", "curium.PNG", "darmstadtium.PNG", "dubnium.PNG", "dysprosium.PNG", "einsteinium.PNG", "erbium.PNG", "europium.PNG", "fermium.PNG", "fluorine.PNG", "francium.PNG", "gadolinum.PNG", "gallium.PNG", "germanium.PNG", "gold.PNG", "hafnium.PNG", "hassium.PNG", "helium.PNG", "holmium.PNG", "hydrogen.PNG", "indium.PNG", "iodine.PNG", "iridium.PNG", "iron.PNG", "krypton.PNG", "lanthanide.PNG", "lawrencium.PNG", "lead.PNG", "lithium.PNG", "lutetium.PNG", "magnesium.PNG", "manganese.PNG", "meitnerium.PNG", "mendelevium.PNG", "mercury.PNG", "molybdenum.PNG", "neodymium.PNG", "neon.PNG", "neptunium.PNG", "nickel.PNG", "niobium.PNG", "nitrogen.PNG", "nobelium.PNG", "osmium.PNG", "oxygen.PNG", "palladium.PNG", "phosphorus.PNG", "platinum.PNG", "plutonium.PNG", "polonium.PNG", "potassium.PNG", "praseodymium.PNG", "promethium.PNG", "protactinium.PNG", "radium.PNG", "radon.PNG", "rhenium.PNG", "rhodium.PNG", "roentgenium.PNG", "rubidium.PNG", "ruthenium.PNG", "rutherfordium.PNG", "samarium.PNG", "scandium.PNG", "seaborgium.PNG", "selenium.PNG", "silicon.PNG", "silver.PNG", "sodium.PNG", "strontium.PNG", "sulfur.PNG", "tantalum.PNG", "technetium.PNG", "tellurium.PNG", "terbium.PNG", "thallium.PNG", "thorium.PNG", "thulium.PNG", "tin.PNG", "titanium.PNG", "tungsten.PNG", "ununaquadium.PNG", "ununhexium.PNG", "ununoctium.PNG", "ununpentium.PNG", "ununseptium.PNG", "ununtrium.PNG", "uranium.PNG", "vanadium.PNG", "xenon.PNG", "ytterbium.PNG", "yttrium.PNG", "zinc.PNG", "zirconium.PNG"}
;
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
        
        addObject(new paddle(),350, 450);
        addObject(new ball(),350, 420);
        addObject(new titleScreen(),350, 250);
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
    String[] randelements = new String[56];
    for (int x = 0; x < randelements.length; x++)
    {
        randelements[x] = bricks[(int)(Math.random() * bricks.length) + 0];
    }
    brick[] elements = new brick[56];
    int[] locations = new int[56];
    for (int x = 0; x < randelements.length; x++)
    {
        for(int y = 0; y < bricks.length; y++)
        {
            if (randelements[x] == bricks[y])
            {
                locations[x] = y;
            }
        }
    }
    for (int x = 0; x < elements.length; x++)
    {
        elements[x] = new brick(bricks[locations[x]]);
        GreenfootImage image = elements[x].getImage();
        image.scale(50,63);
    }
    
    //placement of blocks begins
    for(int i = 0; i < 14; i++)
    {
        addObject(elements[i], i*50 + 25, 25);
        //          distance apart ^ xside^ yside^
    }
    for(int i = 14; i < 28; i++)
    {
        addObject(elements[i], (i-14)*50 + 25, 88);
    }  
    for(int i = 28; i < 42; i++)
    {
        addObject(elements[i], (i-28)*50 + 25, 151);
    }    
    for(int i = 42; i < 56; i++)
    {
        addObject(elements[i], (i-42)*50 + 25, 214);
    }
    /*
    for(int i = 0; i < bricks.length; i++)
    {
        addObject(new brick(bricks[3]), i*137 + 78, 35);
        //                 distance apart ^ xside^ yside^
    }
    */
}
}
