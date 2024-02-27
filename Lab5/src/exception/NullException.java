package exception;

public class NullException extends Exception{
    public NullException(String field) {
        super("Поле " + field + " не может быть null");
    }
}
