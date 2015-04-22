import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.ZonedDateTime;

public interface PricerWithMileageLimit {
	
    QuoteWithMileageLimit getQuote(ZonedDateTime start, ZonedDateTime end, RateWithMileageLimit rate);
}
