package model.notify;

import java.util.List;

import model.PieceIHM;

public class BoardUpdateCommand implements NotifyCommand{
	
	private List<PieceIHM> pieceIHMList;
	private final String COMMAND = "BoardUpdate";
	
	public BoardUpdateCommand(List<PieceIHM> pieceIHMList) {
		this.pieceIHMList = pieceIHMList;
	}

	@Override
	public Object getAttribute() {
		return pieceIHMList;
	}

	@Override
	public String getCommand() {
		return COMMAND;
	}


}
