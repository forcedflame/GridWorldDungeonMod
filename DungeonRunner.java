import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

public class DungeonRunner
{
    public static void main(String[] args)
    {
		boolean hasSword = false;
        ActorWorld world = new ActorWorld();

        Dragon drago = new Dragon();
        Swordsman man = new Swordsman();

        Sword sword = new Sword();
        Sword sword3 = new Sword();

        Wall wall1 = new Wall();
        Wall wall2 = new Wall();
        Wall wall3 = new Wall();
        Wall wall4 = new Wall();
        Wall wall5 = new Wall();
        Wall wall6 = new Wall();
        Wall wall7 = new Wall();
        Wall wall8 = new Wall();
        Wall wall9 = new Wall();
        Wall wall10 = new Wall();
        Wall wall11 = new Wall();
        Wall wall12 = new Wall();
        Wall wall13 = new Wall();
        Wall wall14 = new Wall();
        Wall wall15 = new Wall();
        Wall wall16 = new Wall();

        Lava lava1 = new Lava();
		Lava lava2 = new Lava();
		Lava lava3 = new Lava();
        Lava lava4 = new Lava();
        Lava lava5 = new Lava();
        Lava lava6 = new Lava();
        Lava lava7 = new Lava();
        Lava lava8 = new Lava();
        Lava lava9 = new Lava();
        Lava lava10 = new Lava();

		//coordinates work like (y,x)

        world.add(new Location(4, 8), drago);
        world.add(new Location(5, 5), man);

        world.add(new Location(0, 5), lava1);
        world.add(new Location(0, 6), lava2);
        world.add(new Location(5, 9), lava3);
        world.add(new Location(2, 8), lava4);
        world.add(new Location(6, 3), lava5);
        world.add(new Location(7, 3), lava6);
        world.add(new Location(8, 3), lava7);
        world.add(new Location(1, 2), lava8);
        world.add(new Location(2, 1), lava9);
        world.add(new Location(8, 1), lava10);

		world.add(new Location(3, 4), sword);
		world.add(new Location(7, 8), sword3);

		world.add(new Location(0, 0), wall1);
		world.add(new Location(3, 3), wall2);
		world.add(new Location(4, 2), wall3);
		world.add(new Location(5, 2), wall4);
		world.add(new Location(0, 4), wall5);
		world.add(new Location(4, 6), wall6);
		world.add(new Location(0, 7), wall7);
		world.add(new Location(0, 8), wall8);
		world.add(new Location(0, 9), wall9);
		world.add(new Location(4, 5), wall10);
		world.add(new Location(6, 4), wall11);
		world.add(new Location(6, 5), wall12);
		world.add(new Location(8, 6), wall13);
		world.add(new Location(8, 7), wall14);
		world.add(new Location(9, 8), wall15);
		world.add(new Location(6, 0), wall16);

        world.show();

		System.out.println("Welcome to the Dungeon? Will you kill or be killed?");
		System.out.println("Click \"Run\" to play!");
    }
}