package vue.update;

import java.awt.Component;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Coord;
import model.PieceIHM;
import tools.ChessImageProvider;
import vue.ChessGameGUI;

public class BoardUpdateBehavior implements UpdateCommand{
	
	private List<PieceIHM> piecesList;
	
	public BoardUpdateBehavior(Object piecesList) {
		this.piecesList = (List<PieceIHM>)piecesList;
	}


	@Override
	public void execute(ChessGameGUI gui) {
		JLabel piece;
		JPanel panel;

		clearBoard(gui);

		for (PieceIHM currentPiece : piecesList) {
			for (Coord coord : currentPiece.getList()) {
				piece = new JLabel(new ImageIcon(
						ChessImageProvider.getImageFile(
								currentPiece.getTypePiece(),
								currentPiece.getCouleur())));
				int value = coord.x + 8 * coord.y;
				panel = (JPanel) gui.chessBoard.getComponent(value);
				panel.add(piece);
			}
		}

		gui.chessBoard.revalidate();
		gui.chessBoard.repaint();

		System.out.println(gui.chessGameControler.getMessage());
		String prepareStr = gui.chessGameControler.getMessage() + "<br>"
				+ gui.chessInfos.getText();
		gui.chessInfos.setText("");
		gui.chessInfos.setText("<html>" + prepareStr + "</html>");
	}
	
	private void clearBoard(ChessGameGUI gui) {
		JPanel panel;

		for (Component c : gui.chessBoard.getComponents()) {
			panel = (JPanel) c;
			panel.removeAll();
		}
	}

}
