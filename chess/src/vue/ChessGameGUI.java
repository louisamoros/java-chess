package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.Coord;
import controler.controlerLocal.ChessGameControler;

public class ChessGameGUI extends JFrame implements MouseListener,
		MouseMotionListener, Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final short IDX_CASE_MAX = 63;
	ChessGameControler chessGameControler;
	JLayeredPane layeredPane;
	JPanel chessBoard;
	JLabel chessPiece;
	Coord coordInit;
	Coord coordFinal;
	int xAdjustment;
	int yAdjustment;

	public ChessGameGUI(ChessGameControler chessGameCtrl) {
		Dimension boardSize = new Dimension(600, 600);
		this.chessGameControler = chessGameCtrl;

		// Use a Layered Pane for this this application
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane);
		layeredPane.setPreferredSize(boardSize);
		layeredPane.addMouseListener(this);
		layeredPane.addMouseMotionListener(this);

		// Add a chess board to the Layered Pane
		chessBoard = new JPanel();
		layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
		chessBoard.setLayout(new GridLayout(8, 8));
		chessBoard.setPreferredSize(boardSize);
		chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);

		for (int i = 0; i < 64; i++) {
			JPanel square = new JPanel(new BorderLayout());
			chessBoard.add(square);

			int row = (i / 8) % 2;
			if (row == 0)
				square.setBackground(i % 2 == 0 ? Color.black : Color.white);
			else
				square.setBackground(i % 2 == 0 ? Color.white : Color.black);
		}

		JLabel piece = new JLabel(new ImageIcon(
				"./res/images/cavalierBlancS.png"));
		JPanel panel = (JPanel) chessBoard.getComponent(0);
		panel.add(piece);
		piece = new JLabel(new ImageIcon("./res/images/cavalierBlancS.png"));
		panel = (JPanel) chessBoard.getComponent(15);
		panel.add(piece);
		piece = new JLabel(new ImageIcon("./res/images/cavalierBlancS.png"));
		panel = (JPanel) chessBoard.getComponent(16);
		panel.add(piece);
		piece = new JLabel(new ImageIcon("./res/images/cavalierBlancS.png"));
		panel = (JPanel) chessBoard.getComponent(20);
		panel.add(piece);

	}

	public void mousePressed(MouseEvent e) {
		chessPiece = null;
		Component c = chessBoard.findComponentAt(e.getX(), e.getY());

		coordInit = new Coord(e.getX(), e.getY());

		if (c instanceof JPanel)
			return;

		Point parentLocation = c.getParent().getLocation();
		xAdjustment = parentLocation.x - e.getX();
		yAdjustment = parentLocation.y - e.getY();
		chessPiece = (JLabel) c;
		chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
		chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
		layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
	}

	// Move the chess piece around
	public void mouseDragged(MouseEvent me) {
		if (chessPiece == null)
			return;
		chessPiece
				.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
	}

	// Drop the chess piece back onto the chess board
	public void mouseReleased(MouseEvent e) {
		if (chessPiece == null)
			return;
		chessPiece.setVisible(false);

		coordFinal = new Coord(e.getX(), e.getY());
		chessGameControler.move(coordInit, coordFinal);

		// Component c = chessBoard.findComponentAt(e.getX(), e.getY());
		// if (c instanceof JLabel) {
		// Container parent = c.getParent();
		// parent.remove(0);
		// parent.add(chessPiece);
		// } else {
		// Container parent = (Container) c;
		// parent.add(chessPiece);
		// }
		// chessPiece.setVisible(true);
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("View is updated.");
		System.out.println(o);
	}
}
