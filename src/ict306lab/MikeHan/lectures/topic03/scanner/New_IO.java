package ict306lab.MikeHan.lectures.topic03.scanner;

// inherit or import from std scanner class (stdio)
import java.util.Scanner;

public class New_IO 
{
    public static void main(String[] args) 
    {   Scanner keyboard = new Scanner(System.in);
        int     temp1, temp2;
        
        // %n is line separator (platform specific), %s is string
        System.out.printf("%n%s%n%s%n",
                "Welcome to ICT306!", 
                "The unit lecturer is me.");
        
        // /n platform dependent separator
        System.out.printf("\nEnter 2 integers:");
        temp1 = keyboard.nextInt();
        temp2 = keyboard.nextInt();
        
        // skip past the end of line marker
        // to end the current set of inputs
        String s = keyboard.nextLine();
        
        System.out.printf("%s %d %s %d \n\n",
                "The numbers are:", temp1, "and", temp2);
        
        if ( temp1 >= temp2 )
        {   System.out.printf("Max temp is %d%n%n", temp1); }
        else
        {   System.out.printf("Max temp is %d\n\n", temp2); }
        
        String name;
        System.out.println("Enter your name:");
        name = keyboard.nextLine();
        System.out.println("You entered:");
        System.out.printf("%s%n", name);
    }
}