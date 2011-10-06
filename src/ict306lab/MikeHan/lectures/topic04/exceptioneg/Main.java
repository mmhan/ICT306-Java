package ict306lab.MikeHan.lectures.topic04.exceptioneg;

import java.util.Scanner;

class MyExcept1 extends Exception
{   MyExcept1() { System.out.println("-in MyExcept1"); }
    MyExcept1(String msg) { super(msg); System.out.println("-in MyExcept1"); }
}

public class Main
{
    public static void main(String[] args)
    {   Scanner k = new Scanner(System.in);
        int i=0;
        
        try
        {   try
            {   System.out.print("Enter a number:");
                i = k.nextInt();
                String s = k.nextLine();
                if (i==0) throw new Exception("equal zero");
                if (i==9) throw new MyExcept1();
            }
            catch (MyExcept1 e)
            { System.out.println("inner Except");
              throw new MyExcept1();
            }
            //catch (Exception e)
            //{ System.out.println("inner Except="+e.getMessage()); }
        }
        catch (MyExcept1 e)
        { System.out.println("outter Except"); }
        catch (Exception e) 
        { System.out.println("outter Except="+e.getMessage()); }
    }
}

    
        