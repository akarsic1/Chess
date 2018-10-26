package ba.unsa.etf.rpr;

public abstract class ChessPiece {

    public enum Color{BLACK, WHITE}
    String position;
     public static Color color;

    public boolean checkIllegal(String pozicija){
        char slovo = pozicija.charAt(0);
        int broj = Integer.parseInt(pozicija);
        if(pozicija.length() > 2 || pozicija.length()<= 0)return true;
        if(slovo < 'A' && slovo > 'H' && slovo < 'a' && slovo > 'h')return true;
        if(broj <1 && broj > 9)return true;
        return false;
    }

     public ChessPiece(String pozicija, Color boja){
         if(checkIllegal(pozicija))throw new IllegalArgumentException("");
         position = pozicija;
         color = boja;
     }

     public class IllegalChessMoveException extends  Exception{
         public IllegalChessMoveException() { super(); }
         public IllegalChessMoveException(String msg) {super(msg);}
     }

     public void move(String pozicija)throws IllegalChessMoveException{
     }

    public Color getColor() {
        return color;
    }

    public String getPosition() {
        return position;
    }

}
