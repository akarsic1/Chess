package ba.unsa.etf.rpr;

public abstract class ChessPiece implements Cloneable{

    public enum Color{WHITE,BLACK}


    String position;
    Color color;

     protected Object clone()throws CloneNotSupportedException{
            ChessPiece klon = (ChessPiece)super.clone();
            return klon;
     }

    public boolean checkIllegal(String pozicija){
        if((pozicija == "") || pozicija.equals(getPosition())){return true;}
        char slovo = pozicija.charAt(0);
        char broj = pozicija.charAt(1);
        if(pozicija.length() > 2 || pozicija.length()<= 0)return true;
        if((slovo < 'A' || slovo > 'H') && (slovo < 'a' || slovo > 'h'))return true;
        if(broj < '1' || broj > '8')return true;
        return false;
    }

     public ChessPiece(String pozicija, Color boja){
         if(checkIllegal(pozicija))throw new IllegalArgumentException("");
         position = pozicija;
         this.color = boja;
     }


     public void move(String pozicija)throws IllegalChessMoveException{
     }

    public Color getColor() {
        return color;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
}
