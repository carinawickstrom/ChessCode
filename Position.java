import java.util.ArrayList;
import java.util.List;

public class Position{
    private  Piece[][] matrix = new Piece[8][8];
    private  List<int[]> moveTo = new ArrayList<int[]>();
    private  List<int[]> history = new ArrayList<int[]>();
    private int varValue;
    private int gen = 0;
    private int child = 0;
    
    public Position(){
        
        for(int x=0;x<8;x++){
            for(int y=0;y<8;y++){   
                matrix[x][y]=new Piece(".", '.', 0);
            }
        }
        
        for(int x=0;x<8;x++){   
            matrix[x][1]=new Piece("pawn", 'b', 100);
            matrix[x][6]=new Piece("pawn", 'w', 100);
        }
        
        matrix[0][0]=new Piece("Rook", 'b', 525);
        matrix[1][0]=new Piece("Knight", 'b', 350);
        matrix[2][0]=new Piece("Bishop", 'b', 350);
        matrix[3][0]=new Piece("Queen", 'b', 1000);
        matrix[4][0]=new Piece("King", 'b', 10000);
        matrix[5][0]=new Piece("Bishop", 'b', 350);
        matrix[6][0]=new Piece("Knight", 'b', 350);
        matrix[7][0]=new Piece("Rook", 'b', 525);
        
        matrix[0][7]=new Piece("Rook", 'w', 525);
        matrix[1][7]=new Piece("Knight", 'w', 350);
        matrix[2][7]=new Piece("Bishop", 'w', 350);
        matrix[3][7]=new Piece("Queen", 'w', 1000);
        matrix[4][7]=new Piece("King", 'w', 10000);
        matrix[5][7]=new Piece("Bishop", 'w', 350);
        matrix[6][7]=new Piece("Knight", 'w', 350);
        matrix[7][7]=new Piece("Rook", 'w', 525);
        
    }
    public void setPositionalValue(String pieceName, char pieceColor, int x, int y, int value){
        if(
        matrix[x][y].getName().equals(pieceName)&&
        matrix[x][y].getColor()==(pieceColor)
        ){
            if(pieceColor=='w'){
                varValue += value;
            }
            else if(pieceColor=='b'){
                varValue -= value;
            }
        }
    }
    public void setPiece(int x, int y, Piece piece){
        matrix[x][y]=piece;
    }
    public Piece getPiece(int x, int y){
        if(
        x>-1 &&
        x<8 &&
        y>-1 &&
        y<8 
        ){
            return matrix[x][y];
        }else{
            return new Piece("empty", 'x', 0);
        }
    }
    
    public void display(){
        for(int y=0;y<8;y++){   
            for(int x=0;x<8;x++){
                System.out.print(matrix[x][y].getName() + "\t");
            }
            System.out.println();     
        }
        System.out.println();
    }
    
    public void movePiece(int x1, int y1, int x2, int y2){
    
        matrix[x2][y2]=matrix[x1][y1];
        matrix[x1][y1]=new Piece(".", '.', 0);
        
    }
    
    int getVarValue(){
        return varValue;
    }
    void setVarValue(int d){
        varValue=d;
    }
    
    int getAmountOfLegalMoves(){
        return moveTo.size();
    }
    void clearLegalMoves(){
        moveTo.clear();
    }
    
    int getBranch(){
        return gen;
    }
    void setBranch(int d){
        gen=d;
    }
    
    int getChild(){
        return child;
    }
    void setChild(int d){
        child=d;
    }
    
    void setLegalMoves(int x1, int y1, int x2, int y2) {
        
        if(
        y2>-1 &&
        y2<8 &&
        x2>-1 &&
        x2<8 
        ){
        
                moveTo.add(new int[4]);
            moveTo.get(moveTo.size()-1)[0]=x1;
            moveTo.get(moveTo.size()-1)[1]=y1;
            moveTo.get(moveTo.size()-1)[2]=x2;
            moveTo.get(moveTo.size()-1)[3]=y2;
        
        }
        else{
            //System.err.println("illegal move was added");
        }
    }
    
    void addToHistory(int x1, int y1, int x2, int y2) {
        
        history.add(new int[4]);
        history.get(history.size()-1)[0]=x1;
        history.get(history.size()-1)[1]=y1;
        history.get(history.size()-1)[2]=x2;
        history.get(history.size()-1)[3]=y2;
        
    }
    
    List<int[]> getLegalMoves(){
        return moveTo;
    }
    
    List<int[]> getHistory(){
        return history;
    }
    
    Piece[][] getMatrix(){
        return matrix;
    }
}
