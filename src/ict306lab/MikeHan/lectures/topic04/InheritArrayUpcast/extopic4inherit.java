package ict306lab.MikeHan.lectures.topic04.InheritArrayUpcast;

abstract class Polygon
{   public static int polyCnt = 0;
    public abstract String polyDim();
}

class Circle extends Polygon
{   private int radius=0; 
    Circle(int r)           { radius=r; }
    public String polyDim() { return "Circle: radius="+radius; }
}

class Rectangle extends Polygon
{   private int length=0, width=0;
    Rectangle(int l,int w)  { length=l; width=w; }
    public String polyDim() { return "Rectangle: len="+length+" wd="+width; }
}
    
public class extopic4inherit 
{   public static void main(String[] args) 
    {   Polygon p1, pList[];    // can create variable for abstract class
        // p1 = new Polygon();  // but can't instantiate it
        pList = new Polygon[3]; // creating array not object
        
        Circle c1,c2;
        Rectangle r1;
        
        c1 = new Circle(10);
        c2 = new Circle(20);
        r1 = new Rectangle(5,15);
        
        pList[0] = c1;
        pList[1] = c2;
        pList[2] = r1;
        
        for (int i=0; i<3; i++)
        { System.out.println(pList[i].polyDim()); }

        System.out.println("another version of loop");
        for ( Polygon p : pList)
        { System.out.println(p.polyDim()); }

        final int i=(int)Math.random();
    }
}
