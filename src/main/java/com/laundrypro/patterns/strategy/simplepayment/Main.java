package com.laundrypro.patterns.strategy.simplepayment;

/**
 * Client: Chooses the strategy at runtime and uses the Context.
 * This simple demo does not start Spring; it's a plain Java main method.
 */
public class Main {
    public static void main(String[] args) {
        // Create context
        ShoppingCart cart = new ShoppingCart();

        // Choose a strategy at runtime (PayPal)
        //PaymentStrategy strategy = new PayPalPayment("Dewshan@gmail.com");
        //cart.setPaymentStrategy(strategy);
        // IF you wanted to test CreditCardPayment, you could do:
        cart.setPaymentStrategy(new CreditCardPayment("411111111111", "Dewshan"));

        // Perform checkout: Context delegates to the Strategy
        cart.checkout(100.0);
    }
}
