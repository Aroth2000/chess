package custom;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;


public class King extends Piece {

	public King(String string) {
		super(string);
	}

	public ArrayList<Location> getMoveLocations() {
		
		ArrayList<Location> output = super.getMoveLocations();
		ArrayList<Location> opponentMoves = getAllOpponentMoveLocations();
		
		for(Location kingMove : super.getMoveLocations()) {   
			for(Location opponentMove : opponentMoves) {      //this might be able to be replaced by just output.remove
				if(kingMove.equals(opponentMove)) {
					output.remove(opponentMove);
				}
			}
		}
		
		return output;
	}

	
	public ArrayList<Piece> getOpponents() {
		
		ArrayList<Piece> opponents = new ArrayList<>();
		
		for(Location loc : this.getGrid().getOccupiedLocations()) {
			Actor a = this.getGrid().get(loc);
			if(a instanceof Piece) {
				Piece p = (Piece) a;
				if(!p.getTeam().equals(this.getTeam())) {
					opponents.add(p);
				}
			}
		}
		
		return opponents;
	}
	
	
	public ArrayList<Location> getAllOpponentMoveLocations() {

		ArrayList<Location> output = new ArrayList<>();
		
		for(Piece a : this.getOpponents()) {
			if(a instanceof King) {
				for(Location loc : a.getGrid().getValidAdjacentLocations(a.getLocation())) {
					if(!output.contains(loc)) {
						output.add(loc);
					}
				}
			}
			else {
				for(Location loc : a.getMoveLocations()) {
					if(!output.contains(loc)) {
						output.add(loc);
					}
				}	
			}
		}
		
		return output;
	}
	
	public boolean isInCheck() {
		ArrayList<Location> opponentMoves = this.getAllOpponentMoveLocations();
		if(opponentMoves.contains(this.getLocation()))
			return true;
		else
			return false;
	}
	
	public boolean isSafeMove(Location loc) {
		ArrayList<Location> opponentMoves = this.getAllOpponentMoveLocations();
		if(opponentMoves.contains(loc))
			return true;
		else
			return false;
	}
	
	public boolean willBeInCheckAfter(Piece p, Location newLoc) {
		
		
    	Location oldLoc = p.getLocation();
		Piece takenPiece = null;
		
		if(newLoc.equals(this.getLocation())) {
			return true;
		}
		
		if(this.getGrid().get(newLoc) instanceof Piece) {
			takenPiece = (Piece) this.getGrid().get(newLoc);
		}
		
		if(takenPiece!=null)
			takenPiece.removeSelfFromGrid();
		
		p.moveTo(newLoc);
		
		boolean output = this.isInCheck();
		
		p.moveTo(oldLoc);
		
		if(takenPiece!=null) {
			takenPiece.putSelfInGrid((Grid<Actor>) this.getGrid(), newLoc);
		}
    	
		return output;


	}
}
