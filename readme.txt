I assume the BasicPricerImpl receives the correct duration of daily = 1, weekly = 7, monthly = 30.
which make it calculate the quote based on the value defined in rate per period.

I extended BasicPricerImpl to implement PricerWithMileageLimitImpl and PricerWithDurationDiscountsImpl.

these two classes would polish the data to make it acceptable to base class.