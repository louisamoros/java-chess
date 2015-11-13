package controler.controlerLocal;

import java.util.ArrayList;
import java.util.List;

import model.Coord;
import model.observable.ChessGame;

public class ChessGameControler implements ChessGameControlers {
	private List<Coord> coordonnees;
	private ChessGame chessGame;
	
	public ChessGameControler(ChessGame cG) {
		super();
		chessGame = cG;
		coordonnees = new ArrayList<Coord>();
	}
	
	public String getMessage() {
		// Return to string of Instance chessGame
		return chessGame.toString();
	}
	
	public void move(Coord coordInit, Coord coordFinal) {
		chessGame.move(coordInit.x, coordInit.y, coordFinal.x, coordFinal.y);
	}
}
