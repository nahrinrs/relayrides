import java.math.BigDecimal;
import java.time.Duration;
import java.time.ZonedDateTime;

import junit.framework.Assert;
import junit.framework.TestCase;


public class BasicPricerImplTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	/*
	 * correct rates return Basic quote object with calculated data
	 */
	public void testGetQuoteDay(){
		BasicPricer price = new BasicPricerImpl();
		BasicRate basicRate = new BasicRate();
		basicRate.daily = new BigDecimal(50);
		basicRate.weekly = new BigDecimal(250);
		basicRate.monthly = new BigDecimal(1500);
		ZonedDateTime start = ZonedDateTime.now();
		ZonedDateTime end = ZonedDateTime.now().plusDays(1l);
		BasicQuote q = price.getQuote(start, end, basicRate);
		Assert.assertNotNull(q);
	}
	/*
	 * daily rate greater than weekly rate
	 * return null
	 */
	public void testGetQuoteDay1(){
		BasicPricer price = new BasicPricerImpl();
		BasicRate basicRate = new BasicRate();
		basicRate.daily = new BigDecimal(250);
		basicRate.weekly = new BigDecimal(50);
		basicRate.monthly = new BigDecimal(1500);
		ZonedDateTime start = ZonedDateTime.now();
		ZonedDateTime end = ZonedDateTime.now().plusDays(1l);
		BasicQuote q = price.getQuote(start, end, basicRate);
		Assert.assertNull(q);
	}
	
	/*
	 * correct rates but invalid duration
	 * return null
	 */
	public void testGetQuoteDay2(){
		BasicPricer price = new BasicPricerImpl();
		BasicRate basicRate = new BasicRate();
		basicRate.daily = new BigDecimal(50);
		basicRate.weekly = new BigDecimal(250);
		basicRate.monthly = new BigDecimal(1500);
		ZonedDateTime start = ZonedDateTime.now();
		ZonedDateTime end = ZonedDateTime.now().plusDays(3);
		BasicQuote q = price.getQuote(start, end, basicRate);
		Assert.assertNull(q);
	}
	
	/*
	 * correct rate for monthly rate
	 */
	public void testGetQuoteDay3(){
		BasicPricer price = new BasicPricerImpl();
		BasicRate basicRate = new BasicRate();
		basicRate.daily = new BigDecimal(50);
		basicRate.weekly = new BigDecimal(250);
		basicRate.monthly = new BigDecimal(1500);
		ZonedDateTime start = ZonedDateTime.now();
		ZonedDateTime end = ZonedDateTime.now().plusDays(30);
		BasicQuote q = price.getQuote(start, end, basicRate);
		Assert.assertNotNull(q);
	}
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
