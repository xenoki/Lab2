package adapter;
import exceptions.*;
import model.Automotive;
/**
* Class BuildAuto
*/
public class BuildAuto implements FileInput, UpdateConfiguration
{
    // Properties =========================================================================
    
    private Automotive auto;
    
    // Constructor ========================================================================
    
    public BuildAuto ()
    {
        super();
    }
    
    // Methods ============================================================================
    
    /**
    * Read a automotive configuration file containing option set and the option 
    * associated with each set. Build and return an Automotive object containing the
    * configuration 
    */
    public void readFile(String fileName)
    {   
        System.out.println("BuildAuto: readFile()");
        try 
        {
            auto = new util.FileIO("FordZTW.txt").buildAutoFromFile();

        } catch (AutoException e) 
        {
            e.printStackTrace();
            e.fixallmyproblem();
        }
    }
    
    /**
    * Print the configuration data from the Automotive Object 
    */
    public void print() 
    {
        auto.print();
    }

    /**
    * Update the model name and base price of the Automotive object
    */
    public void updateModel(String newModelName, int basePrice) 
    {
        auto.setName(newModelName);
        auto.setPrice(basePrice);
    }

    /**
    * Given a option set, update the name of it 
    */
    public void updateOptionSet(String optSetName, String newName) 
    {
        auto.updateOptionSet(optSetName, newName);
    }

    /**
    * Given a option set name and a option name, update that option
    */
    public void updateOption(String optSetName, String optName, String newName, int newPrice) 
    {
        auto.updateOption(optSetName, optName, newName, newPrice);
    }

    /**
    * Add a new option set in the Automotive object 
    */
    public void addOptionSet(String optSetName, int numOfOptions) 
    {
        auto.addOptionSet(optSetName, numOfOptions);
    }

    /**
    * Given an option set, add a new option for it 
    */
    public void addOption(String optSetName, String optName, int price) 
    {
        auto.addOption(optSetName, optName, price);
    }

    /**
    * Delete an option set 
    */
    public void deleteOptionSet(int i) 
    {
        auto.deleteOptionSet(i);
    }

    /**
    * Given a option set, delete the option in that set 
    */
    public void deleteOption(String optSetName, String optName) 
    {
        auto.deleteOption(optSetName, optName);
    }
}

   

 
