package vue;

import java.awt.Color;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Coord;
import model.PieceIHM;

public class ColorValidMovesBehavior implements UpdateBehaviors{
	
	private List<Coord> coordsList;
	
	@SuppressWarnings("unchecked")
	public ColorValidMovesBehavior(Object coordsList) {
		this.coordsList = (List<Coord>)coordsList;
	}

	@Override
	public void execute(ChessGameGUI gui) {

		JPanel panel;

		for (Coord coord : coordsList) {
			int value = coord.x + 8 * coord.y;
			panel = (JPanel) gui.chessBoard.getComponent(value);
			panel.setBackground(Color.red);
		}
		
	}

}
