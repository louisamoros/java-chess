package model.observable;

import java.util.Observable;

import model.Echiquier;

public class ChessGame extends Observable{
	
	private static boolean isInstance;
	private Echiquier echiquier;
	
	private ChessGame(){
		super();
		//creation de l'echiquier
		echiquier = new Echiquier();
	}
	
	//make sure we have only one instance of Chessgame
	public static ChessGame getInstance(){
		if(!isInstance){
			isInstance = true;
			return new ChessGame();
		}
		else
			return null;
	}
	
	/**
	 * vérifie si le déplacement est possible
	 * effectue le déplacement s’il est possible
	 * effectue aussi le changement de joueur si le déplacement est OK
	 */
	public boolean move(int xInit, int yInit, int xFinal, int yFinal){
		if(echiquier.isMoveOk(xInit, yInit, xFinal, yFinal))
			if(echiquier.move(xInit, yInit, xFinal, yFinal))
				return true;
		return false;
	}
	
	public String toString(){
		return echiquier.toString();
	}
}
