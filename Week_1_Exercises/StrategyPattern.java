interface PaymentStrategy {
    void pay(double amount);
}
 class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String cvv;
    private String expirationDate;

    public CreditCardPayment(String cardNumber, String cardHolderName, String cvv, String expirationDate) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + " paid with credit card.");
    }
}

 class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + " paid using PayPal.");
    }
}
 class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        paymentStrategy.pay(amount);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        PaymentStrategy creditCard = new CreditCardPayment("1234567890123456", "John Doe", "123", "12/23");
        context.setPaymentStrategy(creditCard);
        context.pay(100.00);

        PaymentStrategy payPal = new PayPalPayment("john.doe@example.com", "password");
        context.setPaymentStrategy(payPal);
        context.pay(200.00);
    }
}
