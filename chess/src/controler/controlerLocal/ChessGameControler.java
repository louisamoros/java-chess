package controler.controlerLocal;

import java.util.List;

import model.Coord;
import model.observable.ChessGame;

public class ChessGameControler implements ChessGameControlers {
	private List<Coord> coordonnees;
	private ChessGame chessGame;
	
	public ChessGameControler(ChessGame cG) {
		super();
		chessGame = cG;
	}
	
	public String getMessage() {
		// Return to string of Instance chessGame
		return chessGame.toString();
	}
	
	public List<Coord> move(Coord coordX, Coord coordY) {
		coordonnees.add(coordX);
		coordonnees.add(coordY);
		return coordonnees;
	}
}
