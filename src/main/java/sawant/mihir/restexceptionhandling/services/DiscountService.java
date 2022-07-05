package sawant.mihir.restexceptionhandling.services;

import org.springframework.stereotype.Service;
import sawant.mihir.restexceptionhandling.exception.WrongCouponException;

@Service
public class DiscountService {

    public double calcDiscount(String couponCode){
        double maxDiscount = switch (couponCode){
            case "APPLY_15" -> 15.00;
            case "APPLY_25" -> 25.00;
            case "APPLY_50" -> 50.00;
            default -> throw new WrongCouponException("Wrong Coupon Code: " + couponCode);
        };
        return maxDiscount;
    }
}
