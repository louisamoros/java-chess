package controler.controlerLocal;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model.Coord;
import model.Couleur;
import model.MoveCoords;
import model.observable.ChessGame;
import socket.ClientSocketConfig;
import socket.ServerSocketConfig;
import socket.SocketManager;

public class ChessGameControler implements ChessGameControlers, Observer {

	private ChessGame chessGame;
	private boolean isServer;
	private Couleur couleur;
	private SocketManager socketManager;

	public ChessGameControler(ChessGame cG, boolean iS, Couleur c) {
		super();
		this.chessGame = cG;
		this.couleur = c;
		this.isServer = iS;
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

		if (couleur.equals(getColorCurrentPlayer())) {
			// Adapt coords
			coordInit.x = coordInit.x / 75;
			coordFinal.x = coordFinal.x / 75;
			coordInit.y = coordInit.y / 75;
			coordFinal.y = coordFinal.y / 75;

			MoveCoords moveCoords = new MoveCoords(coordInit, coordFinal);
			socketManager.send((Object) moveCoords);

			System.out.println("Move from " + coordInit + " to " + coordFinal);
			chessGame
					.move(coordInit.x, coordInit.y, coordFinal.x, coordFinal.y);

		} else {
			// Simulate fake moving
			System.out.println("Fake moving because it's not your turn.");
			chessGame.move(-1, -1, -1, -1);
		}

	}
	
	public void getValidMoves(Coord coords){	
		chessGame.getValidMoves(coords);
	}

	public void createSocket() {
		socketManager = new SocketManager();
		if (isServer) {
			// instanciate socketio / server config
			socketManager.socketConfig = new ServerSocketConfig();
		} else {
			// instanciate socketio / client config
			socketManager.socketConfig = new ClientSocketConfig();
		}

		socketManager.config();
		socketManager.socketReceiver.addObserver(this);
	}

	public SocketManager getSocketManager() {
		return this.socketManager;
	}

	@Override
	public void update(Observable o, Object arg) {

		MoveCoords moveCoords = (MoveCoords) arg;

		// make the opponent's move
		chessGame.move(moveCoords.getInitCoords().x,
				moveCoords.getInitCoords().y, moveCoords.getFinalCoords().x,
				moveCoords.getFinalCoords().y);
		System.out.println("Opponent moves from " + moveCoords.getInitCoords()
				+ " to " + moveCoords.getFinalCoords());

	}

}
