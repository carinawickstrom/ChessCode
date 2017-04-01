import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChessClass{
    
    private static List<Position> positionList = new ArrayList<Position>();
    private static List<Integer> howDidIGetHere = new ArrayList<Integer>();
    private static int childCount = 0;
    private static int branchCount = 0;
    private static int depth = 3;
    
    private static MainFrame mainFrame;
    
    public ChessClass(){}
    
    public static void updateLegalMoves(int color, Position p){
        char opposingColor='.';
        if(color=='w'){opposingColor='b';}
        else if(color=='b'){opposingColor='w';}
        
        if(color=='w'){
            for(int y=0;y<8;y++){
                for(int x=0;x<8;x++){
                    //vit bonde
                    if(p.getPiece(x,y).getName().equals("pawn")&&
                    p.getPiece(x,y).getColor()== 'w'
                    ){
                        //bonde
                        if(p.getPiece(x,y-1).getName().equals(".")){
                            p.setLegalMoves(x,y,x,y-1);
                        }
                        
                        if(
                        y==6&&
                        p.getPiece(x,y-1).getName().equals(".")&&
                        p.getPiece(x,y-2).getName().equals(".")
                        
                        ){
                            p.setLegalMoves(x,y,x,y-2);
                        }
                        
                        if(p.getPiece(x-1,y-1).getColor()==opposingColor){
                            p.setLegalMoves(x,y,x-1,y-1);
                        }
                        if(p.getPiece(x+1,y-1).getColor()==opposingColor){
                            p.setLegalMoves(x,y,x+1,y-1);
                        }
                    }
                }
            }
        }
        if(color=='b'){
            for(int y=0;y<8;y++){
                for(int x=0;x<8;x++){
                    if(p.getPiece(x,y).getName().equals("pawn")&&
                    p.getPiece(x,y).getColor()== 'b' ){
                        //bonde
                        if(p.getPiece(x,y+1).getName().equals(".")){
                            p.setLegalMoves(x,y,x,y+1);
                        }
                        if(
                        y==1&&
                        p.getPiece(x,y+1).getName().equals(".")&&
                        p.getPiece(x,y+2).getName().equals(".")
                        ){
                            p.setLegalMoves(x,y,x,y+2);
                        }
                        if(p.getPiece(x-1,y+1).getColor()==opposingColor){
                            p.setLegalMoves(x,y,x-1,y+1);
                        }
                        if(p.getPiece(x+1,y+1).getColor()==opposingColor){
                            p.setLegalMoves(x,y,x+1,y+1);
                        }
                    }
                }
            }
        }
        
        for(int y=0;y<8;y++){
            for(int x=0;x<8;x++){
                if(p.getPiece(x,y).getColor()==color){
                    //vita pjäser
                    if(p.getPiece(x,y).getName().equals("Knight") ){
                        //springare
                        if(
                        p.getPiece(x-1,y-2).getColor() == opposingColor || 
                        p.getPiece(x-1,y-2).getColor() == '.'
                        ){
                            p.setLegalMoves(x,y,x-1,y-2);
                        }
                        if(
                        p.getPiece(x-2,y-1).getColor() == opposingColor || 
                        p.getPiece(x-2,y-1).getColor() == '.'
                        ){
                            p.setLegalMoves(x,y,x-2,y-1);
                        }
                        if(
                        p.getPiece(x-2,y+1).getColor() == opposingColor || 
                        p.getPiece(x-2,y+1).getColor() == '.'
                        ){
                            p.setLegalMoves(x,y,x-2,y+1);
                        }
                        if(
                        p.getPiece(x-1,y+2).getColor() == opposingColor || 
                        p.getPiece(x-1,y+2).getColor() == '.'
                        ){
                            p.setLegalMoves(x,y,x-1,y+2);
                        }
                        if(
                        p.getPiece(x+1,y+2).getColor() == opposingColor || 
                        p.getPiece(x+1,y+2).getColor() == '.'
                        ){
                            p.setLegalMoves(x,y,x+1,y+2);
                        }
                        if(
                        p.getPiece(x+2,y+1).getColor() == opposingColor || 
                        p.getPiece(x+2,y+1).getColor() == '.'
                        ){
                            p.setLegalMoves(x,y,x+2,y+1);
                        }
                        if(
                        p.getPiece(x+2,y-1).getColor() == opposingColor || 
                        p.getPiece(x+2,y-1).getColor() == '.'
                        ){
                            p.setLegalMoves(x,y,x+2,y-1);
                        }
                        if(
                        p.getPiece(x+1,y-2).getColor() == opposingColor || 
                        p.getPiece(x+1,y-2).getColor() == '.'
                        ){
                            p.setLegalMoves(x,y,x+1,y-2);
                        }
                    }
                   
                    if(p.getPiece(x,y).getName().equals("Bishop") ){
                        //löpare
                        for(int i=1;i<8;i++){
                            if(p.getPiece(x+i,y+i).getColor()==color){
                                break;
                            }//if obsticle
                            p.setLegalMoves(x,y,x+i,y+i);
                            if(p.getPiece(x+i,y+i).getColor()==opposingColor){
                                break;
                            }//if obsticle
                        }
                        for(int i=1;i<8;i++){
                            if(p.getPiece(x+i,y-i).getColor()==color){
                                break;
                            }//if obsticle
                            p.setLegalMoves(x,y,x+i,y-i);
                            if(p.getPiece(x+i,y-i).getColor()==opposingColor){
                                break;
                            }//if obsticle
                        }
                        
                        for(int i=1;i<8;i++){
                            if(p.getPiece(x-i,y-i).getColor()==color){
                                break;
                            }//if obsticle
                            p.setLegalMoves(x,y,x-i,y-i);
                            if(p.getPiece(x-i,y-i).getColor()==opposingColor){
                                break;
                            }//if obsticle
                        }
                        for(int i=1;i<8;i++){
                            if(p.getPiece(x-i,y+i).getColor()==color){
                                break;
                            }//if obsticle
                            p.setLegalMoves(x,y,x-i,y+i);
                            if(p.getPiece(x-i,y+i).getColor()==opposingColor){
                                break;
                            }//if obsticle
                        }
                    }
                    
                    if(p.getPiece(x,y).getName().equals("Rook") ){
                        //torn
                        for(int i=1;i<8;i++){
                            if(p.getPiece(x,y+i).getColor()==color){
                                break;
                            }//if obsticle
                            p.setLegalMoves(x,y,x,y+i);
                            if(p.getPiece(x,y+i).getColor()==opposingColor){
                                break;
                            }//if obsticle
                        }
                        for(int i=1;i<8;i++){
                            if(p.getPiece(x,y-i).getColor()==color){
                                break;
                            }//if obsticle
                            p.setLegalMoves(x,y,x,y-i);
                            if(p.getPiece(x,y-i).getColor()==opposingColor){
                                break;
                            }//if obsticle
                        }
                        for(int i=1;i<8;i++){
                            if(p.getPiece(x+i,y).getColor()==color){
                                break;
                            }//if obsticle
                            p.setLegalMoves(x,y,x+i,y);
                            if(p.getPiece(x+i,y).getColor()==opposingColor){
                                break;
                            }//if obsticle
                        }
                        for(int i=1;i<8;i++){
                            if(p.getPiece(x-i,y).getColor()==color){
                                break;
                            }//if obsticle
                            p.setLegalMoves(x,y,x-i,y);
                            if(p.getPiece(x-i,y).getColor()==opposingColor){
                                break;
                            }//if obsticle
                        }
                    }
                    
                    if(p.getPiece(x,y).getName().equals("Queen") ){
                        //löpare
                        for(int i=1;i<8;i++){
                            if(p.getPiece(x+i,y+i).getColor()==color){
                                break;
                            }//if obsticle
                            p.setLegalMoves(x,y,x+i,y+i);
                            if(p.getPiece(x+i,y+i).getColor()==opposingColor){
                                break;
                            }//if obsticle
                        }
                        for(int i=1;i<8;i++){
                            if(p.getPiece(x+i,y-i).getColor()==color){
                                break;
                            }//if obsticle
                            p.setLegalMoves(x,y,x+i,y-i);
                            if(p.getPiece(x+i,y-i).getColor()==opposingColor){
                                break;
                            }//if obsticle
                        }
                        
                        for(int i=1;i<8;i++){
                            if(p.getPiece(x-i,y-i).getColor()==color){
                                break;
                            }//if obsticle
                            p.setLegalMoves(x,y,x-i,y-i);
                            if(p.getPiece(x-i,y-i).getColor()==opposingColor){
                                break;
                            }//if obsticle
                        }
                        for(int i=1;i<8;i++){
                            if(p.getPiece(x-i,y+i).getColor()==color){
                                break;
                            }//if obsticle
                            p.setLegalMoves(x,y,x-i,y+i);
                            if(p.getPiece(x-i,y+i).getColor()==opposingColor){
                                break;
                            }//if obsticle
                        }
                        
                        //torn
                        for(int i=1;i<8;i++){
                            if(p.getPiece(x,y+i).getColor()==color){
                                break;
                            }//if obsticle
                            p.setLegalMoves(x,y,x,y+i);
                            if(p.getPiece(x,y+i).getColor()==opposingColor){
                                break;
                            }//if obsticle
                        }
                        for(int i=1;i<8;i++){
                            if(p.getPiece(x,y-i).getColor()==color){
                                break;
                            }//if obsticle
                            p.setLegalMoves(x,y,x,y-i);
                            if(p.getPiece(x,y-i).getColor()==opposingColor){
                                break;
                            }//if obsticle
                        }
                        for(int i=1;i<8;i++){
                            if(p.getPiece(x+i,y).getColor()==color){
                                break;
                            }//if obsticle
                            p.setLegalMoves(x,y,x+i,y);
                            if(p.getPiece(x+i,y).getColor()==opposingColor){
                                break;
                            }//if obsticle
                        }
                        for(int i=1;i<8;i++){
                            if(p.getPiece(x-i,y).getColor()==color){
                                break;
                            }//if obsticle
                            p.setLegalMoves(x,y,x-i,y);
                            if(p.getPiece(x-i,y).getColor()==opposingColor){
                                break;
                            }//if obsticle
                        }
                    }
                    if(p.getPiece(x,y).getName().equals("King") ){
                        if(
                        p.getPiece(x-1,y-1).getColor() == opposingColor || 
                        p.getPiece(x-1,y-1).getColor() == '.'
                        ){
                            p.setLegalMoves(x,y,x-1,y-1);
                        }
                        if(
                        p.getPiece(x,y-1).getColor() == opposingColor || 
                        p.getPiece(x,y-1).getColor() == '.'
                        ){
                            p.setLegalMoves(x,y,x,y-1);
                        }
                        if(
                        p.getPiece(x+1,y-1).getColor() == opposingColor || 
                        p.getPiece(x+1,y-1).getColor() == '.'
                        ){
                            p.setLegalMoves(x,y,x+1,y-1);
                        }
                        
                        if(
                        p.getPiece(x-1,y).getColor() == opposingColor || 
                        p.getPiece(x-1,y).getColor() == '.'
                        ){
                            p.setLegalMoves(x,y,x-1,y);
                        }
                        if(
                        p.getPiece(x+1,y).getColor() == opposingColor || 
                        p.getPiece(x+1,y).getColor() == '.'
                        ){
                            p.setLegalMoves(x,y,x+1,y);
                        }
                    
                        if(
                        p.getPiece(x-1,y+1).getColor() == opposingColor || 
                        p.getPiece(x-1,y+1).getColor() == '.'
                        ){
                            p.setLegalMoves(x,y,x-1,y+1);
                        }
                        if(
                        p.getPiece(x,y+1).getColor() == opposingColor || 
                        p.getPiece(x,y+1).getColor() == '.'
                        ){
                            p.setLegalMoves(x,y,x,y+1);
                        }
                        if(
                        p.getPiece(x+1,y+1).getColor() == opposingColor || 
                        p.getPiece(x+1,y+1).getColor() == '.'
                        ){
                            p.setLegalMoves(x,y,x+1,y+1);
                        }
                    }
                }
            }
        }
    }
    
    public static void createChildren(Position p){
        
        childCount=0;
        branchCount++;
        
        for(int i=0;i<p.getAmountOfLegalMoves();i++){
            
            positionList.add(new Position());
            
            for(int mo=0;mo<howDidIGetHere.size()/4;mo++){
            
                positionList.get(positionList.size()-1).movePiece(
                
                howDidIGetHere.get(0+4*mo),
                howDidIGetHere.get(1+4*mo),
                howDidIGetHere.get(2+4*mo),
                howDidIGetHere.get(3+4*mo));
                
            }
            
            for(int k=0;k<p.getHistory().size();k++){
                
                
                positionList.get(positionList.size()-1).movePiece(
                
                p.getHistory().get(k)[0],
                p.getHistory().get(k)[1],
                p.getHistory().get(k)[2],
                p.getHistory().get(k)[3] 
                
                );
                
                //spela ut ställningen enligt histprien på brädet
                
                positionList.get(positionList.size()-1).addToHistory(
                
                p.getHistory().get(k)[0],
                p.getHistory().get(k)[1],
                p.getHistory().get(k)[2],
                p.getHistory().get(k)[3] 
                
                );
                
                //för vidare historien till barn
                
                
            }
            
            positionList.get(positionList.size()-1).movePiece(
            
            p.getLegalMoves().get(i)[0],
            p.getLegalMoves().get(i)[1],
            p.getLegalMoves().get(i)[2],
            p.getLegalMoves().get(i)[3]);
            
            positionList.get(positionList.size()-1).setBranch(branchCount);
            positionList.get(positionList.size()-1).setChild(childCount);
            childCount++;
            
            positionList.get(positionList.size()-1).addToHistory(
            
            p.getLegalMoves().get(i)[0],
            p.getLegalMoves().get(i)[1],
            p.getLegalMoves().get(i)[2],
            p.getLegalMoves().get(i)[3]);
        }
    }
    
    public static void calculate(){
        
        positionList.clear();
        positionList.add(new Position());
        
        for(int mo=0;mo<howDidIGetHere.size()/4;mo++){
            
            positionList.get(0).movePiece(
                
            howDidIGetHere.get(0+4*mo),
            howDidIGetHere.get(1+4*mo),
            howDidIGetHere.get(2+4*mo),
            howDidIGetHere.get(3+4*mo));
                
        }
        
        int i = 0;
        
        // Skapar ett träd med djupet "depth"
        while(positionList.get(positionList.size()-1).getHistory().size()<depth+1){
            
            // Om trädets slutnoder ligger på ett jämnt djup så är det vits tur
            if(positionList.get(i).getHistory().size()%2==0){
                
                // Anropar metoden updateLegalMoves() 
                // som hittar alla lagliga drag för de vita pjäserna
                
                updateLegalMoves('w',(positionList.get(i)));
                
                // Anropar metoden createChildren() 
                // som skapar barn-noder utifrån de senast tillagda lagliga dragen
                
                createChildren(positionList.get(i));
                
            }
            
            // Om trädets slutnoder ligger på ett ojämnt djup så är det istället svarts tur
            if(positionList.get(i).getHistory().size()%2==1){
                
                updateLegalMoves('b',(positionList.get(i)));
                createChildren(positionList.get(i));
                
            }
            
            i++;
        }
    }
    
    public static void addPositionalValue(Position p){
       p.setPositionalValue("pawn", 'w', 3, 4, 30);
       p.setPositionalValue("pawn", 'w', 4, 4, 30);
      
       p.setPositionalValue("pawn", 'b', 3, 3, 30);
       p.setPositionalValue("pawn", 'b', 4, 3, 30);
       
       p.setPositionalValue("Knight", 'w', 2, 5, 25);
       p.setPositionalValue("Knight", 'w', 5, 5, 25);
       
       p.setPositionalValue("Bishop", 'w', 2, 4, 20);
       p.setPositionalValue("Bishop", 'w', 5, 4, 20);
       
       p.setPositionalValue("Bishop", 'w', 1, 5, 10);
       p.setPositionalValue("Bishop", 'w', 6, 5, 10);
       
       p.setPositionalValue("Bishop", 'w', 3, 3, 25);
       p.setPositionalValue("Bishop", 'w', 3, 4, 25);
       p.setPositionalValue("Bishop", 'w', 4, 3, 25);
       p.setPositionalValue("Bishop", 'w', 4, 4, 25);
       
       p.setPositionalValue("Knight", 'w', 3, 3, 25);
       p.setPositionalValue("Knight", 'w', 3, 4, 25);
       p.setPositionalValue("Knight", 'w', 4, 3, 25);
       p.setPositionalValue("Knight", 'w', 4, 4, 25);
       
       p.setPositionalValue("Queen", 'w', 3, 3, 90);
       p.setPositionalValue("Queen", 'w', 3, 4, 90);
       p.setPositionalValue("Queen", 'w', 4, 3, 90);
       p.setPositionalValue("Queen", 'w', 4, 4, 90);
       
       
    }
    
    public static void setLastPositionsTotalValue(){
    
        int pieceCountBlack =0;
        int pieceCountWhite =0;
        for(int i=0;i<positionList.size()-1;i++){
            
            if(positionList.get(i).getHistory().size()==depth){
                for(int y=0;y<8;y++){
                    for(int x=0;x<8;x++){
                        if(positionList.get(i).getPiece(x,y).getColor()=='w'){
                            pieceCountWhite += positionList.get(i).getPiece(x,y).getValue();
                        }
                        if(positionList.get(i).getPiece(x,y).getColor()=='b'){
                            pieceCountBlack += positionList.get(i).getPiece(x,y).getValue();
                        }
                        
                        //addera sammanlagda pjäsvärdet (materiellt värde)
                    }
                }
                
                positionList.get(i).setVarValue(pieceCountWhite - pieceCountBlack);
                addPositionalValue(positionList.get(i));
            }
            //samt positionella poäng
            pieceCountBlack=0;
            pieceCountWhite=0;
            
            //one color's standard accumulated piece value = 14250            
        
        }
    }
   
    public static void positionToCoordinates(Position p){
        
        int drag = 1;
        String[] cooA = {"a", "b", "c", "d", "e", "f", "g", "h" };
        int[] coo1 = {8,7,6,5,4,3,2,1};
        
        for(int i=0;i<p.getHistory().size();i++){
            
            System.out.print(drag + ". ");
            System.out.print(cooA[p.getHistory().get(i)[0]] + " ");
            System.out.print(coo1[p.getHistory().get(i)[1]] + " - ");
            System.out.print(cooA[p.getHistory().get(i)[2]] + " ");
            System.out.print(coo1[p.getHistory().get(i)[3]] );
            System.out.println();
            drag++;
            
        }
        
    }
    
    public static int[] coordinatesToData(String x1, int y1, String x2, int y2 ){
        
        int[] output = new int[4];
        String[] cooA = {"a", "b", "c", "d", "e", "f", "g", "h" };
        
        for(int i=0;i<8;i++){
            if(x1.equals(cooA[i])){
                output[0]=i;
            }
            if(y1==i){
                output[1]=8-i;
            }
            if(x2.equals(cooA[i])){
                output[2]=i;
            }
            if(y2==i){
                output[3]=8-i;
            }
        }
        
        return output;
    }
    
    //följande metod används inte alls
    public static int getIndexFromPosition(Position p){
    
        int bestInt1 = 1;
        boolean correctPosition = true;
        
        for(int i=0; i< positionList.size(); i++){ 
        
            for(int y=0;y<8;y++){
                for(int x=0;x<8;x++){
                    if(
                    p.getPiece(x,y).getName() == positionList.get(i).getPiece(x,y).getName() &&
                    p.getPiece(x,y).getColor() == positionList.get(i).getPiece(x,y).getColor() 
                    
                    ){
                        //System.out.println(" the same " + x + " " + y);
                        
                    }else{
                        correctPosition=false;
                    }
                }
            }
            if(correctPosition){
                bestInt1=i;
                break;
            }
            correctPosition = true;
        
        }
        
        return bestInt1;
    }
    public static void UpdateEntireVarValues(){
    
                  
        setLastPositionsTotalValue();
        
        int smallest = 10000;
        int biggest = -10000;
        List<Integer> varList = new ArrayList<Integer>();
        int ind=0;
        
        for(int i=0; i< positionList.size(); i++){ 
                if(positionList.get(i).getHistory().size()==3){
                    
                    // min-max (max)
                    //för hela listan på ett ojämnt djup
                    //hitta de mest gynnsamma utfallen för svart på varje branch
                    if(positionList.get(i+1).getChild()!=0){
                        if(positionList.get(i).getVarValue()>biggest){
                             biggest = positionList.get(i).getVarValue();
                        }
                    }else{
                        if(positionList.get(i).getVarValue()>biggest){
                             biggest = positionList.get(i).getVarValue();
                        }
                        varList.add(biggest);
                        //variabeln "biggest" återställs till det lägsta 
                        //värdet som ställningen skulle kunna ha.
                        biggest = -10000;
                    }
               }
        }
        
        for(int i=0; i< positionList.size(); i++){ 
                if(positionList.get(i).getHistory().size()==2){
                    //för hela listan där djupet är 3
                    //hitta de mest gynnsamma utfallen för svart på varje branch
                    positionList.get(i).setVarValue(varList.get(ind));
                    ind++;
                    
               }
        }
        varList.clear();
        ind=0;
            
        for(int i=0; i< positionList.size(); i++){ 
               if(positionList.get(i).getHistory().size()==2){
                   
                    //min-max (min)
                    //för hela listan på ett jämnt djup
                    //hitta de mest gynnsamma utfallen för vit på varje branch
                    if(positionList.get(i+1).getChild()!=0){
                        if(positionList.get(i).getVarValue()<smallest){
                             smallest = positionList.get(i).getVarValue();
                        }
                    }else{
                        if(positionList.get(i).getVarValue()<smallest){
                             smallest = positionList.get(i).getVarValue();
                        }
                        varList.add(smallest);
                        //variabeln "smallest" återställs till det lägsta 
                        //värdet som ställningen skulle kunna ha.
                        smallest = 10000;
                    }
                    
               }
        }
            
            
        for(int i=0; i< positionList.size(); i++){ 
                if(positionList.get(i).getHistory().size()==1){
                    //för hela listan där djupet är 3
                    //hitta de mest gynnsamma utfallen för svart på varje branch
                    positionList.get(i).setVarValue(varList.get(ind));
                    ind++;
                    
                    if(positionList.get(i).getVarValue()!=0){
                        
                        //System.out.println(positionList.get(i).getVarValue());
                    }
                   
               }
        }
            
        varList.clear();
        ind=0;    
            
    }
    
    public static Position chooseMove(){
        // vit väljer det mest gynnsamma för vit
        UpdateEntireVarValues();
        
        int lastVar=-10000;
        int bestVarIndexI = 0;
        
        for(int i=0;i<positionList.size()-1;i++){
            //för alla ställningar
            if(positionList.get(i).getHistory().size()==1){
                //System.out.println("jag tillhör den första barnaskaran");
                
                if(positionList.get(i).getVarValue()>lastVar){
                    lastVar = positionList.get(i).getVarValue();
                    bestVarIndexI=i;
                }
            
            }
            
        }
        
        
        System.out.println("solution:");
        positionList.get(bestVarIndexI).display();
        //denna är output-ställningen
        
        
        
        updateGraphics(positionList.get(bestVarIndexI));
        
        System.out.println(positionList.get(bestVarIndexI).getVarValue());
        
        howDidIGetHere.add(positionList.get(bestVarIndexI).getHistory().get(0)[0]);
        howDidIGetHere.add(positionList.get(bestVarIndexI).getHistory().get(0)[1]);
        howDidIGetHere.add(positionList.get(bestVarIndexI).getHistory().get(0)[2]);
        howDidIGetHere.add(positionList.get(bestVarIndexI).getHistory().get(0)[3]);
        
        positionToCoordinates(positionList.get(bestVarIndexI));
        return positionList.get(bestVarIndexI);
        
    }
    
    public static void updateGraphics(Position inP){
        
        for(int y=0;y<8;y++){
            for(int x=0;x<8;x++){
                mainFrame.setPiece(x,y,inP.getMatrix()[x][y].getName());
            }
        }
    
    }
    
    public static void main(String[] args){
        mainFrame = new MainFrame();
        
        mainFrame.setPiece(1,1,"hello");
        
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        
        calculate();
        chooseMove();
        //Vit gör första draget
        
        while(true){
            //spela 4 drag
            System.out.println("skriv ditt drag på typen");
            System.out.println("e");
            System.out.println("2");
            System.out.println("e");
            System.out.println("4");
            
            System.out.println();
            
            String x1 = sc1.nextLine();
            
            if(x1.equals("resign")){
                System.exit(0);
            }
            
            int y1 = sc2.nextInt();
            String x2 = sc1.nextLine();
            int y2 = sc2.nextInt();
            
            System.out.println("reading complete :)");
            
            howDidIGetHere.add(coordinatesToData(x1, y1, x2, y2 )[0]);
            howDidIGetHere.add(coordinatesToData(x1, y1, x2, y2 )[1]);
            howDidIGetHere.add(coordinatesToData(x1, y1, x2, y2 )[2]);
            howDidIGetHere.add(coordinatesToData(x1, y1, x2, y2 )[3]);
            
            calculate();
            chooseMove();
            
            
        }
    }
}