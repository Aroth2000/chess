package custom;

import info.gridworld.grid.Location;

public class SpecialMove {
	
	private final Piece activePiece;
	private final Piece specialPiece;
	private final Location newLoc;
	private final Location specialNewLoc;
	
	SpecialMove(Piece activePiece, Location newLoc, Piece specialPiece, Location specialNewLoc) {
		this.activePiece = activePiece;
		this.specialPiece = specialPiece;
		this.newLoc = newLoc;
		this.specialNewLoc = specialNewLoc;
	}

	public Piece getActivePiece() {
		return activePiece;
	}

	public Piece getSpecialPiece() {
		return specialPiece;
	}

	public Location getLocation() {
		return newLoc;
	}
	
	public Location getSpecialNewLocation() {
		return specialNewLoc;
	}
}