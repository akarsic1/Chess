package ba.unsa.etf.rpr;

    public class Pawn extends ChessPiece {


        public Pawn (String pozicija,Color boja){
            super(pozicija, boja);
        }



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
            if((trenutno_slovo == 'B' || trenutno_slovo == 'G') && (slovo == trenutno_slovo + 2   || slovo == trenutno_slovo +1) && broj == trenutni_broj) position = potez;
            else if(broj == trenutni_broj && slovo == trenutno_slovo + 1 ) position = potez;
            else throw new IllegalChessMoveException("");
        }

    }
