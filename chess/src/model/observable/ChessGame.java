package model.observable;

import java.util.Observable;

import controler.controlerLocal.ChessGameControler;
import controler.controlerLocal.ChessGameControlers;
import vue.ChessGameCmdLine;
import model.Echiquier;

public class ChessGame extends Observable{
	
	private static boolean isInstance;
	private Echiquier echiquier;
	private ChessGameControlers controler;
		
	
	private ChessGame(){
		super();
		//creation de l'echiquier
		echiquier = new Echiquier();
		controler = new ChessGameControler();
		
		//add 2 views as observer
		addObserver(new ChessGameCmdLine((ChessGameControler)controler));
		addObserver(new ChessGameCmdLine((ChessGameControler)controler));
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
