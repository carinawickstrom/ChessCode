import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardPanel extends JPanel{
	private JButton[][] boardGraphics;
	
	public BoardPanel(){
		this.setLayout(new GridLayout(8,8));
		boardGraphics = new JButton[8][8];
		
		for(int y=0;y<8;y++){
			for(int x=0;x<8;x++){
				boardGraphics[x][y] = new JButton();
				this.add(boardGraphics[x][y]);
				
				if(x%2==0 && y%2==0 || x%2==1 && y%2==1){
					boardGraphics[x][y].setBackground(Color.white);
				}else{
					boardGraphics[x][y].setBackground(Color.gray);
				}
			}
		}
	}
	public void setPiece(int x1,int y1, String piece){
	    boardGraphics[x1][y1].setText(piece);
	}

}
