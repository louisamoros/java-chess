package model;

import java.util.List;

public class ColorValidMovesCommand implements CommandsForUpdate{

	private List<Coord> coordsList;
	private final String COMMAND = "ColorValidMoves";
	
	@Override
	public Object getAttribute() {
		return coordsList;
	}

	@Override
	public String getCommand() {
		return COMMAND;
	}

}
