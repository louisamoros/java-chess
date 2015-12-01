package model.notify;

import java.util.List;

import model.Coord;

public class ColorValidMovesCommand implements NotifyCommand{

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
