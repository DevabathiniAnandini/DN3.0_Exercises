interface Notifier {
    void send(String message);
}

 class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email with message: " + message);
    }
}

 abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}

 class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS with message: " + message);
    }
}
 class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlackMessage(message);
    }

    private void sendSlackMessage(String message) {
        System.out.println("Sending Slack message with message: " + message);
    }
}
public class DecoratorPattern {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        notifier.send("Hello via Email!");

        System.out.println("\nAdding SMS Notification:");
        notifier = new SMSNotifierDecorator(notifier);
        notifier.send("Hello via Email and SMS!");

        System.out.println("\nAdding Slack Notification:");
        notifier = new SlackNotifierDecorator(notifier);
        notifier.send("Hello via Email, SMS, and Slack!");
    }
}
