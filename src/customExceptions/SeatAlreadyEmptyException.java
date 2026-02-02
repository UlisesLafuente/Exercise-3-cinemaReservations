package customExceptions;

public class SeatAlreadyEmptyException extends RuntimeException {
    public SeatAlreadyEmptyException(String message) {
        super(message);
    }
}
