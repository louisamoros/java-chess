package controler.controlerLocal;

import java.util.List;

import model.Coord;
import model.observable.ChessGame;

public class ChessGameControler implements ChessGameControlers {
	private String message;
	private List<Coord> coordonnees;
	private ChessGame chessGame;
	
	public String getMessage() {
		//message = chessGame all messages no matter what it is.
		return null;
	}
	
	public List<Coord> move(Coord coordX, Coord coordY) {
		coordonnees.add(coordX);
		coordonnees.add(coordY);
		return coordonnees;
	}
}
