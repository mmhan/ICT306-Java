package ict306lab.MikeHan.lectures.topic04.generic;

import java.util.*;

public class testgeneric 
{   public static <Type> void printarray( Type[] array1 )
    {   System.out.printf("%nelements=%n");
        for (Type x : array1) System.out.println(x);
    }
    public static void main(String[] args) 
    {   Integer i1[] = { 1, 2, 3 };
        Double d1[] = { 1.5, 2.3, 4.5, 5.5 };
        Character c1[] = { 'p', 'k', 'l', 'o', 'o' };
        
        printarray(i1);
        printarray(d1);
        printarray(c1);
        
        // generic object example
        List <Integer> a1 = new ArrayList<Integer>();
        a1.add(0, 10);
        a1.add(1,30);
        System.out.println("Array size="+a1.size());
        
        // iterator example
        Iterator it = a1.iterator();
        System.out.println(it.next()); 
        System.out.println(it.next());       
    }
}
