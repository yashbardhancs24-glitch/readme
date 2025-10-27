
interface PaymentProcessor {
    void pay(double a);
    default void refund(double a){System.out.println("Refunded "+a);}
}
class PayPal implements PaymentProcessor {
    public void pay(double a){System.out.println("Paid via PayPal "+a);}
}
