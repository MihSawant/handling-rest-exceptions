package sawant.mihir.restexceptionhandling.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sawant.mihir.restexceptionhandling.exception.WrongCouponException;

@ControllerAdvice
public record DiscountExceptionControllerAdvice() {

    @ExceptionHandler(WrongCouponException.class)
    public ResponseEntity<ErrorDetails> exceptionWrongCouponHandler(){
        ErrorDetails errorDetails = new ErrorDetails("Coupon Code is Invalid");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
