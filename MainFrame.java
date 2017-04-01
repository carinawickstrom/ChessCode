import java.awt.Color;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
	private BoardPanel boardPanel = new BoardPanel();
	public MainFrame(){

		setTitle("Schack");
		setSize(515,565);
		setBackground(Color.black);
		this.add(boardPanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	public void setPiece(int x1,int y1,String piece){
		boardPanel.setPiece(x1,y1,piece);
	}
}
