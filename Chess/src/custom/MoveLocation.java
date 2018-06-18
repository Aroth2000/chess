package custom;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;


public class MoveLocation extends Actor {
	
	private final Piece creator;
	private final Piece specialPiece;
	private final boolean isSpecialMove;
	private final Location specialMoveLocation;
	
	MoveLocation(Piece creator) {
		this.creator = creator;
		this.isSpecialMove = false;
		this.specialPiece = null;
		specialMoveLocation = null;
	}
	
	MoveLocation(Piece creator, Piece specialPiece, Location sml) {
		this.isSpecialMove = true;
		this.creator = creator;
		this.specialPiece = specialPiece;
		specialMoveLocation = sml;
	}
	
	public Piece selectedBy() {
		return creator;
	}
	
	public boolean isSpecialMove() {
		return isSpecialMove;
	}

	public Piece getSpecialPiece() {
		return specialPiece;
	}

	public Location getSpecialMoveLocation() {
		return specialMoveLocation;
	}
}
