import info.gridworld.actor.Actor;

import java.awt.Color;

public class Footsteps extends Actor
{
    private static final Color DEFAULT_COLOR = Color.BLACK;
    private int counter=0;

    /**
     * Constructs a black rock.
     */
    public Footsteps()
    {
        setColor(null);
    }
    /**
     * Overrides the <code>act</code> method in the <code>Actor</code> class
     * to do nothing.
     */
    public void act()
    {
		counter++;
		if(counter>=5)
			removeSelfFromGrid();
    }
}