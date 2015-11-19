package launcher.localLauncher;

import java.util.Observer;

import javax.swing.JFrame;

import controler.controlerLocal.ChessGameControler;
import model.observable.ChessGame;
import vue.ChessGameGUI;

public class LauncherGUI {
	public static void main(String[] args) {

		ChessGame chessGame;
		chessGame = ChessGame.getInstance();

		ChessGameControler chessGameControler = new ChessGameControler(chessGame);
		
		JFrame frame = new ChessGameGUI(chessGameControler);
		Observer obs = (Observer) frame;
		frame.pack();
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		chessGame.addObserver(obs);
		
		//obs.update(chessGame, null);
	}

}
