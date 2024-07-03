import info.gridworld.actor.Actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class LavaDragon extends Actor
{
    /**
     * Constructs a red bug.
     */
    public LavaDragon()
    {
        setColor(null);
    }

    /**
     * Moves if it can move, turns otherwise.
     */
    public void act()
    {
        if (canMove())
            move();
        else
        {
			int rand=(int)(Math.random()*3)+1;

			if(rand==1)
            	turn();
            else if(rand==2)
            {
				for(int i=0;i<4;i++)
            		turn();
			}
			else
			{
				for(int i=0;i<6;i++)
            		turn();
			}
		}
    }

    /**
     * Turns the bug 45 degrees to the right without changing its location.
     */
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    /**
     * Moves the bug forward, putting a flower into the location it previously
     * occupied.
     */
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
        Footsteps footsteps = new Footsteps();
        footsteps.putSelfInGrid(gr, loc);
    }

    /**
     * Tests whether this bug can move forward into a location that is empty or
     * contains a flower.
     * @return true if this bug can move.
     */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);

        if(neighbor instanceof Emerald)
        {
			Location here = neighbor.getLocation();
			removeSelfFromGrid();
			putSelfInGrid(gr, here);
			removeSelfFromGrid();
			System.out.println("2ND MISSION FAILED, YOU LOSE!!!");
			return false;
		}
		else if(neighbor instanceof Wall)
		{
				Location here = neighbor.getLocation();
				System.out.println("WALL DESTROYED!");
				removeSelfFromGrid();
				putSelfInGrid(gr, here);
			return false;
		}
        else return (neighbor == null);
    }
}