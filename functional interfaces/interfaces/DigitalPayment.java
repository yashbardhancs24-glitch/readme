
interface Payment {
    void pay(double a);
}
class UPI implements Payment {
    public void pay(double a){System.out.println("UPI Paid "+a);}
}
class CreditCard implements Payment {
    public void pay(double a){System.out.println("CreditCard Paid "+a);}
}
class Wallet implements Payment {
    public void pay(double a){System.out.println("Wallet Paid "+a);}
}
