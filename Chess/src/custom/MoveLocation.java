package custom;

import info.gridworld.actor.Actor;


public class MoveLocation extends Actor {
	
	private final Piece creator;
	
	MoveLocation(Piece p) {
		creator = p;
	}
	
	public Piece selectedBy() {
		return creator;
	}
}
