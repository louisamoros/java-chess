package launcher.localLauncher;

import java.util.Observer;

import javax.swing.JFrame;

import model.observable.ChessGame;
import vue.ChessGameGUI;

public class LauncherGUI {
	public static void main(String[] args) {

		ChessGame chessGame;
		chessGame = ChessGame.getInstance();

		JFrame frame = new ChessGameGUI();
		frame.pack();
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		chessGame.addObserver((Observer) frame);
	}

}
