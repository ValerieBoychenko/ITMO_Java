package exception;

public class RangeException extends Exception {
    public RangeException() {
        super("Число не входит в заданный диапазон");
    }
}
