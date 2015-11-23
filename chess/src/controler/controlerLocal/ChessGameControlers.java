package controler.controlerLocal;

import model.Coord;
import model.Couleur;

public interface ChessGameControlers {
	public String getMessage();
	public String toString();
	public boolean isEnd();
	public Couleur getColorCurrentPlayer();
	public void move(Coord coordX, Coord coordY);
}
