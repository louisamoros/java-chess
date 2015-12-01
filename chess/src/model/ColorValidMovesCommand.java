package model;

import java.util.List;

public class ColorValidMovesCommand implements CommandsForUpdate{

	private List<Coord> coordsList;
	private final String COMMAND = "ColorValidMoves";
	
	public ColorValidMovesCommand(List<Coord> coordsList) {
		this.coordsList = coordsList;
	}
	
	@Override
	public Object getAttribute() {
		return coordsList;
	}

	@Override
	public String getCommand() {
		return COMMAND;
	}

}
