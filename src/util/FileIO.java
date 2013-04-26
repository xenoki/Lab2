package util;

import model.Automotive;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import exceptions.AutoException;
import exceptions.AutoFileException;

/**
* This class is use to read in a text file and build an automotive object 
* from the data contain in the file. It also provide provide the 
* functionality of serializing an object to file, and deSerializing an object 
* file from disk into memory. 
*/
public class FileIO
{
    // Constants ===================================================================================

    private final int MODEL_NAME = 0;
    private final int BASE_PRICE = 0;
    private final int OPTION_SET = 1;
    private final int NUM_OF_OPTIONS =2;
    private final int OPTION = 0;
    private final int NAME = 1;
    private final int PRICE = 1;
    private final int OPTION_NAME = 0;
    private final int OPTION_PRICE = 1;
    
    // Properties ==================================================================================
    
    private String fileName;
  
    // Constructors ================================================================================

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
    
   
    // Getters/Setters =============================================================================

    public String getfileName()
    {
        return fileName;
    }

    public void setfileName(String fileName)
    {
        this.fileName = fileName;
    }
    
    // Methods =====================================================================================
    
    public void test() throws AutoException
    {
        System.out.println("Throwing MyException from f()");
        throw new AutoException("Something really bad happened", 1);
    }
    
    
    /**
    * Build an Automotive object by reading in a text file and using the Automotive object methods
    * to set in the value from the text file
    * @return
    */
    public Automotive buildAutoFromFile() throws AutoException
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
                    // System.out.println("else");
                    String data[] = line.split(":");
                    // System.out.println(data[MODEL_NAME]);
                    //System.out.println(data.length);
                    if(data[MODEL_NAME].equalsIgnoreCase("Model Name") && data.length != 1)
                    {   
                       readModelName(model, data);
                    }
                    else if (data[BASE_PRICE].equalsIgnoreCase("Base Price"))
                    {  
                        
                    }
                    else if(data[OPTION].equalsIgnoreCase("Option"))
                    {
                        
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
        
        System.out.println("DEBUG" + data[NAME]);
        if(data[NAME] != null)
        {    
            model.setName(data[NAME]);
            //return 1;
        }
        else 
        {
            //return 0;
            System.out.println("Throwing MyException from readModelName()");
            throw new AutoException("Unable to find model name in file", 1);
        }
        
       
    }
    
    /**
    * Read in the options
    * @param model
    * @param data
    * @param buffer
    * @throws AutoFileException
    */
    private void readOptionSet(Automotive model, String[] data, BufferedReader buffer) throws AutoFileException
    {
        int numberOfoptions = Integer.parseInt(data[NUM_OF_OPTIONS].trim());
        model.addOptionSet(data[OPTION_SET], numberOfoptions);
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
    * Read in the base price of the car model
    * @param model
    * @param data
    * @throws AutoFileException
    */
    private void readBasePrice(Automotive model, String[] data) throws AutoFileException
    {
        if(data[BASE_PRICE] != null)
        {    
            model.setPrice(Integer.parseInt(data[PRICE]));
        }
        else
        {    
            throw new AutoFileException("File does not contain a base price");
        }
    }
    
   
    
    /**
    * Extract data from each line in a text and use it to populate the instance variable
    * in the Automotive object. Data in text file are separated by the character :, split 
    * method is use to separated the data and populated the automotive object properties.
    * A for loop is use to add in options for a option set.
    * @param model  the automotive object that will be initialize with data 
    * @param line   a line from the text file use for automotive variables initialization
    * @param buffer buffer data from text file
    */
    //private void readModel(Automotive model, String [] data)
    
    private void fillAutoObj(Automotive model, String[] data, BufferedReader buffer) throws AutoFileException 
    {
        if(data[MODEL_NAME].equalsIgnoreCase("Model Name") && data[NAME] != null) 
        {   
            model.setName(data[NAME]);
        }
        else 
        {
            throw new AutoFileException("Please check the configuration, Model Name doesnt not exist\n");
        }
        
       
        if(data[BASE_PRICE].equalsIgnoreCase("Base Price")) 
        {
            model.setPrice(Integer.parseInt(data[PRICE]));
        }
        
        else if(data[OPTION].equalsIgnoreCase("Option")) 
        {
            int numberOfoptions = Integer.parseInt(data[NUM_OF_OPTIONS].trim());
            model.addOptionSet(data[OPTION_SET], numberOfoptions);
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
    }
    

    /**
    * Writing a automotive object to with the extension .ser 
    * @param object the automotive object
    */
    public void writeAutoObjToFile(Automotive object)
    {
        System.out.printf("Serializing Automotive Object..........\n");
        try
        {  
            FileOutputStream file = new FileOutputStream(fileName.replaceAll("\\.txt", ".ser"));
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(object);
            out.close();
        } 
        catch (Exception e)
        {
            System.out.print("Serialization Error: " + e);
            System.exit(1);
        }    
    }
    
    /**
    * Read and return a serialize automotive object 
    * @return
    */
    public Automotive readAutoObjToFile()
    {
        System.out.printf("DeSerializing Automotive Object........\n");
        try
        {
            ObjectInputStream input =  new ObjectInputStream(new FileInputStream(fileName + ".ser"));
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
    
    /**
    * Build and return an automotive object from a text file
    * @param fileName the name and path of a file
    * @return an automotive object
    */
    public Automotive readFile(String fileName) throws AutoException 
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
                System.out.println(line);
                if (line == null)
                {    
                   eof = true;
                }   
                else
                {
                    //fillAutoObj(model, line.split(":"), buffer);
                }    
            }
            buffer.close();
        } 
        catch (IOException e) 
        {
            System.out.println("Error -- " + e.toString());
        }
        return model;
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
     
    // Testing Methods not being use =============================================================
    public Object deSerialize (String fileName)
    {
        try 
        {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName));
            Object model = input.readObject();
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
