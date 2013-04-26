package exceptions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import model.Automotive;

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
        writeexceptiontoFile();
    }
    
    public void fixallmyproblem(Automotive model)
    {
        switch(errorno)
        {
            case 1:    addDefaultModelName(model);
                       break;
            case 2:    addDefaultBasePrice(model);
                       break;
        }
    }
   
    public void fixallmyproblem(Automotive model, int numberOfOption)
    {
       switch(errorno)
       {
           
           case 3:    addDefaultOptionSetName(model, numberOfOption);
                      break;
       }
   }
    
   public void addDefaultModelName(Automotive model) 
   {
       System.out.println("Temporary Fix: Adding Model Name as DEFAULT MODEL");
       model.setName("Default Model");
   }
   
   public void addDefaultBasePrice(Automotive model) 
   { 
       System.out.println("Temporary Fix: Adding Default Base Price of 0");
       model.setPrice(0);
   }
   
   public void addDefaultOptionSetName(Automotive model, int numOfOptions) 
   { 
       System.out.println("Temporary Fix: Adding Default Option Set name as DEFAULT OPTION SET");
       model.addOptionSet("Default Option Set", numOfOptions);
   }
   
   void writeexceptiontoFile() 
   { 
       try
       {
           String data = this.message;
           File file =new File("autoFileExceptions.txt");

           if(!file.exists())
           {
               file.createNewFile();
           }

           //true = append file
           FileWriter fileWritter = new FileWriter(file.getName(),true);
           BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
           bufferWritter.write(data);
           bufferWritter.close();
       }
       catch(IOException e)
       {
           e.printStackTrace();
       }
   }
}








