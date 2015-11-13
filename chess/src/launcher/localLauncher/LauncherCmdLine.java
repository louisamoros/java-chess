package launcher.localLauncher;

import model.observable.ChessGame;
import vue.ChessGameCmdLine;
import controler.controlerLocal.ChessGameControler;


/**
 * @author francoise.perrin
 * Lance l'exécution d'un jeu d'échec en mode console.
 */
public class LauncherCmdLine {
	
	public static void main(String[] args) {		
		
		ChessGame chessGame;
		ChessGameControler chessGameControler;		
		
		chessGame = ChessGame.getInstance();	
		chessGameControler = new ChessGameControler(chessGame);
		
		ChessGameCmdLine o = new ChessGameCmdLine(chessGameControler);	
		chessGame.addObserver(o);
	}

}
