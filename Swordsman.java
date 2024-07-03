import info.gridworld.actor.Actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;


public class Swordsman extends Actor
{
    /**
     * Constructs a red bug.
     */

    private boolean hasSword=false;
    private boolean doubleSword=false;

    public Swordsman()
    {
        setColor(null);
    }

    /**
     * Moves if it can move, turns otherwise.
     */
    public void act()
    {
		if(doubleSword)
		{
			int x = (int)(Math.random()*9)+1;
			if(x==1)
				setColor(Color.RED);
			else if(x==2)
				setColor(Color.GREEN);
			else if(x==3)
				setColor(Color.BLUE);
			else if(x==4)
				setColor(Color.CYAN);
			else if(x==5)
				setColor(Color.YELLOW);
			else if(x==6)
				setColor(Color.ORANGE);
			else if(x==7)
				setColor(Color.MAGENTA);
			else if(x==8)
				setColor(Color.PINK);
		}

		int rand=(int)(Math.random()*4)+1;
		if(canMove())
		{
			if(rand==4)
			turn();
			else move();
		}
		else
		{

			if(rand==1)
			{
				for(int i=0;i<6;i++)
					turn();
			}
			else if(rand==2)
			{
				for(int i=0;i<4;i++)
					turn();
			}
			else turn();
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

        if(neighbor instanceof Sword)
		{
			if(hasSword)
			{
				doubleSword=true;
				Location here = neighbor.getLocation();
				System.out.println("What's this? ANOTHER SWORD?");
				System.out.println("The Swordsman has got ANOTHER SWORD?! \n This means he can now break ANYTHING! \n ABSOLUTE OVERDRIVE!!! \n HE NOW CHANGES COLORS EVERY SECOND!!!");
				removeSelfFromGrid();
				putSelfInGrid(gr, here);

				LavaDragon LD = new LavaDragon();
				Location ld = new Location(9,0);
				LD.putSelfInGrid(gr, ld);

				Location orb=new Location(1,9);
				Emerald emerald=new Emerald();

				emerald.putSelfInGrid(gr, orb);
				System.out.println("Protect the EMERALD!!!");

				return false;
			}
			else
			{
				Location here = neighbor.getLocation();
				System.out.println("What's this? A sword?");
				removeSelfFromGrid();
				putSelfInGrid(gr, here);
				setColor(Color.YELLOW);
				System.out.println("The Swordsman has now got his sword, allowing him to go into a hyper state, causing him to become golden and giving him enough power to kill the dragon!");
				hasSword=true;
				return false;
			}
		}
		else if(neighbor instanceof Lava)
		{
			if(doubleSword)
			{
				Location here = neighbor.getLocation();
				System.out.println("LAVA DESTROYED!");
				removeSelfFromGrid();
				putSelfInGrid(gr, here);
			}
			else if(!hasSword)
			{
				int rand=(int)(Math.random()*4)+1;
				if(rand==1)
				{
					removeSelfFromGrid();
					System.out.println("The Swordsman died due to Burning in Lava!");
					System.out.println("Game Over!");
				}
			}
			return false;
		}
		else if(neighbor instanceof Wall)
		{
			if(doubleSword)
			{
				Location here = neighbor.getLocation();
				System.out.println("WALL DESTROYED!");
				removeSelfFromGrid();
				putSelfInGrid(gr, here);
			}
		}
		else if(neighbor instanceof Dragon)
		{
			if(hasSword)
			{
				Location here = neighbor.getLocation();
				removeSelfFromGrid();
				putSelfInGrid(gr, here);
				System.out.println("The Swordsman has defeated the Dragon!");
				System.out.println("1ST MISSION CLEARED");
			}
			else if(!hasSword)
			{
				System.out.println("The Swordsman died due to being eaten by the Dragon");
				System.out.println("Game Over!");
				removeSelfFromGrid();
			}
			return false;
		}
		else if(neighbor instanceof LavaDragon)
		{

			Location here = neighbor.getLocation();
			removeSelfFromGrid();
			putSelfInGrid(gr, here);
			System.out.println("The Swordsman has defeated the LavaDragon!");
			System.out.println("YOU WIN!!!");
			return false;
		}
		else if(neighbor instanceof Footsteps)
		{
			if(hasSword)
			{
				return true;
			}
			else
				return false;
		}
		return (neighbor == null);

    }
}
