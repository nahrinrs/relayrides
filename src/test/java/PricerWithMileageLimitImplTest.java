import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PricerWithMileageLimitImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * price are per mile for each period
	 */
	@Test
	public void testGetQuote() {
		PricerWithMileageLimit price = new PricerWithMileageLimitImpl();
		RateWithMileageLimit rate = new RateWithMileageLimit();
		rate.daily = new BigDecimal(0.5);
		rate.weekly = new BigDecimal(3);
		rate.monthly= new BigDecimal(15);
		rate.dailyMileageLimit = 250;
		ZonedDateTime start = ZonedDateTime.now();
		ZonedDateTime end = ZonedDateTime.now().plusDays(1l);
		QuoteWithMileageLimit q = price.getQuote(start, end, rate);
		Assert.assertNotNull(q);
	}

}
