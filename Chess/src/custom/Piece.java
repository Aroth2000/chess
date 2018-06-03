package custom;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class Piece extends Critter {
	
	private String team;
	private boolean selected;
	private Piece selectedBy;
	private Color teamColor;
	
	Piece(String team) {
		this.team = team;
		
		if(team.equals("WHITE"))
			teamColor = Color.WHITE;
		else
			teamColor = Color.BLACK;
		
		this.setColor(teamColor);
	}
	
	public void act() {
		boolean flag = false;
		
		if(flag) {
			//manual control
		}
			
		else
			super.act(); //control by computer
	}
	
	public void displayMoveLocations(boolean inCheck) {
		
		if(inCheck) {
			King k = this.getGrid().getKing(this.getTeam());
			ArrayList<Location> opponentMoves = k.getAllOpponentMoveLocations();
			//basically only display moves that will end check. this is impossible
			
		}
		
		else {
			this.getGrid().removeMoveLocations();
	
			for(Location loc : this.getMoveLocations()) {
				
				Actor a = this.getGrid().get(loc);
	
				if(a==null) {
					(new MoveLocation(this)).putSelfInGrid(this.getGrid(), loc);
				}
				else if(a instanceof Piece) {
					Piece b = (Piece) a;
					if(!b.getTeam().equals(this.getTeam())) {
						b.setSelected(true);
						b.setSelectedBy(this);
					}
				}
					
			}
		}
	}
	
	public ArrayList<Location> getMoveLocations() {
		return this.getGrid().getValidAdjacentLocations(this.getLocation());
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
		if(selected)
			setColor(Color.GREEN);
		else
			setColor(teamColor);
	}
	
	public String getTeam() {
		return team;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}
	
	public Piece selectedBy() {
		return selectedBy;
	}

	public void setSelectedBy(Piece selectedBy) {
		this.selectedBy = selectedBy;
	}
	
	public String toString() {
		return super.toString() + "Team: " + team;
	}
}
