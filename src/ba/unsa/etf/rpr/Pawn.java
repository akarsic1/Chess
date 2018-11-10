package ba.unsa.etf.rpr;

    public class Pawn extends ChessPiece {


        public Pawn (String pozicija,Color boja){
            super(pozicija, boja);
        }



        @Override
        public void move(String potez)throws IllegalChessMoveException{
            String trenutna = getPosition();
            if(checkIllegal(potez))throw new IllegalArgumentException("");
            char slovo = potez.charAt(0);
            char broj = potez.charAt(1);
            if(slovo > 72) slovo -= 32;
            char trenutno_slovo = trenutna.charAt(0);
            char trenutni_broj = trenutna.charAt(1);
            if(trenutno_slovo > 72)trenutno_slovo -= 32;
            if((Math.abs(trenutni_broj-broj)==1) && (slovo == trenutno_slovo + 1 || slovo == trenutno_slovo - 1)) position = potez;
            else if((trenutni_broj =='7' || trenutni_broj == '2') && slovo == trenutno_slovo && (Math.abs(trenutni_broj-broj)<=2))position = potez;
            else if((Math.abs(trenutni_broj-broj)==1) && slovo == trenutno_slovo ) position = potez;
            else throw new IllegalChessMoveException("");
        }

    }
