package controler.controlerLocal;

import java.net.Socket;

import model.Coord;
import model.Couleur;
import model.observable.ChessGame;

public class ChessGameControler implements ChessGameControlers {
	private ChessGame chessGame;
	private boolean isServer;
	private Couleur couleur;
	private Socket socket;

	public ChessGameControler(ChessGame cG, boolean iS, Couleur c) {
		super();
		chessGame = cG;
		couleur = c;
		isServer = iS;
		createSocket();
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
		
		if(couleur.equals(getColorCurrentPlayer())) {
			// Adapt coords
			coordInit.x = coordInit.x / 75;
			coordFinal.x = coordFinal.x / 75;
			coordInit.y = coordInit.y / 75;
			coordFinal.y = coordFinal.y / 75;

			System.out.println("Move from " + coordInit + " to " + coordFinal);
			chessGame.move(coordInit.x, coordInit.y, coordFinal.x, coordFinal.y);			
		} else {
			// Simulate fake moving
			System.out.println("Fake moving because it's not your turn.");
			chessGame.move(-1, -1, -1, -1);
		}
	}
	
	public void createSocket() {
		if(isServer) {
			//instanciate socketio / server config
		} else {
			//instanciate socketio / client config			
		}
	}
	
}
