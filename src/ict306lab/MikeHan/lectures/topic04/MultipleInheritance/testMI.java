package ict306lab.MikeHan.lectures.topic04.MultipleInheritance;

interface Payable
{   double getPaymentAmt();  }

class Product implements Payable
{   private double productAmt=0;
    
    Product(double amt) { productAmt=amt; }
    public double getPaymentAmt() { return productAmt; }
}

interface DeliveryInterface extends Payable
{   }

class Delivery implements DeliveryInterface
{   private double deliveryAmt=0;
    
    Delivery(double amt) { deliveryAmt=amt; }
    public double getPaymentAmt() { return deliveryAmt; }
}

public class testMI extends Product implements DeliveryInterface
{   testMI() { super(0); }
    
    public static void main(String[] args) 
    {   Payable p1 = new Product(15.0);
        Payable d1 = new Delivery(20.0);

        System.out.println("Product="+p1.getPaymentAmt());
        System.out.println("delivery="+d1.getPaymentAmt());
    }
}
