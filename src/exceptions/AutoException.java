package exceptions;

public class AutoException extends Exception
{
    private static final long serialVersionUID = -8239592865109816171L;
    private int errorno;
    private String message;
    
    public AutoException() 
    { 
        
    }

    public AutoException(String msg) 
    {
      super(msg);
    }
    
    public void setMessage(String message)
    {
        this.message = message;
    }
    
    public String getMessage()
    {
        return message;
    }
   
    public AutoException(String msg, int errorno) 
    {
        this.message = msg;
        this.errorno = errorno;
    }
    
    public void fixallmyproblem()
    {
        switch(errorno)
        {
            case 1:fix1();break;
            case 2:fix2();break;
            case 3:fix3();break;
        }
   }
    
   void fix1() 
   { 
       
   }
   
   void fix2() 
   { 
       
   }
   
   void fix3() 
   { 
       
   }
   
   void writeexceptiontoFile() { }
}
