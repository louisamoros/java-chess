package launcher.localLauncher;

import java.awt.Color;
import java.util.Observer;

import javax.swing.JFrame;

import model.Couleur;
import model.observable.ChessGame;
import vue.ChessGameGUI;
import controler.controlerLocal.ChessGameControler;

public class LauncherGUIClient {
	public static void main(String[] args) {

		final boolean isServer = false;
		final Couleur couleur = Couleur.NOIR;
		final Color boardColor = Color.blue;
		
		ChessGame chessGame = new ChessGame();

		ChessGameControler chessGameControler = new ChessGameControler(
				chessGame, isServer, couleur);
		
		JFrame frame = new ChessGameGUI(chessGameControler, boardColor);

		chessGame.addObserver((Observer) frame);
		chessGame.notifyObservers();

		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
