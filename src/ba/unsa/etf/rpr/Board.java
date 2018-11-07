package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class Board {
    ArrayList<ChessPiece> Figures = new ArrayList<ChessPiece>();

    void move(Class type, ChessPiece.Color color, String position){}
    void move(String oldPosition, String newPosition){}
    boolean isCheck(ChessPiece.Color color){
        return true;
    }
}
