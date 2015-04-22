# Pricing

## Why

RelayRides aims to offer great value to owners *and* renters. Transparent, flexible, and fair pricing is crucial to both sides of the marketplace.

## What

Implement a few versions of a pricing interface and associated a tests. There are no right answers, and we encourage you to think about how to develop a strategy that supports the product’s transparency and fairness in both owner’s intentions and renter satisfaction.

There are four distinct tasks, but they can be completed in any order. The interface and object definitions are in Java, but you are welcome to use any language and toolchain that you want.

1. Write an implementation for three different Pricer interfaces.
2. Write documentation for each method.
3. Write unit tests for each Pricer method. Consider edge cases and the principles of fairness and transparency that you are trying to maintain. For example, here are some extreme rates that an owner may set:

        basicRate = new BasicRate(.daily = 50, .weekly = 250, .monthly = 1500)

        rateWithDiscounts = new RateWithDurationDiscounts(.daily = 50, .weeklyDiscount = .1, .monthlyDiscount = .5)

4. Write a paragraph about the thinking that went into each method. Did you make compromises? Were they in favor of the owner, or were they in favor of the renter?

### Notes

- Feel free to include anything you used to help write & run what you wrote, such as Maven, Gradle, or other build system files, but they are not required. The only required deliverables are the interface implementations and unit tests.
- The Java interfaces use Java 8’s `ZonedDateTime` class.
- Feel free to make use of additional libraries as needed. Explain why you used them in #4.
- Please make some rough notes about how long each step took to implement. This whole project should take an hour or two.

[1]: http://www.joda.org/joda-time/
