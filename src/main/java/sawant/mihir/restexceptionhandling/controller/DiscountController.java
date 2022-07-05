package sawant.mihir.restexceptionhandling.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sawant.mihir.restexceptionhandling.exception.WrongCouponException;
import sawant.mihir.restexceptionhandling.services.DiscountDetails;
import sawant.mihir.restexceptionhandling.services.DiscountService;
import sawant.mihir.restexceptionhandling.services.ErrorDetails;

import java.util.Locale;

@RestController
public record DiscountController(DiscountService discountService) {

    public DiscountController(DiscountService discountService){
        this.discountService = discountService;
    }

    @PostMapping("/discount")
    public ResponseEntity<?> getDiscount(@RequestParam String couponCode){
        try{
            double discount = discountService.calcDiscount(couponCode.toUpperCase(Locale.ROOT));
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(new DiscountDetails(discount, "Coupon Code Applied Successfully"));
        }catch (WrongCouponException ex){
            return ResponseEntity
                    .badRequest()
                    .body(new ErrorDetails(ex.getMessage()));
        }
    }


}
