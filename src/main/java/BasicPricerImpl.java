import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.Duration;

public class BasicPricerImpl implements BasicPricer  {
	protected final static long DURATION_DAY = 1l;
	protected final static long DURATION_WEEK = 7l;
	protected final static long DURATION_MONTH = 30l;
	
	/*
	 * (non-Javadoc)
	 * @see BasicPricer#getQuote(java.time.ZonedDateTime, java.time.ZonedDateTime, BasicRate)
	 * start and end date duration should represent one of the values defined as constant
	 * based on that proper rate will be chosen and quote will be calculated.
	 */
	public BasicQuote getQuote(ZonedDateTime start, ZonedDateTime end,
			BasicRate rate) {
		BasicQuote quote = new BasicQuote();
		if (rate == null) return null;
		if (rate.daily.compareTo(rate.weekly) == 1 || rate.weekly.compareTo(rate.monthly) == 1 ||
				rate.daily.compareTo(rate.monthly) == 1){
			return null;
		}
		long d = Duration.between(start, end).toDays();
		if (d == DURATION_DAY){
			quote.renterCost = rate.daily.multiply(new BigDecimal(.25 * d));
			quote.ownerEarnings = rate.daily.multiply(new BigDecimal(.75 * d));
		} else if ( d == DURATION_WEEK) {
			quote.renterCost = rate.weekly.multiply(new BigDecimal(.25 * d));
			quote.ownerEarnings = rate.weekly.multiply(new BigDecimal(.75 * d));
		} else if (d == DURATION_MONTH) {
			quote.renterCost = rate.monthly.multiply(new BigDecimal(.25 * d));
			quote.ownerEarnings = rate.monthly.multiply(new BigDecimal(.75 * d));
		} else {
			return null;
		}
		return quote;
	}

}
