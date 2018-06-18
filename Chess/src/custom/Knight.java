package custom;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class Knight extends Piece 
{
	Knight(String team) 
	{
		super(team);
	}
	
	public ArrayList<Location> getMoveLocations()
	{
		ArrayList<Location> potential = new ArrayList<>(); //plus plus
		Location location = getLocation();
		int currentRow = location.getRow();
		int currentCol = location.getCol();
		int twoUp = currentRow+2;
		int twoDown = currentRow-2;
		int up = currentRow+1;
		int down = currentRow-1;
		int right = currentCol+1;
		int left = currentCol-1;
		int twoRight = currentCol+2;
		int twoLeft = currentCol-2;
		String team = getTeam();
		Grid<Actor> gr = this.getGrid();
		
		Location one = new Location(twoUp, right);
		if(gr.isValid(one)) 
			if(!(gr.get(one) instanceof Piece) || ((Piece) gr.get(one)).getTeam()!=team)
				potential.add(one);
		
		Location two = new Location(twoUp, left);
		if(gr.isValid(two)) 
			if(!(gr.get(two) instanceof Piece) || ((Piece) gr.get(two)).getTeam()!=team)
				potential.add(two);
		
		Location three = new Location(twoDown, right);
		if(gr.isValid(three)) 
			if(!(gr.get(three) instanceof Piece) || ((Piece) gr.get(three)).getTeam()!=team)
				potential.add(three);
		
		Location four = new Location(twoDown, left);
		if(gr.isValid(four)) 
			if(!(gr.get(four) instanceof Piece) || ((Piece) gr.get(four)).getTeam()!=team)
				potential.add(four);
		
		Location five = new Location(up, twoRight);
		if(gr.isValid(five)) 
			if(!(gr.get(five) instanceof Piece) || ((Piece) gr.get(five)).getTeam()!=team)
				potential.add(five);
		
		Location six = new Location(up, twoLeft);
		if(gr.isValid(six)) 
			if(!(gr.get(six) instanceof Piece) || ((Piece) gr.get(six)).getTeam()!=team)
				potential.add(six);
		
		Location seven = new Location(down, twoRight);
		if(gr.isValid(seven)) 
			if(!(gr.get(seven) instanceof Piece) || ((Piece) gr.get(seven)).getTeam()!=team)
				potential.add(seven);
		
		Location eight = new Location(down, twoLeft);
		if(gr.isValid(eight)) 
			if(!(gr.get(eight) instanceof Piece) || ((Piece) gr.get(eight)).getTeam()!=team)
				potential.add(eight);
				
		return potential;
	}	
}