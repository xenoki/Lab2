package exceptions;
public class FullConstructors 
{
    public static void f() throws AutoException 
    {
        System.out.println("Throwing MyException from f()");
        throw new AutoException("Something really bad happened", 1);
    }
    
    public static void g() throws AutoException
    {
        System.out.println("Throwing MyException from g()");
        throw new AutoException("Something really really really bad happened", 2);
    }
    
    public static void main(String[] args) 
    {
        
      try 
      {
        f();
      } 
      catch (AutoException e) 
      {
        e.printStackTrace();
        e.fixallmyproblem();
      }
      
      try 
      {
        g();
      } 
      catch (AutoException e) 
      {
        e.printStackTrace();
        e.fixallmyproblem();
      }
    }
} 