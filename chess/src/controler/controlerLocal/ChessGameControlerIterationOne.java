package controler.controlerLocal;

import model.Coord;
import model.Couleur;
import model.observable.ChessGame;

public class ChessGameControlerIterationOne implements ChessGameControlers {
	private ChessGame chessGame;

	public ChessGameControlerIterationOne(ChessGame cG) {
		super();
		chessGame = cG;
	}

	public String getMessage() {
		return chessGame.getMessage();
	}

	public String toString() {
		return chessGame.toString();
	}

	public boolean isEnd() {
		return chessGame.isEnd();
	}

	public Couleur getColorCurrentPlayer() {
		return chessGame.getColorCurrentPlayer();
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
