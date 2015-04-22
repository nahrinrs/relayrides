import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.ZonedDateTime;

public class PricerWithDurationDiscountsImpl extends BasicPricerImpl implements PricerWithDurationDiscounts {
	
	/**
	 * calculate the rate based on the discount amount and daily rate 
	 * Multiply by 7 for week and 30 for month
	 */
	public BasicQuote getQuote(ZonedDateTime start, ZonedDateTime end,
			RateWithDurationDiscounts rate) {
		
		if (rate == null) return null;
		BasicRate bRate = new BasicRate();
		bRate.daily = rate.daily;
		bRate.weekly = rate.daily.multiply(new BigDecimal(DURATION_WEEK)).subtract(rate.daily.multiply(rate.weeklyDiscount));
		bRate.monthly = rate.daily.multiply(new BigDecimal(DURATION_MONTH)).subtract(rate.daily.multiply(rate.monthlyDiscount));
		return getQuote(start, end, bRate);
	}
}
