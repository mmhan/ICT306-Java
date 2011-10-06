package ict306lab.MikeHan.lectures.topic03.staticeg;

class Employee
{   private String empNm;
    private static int empCnt = 0;
    
    public Employee(String nm) { empNm=nm;  empCnt++; }
    public String getEmpNm() { return empNm; }
    public static int getEmpCnt() { return empCnt; }
    
    protected void finalize() 
    { empCnt--; System.out.println("in finalize with Cnt="+empCnt); }
}

public class EmployeeTest 
{   public static void main(String[] args) 
    {   System.out.println("Cnt b4 Emp init="+Employee.getEmpCnt());
        
        Employee e1 = new Employee("pkloo");
        Employee e2 = new Employee("hello");
        
        // should reflect the same cnt since only 1 copy
        System.out.println("Cnt af init via e1="+e1.getEmpCnt());
        System.out.println("Cnt af init via e2="+e1.getEmpCnt());
        
        // yet still maintain their own object attribute
        System.out.println("e1 name="+e1.getEmpNm());
        System.out.println("e2 name="+e2.getEmpNm());
        
        // System.out.println("b4 set e1 & e2 null");
        e1 = null;
        e2 = null;
        // System.out.println("af set e1 & e2 null");
        
        System.gc();  // force garbage collection
    }
}
