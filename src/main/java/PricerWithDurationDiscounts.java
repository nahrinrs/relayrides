import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.ZonedDateTime;

public interface PricerWithDurationDiscounts {
	
    BasicQuote getQuote(ZonedDateTime start, ZonedDateTime end, RateWithDurationDiscounts rate);
}
