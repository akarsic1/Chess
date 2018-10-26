package ba.unsa.etf.rpr;
import java.lang.Math;

public class Bishop extends ChessPiece{
    public Bishop(String pozicija, Color boja){super(pozicija,boja);}
    @Override
    public void move(String potez)throws IllegalChessMoveException{
        char slovo = potez.charAt(0);
        int broj = Integer.parseInt(potez);
        String trenutna = getPosition();
        if(checkIllegal(potez))throw new IllegalArgumentException("");
        if(slovo > 72) slovo -= 32;
        char trenutno_slovo = trenutna.charAt(0);
        int trenutni_broj = Integer.parseInt(trenutna);
        if(trenutno_slovo > 72)trenutno_slovo -= 32;
        int razlika = trenutno_slovo - slovo;
        int razlika1 = trenutni_broj - broj;
        if(Math.abs(razlika) != Math.abs(razlika1))throw  new IllegalChessMoveException("");
        position = potez;
    }
}