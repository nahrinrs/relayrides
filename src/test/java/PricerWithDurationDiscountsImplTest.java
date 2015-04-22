import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PricerWithDurationDiscountsImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * correct discount rate and correct duration - daily
	 */
	@Test
	public void testGetQuote() {
		PricerWithDurationDiscounts price = new PricerWithDurationDiscountsImpl();
		RateWithDurationDiscounts rate = new RateWithDurationDiscounts();
		rate.daily = new BigDecimal(50);
		rate.weeklyDiscount = new BigDecimal(.10);
		rate.monthlyDiscount= new BigDecimal(.50);
		ZonedDateTime start = ZonedDateTime.now();
		ZonedDateTime end = ZonedDateTime.now().plusDays(1l);
		BasicQuote q = price.getQuote(start, end, rate);
		Assert.assertNotNull(q);
	}

}
