package controler.controlerLocal;

import model.Coord;
import model.observable.ChessGame;

public class ChessGameControler implements ChessGameControlers {
	private ChessGame chessGame;
	
	public ChessGameControler(ChessGame cG) {
		super();
		chessGame = cG;
	}
	
	public String getMessage() {
		// Return to string of Instance chessGame
		return chessGame.toString();
	}
	
	public void move(Coord coordInit, Coord coordFinal) {
		
		// Adapt coords
		coordInit.x = coordInit.x / 75;
		coordFinal.x = coordFinal.x / 75;
		coordInit.y = coordInit.y / 75;
		coordFinal.y = coordFinal.y / 75;
		
		System.out.println("Move from " + coordInit + " to " + coordFinal);
		chessGame.move(coordInit.x, coordInit.y, coordFinal.x, coordFinal.y);
	}
}
