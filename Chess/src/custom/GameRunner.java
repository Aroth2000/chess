package custom;
/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

/**
 * This class runs a world that contains a bug and a rock, added at random
 * locations. Click on empty locations to add additional actors. Click on
 * populated locations to invoke methods on their occupants. <br />
 * To build your own worlds, define your own actors and a runner class. See the
 * BoxBugRunner (in the boxBug folder) for an example. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class GameRunner
{
    public static void main(String[] args)
    {
    	
        newGame();
     
    }
    
    public static void newGame() {
    	
    	ActorWorld world = new ActorWorld(new BoundedGrid<Actor>(8, 8));
    	
    	for(int i = 0; i<world.getGrid().getNumCols(); i++) {
    		world.add(new Location(6,i),new Pawn("WHITE"));
    		world.add(new Location(1,i),new Pawn("BLACK"));
    	}
    	
        world.add(new Location(7,0),new Rook("WHITE"));
        world.add(new Location(0,0),new Rook("BLACK"));
        world.add(new Location(7,7),new Rook("WHITE"));
        world.add(new Location(0,7),new Rook("BLACK"));
        
        world.add(new Location(7,6),new Knight("WHITE"));
        world.add(new Location(0,1),new Knight("BLACK"));
        world.add(new Location(7,1),new Knight("WHITE"));
        world.add(new Location(0,6),new Knight("BLACK"));
        
        world.add(new Location(7,5),new Bishop("WHITE"));
        world.add(new Location(0,2),new Bishop("BLACK"));
        world.add(new Location(7,2),new Bishop("WHITE"));
        world.add(new Location(0,5),new Bishop("BLACK"));
        
        world.add(new Location(7,4),new Queen("WHITE"));
        world.add(new Location(0,4),new Queen("BLACK"));
        
        world.add(new Location(7,3),new King("WHITE"));
        world.add(new Location(0,3),new King("BLACK"));
    
        world.show();
    }
}
