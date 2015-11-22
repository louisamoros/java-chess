package model.observable;

import java.util.Observable;

import model.Echiquier;

public class ChessGame extends Observable{
	
	private static ChessGame instance = null;
	private Echiquier echiquier;
	
	private ChessGame(){
		super();
		//creation de l'echiquier
		echiquier = new Echiquier();
	}
	
	//make sure we have only one instance of Chessgame
	public static ChessGame getInstance(){
		if(instance == null)
			instance = new ChessGame();
			
		return instance;
	}
	
	/**
	 * vérifie si le déplacement est possible
	 * effectue le déplacement s’il est possible
	 * effectue aussi le changement de joueur si le déplacement est OK
	 */
	public boolean move(int xInit, int yInit, int xFinal, int yFinal){
		boolean isOk = false;
		if(echiquier.isMoveOk(xInit, yInit, xFinal, yFinal)) {
			if(echiquier.move(xInit, yInit, xFinal, yFinal)) {
				echiquier.switchJoueur();
				isOk = true;
			}
		}
		System.out.println(this.echiquier.getMessage());
		instance.setChangedAndNotify();
		return isOk;
	}
	
	public String toString(){
		return echiquier.toString();
	}
	
	public void setChangedAndNotify() {
		instance.setChanged();
		instance.notifyObservers();
	}
	
	public void notifyObservers() {
		super.notifyObservers(this.echiquier.getPiecesIHM());
	}
}
