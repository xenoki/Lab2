package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.*;

/**
* Hung Quach
* CIS 35B
* Lab 1:
* Due Date:       4/15/2013
* Date Submitted: 4/15/2013
*
* This class is use to read in a text file and build an automotive object 
* from the data contain in the file. It also provide provide the 
* functionality of serializing an object to file, and deSerializing an object 
* file from disk into memory. 
*/
public class FileIO
{
    // Constants ========================================================

    private final int MODEL_NAME = 0;
    private final int BASE_PRICE = 0;
    private final int OPTION_SET = 1;
    private final int NUM_OF_OPTIONS =2;
    private final int OPTION = 0;
    private final int NAME = 1;
    private final int PRICE = 1;
    private final int OPTION_NAME = 0;
    private final int OPTION_PRICE = 1;
    
    // Properties =======================================================
    
    private String filename;
    
    // Constructors =====================================================

    /**
    * Constructs a default FILEIO object 
    */
    public FileIO() { }
    
    /**
    * Constructs a FILEIO object and initialize the name of the file 
    * @param filename the name and path of the file
    */
    public FileIO(String filename)
    {
        this.filename = filename;
    }
    
    // Getters/Setters ==================================================

    public String getFilename()
    {
        return filename;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
    }
    
    // Methods ==========================================================
    
    /**
    * Build and return an automotive object from a text file
    * @return an automotive object
    */
    public Automotive readFile() 
    {
         return this.readFile(filename);
    }
   
    /**
    * Build and return an automotive object from a text file
    * @param filename the name and path of a file
    * @return an automotive object
    */
    public Automotive readFile(String filename) 
    {   
        Automotive model = new Automotive();
        try 
        {
            FileReader file = new FileReader(filename);
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
                    buildAutomotive(model, line.split(":"), buffer);
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
    * Extract data from each line in a text and use it to populate the instance variable
    * in the Automotive object. Data in text file are separated by the character :, split 
    * method is use to separated the data and populated the automotive object properties.
    * A for loop is use to add in options for a option set.
    * @param model  the automotive object that will be initialize with data 
    * @param line   a line from the text file use for automotive variables initialization
    * @param buffer buffer data from text file
    */
    private void buildAutomotive(Automotive model, String[] data, BufferedReader buffer)
    {
        if(data[MODEL_NAME].equalsIgnoreCase("Model Name"))
        {   
            model.setName(data[NAME]);
        }
        else if(data[BASE_PRICE].equalsIgnoreCase("Base Price"))
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
                    model.addOptionToSet(data[OPTION_SET], 
                                         option[OPTION_NAME].trim(), 
                                         Integer.parseInt(option[OPTION_PRICE].trim()));
                } 
                catch (Exception e)
                {
                    System.out.println("Error 1 -- " + e.toString());
                }
            }
        }
    }
    
    /**
    * Serialize automotive object to file 
    * @param model the automotive object to be serialize
    */
    public void serializeAutomotive(Automotive model)
    {
        try
        {  
            FileOutputStream file = new FileOutputStream(filename.replaceAll("\\.txt$", ".ser"));
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
    * @param filename the name of the serialize object file
    * @return a deSerialize automotive object
    */
    public Automotive deserializeAutomotive(String filename)
    {
        try
        {
            ObjectInputStream input =  new ObjectInputStream(new FileInputStream(filename));
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
