package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class Board {
    ArrayList<ChessPiece> figures = new ArrayList<ChessPiece>();

    public Board(){
        figures.add(new King("E1",ChessPiece.color.WHITE));
        figures.add(new King("E8",ChessPiece.color.BLACK));
        figures.add(new Queen("D1",ChessPiece.color.WHITE));
        figures.add(new Queen("D8",ChessPiece.color.BLACK));
        figures.add(new Bishop("C1", ChessPiece.color.WHITE));
        figures.add(new Bishop("F1", ChessPiece.color.WHITE));
        figures.add(new Bishop("C8", ChessPiece.color.BLACK));
        figures.add(new Bishop("F8", ChessPiece.color.BLACK));
        figures.add(new Knight("B1",ChessPiece.color.WHITE));
        figures.add(new Knight("G1",ChessPiece.color.WHITE));
        figures.add(new Knight("B8",ChessPiece.color.BLACK));
        figures.add(new Knight("G8",ChessPiece.color.BLACK));
        figures.add(new Rook("A1",ChessPiece.color.WHITE));
        figures.add(new Rook("H1",ChessPiece.color.WHITE));
        figures.add(new Rook("A8",ChessPiece.color.BLACK));
        figures.add(new Rook("H8",ChessPiece.color.BLACK));
        for(char i = 'A'; i <='H'; i++){
            String pozicija = i+"2";
            figures.add(new Pawn(pozicija, ChessPiece.color.WHITE));
        }
        for(char i = 'A'; i <='H'; i++){
            String pozicija = i+"7";
            figures.add(new Pawn(pozicija, ChessPiece.color.BLACK));
        }
    }

    void move(Class type, ChessPiece.Color color, String position){}

    void move(String oldPosition, String newPosition){}

    boolean isCheck(ChessPiece.Color color){

        return true;
    }
}
