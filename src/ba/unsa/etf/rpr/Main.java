package ba.unsa.etf.rpr;

public class Main {
    public static void main(String[] args) {
        Board b = new Board();
        try {
            b.move(Queen.class, ChessPiece.Color.BLACK, "A5");
        }catch (IllegalChessMoveException e){
            System.out.println("soso");
        }

    }
}