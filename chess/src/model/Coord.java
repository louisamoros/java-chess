package model;

import java.io.Serializable;

/**
 * @author francoise.perrin
 *
 */
public class Coord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int x, y;

	/**
	 * @param x
	 * @param y
	 */
	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}

	/**
	 * @param x
	 * @param y
	 * @return true si les coordonn�es sont valides (dans un plateau de 8*8)
	 */
	public static boolean coordonnees_valides(int x, int y) {
		return ((x <= 7) && (x >= 0) && (y <= 7) && (y >= 0));
	}
}
