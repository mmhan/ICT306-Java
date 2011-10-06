package ict306lab.MikeHan.lectures.topic03.boxing;

public class convert 
{   public static void main(String[] args) 
    {   int i     = 10;
        double j  = 0;
        String s1 = "23";
        String s2 = "  12.345 ";
        
        test(i);
        System.out.println("b4 trim="+s2+"end");        
        System.out.println("af trim="+s2.trim()+"end");
        
        // valueOf will convert s1 to an integer class
        // intValue will convert integer class to int
        // parseInt will convert straight from string to an int
        i = Integer.valueOf(s1).intValue();
        // parseDouble will convert string to double 
        j = Double.parseDouble(s2);
        System.out.println("i="+i);
        System.out.println("j="+j);
        
        float g = 6 + 2/3;
        System.out.println("g="+g);
    
        float n = (float) (6 + (float)2 / (float)3);
        System.out.println("n="+n);
    }
    
    public static void test(Integer a)
    {   System.out.println("in test a="+a); }
}
