package ba.unsa.etf.rpr;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) { //moves in format: for pawns(e4,e5), other figures (Nf3, Nc6, Bb5) r for rook, n for knight, b for bishop, k for king and q for queen
        Board Tabla = new Board();
        glavna:
        while (true) {
            first:
            while (true) {
                try {
                    System.out.println("White move: ");
                    Scanner bjeli = new Scanner(System.in);
                    String ulaz;
                    ulaz = bjeli.nextLine();
                    if(!ulaz.equals("X")) ulaz = ulaz.toLowerCase();
                    if (ulaz.equals("X")) {
                        System.out.println("Bjeli je predao.");
                        break glavna;
                    } else if ('r' == ulaz.charAt(0))
                        Tabla.move(Rook.class, ChessPiece.Color.WHITE, ulaz.substring(1,3));
                    else if ('n' == ulaz.charAt(0))
                        Tabla.move(Knight.class, ChessPiece.Color.WHITE, ulaz.substring(1,3));
                    else if ('b' == ulaz.charAt(0) && ulaz.length() > 2)
                        Tabla.move(Bishop.class, ChessPiece.Color.WHITE, ulaz.substring(1,3));
                    else if ('k' == ulaz.charAt(0))
                        Tabla.move(King.class, ChessPiece.Color.WHITE, ulaz.substring(1,3));
                    else if ('q' == ulaz.charAt(0))
                        Tabla.move(Queen.class, ChessPiece.Color.WHITE, ulaz.substring(1,3));
                    else
                        Tabla.move(Pawn.class, ChessPiece.Color.WHITE, ulaz);
                    if (Tabla.isCheck(ChessPiece.Color.BLACK)) System.out.println("CHECK");
                    break first;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue first;
                }
            }

            second:
            while (true) {
                try {
                    System.out.println("Black move: ");
                    Scanner crni = new Scanner(System.in);
                    String ulaz;
                    ulaz = crni.nextLine();
                    if(!ulaz.equals("X")) ulaz = ulaz.toLowerCase();
                    if (ulaz.equals("X")) {
                        System.out.println("Crni je predao.");
                        break glavna;
                    } else if ('r' == ulaz.charAt(0))
                        Tabla.move(Rook.class, ChessPiece.Color.BLACK, ulaz.substring(1,3));
                    else if ('n' == ulaz.charAt(0))
                        Tabla.move(Knight.class, ChessPiece.Color.BLACK, ulaz.substring(1,3));
                    else if ('b' == ulaz.charAt(0) && ulaz.length() > 2)
                        Tabla.move(Bishop.class, ChessPiece.Color.BLACK, ulaz.substring(1,3));
                    else if ('k' == ulaz.charAt(0))
                        Tabla.move(King.class, ChessPiece.Color.BLACK, ulaz.substring(1,3));
                    else if ('q' == ulaz.charAt(0))
                        Tabla.move(Queen.class, ChessPiece.Color.BLACK, ulaz.substring(1,3));
                    else
                        Tabla.move(Pawn.class, ChessPiece.Color.BLACK, ulaz);
                    if (Tabla.isCheck(ChessPiece.Color.WHITE)) System.out.println("CHECK");
                    continue glavna;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue second;
                }
            }
        }
    }

}