package ict306lab.MikeHan.lectures.topic04.selector;

//Selector
interface Selector 
{   boolean end();
    Object  current();
    void    next();
}

//SelPrint
class SelPrint
{   public static void selPrint(Selector s)
    {   while (!s.end())
        {   System.out.println((String)s.current()); s.next(); }
    }
}

//Sequence
public class Sequence 
{   private     Object[] o;
    private int next=0;
    
    Sequence(int size) { o = new Object[size]; }

    public void add(Object x)
    {   if (next < o.length) { o[next]=x; next++; }    }
    
    //inner class
    private class SSelector implements Selector
    {   int i=0;
        
        public boolean end()    { return i == o.length; } 
        public Object current() { return o[i]; }
        public void next()      { if (i<o.length) i++; }
    }

    public Selector getSelector() { return new SSelector(); }

    public static void main(String[] args) 
    {   Sequence s = new Sequence(10);
        for (int i=0; i<10; i++) s.add(Integer.toString(i));
        SelPrint.selPrint(s.getSelector());
    }
}
