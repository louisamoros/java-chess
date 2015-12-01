package controler.controlerLocal;

import java.util.List;

import model.Coord;
import model.Couleur;

public interface ChessGameControlers {
	public String getMessage();
	public String toString();
	public boolean isEnd();
	public Couleur getColorCurrentPlayer();
	public void move(Coord coordX, Coord coordY);
	public void getValidMoves(Coord coords);
}
