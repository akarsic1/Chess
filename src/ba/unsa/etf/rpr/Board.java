package ba.unsa.etf.rpr;

import java.util.ArrayList;

import static ba.unsa.etf.rpr.ChessPiece.Color.BLACK;
import static ba.unsa.etf.rpr.ChessPiece.Color.WHITE;

public class Board {
    private ArrayList<ChessPiece> Tabla=new ArrayList<>();
    Board(){
        Tabla.add(new Rook("a1", ChessPiece.Color.WHITE));
        Tabla.add(new Knight("b1", ChessPiece.Color.WHITE));
        Tabla.add(new Bishop("c1", ChessPiece.Color.WHITE));
        Tabla.add(new Queen("d1", ChessPiece.Color.WHITE));
        Tabla.add(new King("e1", ChessPiece.Color.WHITE));
        Tabla.add(new Bishop("f1", ChessPiece.Color.WHITE));
        Tabla.add(new Knight("g1", ChessPiece.Color.WHITE));
        Tabla.add(new Rook("h1", ChessPiece.Color.WHITE));
        Tabla.add(new Pawn("a2",ChessPiece.Color.WHITE));
        Tabla.add(new Pawn("b2",ChessPiece.Color.WHITE));
        Tabla.add(new Pawn("c2",ChessPiece.Color.WHITE));
        Tabla.add(new Pawn("d2",ChessPiece.Color.WHITE));
        Tabla.add(new Pawn("e2",ChessPiece.Color.WHITE));
        Tabla.add(new Pawn("f2",ChessPiece.Color.WHITE));
        Tabla.add(new Pawn("g2",ChessPiece.Color.WHITE));
        Tabla.add(new Pawn("h2",ChessPiece.Color.WHITE));
        Tabla.add(new Rook("a8", ChessPiece.Color.BLACK));
        Tabla.add(new Knight("b8", ChessPiece.Color.BLACK));
        Tabla.add(new Bishop("c8", ChessPiece.Color.BLACK));
        Tabla.add(new Queen("d8", ChessPiece.Color.BLACK));
        Tabla.add(new King("e8", ChessPiece.Color.BLACK));
        Tabla.add(new Bishop("f8", ChessPiece.Color.BLACK));
        Tabla.add(new Knight("g8", ChessPiece.Color.BLACK));
        Tabla.add(new Rook("h8", ChessPiece.Color.BLACK));
        Tabla.add(new Pawn("a7",ChessPiece.Color.BLACK));
        Tabla.add(new Pawn("b7",ChessPiece.Color.BLACK));
        Tabla.add(new Pawn("c7",ChessPiece.Color.BLACK));
        Tabla.add(new Pawn("d7",ChessPiece.Color.BLACK));
        Tabla.add(new Pawn("e7",ChessPiece.Color.BLACK));
        Tabla.add(new Pawn("f7",ChessPiece.Color.BLACK));
        Tabla.add(new Pawn("g7",ChessPiece.Color.BLACK));
        Tabla.add(new Pawn("h7",ChessPiece.Color.BLACK));
    }

    public boolean jeLiPoljeZauzeto(String position){
        for(int k = 0; k < Tabla.size(); k++)
            if(Tabla.get(k).getPosition().equals(position)) return true;
        return false;
    }

    public boolean jeLiPoljeZauzeto(int i, int j){
        char indeks = (char) (9+48-i);
        char slovo = (char) j;
        String sljedecePolje;
        sljedecePolje = Character.toString(slovo)+Character.toString(indeks);
        for(int k = 0; k < Tabla.size(); k++)
            if(Tabla.get(k).getPosition().equals(sljedecePolje)) return true;
        return false;
    }

