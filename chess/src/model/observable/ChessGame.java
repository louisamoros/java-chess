package model.observable;

import java.util.Observable;

import model.Couleur;
import model.Echiquier;

public class ChessGame extends Observable{
	
	private Echiquier echiquier;
	
	public ChessGame(){
		super();
		//creation de l'echiquier
		echiquier = new Echiquier();
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
		notifyObservers();
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
		
	public void notifyObservers() {
		super.setChanged();
		super.notifyObservers(this.echiquier.getPiecesIHM());
	}
}
