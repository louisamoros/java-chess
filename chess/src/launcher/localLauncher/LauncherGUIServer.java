package launcher.localLauncher;

import java.awt.Color;
import java.util.Observer;

import javax.swing.JFrame;

import model.Couleur;
import model.observable.ChessGame;
import vue.ChessGameGUI;
import controler.controlerLocal.ChessGameControler;

public class LauncherGUIServer {
	public static void main(String[] args) {

		final boolean isServer = true;
		final Couleur couleur = Couleur.BLANC;
		final Color boardColor = Color.black;

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
