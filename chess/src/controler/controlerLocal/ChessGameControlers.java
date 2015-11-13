package controler.controlerLocal;

import java.util.List;

import model.Coord;

public interface ChessGameControlers {
	public String getMessage();
	public List<Coord> move(Coord coordX, Coord coordY);
}