    public void move(Class type, ChessPiece.Color color, String position) throws IllegalChessMoveException{
        position = position.toLowerCase();
        int brojac = 0;
        first:
        for(int k=0; k < Tabla.size() ;k++){
            if(Tabla.get(k).getColor().equals(color) && Tabla.get(k).getClass().equals(type)){
                String oldPosition = Tabla.get(k).getPosition();
                try {
                    Tabla.get(k).move(position);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(e.getMessage());
                }
                catch (IllegalChessMoveException e) {
                    continue first;
                }
                if(!type.equals(Knight.class) && !type.equals(King.class)) {
                    int x_staro = 0, x_novo = 0, y_staro = 0, y_novo = 0, k_x, k_y;

                    x_staro = 9 - ((int) oldPosition.charAt(1) - 48);
                    x_novo = 9 - ((int) Tabla.get(k).getPosition().charAt(1) - 48);

                    y_staro = (int) oldPosition.charAt(0);
                    y_novo = (int) Tabla.get(k).getPosition().charAt(0);

                    if (y_staro != y_novo)
                        k_y = (y_novo - y_staro) / Math.abs(y_staro - y_novo);
                    else
                        k_y = 0;

                    if (x_staro != x_novo)
                        k_x = (x_novo - x_staro) / Math.abs(x_staro - x_novo);
                    else {
                        k_x = 0;
                        x_novo += Math.abs(y_novo - y_staro);
                    }

                    int j = y_staro;
                    int i = x_staro;
                    if (k_x == 0) x_staro++;
                    else x_staro += k_x;
                    while (x_staro != x_novo) {
                        i += k_x;
                        j += k_y;
                        if (jeLiPoljeZauzeto(i, j)) {
                            Tabla.get(k).setPosition(oldPosition);
                            continue first;
                        }
                        if (k_x == 0) x_staro++;
                        else x_staro += k_x;
                    }
                }
                Tabla.get(k).setPosition(oldPosition);
                if(jeLiPoljeZauzeto(position)){
                    for(int j = 0 ;j < Tabla.size() ;j++)
                        if(position.equals(Tabla.get(j).getPosition()) && color!=Tabla.get(j).getColor()){
                            if(!Tabla.get(j).getClass().equals(King.class)){
                                Tabla.get(k).move(position);
                                Tabla.remove(j);
                            }
                            brojac++;
                            break first;
                        }
                        else if(position.equals(Tabla.get(j).getPosition()) && color==Tabla.get(j).getColor()){
                            throw new IllegalChessMoveException("Illegal move.");
                        }
                }
                else{
                    if(Tabla.get(k).getClass().equals(Pawn.class) && position.charAt(0)!=Tabla.get(k).getPosition().charAt(0)) {
                        continue first;
                    }
                    Tabla.get(k).move(position);
                    brojac++;
                    break first;
                }
            }
        }
        if(brojac == 0){
            throw new IllegalChessMoveException("Illegal move.");
        }
    }

    public void move(String oldPosition, String newPosition)throws IllegalChessMoveException{
        int brojac = 0;
        oldPosition = oldPosition.toLowerCase();
        for(int i = 0; i < Tabla.size(); i++){
            if(oldPosition.equals(Tabla.get(i).getPosition())){
                try {
                    brojac++;
                    move(Tabla.get(i).getClass(), Tabla.get(i).getColor(), newPosition);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(e.getMessage());
                } catch (IllegalChessMoveException e) {
                    throw new IllegalChessMoveException(e.getMessage());
                }
            }
        }
        if(brojac == 0){
            throw new IllegalChessMoveException("Illegal move.");
        }
    }

    public boolean isCheck(ChessPiece.Color color){
        String kingPosition = new String();
        for(int i = 0; i < Tabla.size(); i++) {
            if(Tabla.get(i).getClass().equals(King.class) && color.equals(Tabla.get(i).getColor())) {
                kingPosition = Tabla.get(i).getPosition();
            }
        }
        first:
        for(int i = 0; i < Tabla.size(); i++){
            if(!Tabla.get(i).getColor().equals(color)) {
                try{
                    move(Tabla.get(i).getClass(),Tabla.get(i).getColor(),kingPosition);
                    return true;
                } catch (Exception e) {
                    continue first;
                }
            }
        }
        return false;
    }

}

