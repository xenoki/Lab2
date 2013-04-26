package util;

import model.Automotive;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import temp.AutoFileException;
import exceptions.AutoException;

/**
* This class is use to read in a text file and build an automotive object 
* from the data contain in the file. It also provide provide the 
* functionality of serializing an object to file, and deSerializing an object 
* file from disk into memory. 
*/
public class FileIO
{
    // Constants -----------------------------------------------------------------------------------
    
    private final int MODEL_NAME = 0;
    private final int BASE_PRICE = 0;
    private final int OPTION_SET = 1;
    private final int NUM_OF_OPTIONS =2;
    private final int OPTION = 0;
    private final int NAME = 1;
    private final int PRICE = 1;
    private final int OPTION_NAME = 0;
    private final int OPTION_PRICE = 1;
    private final int NO_MODEL_NAME = 1;
    private final int NO_BASE_PRICE = 2;
    private final int NO_OPTIONSET_NAME = 3;
    
    // Properties ----------------------------------------------------------------------------------
    
    private String fileName;
  
    // Constructors --------------------------------------------------------------------------------
    
    /**
    * Constructs a default FILEIO object 
    */
    public FileIO() { }
    
    /**
    * Constructs a FILEIO object and initialize the name of the file 
    * @param fileName the name and path of the file
    */
    public FileIO(String fileName)
    {
        this.fileName = fileName;
    }
    
    // Getters/Setters -----------------------------------------------------------------------------
    
    public String getfileName()
    {
        return fileName;
    }

    public void setfileName(String fileName)
    {
        this.fileName = fileName;
    }
    
    // Methods ---------------------------------------------------------------------------------------
    
    /**
    * Build an Automotive object by reading in a text file and using the Automotive object methods
    * to set in the value from the text file
    * @return
    */
    public Automotive buildAutoFromFile()
    {
        System.out.printf("Building Automotive Object\n");
        Automotive model = new Automotive();
        try 
        {
            FileReader file = new FileReader(fileName);
            BufferedReader buffer = new BufferedReader(file);
            boolean eof = false;
           
            while (!eof)
            {
                String line = buffer.readLine();
                if (line == null)
                {    
                   eof = true;
                }   
                else
                {   
                    String data[] = line.split(":");
                    if(data[MODEL_NAME].equalsIgnoreCase("Model Name"))
                    {  
                        try 
                        {
                            readModelName(model, data);
                        } 
                        catch (AutoException e) 
                        {
                            System.out.printf("%s",e);
                            e.fixallmyproblem(model);
                        } 
                    }
                    else if (data[BASE_PRICE].equalsIgnoreCase("Base Price"))
                    {
                        try 
                        {
                            readBasePrice(model, data);
                        } 
                        catch (AutoException e) 
                        {
                            System.out.printf("%s",e);
                            e.fixallmyproblem(model);
                        }
                    }
                    else if(data[OPTION].equalsIgnoreCase("Option"))
                    {
                        try 
                        {
                            readOptionSet(model, data, buffer);
                        } 
                        catch (AutoException e) 
                        {
                            System.out.printf("%s",e);
                            e.fixallmyproblem(model);
                        }
                    }
                }  
                
            }
            buffer.close();
        } 
        catch (IOException e) 
        {
            System.out.println("buildAutoFromFileError -- " + e.toString());
        }
        return model;
    }
    
    /**
    * Read the model name from a text configuration file
    * @param model The automotive object 
    * @param data  The buffer data
    * @throws AutoFileException
    */
    private void readModelName(Automotive model, String[] data) throws AutoException
    {
        if(data.length != 1)
        {    
            model.setName(data[NAME]);
        }
        else 
        {
            throw new AutoException("Unable to find model name in file\n", NO_MODEL_NAME);
        }
    }
    
    /**
    * Read in the base price of the car model
    * @param model
    * @param data
    * @throws AutoFileException
    */
    private void readBasePrice(Automotive model, String[] data) throws AutoException
    {
        if(data.length != 1)
        {    
            model.setPrice(Integer.parseInt(data[PRICE]));
        }
        else
        {    
            throw new AutoException("File does not contain a base price\n", NO_BASE_PRICE);
        }
     }
    
    /**
    * Read in the options
    * @param model
    * @param data
    * @param buffer
    * @throws AutoFileException
    */
    private void readOptionSet(Automotive model, String[] data, BufferedReader buffer) throws AutoException
    {
        int numberOfoptions = Integer.parseInt(data[NUM_OF_OPTIONS].trim());
        
        if(data.length != 1)
        {    
            model.addOptionSet(data[OPTION_SET], numberOfoptions);
        }
        else 
        {
            throw new AutoException("No Name specified for this optoin set\n", NO_OPTIONSET_NAME);
        }
        
        for(int i = 0; i < numberOfoptions; i++) 
        {   
            try 
            {   
                String [] option = buffer.readLine().split(":");
                model.addOption(data[OPTION_SET], option[OPTION_NAME].trim(), Integer.parseInt(option[OPTION_PRICE].trim()));
            } 
            catch (Exception e) 
            {
                System.out.println("Error 101 -- " + e.toString());
            }
       }
    }
    
    /**
    * Serialize automotive object to file 
    * @param model the automotive object to be serialize
    */
    public void serializeAutomotive(String fileName, Automotive model)
    {
        System.out.printf("Serializing Automotive Object..........\n");
        try
        {  
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(model);
            out.close();
        } 
        catch (Exception e)
        {
            System.out.print("Serialization Error: " + e);
            System.exit(1);
        }
    }
     
    /**
    * deSerialize automotive object file from disk into memory and return a new automotive
    * object 
    * @param fileName the name of the serialize object file
    * @return a deSerialize automotive object
    */
    public Automotive deserializeAutomotive(String fileName)
    {
        System.out.printf("DeSerializing Automotive Object........\n");
        try
        {
            ObjectInputStream input =  new ObjectInputStream(new FileInputStream(fileName));
            Automotive model = (Automotive) input.readObject();
            input.close();
            return model;
        } 
        catch (Exception e)
        {
            System.out.print("DeSerilization Error: " + e);
            return null;
        }
    }
}
