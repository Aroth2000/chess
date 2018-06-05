package custom;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.util.ArrayList;

public class Rook extends Piece {

	public Rook(String string) {
		super(string);
	}
	
	public ArrayList<Location> getMoveLocations()
	{
		ArrayList<Location> potential = new ArrayList<>();
		Location location = getLocation();
		int currentRow = location.getRow();
		int currentCol = location.getCol();
		String team = getTeam();
		Grid<Actor> gr = this.getGrid();
		
		int i=currentRow+1;
		while(i!=8)
		{
			Location a = new Location(i, currentCol);
			if(gr.isValid(a)) 
			{
				if(!(gr.get(a) instanceof Piece))
				{
					potential.add(a);
					i++;
				}
				else if(((Piece) gr.get(a)).getTeam()!=team)
				{
					potential.add(a);
					i=8;
				}
				else
					i=8;	
			}
			else
				i=8;
		}
		
		int j=currentRow-1;
		while(j!=-1)
		{
			Location a = new Location(j, currentCol);
			if(gr.isValid(a)) 
			{
				if(!(gr.get(a) instanceof Piece))
				{
					potential.add(a);
					j--;
				}
				else if(((Piece) gr.get(a)).getTeam()!=team)
				{
					potential.add(a);
					j=-1;
				}
				else
					j=-1;	
			}
		}
		
		int k=currentCol+1;
		while(k!=8)
		{
			Location a = new Location(currentRow, k);
			if(gr.isValid(a)) 
			{
				if(!(gr.get(a) instanceof Piece))
				{
					potential.add(a);
					k++;
				}
				else if(((Piece) gr.get(a)).getTeam()!=team)
				{
					potential.add(a);
					k=8;
				}
				else
					k=8;	
			}
		}
		
		int l=currentCol-1;
		while(l!=-1)
		{
			Location a = new Location(currentRow, l);
			if(gr.isValid(a)) 
			{
				if(!(gr.get(a) instanceof Piece))
				{
					potential.add(a);
					l--;
				}
				else if(((Piece) gr.get(a)).getTeam()!=team)
				{
					potential.add(a);
					l=-1;
				}
				else
					l=-1;	
			}
		}
		
		return potential;
	}
}
