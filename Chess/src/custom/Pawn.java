package custom;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class Pawn extends Piece {

	private boolean hasMovedAlready;
	
	public Pawn(String string) {
		super(string);
		hasMovedAlready = false;
	}



	
}
