package model;

import java.io.Serializable;

public class MoveCoords implements Serializable{
	
	private Coord initCoords;
	private Coord finalCoords;
	
	public MoveCoords(Coord initCoords, Coord finalCoords)
	{
		this.initCoords = initCoords;
		this.finalCoords = finalCoords;
	}

	public Coord getInitCoords() {
		return initCoords;
	}

	public void setInitCoords(Coord initCoords) {
		this.initCoords = initCoords;
	}

	public Coord getFinalCoords() {
		return finalCoords;
	}

	public void setFinalCoords(Coord finalCoords) {
		this.finalCoords = finalCoords;
	}

}
