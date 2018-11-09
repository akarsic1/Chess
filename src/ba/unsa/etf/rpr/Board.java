package ba.unsa.etf.rpr;

import java.util.ArrayList;

import static ba.unsa.etf.rpr.ChessPiece.Color.BLACK;
import static ba.unsa.etf.rpr.ChessPiece.Color.WHITE;

public class Board {
    ArrayList<ChessPiece> figures = new ArrayList<ChessPiece>();

    public Board(){
        figures.add(new King("E1",WHITE));
        figures.add(new King("E8",BLACK));
        figures.add(new Queen("D1", WHITE));
        figures.add(new Queen("D8", BLACK));
        figures.add(new Bishop("C1", WHITE));
        figures.add(new Bishop("F1", WHITE));
        figures.add(new Bishop("C8", BLACK));
        figures.add(new Bishop("F8", BLACK));
        figures.add(new Knight("B1", WHITE));
        figures.add(new Knight("G1", WHITE));
        figures.add(new Knight("B8", BLACK));
        figures.add(new Knight("G8", BLACK));
        figures.add(new Rook("A1", WHITE));
        figures.add(new Rook("H1", WHITE));
        figures.add(new Rook("A8", BLACK));
        figures.add(new Rook("H8", BLACK));
        for(char i = 'A'; i <='H'; i++){
            String pozicija = i+"2";
            figures.add(new Pawn(pozicija, WHITE));
        }
        for(char i = 'A'; i <='H'; i++){
            String pozicija = i+"7";
            figures.add(new Pawn(pozicija, BLACK));
        }
    }

    public void captured(ChessPiece c){
        for(int i = 0; i < figures.size(); i++){
            if(figures.get(i) == c)figures.remove(i);
        }
    }

