import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Duration;
import java.time.ZonedDateTime;

public class PricerWithMileageLimitImpl extends BasicPricerImpl implements PricerWithMileageLimit {
	
	public QuoteWithMileageLimit getQuote(ZonedDateTime start,
			ZonedDateTime end, RateWithMileageLimit rate) {
		
		if (rate == null) return null;
		BasicRate bRate = new BasicRate();
		bRate.daily = rate.daily.multiply(new BigDecimal(rate.dailyMileageLimit));
		bRate.weekly = rate.weekly.multiply(new BigDecimal(rate.dailyMileageLimit));
		bRate.monthly = rate.monthly.multiply(new BigDecimal(rate.dailyMileageLimit));
		BasicQuote bQuote = getQuote(start, end, bRate);
		if (bQuote == null) return null;
		QuoteWithMileageLimit quote = new QuoteWithMileageLimit();
		quote.renterCost = bQuote.renterCost;
		quote.ownerEarnings = bQuote.ownerEarnings;
		long d = Duration.between(start, end).toDays();
		quote.mileageLimit = (int) (d * rate.dailyMileageLimit);
		return quote;
	}

}
