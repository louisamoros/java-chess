package model.observable;

import java.util.Observable;

import model.Couleur;
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
		instance.setChangedAndNotify();
		return isOk;
	}
	
	public String toString(){
		return this.echiquier.toString();
	}
	
	public Couleur getColorCurrentPlayer() {
		return this.echiquier.getColorCurrentPlayer();
	}
	
	public boolean isEnd() {
		return this.echiquier.isEnd();
	}
	
	public String getMessage(){
		return this.echiquier.getMessage();
	}
	
	public void setChangedAndNotify() {
		instance.setChanged();
		instance.notifyObservers();
	}
	
	public void notifyObservers() {
		super.notifyObservers(this.echiquier.getPiecesIHM());
	}
}
