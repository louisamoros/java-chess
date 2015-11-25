package launcher.localLauncher;

import java.util.Observer;

import javax.swing.JFrame;

import model.observable.ChessGame;
import vue.ChessGameGUI;
import controler.controlerLocal.ChessGameControler;

public class LauncherGUIClient {
	public static void main(String[] args) {

		ChessGame chessGame;
		chessGame = ChessGame.getInstance();

		ChessGameControler chessGameControler = new ChessGameControler(
				chessGame);
		JFrame frame = new ChessGameGUI(chessGameControler);

		chessGame.addObserver((Observer) frame);
		chessGame.notifyObservers();

		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		
		//Recup socket

	}
}
