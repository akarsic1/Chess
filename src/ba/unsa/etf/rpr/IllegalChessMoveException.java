package ba.unsa.etf.rpr;

public class IllegalChessMoveException extends  Exception{
    public IllegalChessMoveException() { super(); }
    public IllegalChessMoveException(String msg) {super(msg);}
}
