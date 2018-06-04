package custom;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class Bishop extends Piece {

	public Bishop(String string) {
		super(string);
	}
	
	public ArrayList<Location> getMoveLocations() {
		ArrayList<Location> output = new ArrayList<>();
		
		for(int i = Location.NORTHEAST; i<Location.FULL_CIRCLE; i=i+Location.RIGHT)
			output.addAll(getDiagonalMoves(i));
		
		return output;
	}
	
	private ArrayList<Location> getDiagonalMoves(int direction) {
		ArrayList<Location> output = new ArrayList<>();
		boolean pieceEncountered = false;
		Location origLoc = this.getLocation();
		Location nextLoc = this.getLocation();
		
		while(!pieceEncountered) {
			
			origLoc = nextLoc;
			nextLoc = origLoc.getAdjacentLocation(direction);
			
			if(this.getGrid().isValid(nextLoc)) {
				Actor a = this.getGrid().get(nextLoc);
				if(a instanceof Piece) {
					pieceEncountered = true;
					if(!((Piece) a).getTeam().equals(this.getTeam())) {
						output.add(nextLoc);
					}
				}
				
				else
					output.add(nextLoc);
			}
			
			else
				pieceEncountered = true;

		}
		
		return output;
	}
}
