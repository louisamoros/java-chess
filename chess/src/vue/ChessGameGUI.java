package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.Coord;
import model.PieceIHM;
import tools.ChessImageProvider;
import controler.controlerLocal.ChessGameControler;

public class ChessGameGUI extends JFrame implements MouseListener,
		MouseMotionListener, Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ChessGameControler chessGameControler;
	JLayeredPane layeredPane;
	JPanel chessBoard;
	JPanel infoBoard;
	JLabel chessInfos = new JLabel();
	JLabel chessPiece;
	Dimension chessBoardSize;
	Dimension infoBoardSize;
	Dimension boardSize;
	Coord coordInit;
	Coord coordFinal;
	int xAdjustment;
	int yAdjustment;

	public ChessGameGUI(ChessGameControler chessGameCtrl) {
		this.chessGameControler = chessGameCtrl;
		this.chessBoardSize = new Dimension(600, 600);
		this.infoBoardSize = new Dimension(400, 600);
		this.boardSize = new Dimension(1000, 600);
		
		// Use a Layered Pane for this this application
		initializeLayeredPane();

		// Add a chess board to the Layered Pane
		initializeChessBoard();
		
		// Add a info board to the Layered Pane
		initializeInfoBoard();
	}

	private void initializeInfoBoard() {
		infoBoard = new JPanel();
		layeredPane.add(infoBoard, JLayeredPane.DEFAULT_LAYER);
		infoBoard.setLayout(new FlowLayout(FlowLayout.LEFT));
		infoBoard.setPreferredSize(infoBoardSize);
		infoBoard.setBounds(chessBoardSize.width, 0, infoBoardSize.width, infoBoardSize.height);
		infoBoard.setBackground(Color.orange);
		infoBoard.add(chessInfos);
	}

	private void initializeChessBoard() {
		chessBoard = new JPanel();
		layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
		chessBoard.setLayout(new GridLayout(8, 8));
		chessBoard.setPreferredSize(chessBoardSize);
		chessBoard.setBounds(0, 0, chessBoardSize.width, chessBoardSize.height);
		chessBoard.addMouseListener(this);
		chessBoard.addMouseMotionListener(this);

		for (int i = 0; i < 64; i++) {
			JPanel square = new JPanel(new BorderLayout());
			chessBoard.add(square);

			int row = (i / 8) % 2;
			if (row == 0)
				square.setBackground(i % 2 == 0 ? Color.white : Color.black);
			else
				square.setBackground(i % 2 == 0 ? Color.black : Color.white);
		}
	}

	private void initializeLayeredPane() {
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane);
		layeredPane.setPreferredSize(boardSize);
	}

	public void mousePressed(MouseEvent e) {
		chessPiece = null;
		Component c = chessBoard.findComponentAt(e.getX(), e.getY());

		if (c instanceof JPanel)
			return;

		Point parentLocation = c.getParent().getLocation();
		coordInit = new Coord(parentLocation.x, parentLocation.y);
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
		Component c = chessBoard.findComponentAt(e.getX(), e.getY());
		Point parentLocation;
		
		if (c instanceof JLabel) {
			Container parent = c.getParent();
			parentLocation = parent.getLocation();
		} else {
			Container parent = (Container) c;
			parentLocation = parent.getLocation();
		 }
		
		coordFinal = new Coord(parentLocation.x, parentLocation.y); 
		chessGameControler.move(coordInit, coordFinal);
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
		JLabel piece;
		JPanel panel;
		
		LinkedList<PieceIHM> piecesList = (LinkedList<PieceIHM>) arg;
		
		for(Component c : chessBoard.getComponents())
		{
			panel = (JPanel)c;
			panel.removeAll();	
		}

		for(PieceIHM currentPiece : piecesList)
		{
			for(Coord coord : currentPiece.getList())
			{
				piece = new JLabel(new ImageIcon(ChessImageProvider.getImageFile(currentPiece.getTypePiece(),currentPiece.getCouleur())));
				int value = coord.x + 8 * coord.y;
				panel = (JPanel) chessBoard.getComponent(value);
				panel.add(piece);
			}
		}
		
		chessBoard.revalidate();
		chessBoard.repaint();
		//chessBoard.updateUI();
		layeredPane.updateUI();
		
		System.out.println(chessGameControler.getMessage());
		String prepareStr = chessGameControler.getMessage() +  "<br>"  + chessInfos.getText();
		chessInfos.setText("");
		chessInfos.setText("<html>" + prepareStr + "</html>");

	}
}
