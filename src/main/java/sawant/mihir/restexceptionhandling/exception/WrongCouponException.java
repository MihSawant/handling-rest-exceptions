package sawant.mihir.restexceptionhandling.exception;

public class WrongCouponException extends RuntimeException {
    private String message;

    public WrongCouponException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