    public boolean isPathClear(ChessPiece moveable, String newPosition) throws IllegalChessMoveException {
        Board nova = new Board();
        String now = moveable.getPosition();
        ChessPiece.Color boja = moveable.getColor();
        nova.figures = new ArrayList<ChessPiece>();
        try {
            for (int i = 0; i < figures.size(); i++) {
                nova.figures.add((ChessPiece) figures.get(i).clone());
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (moveable instanceof Knight) {
            for (int i = 0; i < nova.figures.size(); i++) {
                if (nova.figures.get(i).getPosition() == newPosition && nova.figures.get(i).getColor().equals(boja))
                    return false;
                else if (nova.figures.get(i).getPosition() == newPosition && nova.figures.get(i).getColor() != boja) {
                    captured(nova.figures.get(i));
                    return true;
                }
            }
            return true;
        }

        if (moveable instanceof Rook) {
            if (now.charAt(0) == newPosition.charAt(0)) {
                for (int i = 0; i < nova.figures.size(); i++) {
                    if (now.charAt(0) == nova.figures.get(i).getPosition().charAt(0)) {
                        if (nova.figures.get(i).getPosition() == newPosition && nova.figures.get(i).getColor().equals(boja)) {
                            return false;
                        } else if ((nova.figures.get(i).getPosition().charAt(1) < newPosition.charAt(1) && nova.figures.get(i).getPosition().charAt(1) > now.charAt(1)) || (nova.figures.get(i).getPosition().charAt(1) > newPosition.charAt(1) && nova.figures.get(i).getPosition().charAt(1) < now.charAt(1))) {
                            return false;
                        } else if (nova.figures.get(i).getPosition() == newPosition && nova.figures.get(i).getColor() != boja) {
                            captured(nova.figures.get(i));
                            return true;
                        }
                    }
                }
                return true;
            }
            if (now.charAt(1) == newPosition.charAt(1)) {
                for (int i = 0; i < nova.figures.size(); i++) {
                    if (now.charAt(1) == nova.figures.get(i).getPosition().charAt(1)) {
                        if (nova.figures.get(i).getPosition() == newPosition && nova.figures.get(i).getColor().equals(boja))
                            return false;
                        else if ((nova.figures.get(i).getPosition().charAt(0) < newPosition.charAt(0) && nova.figures.get(i).getPosition().charAt(0) > now.charAt(0)) || (nova.figures.get(i).getPosition().charAt(0) > newPosition.charAt(0) && nova.figures.get(i).getPosition().charAt(0) < now.charAt(0)))
                            return false;
                        else if (nova.figures.get(i).getPosition() == newPosition && nova.figures.get(i).getColor() != boja) {
                            captured(nova.figures.get(i));
                            return true;
                        }
                    }
                }
                return true;
            }
            return true;
        }

        if (moveable instanceof Bishop) {
            int razlika = Math.abs(now.charAt(0) - newPosition.charAt(0));
            for (int i = 0; i < nova.figures.size(); i++) {
                char poz = nova.figures.get(i).getPosition().charAt(0);
                char br = nova.figures.get(i).getPosition().charAt(1);
                if (nova.figures.get(i).getPosition() == newPosition && nova.figures.get(i).getColor().equals(boja))
                    return false;
                else if (Math.abs(poz - now.charAt(0)) > now.charAt(0) && Math.abs(poz - now.charAt(0)) < razlika && ((poz < now.charAt(0) && poz > newPosition.charAt(0)) || (poz > now.charAt(0) && poz < newPosition.charAt(0)))){
                   return false;}
                else if (nova.figures.get(i).getPosition() == newPosition && nova.figures.get(i).getColor() != boja) {
                    captured(nova.figures.get(i));
                    return true;
                }
            }
            return true;
        }

        if (moveable instanceof King) {
            for (int i = 0; i < nova.figures.size(); i++) {
                if (nova.figures.get(i).getPosition() == newPosition && nova.figures.get(i).getColor().equals(boja))
                    return false;
                else if (nova.figures.get(i).getPosition() == newPosition && nova.figures.get(i).getColor() != boja) {
                    captured(nova.figures.get(i));
                    return true;
                }
            }
            return true;
        }

        if (moveable instanceof Queen) {
            if (now.charAt(0) == newPosition.charAt(0)) {
                for (int i = 0; i < nova.figures.size(); i++) {
                    if (now.charAt(0) == nova.figures.get(i).getPosition().charAt(0)) {
                        if (nova.figures.get(i).getPosition() == newPosition && nova.figures.get(i).getColor().equals(boja)) {
                            return false;
                        } else if ((nova.figures.get(i).getPosition().charAt(1) < newPosition.charAt(1) && nova.figures.get(i).getPosition().charAt(1) > now.charAt(1)) || (nova.figures.get(i).getPosition().charAt(1) > newPosition.charAt(1) && nova.figures.get(i).getPosition().charAt(1) < now.charAt(1))) {
                            return false;
                        } else if (nova.figures.get(i).getPosition() == newPosition && nova.figures.get(i).getColor() != boja) {
                            captured(nova.figures.get(i));
                            return true;
                        }
                    }
                }
                return true;
            }
            else if (now.charAt(1) == newPosition.charAt(1)) {
                for (int i = 0; i < nova.figures.size(); i++) {
                    if (now.charAt(1) == nova.figures.get(i).getPosition().charAt(1)) {
                        if (nova.figures.get(i).getPosition() == newPosition && nova.figures.get(i).getColor().equals(boja))
                            return false;
                        else if ((nova.figures.get(i).getPosition().charAt(0) < newPosition.charAt(0) && nova.figures.get(i).getPosition().charAt(0) > now.charAt(0)) || (nova.figures.get(i).getPosition().charAt(0) > newPosition.charAt(0) && nova.figures.get(i).getPosition().charAt(0) < now.charAt(0)))
                            return false;
                        else if (nova.figures.get(i).getPosition() == newPosition && nova.figures.get(i).getColor() != boja) {
                            captured(nova.figures.get(i));
                            return true;
                        }
                    }
                }
                return true;
            }
            int razlika = Math.abs(now.charAt(0) - newPosition.charAt(0));
            int razlika1 = Math.abs(now.charAt(1) - newPosition.charAt(1));
            if(razlika == razlika1) {
                for (int i = 0; i < nova.figures.size(); i++) {
                    char poz = nova.figures.get(i).getPosition().charAt(0);
                    if (nova.figures.get(i).getPosition() == newPosition && nova.figures.get(i).getColor().equals(boja))
                        return false;
                    else if (Math.abs(poz - now.charAt(0)) < razlika && ((poz < now.charAt(0) && poz > newPosition.charAt(0)) || (poz > now.charAt(0) && poz < newPosition.charAt(0))))
                        return false;
                    else if (nova.figures.get(i).getPosition() == newPosition && nova.figures.get(i).getColor() != boja) {
                        captured(nova.figures.get(i));
                        return true;
                    }
                }
                return true;
            }
        }
        if (moveable instanceof Pawn) {
            for (int i = 0; i < nova.figures.size(); i++) {
                if (nova.figures.get(i).getPosition() == newPosition && nova.figures.get(i).getColor().equals(boja)) return false;
                if (now.charAt(0) == newPosition.charAt(0)) {
                    if(Math.abs(now.charAt(1) - newPosition.charAt(1)) == 1)return true;
                    if (nova.figures.get(i).getPosition() == newPosition && nova.figures.get(i).getColor() != boja) {
                            return false;
                        }
                    } else if (now.charAt(0) != newPosition.charAt(0)) {
                        for (int j = 0; j < nova.figures.size(); j++) {
                            if (nova.figures.get(j).getPosition() == newPosition && nova.figures.get(i).getColor() != boja) {
                                System.out.println("Pojo");
                                captured(nova.figures.get(i));
                                return true;
                            }
                        }
                        return false;
                    }
                }
                return true;
            }
            return false;
    }

    public void move(Class type, ChessPiece.Color color, String position) throws IllegalChessMoveException {
        Board nova = new Board();
        String pozicija = "";
        nova.figures = new ArrayList<ChessPiece>();
        try {
            for(int i = 0; i<figures.size(); i++) {
                nova.figures.add((ChessPiece) figures.get(i).clone());
            }
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        String stara_pozicija = "";
        for(int i = 0; i < nova.figures.size(); i++){
            try {
                if(figures.get(i).getClass().equals(type) && figures.get(i).getColor() == color) {
                    stara_pozicija = figures.get(i).getPosition();
                    figures.get(i).move(position);//pokusaj uskladiti
                    figures.get(i).setPosition(stara_pozicija);
                    break;
                }
            }catch (IllegalChessMoveException e){
                    figures.get(i).setPosition(stara_pozicija);
            }
            /*if(nova.figures.get(i).getColor().equals(color) && nova.figures.get(i).getClass() == type && nova.figures.get(i) instanceof Pawn){
                if((position.charAt(0) == nova.figures.get(i).getPosition().charAt(0) && Math.abs(position.charAt(1) - nova.figures.get(i).getPosition().charAt(1)) <= 2) || (Math.abs(position.charAt(0) - nova.figures.get(i).getPosition().charAt(0))==1) &&  (Math.abs(position.charAt(1) - nova.figures.get(i).getPosition().charAt(1))==1)){
                    if(isPathClear(nova.figures.get(i), position)){pozicija = nova.figures.get(i).getPosition();break;}
                }
            }
            else if(nova.figures.get(i).getColor().equals(color) && nova.figures.get(i).getClass() == type && nova.figures.get(i) instanceof Knight && Math.abs(nova.figures.get(i).getPosition().charAt(0)-position.charAt(0))<=2)
                pozicija = nova.figures.get(i).getPosition();
            else if(nova.figures.get(i).getColor().equals(color) && nova.figures.get(i).getClass() == type)
                pozicija = nova.figures.get(i).getPosition();*/
        }
        System.out.println(pozicija);
        for(int i = 0; i < nova.figures.size(); i++){
            if(nova.figures.get(i).getColor().equals(color) && nova.figures.get(i).getClass().equals(type) && nova.figures.get(i).getPosition() == pozicija){
                try{
                    nova.figures.get(i).move(position);
                    if(isPathClear(figures.get(i), position))figures.get(i).move(position);
                    else throw new IllegalChessMoveException("");
                }catch (IllegalChessMoveException e){
                    throw new IllegalChessMoveException();
                }

            }
        }

    }

    void move(String oldPosition, String newPosition){}

    boolean isCheck(ChessPiece.Color color){
                /*Board nova = new Board();
                String pozicija = "";
                nova.figures = new ArrayList<ChessPiece>();
                    try {
                        for(int i = 0; i<figures.size(); i++) {
                            nova.figures.add((ChessPiece) figures.get(i).clone());
                        }
                    }catch (CloneNotSupportedException e){
                        e.printStackTrace();
                    }
                    for(int i = 0; i < nova.figures.size(); i++){
                        if(nova.figures.get(i).getColor() == color && nova.figures.get(i)instanceof King)pozicija = nova.figures.get(i).getPosition();
                    }
                    for(int i = 0; i < nova.figures.size(); i++) {
                        if(nova.figures.get(i).getColor() != color && nova.figures.get(i)instanceof Knight){
                            try{
                                Knight k = new Knight(nova.figures.get(i).getPosition(), nova.figures.get(i).getColor());
                                k.move(pozicija);
                            }catch (IllegalChessMoveException e){
                                System.out.println("CHECK!!!");
                            }
                        }
                        if(nova.figures.get(i).getColor() != color && nova.figures.get(i)instanceof Queen){
                            try{
                                Queen k = new Queen(nova.figures.get(i).getPosition(), nova.figures.get(i).getColor());
                                k.move(pozicija);
                            }catch (IllegalChessMoveException e){
                                System.out.println("CHECK!!!");
                            }
                        }
                        if(nova.figures.get(i).getColor() != color && nova.figures.get(i)instanceof Rook){
                            try{
                                Knight k = new Knight(nova.figures.get(i).getPosition(), nova.figures.get(i).getColor());
                                k.move(pozicija);
                            }catch (IllegalChessMoveException e){
                                System.out.println("CHECK!!!");
                            }
                        }
                    }*/
            return true;
    }
}
