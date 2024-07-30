
 interface PaymentProcessor {
    void processPayment(double amount);
}

 class PayPalPayment {
    public void sendPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

 class StripePayment {
    public void makePayment(double amount) {
        System.out.println("Processing Stripe payment of $" + amount);
    }
}

 class SquarePayment {
    public void charge(double amount) {
        System.out.println("Processing Square payment of $" + amount);
    }
}

 class PayPalAdapter implements PaymentProcessor {
    private PayPalPayment payPalPayment;

    public PayPalAdapter(PayPalPayment payPalPayment) {
        this.payPalPayment = payPalPayment;
    }

    @Override
    public void processPayment(double amount) {
        payPalPayment.sendPayment(amount);
    }
}

 class StripeAdapter implements PaymentProcessor {
    private StripePayment stripePayment;

    public StripeAdapter(StripePayment stripePayment) {
        this.stripePayment = stripePayment;
    }

    @Override
    public void processPayment(double amount) {
        stripePayment.makePayment(amount);
    }
}

 class SquareAdapter implements PaymentProcessor {
    private SquarePayment squarePayment;

    public SquareAdapter(SquarePayment squarePayment) {
        this.squarePayment = squarePayment;
    }

    @Override
    public void processPayment(double amount) {
        squarePayment.charge(amount);
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPalPayment());
        payPalProcessor.processPayment(100.0);

        PaymentProcessor stripeProcessor = new StripeAdapter(new StripePayment());
        stripeProcessor.processPayment(200.0);

        PaymentProcessor squareProcessor = new SquareAdapter(new SquarePayment());
        squareProcessor.processPayment(300.0);
    }
}
