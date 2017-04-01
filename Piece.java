import java.util.ArrayList;
import java.util.List;

public class Piece{
    private int value = 0;
    private char color;
    private String name;
    // en pjäs har endast 3 egenskaper: namn, värde och färg. 
    
    public Piece(){}
    public Piece(String name, char color, int value){
        this.name=name;
        this.color=color;
        this.value=value;
    }
    
    void setName(String name) {
        this.name=name;
    }
    String getName(){
        return name;
    }
    
    void setValue(int value) {
        this.value = value;
    }
    int getValue() { 
        return value; 
    }
    
    void setColor(char color) {
        this.color = color;
    }
    char getColor() { 
        return color; 
    }
}