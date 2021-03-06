import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.GroupLayout.Alignment;

abstract public class ChessBoard extends JPanel implements MouseListener {
	

	private ChessGrid[][] board;
	private int maxX,maxY;
	protected Image boardImg;

	
	
	ChessBoard(int maxX,int maxY){
		
		this.maxX = maxX;
		this.maxY = maxY;
		
		setLayout(new GridLayout(10, 9, 0, 0));
		
		
		board = new ChessGrid[maxY][maxX];		
		
		for(int y=0;y<maxY;y++)
		{
			for(int x=0;x<maxX;x++)
			{	
				board[y][x] = new ChessGrid();
				board[y][x].setPreferredSize(new Dimension(50,50));
				add(board[y][x]);
			}
		}

	}
	
	public Chess getChess(int axisX ,int axisY){		
		
		return board[axisY][axisX].getChess();
	}
	
	public void setChess(int axisX ,int axisY ,Chess c){
		
		board[axisY][axisX].setChess(c);	
		/*c.setSize(this.getSize());
		c.setBounds(axisX*60,axisY*60,60,60);*/
	}
	
	public void removeChess(int axisX ,int axisY){
		this.remove(board[axisY][axisX].getChess());
		board[axisY][axisX].removeChess();		
	}
	
	 public void paintComponent(Graphics g) {
		 
		 super.paintComponent(g);		 
		 Image boardImg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("ChChessBroad.jpg"));			 
		 g.drawImage(boardImg, 0, 0, null);
	 }
	 
	public String getTotalInfo(){
		
		String boardInfo = new String();
				
		
		for(int y=0;y<maxY;y++)
		{
			boardInfo = boardInfo+"\n";
			for(int x=0;x<maxX;x++)
			{
				
				boardInfo = boardInfo + board[y][x].getChessType();
			}
		}


		return boardInfo;
	}

	abstract public void newGameFactory(Player p1 ,Player p2);
}
