package ict306lab.MikeHan.lectures.topic04.innerclass;

class outterx
{   public int outA = 1;
    
    public class innerx
    {   public int inA = 1;
        
        innerx() { System.out.println("inner outA = "+outterx.this.outA); }
    }
}

public class innerclass 
{       
    public static void main(String[] args) 
    {   outterx temp1 = new outterx();
        temp1.outA = 10;
        System.out.println("temp1 outA="+temp1.outA);
        System.out.println();
                
        outterx.innerx temp2 = temp1.new innerx();
        temp1 = null;
        temp2.inA = 20;
        System.out.println("temp2 inA="+temp2.inA);
        System.out.println();

        
        outterx.innerx temp3 = new outterx().new innerx();
        temp3.inA = 30;
        System.out.println("temp3 inA="+temp3.inA);
    }
}
