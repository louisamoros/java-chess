package launcher.localLauncher;

import java.util.Observer;

import javax.swing.JFrame;

import model.Couleur;
import model.observable.ChessGame;
import vue.ChessGameGUI;
import controler.controlerLocal.ChessGameControler;

public class LauncherGUIClientServer {
	public static void main(String[] args) {
		
		//**************************
		//LAUNCH SERVER
		//**************************
		boolean isServer = true;
		Couleur couleur = Couleur.BLANC;

		ChessGame chessGameServer = new ChessGame();

		ChessGameControler chessGameControlerServer = new ChessGameControler(
				chessGameServer, isServer, couleur);
		JFrame frameServer = new ChessGameGUI(chessGameControlerServer);

		chessGameServer.addObserver((Observer) frameServer);
		chessGameServer.notifyObservers();

		frameServer.pack();
		frameServer.setVisible(true);
		frameServer.setResizable(false);
		
		//**************************
		//LAUNCH CLIENT
		//**************************
		isServer = false;
		couleur = Couleur.NOIR;
		
		ChessGame chessGameClient = new ChessGame();

		ChessGameControler chessGameControlerClient = new ChessGameControler(
				chessGameClient, isServer, couleur);
		
		JFrame frameClient = new ChessGameGUI(chessGameControlerClient);

		chessGameClient.addObserver((Observer) frameClient);
		chessGameClient.notifyObservers();

		frameClient.pack();
		frameClient.setVisible(true);
		frameClient.setResizable(false);
	}
}
