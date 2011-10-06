package ict306lab.MikeHan.lectures.topic03.defaultvalue;

class A { int a1; }

public class Main
{   public static void main(String[] args)
    {   final int   var1 = 87;
        double      var2 = 12.35;
        boolean     var3 = true;
        String      var4 = "ddd";
        String      var41 = new String("var41 ddd");
        A           var51 = new A();
        A           var52 = new A();
        
        // var1 = 12;

        System.out.println("* Part 1 demo");
        System.out.println("var1 =" + var1);
        System.out.println("var2 =" + var2);
        System.out.println("var3 =" + var3);
        System.out.println("var4 =" + var4);
        System.out.println("var41=" + var41);
        System.out.println("var51=" + var51);
        System.out.println("var52=" + var52);

        System.out.println("\n* Part 2 demo");
        int var10 = 10;
        A   var20 = new A();  var20.a1 = 20;
        A   var30 = new A();  var30.a1 = 30;
        System.out.println("var10="+var10);
        System.out.println("var20=" + var20+"("+var20.a1+")");
        System.out.println("var30=" + var30+"("+var30.a1+")");

        System.out.println("\n* Part 3 demo");
        m1(var10, var20, var30);
        System.out.println("- outside m1");
        System.out.println("var10="+var10);
        System.out.println("var20=" + var20+"("+var20.a1+")");
        System.out.println("var30=" + var30+"("+var30.a1+")");
    }
    
    static void m1(int x1, A x2, A x3)
    {   System.out.println("- Inside m1 method");
        System.out.println("x1=" + x1);
        System.out.println("x2=" + x2 + "("+x2.a1+")");
        System.out.println("x3=" + x3 + "("+x3.a1+")");
        x1 = 100;
        x2.a1 = 200;
        x3 = new A();
        System.out.println("x1=" + x1);
        System.out.println("x2=" + x2 + "("+x2.a1+")");
        System.out.println("x3=" + x3 + "("+x3.a1+")");
    }

}
