package model;

import java.util.List;

public class BoardUpdateCommand implements CommandsForUpdate{
	
	private List<PieceIHM> pieceIHMList;
	private final String COMMAND = "BoardUpdate";

	@Override
	public Object getAttribute() {
		return pieceIHMList;
	}

	@Override
	public String getCommand() {
		return COMMAND;
	}


}
