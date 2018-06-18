package custom;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class Pawn extends Piece {

	public Pawn(String string) 
	{
		super(string);
	}
	
	public ArrayList<Location> getMoveLocations() //add special move
	{
		ArrayList<Location> potential = new ArrayList<>();
		Location location = getLocation();
		int currentRow = location.getRow();
		int currentCol = location.getCol();
		int up = currentRow-1;
		int down = currentRow+1;
		int right = currentCol+1;
		int left = currentCol-1;
		String team = this.getTeam();
		Grid<Actor> gr = this.getGrid();
		
		if(team.equals("WHITE"))
		{

			Location up1 = new Location(up,currentCol);
			if(gr.isValid(up1)) {
				if(!(gr.get(up1) instanceof Piece)) {
					potential.add(up1);
					
					Location up2 = new Location(up-1,currentCol);
					if(gr.isValid(up2) && this.hasMoved()==false) {
						if(!(gr.get(up2) instanceof Piece)) {
							potential.add(up2);
						}
					}
				}
			}
			
			Location dR = new Location(up, right);
			if(gr.isValid(dR)) {
				if((gr.get(dR) instanceof Piece) && ((Piece) gr.get(dR)).getTeam()!=team) {
					potential.add(dR);
				}
			}
			
			Location dL = new Location(up, left);
			if(gr.isValid(dL)) {
				if((gr.get(dL) instanceof Piece) && ((Piece) gr.get(dL)).getTeam()!=team) {
					potential.add(dL);
				}
			}
			
		}
		
		else
		{
			Location down1 = new Location(down,currentCol);
			if(gr.isValid(down1)) {
				if(!(gr.get(down1) instanceof Piece)) {
					potential.add(down1);
					
					Location down2 = new Location(down+1,currentCol);
					if(gr.isValid(down2) && this.hasMoved()==false) {
						if(!(gr.get(down2) instanceof Piece)) {
							potential.add(down2);
						}
					}
				}
			}
			
			Location uR = new Location(down, right);
			if(gr.isValid(uR)) {
				if((gr.get(uR) instanceof Piece) && ((Piece) gr.get(uR)).getTeam()!=team) {
					potential.add(uR);
				}
			}
			
			Location uL = new Location(down, left);
			if(gr.isValid(uL)) {
				if((gr.get(uL) instanceof Piece) && ((Piece) gr.get(uL)).getTeam()!=team) {
					potential.add(uL);
				}
			}
			
		}
		return potential;
	}
	

	
}
